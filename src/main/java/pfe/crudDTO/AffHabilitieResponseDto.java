package pfe.crudDTO;

import java.util.Date;

public class AffHabilitieResponseDto {
    private String habIdenti;
    private Date habDebeff;
    private String habLiblat;
    private String habLibara;
    private Date habFineff;

    public AffHabilitieResponseDto() {}

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
