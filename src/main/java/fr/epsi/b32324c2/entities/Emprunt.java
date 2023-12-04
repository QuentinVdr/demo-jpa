package fr.epsi.b32324c2.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_debut")
    Date dateDebut;

    @Column(name = "date_fin", nullable = true)
    Date dateFin;

    @Column(name = "delai")
    int delai;

    @ManyToMany
    @JoinTable(name = "compo",
            joinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "id")
    )
    Set<Livre> livres;

    @ManyToOne
    @JoinColumn(name = "id_client")
    Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                ", livres=" + livres +
                '}';
    }
}
