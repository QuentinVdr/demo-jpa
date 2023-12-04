package fr.epsi.b32324c2.dal.Impl;

import fr.epsi.b32324c2.dal.ILivreDAO;
import fr.epsi.b32324c2.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class LivreDAOImpl implements ILivreDAO {
    @Override
    public Optional<Livre> getById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        Livre livre = entityManager.find(Livre.class, id);

        entityManager.close();
        emf.close();

        if (livre == null)
            return Optional.empty();
        else
            return Optional.of(livre);
    }

    @Override
    public void insert(Livre livre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(livre);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }

    @Override
    public void update(int id, Livre livre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        Livre livreRead = entityManager.find(Livre.class, id);
        livreRead.setTitre(livre.getTitre());
        livreRead.setAuteur(livre.getAuteur());
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }

    @Override
    public Optional<Livre> getByTitle(String title) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        Livre livre = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre = :titre", Livre.class)
                .setParameter("titre", title)
                .getSingleResult();

        entityManager.close();
        emf.close();

        if (livre == null)
            return Optional.empty();
        else
            return Optional.of(livre);
    }

    @Override
    public List<Livre> getByAuthor(String author) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        List<Livre> livres = entityManager.createQuery("SELECT l FROM Livre l WHERE l.auteur = :auteur", Livre.class)
                .setParameter("auteur", author)
                .getResultList();

        entityManager.close();
        emf.close();

        return livres;
    }

    @Override
    public void deleteById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        Livre livre = entityManager.find(Livre.class, id);
        entityManager.remove(livre);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }

    @Override
    public List<Livre> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        List<Livre> livres = entityManager.createQuery("SELECT l FROM Livre l", Livre.class)
                .getResultList();

        entityManager.close();
        emf.close();

        return livres;
    }
}
