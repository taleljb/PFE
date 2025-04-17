package pfe.crud.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;
import pfe.crud.Repository.AffUserProfilRepository;
import pfe.crud.Service.ServiceInterface.UserprofilService;

import java.util.Date;
import java.util.Optional;

@Service
public class UserprofilServiceImpl implements UserprofilService {
    private static int compteur = 1;
    public final AffUserProfilRepository userRepository ;
    public UserprofilServiceImpl(AffUserProfilRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public void createuser(AffUserProfil user) {
    	System.out.println("identi= "+user.getPrfIdenti());
        // Vérifier que l'identifiant n'est pas null ou vide
        if (user.getPrfIdenti() == null || user.getPrfIdenti().isEmpty()) {
            throw new IllegalArgumentException("Identifiant doit être fourni");
        }

        // Vérifier que la date de début n'est pas null
        if (user.getPrfDebeff() == null) {
            throw new IllegalArgumentException("Date de début doit être fournie");
        }

        // Sauvegarde de l'utilisateur avec les informations reçues
        userRepository.save(user);
        
    }

	@Override
	public void updateuser(AffUserProfil user, AffUserProfilId id) {
		   Optional<AffUserProfil> optionalUser = userRepository.findById(id);

		    if (optionalUser.isPresent()) {
		        AffUserProfil existingUser = optionalUser.get();
		        existingUser.setPrfLiblat(user.getPrfLiblat());
		        existingUser.setPrfLibara(user.getPrfLibara());
		        existingUser.setPrfFineff(user.getPrfFineff());

		        userRepository.save(existingUser); // Fait un update
		    } else {
		        throw new RuntimeException("Utilisateur non trouvé");
		    }		
	}
	@Override
	public void deleteuser(AffUserProfilId id) {
		Optional<AffUserProfil> optionalUser = userRepository.findById(id);
		 if (optionalUser.isPresent()) {
			 userRepository.deleteById(id);
		 }
		
	}
	@Override
	  public Optional<AffUserProfil> getuser (AffUserProfilId id) {
		return userRepository.findById(id);
	
	}
}