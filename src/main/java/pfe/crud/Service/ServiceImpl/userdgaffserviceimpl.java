package pfe.crud.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Repository.AffUsersDgaffRepository;
import pfe.crud.Service.ServiceInterface.userdgaffservice;
import pfe.crudDTO.AffUsersDgaffRequestDto;
import pfe.crudDTO.AffUsersDgaffResponseDto;

import java.util.List;
import java.util.Optional;

@Service
public class userdgaffserviceimpl implements userdgaffservice {

    private final AffUsersDgaffRepository repository;

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

    @Override
    public void delete(String id) {
        repository.deleteById(id);
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
        dto.setUsrPrenom(user.getUsrPrenom());
        dto.setUsrDatnai(user.getUsrDatnai());

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
        user.setUsrPrenom(dto.getUsrPrenom());
        user.setUsrDatnai(dto.getUsrDatnai());

        if (dto.getPrfIdenti() != null && dto.getPrfDebeff() != null) {
            AffUserProfil profil = new AffUserProfil();
            profil.setPrfIdenti(dto.getPrfIdenti());
            profil.setPrfDebeff(dto.getPrfDebeff());
            // Optionnel : setPrfLiblat/Libara si disponibles dans la BDD (sinon laisser à null)

            user.setProfil(profil);
        }

        return user;
    }

}
