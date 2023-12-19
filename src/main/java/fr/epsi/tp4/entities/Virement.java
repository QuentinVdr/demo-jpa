package fr.epsi.tp4.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "virement")
public class Virement extends Operation {
    private String beneficiaire;

    public Virement() {
    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement(String beneficiaire, double montant, String motif) {
        super(montant, motif);
        this.beneficiaire = beneficiaire;
    }

    public Virement(String beneficiaire, double montant, String motif, Compte compte) {
        super(montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
