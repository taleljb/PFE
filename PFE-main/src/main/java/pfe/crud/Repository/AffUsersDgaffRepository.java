package pfe.crud.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pfe.crud.Models.AffUsersDgaff;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AffUsersDgaffRepository extends JpaRepository<AffUsersDgaff, String> {
    Optional<AffUsersDgaff> findByEmail(String email);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users_roles WHERE USR_IDENTI = :usrIdenti", nativeQuery = true)
    void deleteUserRoles(@Param("usrIdenti") String usrIdenti);
    List<AffUsersDgaff> findByProfil_PrfIdentiAndProfil_PrfDebeff(String prfIdenti, Date prfDebeff);

}
