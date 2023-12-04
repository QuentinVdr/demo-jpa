package fr.epsi.b32324c2.dal;

import fr.epsi.b32324c2.entities.Livre;

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
     *
     * @param id id of the livre to update
     * @param livre the livre to update
     */
    void update(int id, Livre livre);
}
