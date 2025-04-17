package pfe.crud.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AFF_HABILITIES")
@IdClass(affHabilitieId.class)
public class affhabilitie implements Serializable {

    @Id
    private String habIdenti;

    @Id
    @Temporal(TemporalType.DATE)
    private Date habDebeff;

    private String habLiblat;
    private String habLibara;

    @Temporal(TemporalType.DATE)
    private Date habFineff;

    public affhabilitie() {}

    public affhabilitie(String habIdenti, Date habDebeff, String habLiblat, String habLibara, Date habFineff) {
        this.habIdenti = habIdenti;
        this.habDebeff = habDebeff;
        this.habLiblat = habLiblat;
        this.habLibara = habLibara;
        this.habFineff = habFineff;
    }
    // Getters and setters
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
