package fr.epsi.tp4.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {
    private double taux;

    public LivretA() {
    }

    public LivretA(double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public LivretA(String numero, double solde, Set<Client> clients, double taux) {
        super(numero, solde, clients);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
