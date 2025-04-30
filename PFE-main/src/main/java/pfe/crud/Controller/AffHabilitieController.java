package pfe.crud.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfe.crudDTO.AffHabilitieRequestDto;
import pfe.crudDTO.AffHabilitieResponseDto;
import pfe.crud.Models.affHabilitieId;
import pfe.crud.Models.affhabilitie;
import pfe.crud.Service.ServiceImpl.HabilitationServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilites")
public class AffHabilitieController {

    private final HabilitationServiceImpl habilitationService;

    public AffHabilitieController(HabilitationServiceImpl habilitationService) {
        this.habilitationService = habilitationService;
    }

    // 1. Récupérer une habilitation par son ID
    @GetMapping("/{habIdenti}/{habDebeff}")
    public ResponseEntity<?> getById(
            @PathVariable String habIdenti,
            @PathVariable String habDebeff) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date habDebeffDate = format.parse(habDebeff);
            affHabilitieId id = new affHabilitieId(habIdenti, habDebeffDate);

            Optional<affhabilitie> habilitieOpt = habilitationService.getHabilitie(id);

            if (habilitieOpt.isPresent()) {
                AffHabilitieResponseDto dto = habilitationService.toDto(habilitieOpt.get());
                return ResponseEntity.ok(dto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    // 2. Récupérer toutes les habilitations
    @GetMapping
    public ResponseEntity<List<AffHabilitieResponseDto>> getAll() {
        List<affhabilitie> habilites = habilitationService.getAllHabilities();
        List<AffHabilitieResponseDto> dtos = habilites.stream()
                .map(habilitationService::toDto)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    // 3. Créer une habilitation
    @PostMapping("/create")
    public ResponseEntity<String> createHabilitie(@RequestBody AffHabilitieRequestDto requestDto) {
        try {
            affhabilitie habilitie = habilitationService.toEntity(requestDto);
            habilitationService.createHabilitie(habilitie);
            return ResponseEntity.ok("Habilitation créée avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    // 4. Mettre à jour une habilitation
    @PutMapping("/update/{habIdenti}/{habDebeff}")
    public ResponseEntity<String> updateHabilitie(
            @PathVariable String habIdenti,
            @PathVariable String habDebeff,
            @RequestBody AffHabilitieRequestDto requestDto) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date habDebeffDate = format.parse(habDebeff);
            affHabilitieId id = new affHabilitieId(habIdenti, habDebeffDate);

            affhabilitie habilitie = habilitationService.toEntity(requestDto);
            habilitationService.updateHabilitie(habilitie, id);

            return ResponseEntity.ok("Habilitation mise à jour avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    // 5. Supprimer une habilitation
    @DeleteMapping("/delete/{habIdenti}/{habDebeff}")
    public ResponseEntity<String> deleteHabilitie(
            @PathVariable String habIdenti,
            @PathVariable String habDebeff) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date habDebeffDate = format.parse(habDebeff);
            affHabilitieId id = new affHabilitieId(habIdenti, habDebeffDate);

            habilitationService.deleteHabilitie(id);
            return ResponseEntity.ok("Habilitation supprimée avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
}
