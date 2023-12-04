package fr.epsi.b32324c2;

import fr.epsi.b32324c2.dal.ILivreDAO;
import fr.epsi.b32324c2.dal.Impl.LivreDAOImpl;
import fr.epsi.b32324c2.entities.Livre;

import java.util.List;
import java.util.Optional;

public class TestJPA {
    public static void main(String[] args) {
        ILivreDAO livreDAO = new LivreDAOImpl();

        Optional<Livre> livreDAOById = livreDAO.getById(1);
        System.out.println(livreDAOById);

        livreDAO.insert(new Livre("titre", "auteur"));
        System.out.println("enregistrer un nouveau livre");

        livreDAO.update(5, new Livre(" Du plaisir dans la cuisine", "auteur"));
        System.out.println("Livre 5 est modifier");

        Optional<Livre> libreByTitle = livreDAO.getByTitle("Vingt mille lieues sous les mers");
        System.out.println(libreByTitle);

        List<Livre> libreByAuthor = livreDAO.getByAuthor("Jules Verne");
        System.out.println(libreByAuthor);

        livreDAO.deleteById(9);
        System.out.println("delete livre 9");

        List<Livre> allLivre = livreDAO.getAll();
        System.out.println(allLivre);
    }
}
