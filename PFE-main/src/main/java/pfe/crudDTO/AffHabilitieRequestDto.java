package pfe.crudDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AffHabilitieRequestDto {
    private String habIdenti;
    private Date habDebeff;
    private String habLiblat;
    private String habLibara;
    private Date habFineff;

    public AffHabilitieRequestDto() {}
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
