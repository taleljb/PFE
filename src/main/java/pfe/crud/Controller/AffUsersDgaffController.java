package pfe.crud.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Service.ServiceInterface.userdgaffservice;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usersdgaff")
public class AffUsersDgaffController {

    private final userdgaffservice userService;

    // Constructeur pour injecter le service
    public AffUsersDgaffController(userdgaffservice userService) {
        this.userService = userService;
    }

    // Créer un utilisateur
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AffUsersDgaff user) {
        try {
            userService.create(user);
            return ResponseEntity.ok("Utilisateur créé avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de la création : " + e.getMessage());
        }
    }

    // Mettre à jour un utilisateur
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody AffUsersDgaff user) {
        try {
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
    public ResponseEntity<AffUsersDgaff> getById(@PathVariable String id) {
        Optional<AffUsersDgaff> user = userService.getById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Récupérer tous les utilisateurs
    @GetMapping("/getAll")
    public ResponseEntity<List<AffUsersDgaff>> getAll() {
        List<AffUsersDgaff> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
}
