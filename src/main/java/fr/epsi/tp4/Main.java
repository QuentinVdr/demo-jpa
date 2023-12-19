package fr.epsi.tp4;

import fr.epsi.tp4.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
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
        // Get the client with id 1
        Client clientFind = entityManager.find(Client.class, 1);

        // Create a livret A account
        LivretA livretA = new LivretA("123456789", 100000, Set.of(clientFind), 1.5);
        // Persist the livret A account
        entityManager.persist(livretA);

        // Create a life assurance account
        AssuranceVie assuranceVie = new AssuranceVie("987654321", 100000, Set.of(clientFind), 1.5, LocalDateTime.now());
        // Persist the livret A account
        entityManager.persist(assuranceVie);

        // Create an operation
        Operation operation = new Operation(java.time.LocalDateTime.now(), 100, "Dépense", livretA);
        // Persist the virement operation
        entityManager.persist(operation);

        // Create a virement operation
        Virement virement = new Virement(LocalDateTime.now(), 100, "Dépense", livretA, "John Doe");
        // Persist the virement operation
        entityManager.persist(virement);

        // Commit the transaction
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}