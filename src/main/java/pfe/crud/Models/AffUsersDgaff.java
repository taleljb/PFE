package pfe.crud.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AFF_USERSDGAFF")
public class AffUsersDgaff {

    @Id
    @Column(name = "USR_IDENTI", length = 10)
    private String usrIdenti;
    
    
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "USR_NOMUSR", length = 100)
    private String usrNomusr;

    @Column(name = "USR_PRENOM", length = 100)
    private String usrPrenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "USR_DATNAI")
    private Date usrDatnai;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "PRF_IDENTI", referencedColumnName = "PRF_IDENTI"),
        @JoinColumn(name = "PRF_DEBEFF", referencedColumnName = "PRF_DEBEFF")
    })
    private AffUserProfil profil;


    public AffUsersDgaff() {}

    public AffUsersDgaff(String usrIdenti, String usrNomusr,String password, String usrPrenom, Date usrDatnai, AffUserProfil profil) {
        this.usrIdenti = usrIdenti;
        this.usrNomusr = usrNomusr;
        this.password = password;

        this.usrPrenom = usrPrenom;
        this.usrDatnai = usrDatnai;
        this.profil = profil;
    }
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsrIdenti() { return usrIdenti; }
    public void setUsrIdenti(String usrIdenti) { this.usrIdenti = usrIdenti; }

    public String getUsrNomusr() { return usrNomusr; }
    public void setUsrNomusr(String usrNomusr) { this.usrNomusr = usrNomusr; }

    public String getUsrPrenom() { return usrPrenom; }
    public void setUsrPrenom(String usrPrenom) { this.usrPrenom = usrPrenom; }

    public Date getUsrDatnai() { return usrDatnai; }
    public void setUsrDatnai(Date usrDatnai) { this.usrDatnai = usrDatnai; }

    public AffUserProfil getProfil() { return profil; }
    public void setProfil(AffUserProfil profil) { this.profil = profil; }
}
