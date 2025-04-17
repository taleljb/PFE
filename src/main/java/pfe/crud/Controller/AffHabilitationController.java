package pfe.crud.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.crud.Models.affhabilitie;
import pfe.crud.Models.affHabilitieId;
import pfe.crud.Service.ServiceImpl.HabilitationServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilitations")
public class AffHabilitationController {

    private final HabilitationServiceImpl habilitationService;

    public AffHabilitationController(HabilitationServiceImpl habilitationService) {
        this.habilitationService = habilitationService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody affhabilitie habilitation) {
        try {
            habilitationService.createHabilitie(habilitation);
            return ResponseEntity.ok("Habilitation créée avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @PutMapping("/update/{habIdenti}/{habDebeff}")
    public ResponseEntity<String> update(
            @PathVariable String habIdenti,
            @PathVariable String habDebeff,
            @RequestBody affhabilitie habilitation) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date debDate = format.parse(habDebeff);
            affHabilitieId id = new affHabilitieId(habIdenti, debDate);
            habilitationService.updateHabilitie(habilitation, id);
            return ResponseEntity.ok("Habilitation mise à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{habIdenti}/{habDebeff}")
    public ResponseEntity<String> delete(
            @PathVariable String habIdenti,
            @PathVariable String habDebeff) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date debDate = format.parse(habDebeff);
            affHabilitieId id = new affHabilitieId(habIdenti, debDate);
            habilitationService.deleteHabilitie(id);
            return ResponseEntity.ok("Habilitation supprimée avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/get/{habIdenti}/{habDebeff}")
    public ResponseEntity<?> getOne(
            @PathVariable String habIdenti,
            @PathVariable String habDebeff) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date debDate = format.parse(habDebeff);
            affHabilitieId id = new affHabilitieId(habIdenti, debDate);
            Optional<affhabilitie> habilitation = habilitationService.getHabilitie(id);
            return habilitation.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<affhabilitie> getAll() {
        return habilitationService.getAllHabilities();
    }
}