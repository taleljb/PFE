package pfe.crud.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class affHabilitieId implements Serializable {

    private String habIdenti;
    private Date habDebeff;

    // Constructeur par défaut
    public affHabilitieId() {}

    // Constructeur avec paramètres
    public affHabilitieId(String habIdenti, Date habDebeff) {
        this.habIdenti = habIdenti;
        this.habDebeff = habDebeff;
    }

    // Getters et Setters
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

    // Redéfinir equals et hashCode pour que la clé composite fonctionne correctement
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        affHabilitieId that = (affHabilitieId) o;
        return Objects.equals(habIdenti, that.habIdenti) && Objects.equals(habDebeff, that.habDebeff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habIdenti, habDebeff);
    }
}
