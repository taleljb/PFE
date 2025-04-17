

package pfe.crud.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Repository.AffUserProfilRepository;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;
import pfe.crud.Service.ServiceImpl.userdgaffserviceimpl;
import pfe.crud.Service.ServiceInterface.userdgaffservice;
import pfe.crudDTO.AffUsersDgaffRequestDto;
import pfe.crudDTO.AffUsersDgaffResponseDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usersdgaff")
public class AffUsersDgaffController {

    private final userdgaffservice userService;
    private final userdgaffserviceimpl userServiceImpl;
    private final AffUserProfilRepository profilRepository;

    public AffUsersDgaffController(userdgaffservice userService, userdgaffserviceimpl userServiceImpl, AffUserProfilRepository profilRepository) {
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
		this.profilRepository = profilRepository;
    }

    // Créer un utilisateur
    @PostMapping("/create")
    public ResponseEntity<String> create(AffUsersDgaff userDgaff) {
        // Récupérer la clé composée
        AffUserProfilId profilId = new AffUserProfilId();
        profilId.setPrfIdenti(userDgaff.getProfil().getPrfIdenti());
        profilId.setPrfDebeff(userDgaff.getProfil().getPrfDebeff());

        // Récupérer le profil existant
        AffUserProfil profil = profilRepository.findById(profilId)
            .orElseThrow(() -> new RuntimeException("Profil introuvable"));

        // Attacher à l’objet principal
        userDgaff.setProfil(profil);

        return ResponseEntity.ok("Utilisateur créé avec succès");
    }
  /*  @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AffUsersDgaffRequestDto dto) {
        try {
        	AffUsersDgaff user = userServiceImpl.mapToEntity(dto);
        	  AffUserProfilId profilId = new AffUserProfilId();
              profilId.setPrfIdenti(user.getProfil().getPrfIdenti());
              profilId.setPrfDebeff(user.getProfil().getPrfDebeff());

              // Récupérer le profil existant
              AffUserProfil profil = profilRepository.findById(profilId)
                  .orElseThrow(() -> new RuntimeException("Profil introuvable"));

              // Attacher à l’objet principal
              user.setProfil(profil);
            userService.create(user);
            return ResponseEntity.ok("Utilisateur créé avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la création : " + e.getMessage());
        }
    }*/
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AffUsersDgaffRequestDto dto) {
        try {
            // Mapper le DTO vers l'entité AffUsersDgaff
            AffUsersDgaff user = userServiceImpl.mapToEntity(dto);
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

    // Supprimer un utilisateur
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok("Utilisateur supprimé avec succès");
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

