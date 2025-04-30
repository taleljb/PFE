

package pfe.crud.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Repository.AffUserProfilRepository;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;
import pfe.crud.Service.ServiceImpl.userdgaffserviceimpl;
import pfe.crud.Service.ServiceInterface.AuthService;
import pfe.crud.Service.ServiceInterface.userdgaffservice;
import pfe.crudDTO.AffUsersDgaffRequestDto;
import pfe.crudDTO.AffUsersDgaffResponseDto;
import pfe.crudDTO.JwtAuthResponse;
import pfe.crudDTO.LoginDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usersdgaff")
public class AffUsersDgaffController {

    private final userdgaffservice userService;
    private final userdgaffserviceimpl userServiceImpl;
    private final AffUserProfilRepository profilRepository;
    private AuthService authService;


    public AffUsersDgaffController(userdgaffservice userService, userdgaffserviceimpl userServiceImpl, AffUserProfilRepository profilRepository, AuthService authService) {
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
        this.profilRepository = profilRepository;
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AffUsersDgaffRequestDto dto) {
        try {
            // Mapper le DTO vers l'entité AffUsersDgaff
            System.out.println("voici le mot de passe de ce dto" + dto.getPassword());
            AffUsersDgaff user = userServiceImpl.mapToEntity(dto);
            System.out.println("voici le mot de passe de ce user" + user.getPassword());
            AffUserProfilId profilId = new AffUserProfilId();
            profilId.setPrfIdenti(user.getProfil().getPrfIdenti());
            profilId.setPrfDebeff(user.getProfil().getPrfDebeff());

            // Rechercher l'AffUserProfil dans la base de données
            AffUserProfil profil = profilRepository.findById(profilId)
                    .orElseThrow(() -> new RuntimeException("Profil non trouvé"));

            // Associer l'AffUserProfil trouvé à l'utilisateur
            user.setProfil(profil);

            // Créer l'utilisateur dans la base de données
            userService.create(user);

            return ResponseEntity.ok("Utilisateur créé avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la création : " + e.getMessage());
        }
    }


    // Mettre à jour un utilisateur
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody AffUsersDgaffRequestDto dto) {
        try {
            AffUsersDgaff user = userServiceImpl.mapToEntity(dto);
            userService.update(id, user);
            return ResponseEntity.ok("Utilisateur mis à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("Utilisateur supprimé avec succès");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la suppression : " + e.getMessage());
        }
    }


    // Récupérer un utilisateur par ID
    @GetMapping("/get/{id}")
    public ResponseEntity<AffUsersDgaffResponseDto> getById(@PathVariable String id) {
        Optional<AffUsersDgaff> optionalUser = userService.getById(id);
        if (optionalUser.isPresent()) {
            AffUsersDgaffResponseDto dto = userServiceImpl.mapToResponse(optionalUser.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


    // Récupérer tous les utilisateurs
    @GetMapping("/getAll")
    public ResponseEntity<List<AffUsersDgaffResponseDto>> getAll() {
        List<AffUsersDgaff> users = userService.getAll();
        List<AffUsersDgaffResponseDto> dtos = users.stream()
                .map(userServiceImpl::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}

