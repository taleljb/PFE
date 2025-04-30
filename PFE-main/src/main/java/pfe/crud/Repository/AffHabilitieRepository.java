package pfe.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfe.crud.Models.affHabilitieId;
import pfe.crud.Models.affhabilitie;

@Repository
public interface AffHabilitieRepository extends JpaRepository<affhabilitie, affHabilitieId> {
}
