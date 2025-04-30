package pfe.crudDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AffUserProfilResponseDto {
    private String prfIdenti;
    private Date prfDebeff;
    private String prfLiblat;
    private String prfLibara;
    private Date prfFineff;
    
    // Habilités associées au profil
    private Set<AffHabilitieResponseDto> habilities = new HashSet<>();

 

    // Getters
    public String getPrfIdenti() {
        return prfIdenti;
    }

    public AffUserProfilResponseDto(String prfIdenti, Date prfDebeff, String prfLiblat, String prfLibara,
			Date prfFineff, Set<AffHabilitieResponseDto> habilities) {
		super();
		this.prfIdenti = prfIdenti;
		this.prfDebeff = prfDebeff;
		this.prfLiblat = prfLiblat;
		this.prfLibara = prfLibara;
		this.prfFineff = prfFineff;
		this.habilities = habilities;
	}

	public Date getPrfDebeff() {
        return prfDebeff;
    }

    public String getPrfLiblat() {
        return prfLiblat;
    }

    public String getPrfLibara() {
        return prfLibara;
    }

    public Date getPrfFineff() {
        return prfFineff;
    }

    // Getter et Setter pour les habilités
    public Set<AffHabilitieResponseDto> getHabilities() {
        return habilities;
    }

    public void setHabilities(Set<AffHabilitieResponseDto> habilities) {
        this.habilities = habilities;
    }
}
