package pfe.crud.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pfe.crud.Models.AffUserProfil;
import pfe.crud.Models.AffUserProfilId;
import pfe.crud.Repository.AffUserProfilRepository;
import pfe.crud.Service.ServiceImpl.UserprofilServiceImpl;
import pfe.crud.Service.ServiceImpl.UserprofilServiceImpl;
import pfe.crud.Service.ServiceInterface.UserprofilService;

@RestController
@RequestMapping("/api/userprofils")
public class AffUserProfilController {
private final UserprofilServiceImpl UserprofilService;

    public AffUserProfilController(UserprofilServiceImpl UserprofilService) {
        this.UserprofilService = UserprofilService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody AffUserProfil user) {
        try {
        	UserprofilService.createuser(user);
            return ResponseEntity.ok("Utilisateur créé avec succès");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @PutMapping("/update/{prfIdenti}/{prfDebeff}")
    public ResponseEntity<String> update(
            @PathVariable String prfIdenti, 
            @PathVariable String prfDebeff, @RequestBody AffUserProfil user) {
    	  try {
    	        
    	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	        Date prfDebeffDate = format.parse(prfDebeff); 

    	    
    	        AffUserProfilId id = new AffUserProfilId(prfIdenti, prfDebeffDate);

    	        UserprofilService.updateuser(user, id);

    	    
    	        return ResponseEntity.ok("Utilisateur mis à jour avec succès");
    	    } catch (Exception e) {
    	       
    	        return ResponseEntity.badRequest().body("Erreur de format de date ou autre exception : " + e.getMessage());
    	    }
    }
@DeleteMapping("/delete/{prfIdenti}/{prfDebeff}")
public ResponseEntity<String> delete(
		@PathVariable String prfIdenti, 
        @PathVariable String prfDebeff
		)
{
	  try {
	        
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date prfDebeffDate = format.parse(prfDebeff); 

	    
	        AffUserProfilId id = new AffUserProfilId(prfIdenti, prfDebeffDate);

	        UserprofilService.deleteuser(id);

	    
	        return ResponseEntity.ok("Utilisateur supprimé avec succès");
	    } catch (Exception e) {
	       
	        return ResponseEntity.badRequest().body("Erreur de format de date ou autre exception : " + e.getMessage());
	    }
	  
}




}