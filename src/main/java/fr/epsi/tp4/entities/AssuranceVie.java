package fr.epsi.tp4.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {
    private double taux;

    private LocalDateTime dateFin;

    public AssuranceVie() {
    }

    public AssuranceVie(double taux) {
        this.taux = taux;
    }

    public AssuranceVie(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public AssuranceVie(String numero, double solde, Set<Client> clients, double taux) {
        super(numero, solde, clients);
        this.taux = taux;
    }

    public AssuranceVie(double taux, LocalDateTime dateFin) {
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public AssuranceVie(String numero, double solde, double taux, LocalDateTime dateFin) {
        super(numero, solde);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public AssuranceVie(String numero, double solde, Set<Client> clients, double taux, LocalDateTime dateFin) {
        super(numero, solde, clients);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
}
