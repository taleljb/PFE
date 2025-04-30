package pfe.crud.Service.ServiceInterface;

import pfe.crud.Models.affhabilitie;
import pfe.crud.Models.affHabilitieId;

import java.util.List;
import java.util.Optional;

public interface HabilitationService {

    List<affhabilitie> getAllHabilities();
    Optional<affhabilitie> getHabilitie(affHabilitieId id);
    void createHabilitie(affhabilitie habilitie);
    void updateHabilitie(affhabilitie habilitie, affHabilitieId id);
    void deleteHabilitie(affHabilitieId id);
}
