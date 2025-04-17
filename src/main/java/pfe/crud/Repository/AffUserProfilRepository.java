package pfe.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;

public interface AffUserProfilRepository extends JpaRepository <AffUserProfil, AffUserProfilId> {
}
