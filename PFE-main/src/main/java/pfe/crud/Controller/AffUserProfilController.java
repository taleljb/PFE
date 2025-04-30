package pfe.crud.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;
import pfe.crud.Repository.AffUserProfilRepository;
import pfe.crud.Service.ServiceImpl.UserprofilServiceImpl;
import pfe.crud.Service.ServiceImpl.userdgaffserviceimpl;
import pfe.crud.Service.ServiceImpl.UserprofilServiceImpl;
import pfe.crud.Service.ServiceInterface.UserprofilService;
import pfe.crud.Service.ServiceInterface.userdgaffservice;
import pfe.crudDTO.AffUserProfilRequestDto;
import pfe.crudDTO.AffUserProfilResponseDto;

@RestController
@RequestMapping("/api/userprofils")
public class AffUserProfilController {

    private final UserprofilServiceImpl userprofilService;
    private final userdgaffserviceimpl userservice;

    public AffUserProfilController(UserprofilServiceImpl userprofilService, userdgaffserviceimpl userservice) {
 		super();
 		this.userprofilService = userprofilService;
 		this.userservice = userservice;
 	}
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody AffUserProfilRequestDto dto) {
        try {
            AffUserProfil entity = userprofilService.toEntity(dto);
            userprofilService.createuser(entity);
            return ResponseEntity.ok("Utilisateur créé avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

	@PutMapping("/update/{prfIdenti}/{prfDebeff}")
    public ResponseEntity<String> update(
            @PathVariable String prfIdenti,
            @PathVariable String prfDebeff,
            @RequestBody AffUserProfilRequestDto dto) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date prfDebeffDate = format.parse(prfDebeff);
            AffUserProfilId id = new AffUserProfilId(prfIdenti, prfDebeffDate);
            AffUserProfil entity = userprofilService.toEntity(dto);
            userprofilService.updateuser(entity, id);
            return ResponseEntity.ok("Utilisateur mis à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{prfIdenti}/{prfDebeff}")
    public ResponseEntity<String> delete(
            @PathVariable String prfIdenti,
            @PathVariable String prfDebeff) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date prfDebeffDate = format.parse(prfDebeff);
            AffUserProfilId id = new AffUserProfilId(prfIdenti, prfDebeffDate);
            userservice.deleteAllUsersByProfil(id);
            userprofilService.deleteuser(id);
            return ResponseEntity.ok("Utilisateur supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
    @GetMapping("/{prfIdenti}/{prfDebeff}")
    public ResponseEntity<?> getById(
            @PathVariable String prfIdenti,
            @PathVariable String prfDebeff) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date prfDebeffDate = format.parse(prfDebeff);
            AffUserProfilId id = new AffUserProfilId(prfIdenti, prfDebeffDate);

            Optional<AffUserProfil> userOpt = userprofilService.getuser(id);

            if (userOpt.isPresent()) {
                AffUserProfilResponseDto dto = userprofilService.toDto(userOpt.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<List<AffUserProfilResponseDto>> getAll() {
        List<AffUserProfil> entities = userprofilService.getusers();
        List<AffUserProfilResponseDto> dtos = entities.stream()
                .map(userprofilService::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

}




