package pfe.crudDTO;

import java.util.Date;

public class AffUsersDgaffResponseDto {

    private String usrIdenti;
    private String password;
    private String usrNomusr;
    private String usrPrenom;
    private Date usrDatnai;

    private String prfIdenti;
    private Date prfDebeff;
    private String prfLiblat;
    private String prfLibara;

    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getUsrIdenti() {
        return usrIdenti;
    }

    public void setUsrIdenti(String usrIdenti) {
        this.usrIdenti = usrIdenti;
    }

    public String getUsrNomusr() {
        return usrNomusr;
    }

    public void setUsrNomusr(String usrNomusr) {
        this.usrNomusr = usrNomusr;
    }

    public String getUsrPrenom() {
        return usrPrenom;
    }

    public void setUsrPrenom(String usrPrenom) {
        this.usrPrenom = usrPrenom;
    }

    public Date getUsrDatnai() {
        return usrDatnai;
    }

    public void setUsrDatnai(Date usrDatnai) {
        this.usrDatnai = usrDatnai;
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
}
