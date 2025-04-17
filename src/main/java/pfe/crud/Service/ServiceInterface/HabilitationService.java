package pfe.crud.Service.ServiceInterface;

import pfe.crud.Models.affhabilitie;
import pfe.crud.Models.affHabilitieId;

import java.util.List;
import java.util.Optional;

public interface HabilitationService {

    // Méthode pour obtenir toutes les habilitations
    List<affhabilitie> getAllHabilities();

    // Méthode pour obtenir une habilitation par son identifiant composite
    Optional<affhabilitie> getHabilitie(affHabilitieId id);

    // Méthode pour créer une nouvelle habilitation
    void createHabilitie(affhabilitie habilitie);

    // Méthode pour mettre à jour une habilitation existante
    void updateHabilitie(affhabilitie habilitie, affHabilitieId id);

    // Méthode pour supprimer une habilitation
    void deleteHabilitie(affHabilitieId id);
}
