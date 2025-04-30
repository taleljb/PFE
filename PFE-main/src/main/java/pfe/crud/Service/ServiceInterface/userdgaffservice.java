package pfe.crud.Service.ServiceInterface;

import pfe.crud.Models.AffUsersDgaff;
import java.util.List;
import java.util.Optional;

public interface userdgaffservice {
   public void create(AffUsersDgaff user);
    public void update(String id, AffUsersDgaff user);
    public void delete(String id);
    Optional<AffUsersDgaff> getById(String id);
    List<AffUsersDgaff> getAll();
}






