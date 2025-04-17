package pfe.crud.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import pfe.crud.Models.AffUsersDgaff;
import pfe.crud.Repository.AffUsersDgaffRepository;
import pfe.crud.Service.ServiceInterface.userdgaffservice;

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
}
