package pfe.crud.Service.ServiceImpl;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Models.Role;
import pfe.crud.Repository.AffUsersDgaffRepository;
import pfe.crud.Repository.RoleRepository;
import pfe.crud.Service.ServiceInterface.userdgaffservice;
import pfe.crudDTO.AffUsersDgaffRequestDto;
import pfe.crudDTO.AffUsersDgaffResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class userdgaffserviceimpl implements userdgaffservice {

    private final AffUsersDgaffRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(userdgaffserviceimpl.class);

    public userdgaffserviceimpl(AffUsersDgaffRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(AffUsersDgaff user) {
        repository.save(user);
    }

    
    
    @Override
    public void update(String id, AffUsersDgaff user) {
        if (repository.existsById(id)) {
            user.setUsrIdenti(id); // s'assurer que l'ID correspond
            repository.save(user);
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec ID: " + id);
        }
    }
    @Transactional
    @Override
    public void delete(String usrIdenti) {
        repository.deleteUserRoles(usrIdenti);
        
        repository.deleteById(usrIdenti);
    }
    public void deleteAllUsersByProfil(AffUserProfilId profilId) {
                List<AffUsersDgaff> users = repository.findByProfil_PrfIdentiAndProfil_PrfDebeff(
            profilId.getPrfIdenti(), profilId.getPrfDebeff());

        for (AffUsersDgaff user : users) {
            repository.deleteUserRoles(user.getUsrIdenti());
        }

        for (AffUsersDgaff user : users) {
            repository.deleteById(user.getUsrIdenti());
        }
    }
    @Override
    public Optional<AffUsersDgaff> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<AffUsersDgaff> getAll() {
        return repository.findAll();
    }
    public AffUsersDgaffResponseDto mapToResponse(AffUsersDgaff user) {
        AffUsersDgaffResponseDto dto = new AffUsersDgaffResponseDto();
        dto.setUsrIdenti(user.getUsrIdenti());
        dto.setUsrNomusr(user.getUsrNomusr());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles());
        dto.setUsrPrenom(user.getUsrPrenom());
        dto.setUsrDatnai(user.getUsrDatnai());
    	logger.info("voici le mot de passe de ce user : {}", user.getPassword());
    	logger.info("voici le mot de passe de ce user : {}", dto.getPassword());

        if (user.getProfil() != null) {
            dto.setPrfIdenti(user.getProfil().getPrfIdenti());
            dto.setPrfDebeff(user.getProfil().getPrfDebeff());
            dto.setPrfLiblat(user.getProfil().getPrfLiblat());
            dto.setPrfLibara(user.getProfil().getPrfLibara());
        }

        return dto;
    }
    public AffUsersDgaff mapToEntity(AffUsersDgaffRequestDto dto) {
        AffUsersDgaff user = new AffUsersDgaff();
        user.setUsrIdenti(dto.getUsrIdenti());
        user.setUsrNomusr(dto.getUsrNomusr());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        System.out.println("Rôles reçus dans le DTO : " + dto.getRoles());
        System.out.println("Rôles reçus dans le DTO : " + dto.getRoles());

        Set<Role> rolesFromDb = dto.getRoles().stream()
                .map(id -> {
                    Role role = roleRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
                    // Afficher le nom du rôle pour plus de clarté
                    System.out.println("Rôle trouvé : " + role.getName());
                    return role;
                })
                .collect(Collectors.toSet());

        // Ajouter un log pour afficher les rôles avec leurs noms
        System.out.println("Rôles après récupération de la base de données : " + rolesFromDb.stream()
                .map(Role::getName)  // Afficher les noms des rôles
                .collect(Collectors.joining(", ")));
        user.setRoles(rolesFromDb);
        user.setUsrPrenom(dto.getUsrPrenom());
        user.setUsrDatnai(dto.getUsrDatnai());

        if (dto.getPrfIdenti() != null && dto.getPrfDebeff() != null) {
            AffUserProfil profil = new AffUserProfil();
            profil.setPrfIdenti(dto.getPrfIdenti());
            profil.setPrfDebeff(dto.getPrfDebeff());

            user.setProfil(profil);
        }

        return user;
    }

}
