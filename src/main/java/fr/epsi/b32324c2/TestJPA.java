package fr.epsi.b32324c2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-a1");
        EntityManager entityManager = emf.createEntityManager();

        System.out.println(entityManager.isOpen()); // se connecte à la bdd

        entityManager.close();
        emf.close();
    }
}
