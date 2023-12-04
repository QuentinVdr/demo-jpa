package fr.epsi.b32324c2.dal;

import fr.epsi.b32324c2.entities.Livre;

import java.util.List;
import java.util.Optional;

public interface ILivreDAO {

    /**
     * Get a livre from the database
     *
     * @param id the id of the livre to get
     * @return the livre
     */
    Optional<Livre> getById(int id);

    /**
     * Insert a livre in the database
     *
     * @param livre the livre to insert
     */
    void insert(Livre livre);

    /**
     * Update a livre in the database
     *
     * @param id id of the livre to update
     * @param livre the livre to update
     */
    void update(int id, Livre livre);

    /**
     * Get a livre in the database by its title
     *
     * @param title title of the livre to get
     */
    Optional<Livre> getByTitle(String title);

    /**
     * Get a livre in the database by its author
     *
     * @param author title of the livre to get
     */
    List<Livre> getByAuthor(String author);

    /**
     * Delete a livre in the database
     *
     * @param id id of the livre to delete
     */
    void deleteById(int id);

    /**
     * Get all livres in the database
     *
     * @return all livres
     */
    List<Livre> getAll();
}
