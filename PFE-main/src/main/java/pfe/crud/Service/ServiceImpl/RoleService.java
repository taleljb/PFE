package pfe.crud.Service.ServiceImpl;


import pfe.crud.Models.Role;
import pfe.crud.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Créer un rôle
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
