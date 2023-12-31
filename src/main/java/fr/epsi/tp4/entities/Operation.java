package fr.epsi.tp4.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;

    private double montant;

    private String motif;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    public Operation() {
    }

    public Operation(LocalDateTime date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    public Operation(double montant, String motif) {
        this.montant = montant;
        this.motif = motif;
    }

    public Operation(double montant, String motif, Compte compte) {
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
        this.compte = compte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
