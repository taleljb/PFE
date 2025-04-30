package pfe.crud.Service.ServiceInterface;

import java.util.List;
import java.util.Optional;

import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;

public interface UserprofilService {
    public void createuser (AffUserProfil user);
    public void updateuser (AffUserProfil user, AffUserProfilId id);
    public void deleteuser (AffUserProfilId id);
    public Optional<AffUserProfil> getuser (AffUserProfilId id);
    public List <AffUserProfil> getusers ();
    
}