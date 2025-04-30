package pfe.crudDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AffHabilitieResponseDto {
    private String habIdenti;
    private Date habDebeff;
    private String habLiblat;
    private String habLibara;
    private Date habFineff;
    private Set<AffUserProfilResponseDto> userProfils = new HashSet<>();
    public AffHabilitieResponseDto() {}
    
    


    

    public Set<AffUserProfilResponseDto> getUserProfils() {
		return userProfils;
	}






	public void setUserProfils(Set<AffUserProfilResponseDto> userProfils) {
		this.userProfils = userProfils;
	}






	public AffHabilitieResponseDto(String habIdenti, Date habDebeff, String habLiblat, String habLibara, Date habFineff) {
        this.habIdenti = habIdenti;
        this.habDebeff = habDebeff;
        this.habLiblat = habLiblat;
        this.habLibara = habLibara;
        this.habFineff = habFineff;
    }

    public String getHabIdenti() {
        return habIdenti;
    }

    public void setHabIdenti(String habIdenti) {
        this.habIdenti = habIdenti;
    }

    public Date getHabDebeff() {
        return habDebeff;
    }

    public void setHabDebeff(Date habDebeff) {
        this.habDebeff = habDebeff;
    }

    public String getHabLiblat() {
        return habLiblat;
    }

    public void setHabLiblat(String habLiblat) {
        this.habLiblat = habLiblat;
    }

    public String getHabLibara() {
        return habLibara;
    }

    public void setHabLibara(String habLibara) {
        this.habLibara = habLibara;
    }

    public Date getHabFineff() {
        return habFineff;
    }

    public void setHabFineff(Date habFineff) {
        this.habFineff = habFineff;
    }
}
