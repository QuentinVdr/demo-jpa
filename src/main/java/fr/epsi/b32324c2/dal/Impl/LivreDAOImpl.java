package fr.epsi.b32324c2.dal.Impl;

import fr.epsi.b32324c2.dal.ILivreDAO;
import fr.epsi.b32324c2.entities.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

}
