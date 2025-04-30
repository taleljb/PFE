package pfe.crud.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pfe.crud.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}