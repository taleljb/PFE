package pfe.crud.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;

public interface AffUserProfilRepository extends JpaRepository <AffUserProfil, AffUserProfilId> {
	  @Modifying
	    @Transactional
	    @Query(value = "DELETE FROM AFF_PROFIHABIL WHERE PRF_IDENTI = :prfIdenti AND PRF_DEBEFF = :prfDebeff", nativeQuery = true)
	  void deleteUserProfilHabilitieLinks(@Param("prfIdenti") String prfIdenti, @Param("prfDebeff") Date prfDebeff);


}
