package pfe.crudDTO;

import java.util.Date;

public class AffUsersDgaffRequestDto {

    private String usrIdenti;
    private String usrNomusr;
    private String password;
	private String usrPrenom;
    private Date usrDatnai;

    // Clé étrangère vers AffUserProfil
    private String prfIdenti;
    private Date prfDebeff;

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
}
