package fr.epsi.b32324c2;

import fr.epsi.b32324c2.dal.ILivreDAO;
import fr.epsi.b32324c2.dal.Impl.LivreDAOImpl;
import fr.epsi.b32324c2.entities.Livre;

import java.util.Optional;

public class TestJPA {
    public static void main(String[] args) {
        ILivreDAO livreDAO = new LivreDAOImpl();

        Optional<Livre> livreDAOById = livreDAO.getById(1);
        System.out.println(livreDAOById);

        livreDAO.insert(new Livre("titre", "auteur"));
        System.out.println("enregistrer un nouveau livre");
    }
}
