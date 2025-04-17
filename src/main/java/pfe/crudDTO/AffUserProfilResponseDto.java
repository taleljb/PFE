package pfe.crudDTO;

import java.util.Date;

public class AffUserProfilResponseDto {
    private String prfIdenti;
    private Date prfDebeff;
    private String prfLiblat;
    private String prfLibara;
    private Date prfFineff;

    // Constructeur
    public AffUserProfilResponseDto(String prfIdenti, Date prfDebeff, String prfLiblat, String prfLibara, Date prfFineff) {
        this.prfIdenti = prfIdenti;
        this.prfDebeff = prfDebeff;
        this.prfLiblat = prfLiblat;
        this.prfLibara = prfLibara;
        this.prfFineff = prfFineff;
    }

    // Getters
    public String getPrfIdenti() {
        return prfIdenti;
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
}

