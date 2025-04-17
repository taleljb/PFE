package pfe.crud.Models;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@IdClass(AffUserProfilId.class)
@Table(name = "AFF_USERPROFIL")
public class AffUserProfil {
    @Id
    @Column(name = "PRF_IDENTI", length = 2, nullable = false)
    private String prfIdenti;
    @Id
    @Column(name = "PRF_DEBEFF", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date prfDebeff;
    @Column(name = "PRF_LIBLAT", length = 300)
    private String prfLiblat;
    @Column(name = "PRF_LIBARA", length = 300)
    private String prfLibara;
    @Column(name = "PRF_FINEFF")
    @Temporal(TemporalType.DATE)
    private Date prfFineff;

    public AffUserProfil(String prfIdenti,Date prfDebeff,String prfLiblat, String prfLibara, Date prfFineff) {
        this.prfIdenti = prfIdenti;
        this.prfDebeff = prfDebeff;
        this.prfLiblat = prfLiblat;
        this.prfLibara = prfLibara;
        this.prfFineff = prfFineff;
    }

    public AffUserProfil() {

    }

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
}
