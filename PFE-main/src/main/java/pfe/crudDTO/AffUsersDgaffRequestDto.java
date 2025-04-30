package pfe.crudDTO;

import pfe.crud.Models.Role;

import java.util.Date;
import java.util.Set;

public class AffUsersDgaffRequestDto {

    private String usrIdenti;
    private String usrNomusr;
    private String password;
    private String email;
	private String usrPrenom;
    private Date usrDatnai;
    private Set<Long> roles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Long> getRoles() {
        return roles;
    }

    public void setRoles(Set<Long> roles) {
        this.roles = roles;
    }
}
