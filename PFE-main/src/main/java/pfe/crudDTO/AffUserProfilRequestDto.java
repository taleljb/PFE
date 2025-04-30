package pfe.crudDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AffUserProfilRequestDto {
    private String prfIdenti;
    private Date prfDebeff;
    private String prfLiblat;
    private String prfLibara;
    private Date prfFineff;

    private Set<AffHabilitieResponseDto> habilities = new HashSet<>(); 

    // Getters et Setters
    public String getPrfIdenti() {
        return prfIdenti;
    }

    public void setPrfIdenti(String prfIdenti) {
        this.prfIdenti = prfIdenti;
    }

    public Date getPrfDebeff() {
        return prfDebeff;
    }

    public void setPrfDebeff(Date prfDebeff) {
        this.prfDebeff = prfDebeff;
    }

    public String getPrfLiblat() {
        return prfLiblat;
    }

    public void setPrfLiblat(String prfLiblat) {
        this.prfLiblat = prfLiblat;
    }

    public String getPrfLibara() {
        return prfLibara;
    }

    public void setPrfLibara(String prfLibara) {
        this.prfLibara = prfLibara;
    }

    public Date getPrfFineff() {
        return prfFineff;
    }

    public void setPrfFineff(Date prfFineff) {
        this.prfFineff = prfFineff;
    }

    public Set<AffHabilitieResponseDto> getHabilities() {
        return habilities;
    }

    public void setHabilities(Set<AffHabilitieResponseDto> habilities) {
        this.habilities = habilities;
    }
}
