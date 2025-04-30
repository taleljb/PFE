package pfe.crud.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import pfe.crud.Models.affhabilitie;
import pfe.crud.Models.affHabilitieId;
import pfe.crud.Repository.AffHabilitieRepository;
import pfe.crud.Service.ServiceInterface.HabilitationService;
import pfe.crudDTO.AffHabilitieRequestDto;
import pfe.crudDTO.AffHabilitieResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HabilitationServiceImpl implements HabilitationService {

    private final AffHabilitieRepository habilitieRepository;

    public HabilitationServiceImpl(AffHabilitieRepository habilitieRepository) {
        this.habilitieRepository = habilitieRepository;
    }

    @Override
    public void createHabilitie(affhabilitie habilitie) {
        if (habilitie.getHabIdenti() == null || habilitie.getHabIdenti().isEmpty()) {
            throw new IllegalArgumentException("Identifiant de l'habilitation doit être fourni");
        }

        if (habilitie.getHabDebeff() == null) {
            throw new IllegalArgumentException("Date de début doit être fournie");
        }
        habilitieRepository.save(habilitie);
    }

    @Override
    public void updateHabilitie(affhabilitie habilitie, affHabilitieId id) {
        Optional<affhabilitie> optionalHabilitie = habilitieRepository.findById(id);

        if (optionalHabilitie.isPresent()) {
            affhabilitie existingHabilitie = optionalHabilitie.get();
            existingHabilitie.setHabLiblat(habilitie.getHabLiblat());
            existingHabilitie.setHabLibara(habilitie.getHabLibara());
            existingHabilitie.setHabFineff(habilitie.getHabFineff());

            habilitieRepository.save(existingHabilitie); // Mise à jour de l'habilitation
        } else {
            throw new RuntimeException("Habilitation non trouvée");
        }
    }

    @Override
    public void deleteHabilitie(affHabilitieId id) {
        Optional<affhabilitie> optionalHabilitie = habilitieRepository.findById(id);
        if (optionalHabilitie.isPresent()) {
            habilitieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Habilitation non trouvée");
        }
    }

    @Override
    public Optional<affhabilitie> getHabilitie(affHabilitieId id) {
        return habilitieRepository.findById(id);
    }

    @Override
    public List<affhabilitie> getAllHabilities() {
        return habilitieRepository.findAll();
    }

    public AffHabilitieResponseDto toDto(affhabilitie habilitie) {
        return new AffHabilitieResponseDto(
            habilitie.getHabIdenti(),
            habilitie.getHabDebeff(),
            habilitie.getHabLiblat(),
            habilitie.getHabLibara(),
            habilitie.getHabFineff()
        );
    }

    // Méthode de conversion : DTO (Requête) -> Entité
    public affhabilitie toEntity(AffHabilitieRequestDto requestDto) {
        return new affhabilitie(
            requestDto.getHabIdenti(),
            requestDto.getHabDebeff(),
            requestDto.getHabLiblat(),
            requestDto.getHabLibara(),
            requestDto.getHabFineff()
        );
    }
}
