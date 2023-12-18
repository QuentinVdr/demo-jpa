package fr.epsi.tp4;

import fr.epsi.tp4.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("pu-tp4");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Create a bank
        Banque banque = new Banque("Banque de France");
        // Persist the bank
        entityManager.persist(banque);

        // Create an address
        Adresse adresse = new Adresse(1, "rue de la Paix", 75000, "Paris");
        // Create a client
        Client client = new Client("Doe", "John", java.time.LocalDate.now(), adresse, banque);
        // Persist the client
        entityManager.persist(client);

        // Create an account
        Client clientFind = entityManager.find(Client.class, 1);
        Compte compte = new Compte("123456789", 100000, Set.of(clientFind));
        // Persist the account
        entityManager.persist(compte);

        // Create operation
        Operation operation = new Operation(java.time.LocalDateTime.now(), 100, "Virement", compte);
        // Persist the operation
        entityManager.persist(operation);

        // Commit the transaction
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}