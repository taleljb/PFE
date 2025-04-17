package pfe.crud.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
public class AffUserProfilId implements Serializable {
    private String prfIdenti;
    private Date prfDebeff;
    public AffUserProfilId() {}
    public AffUserProfilId(String prfIdenti, Date prfDebeff) {
        this.prfIdenti = prfIdenti;
        this.prfDebeff = prfDebeff;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AffUserProfilId)) return false;
        AffUserProfilId that = (AffUserProfilId) o;
        return Objects.equals(prfIdenti, that.prfIdenti) &&
                Objects.equals(prfDebeff, that.prfDebeff);
    }
    @Override
    public int hashCode() {
        return Objects.hash(prfIdenti, prfDebeff);
    }
}
