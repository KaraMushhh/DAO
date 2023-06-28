package test;


import java.sql.*;
import java.util.List;



import genereDao.EditoreDao;
import genereDao.EditoreDaoImpl;
import model.Editore;
public class TestEditore {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/betacom";
        String username = "root";
        String password = "Ciccio1968";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connessione al database riuscita");

            // Creazione dell'oggetto GenereDaoImpl
            EditoreDao EditoreDao = new EditoreDaoImpl(connection);

            // Test del metodo getAll()
            System.out.println("Generi presenti su DB:");
            List<Editore> editori = EditoreDao.getAll();
            for (Editore editore : editori) {
                System.out.println(editore);
            }

            // Test del metodo getGenereById()
            System.out.println("\nGenere con codiceG = 2:");
            Editore editore = EditoreDao.getEditoreById(2);
            System.out.println(editore);

            // Test del metodo insert()
            Editore nuovoEditore = new Editore();
            nuovoEditore.setNome("Nuovo editore");
            nuovoEditore.setSede("Nuova sede");
            EditoreDao.insert(nuovoEditore);
            System.out.println("\nNuovo editore inserito:");
            System.out.println(nuovoEditore);
            editori = EditoreDao.getAll();
            for (Editore p : editori) {
                System.out.println(p);
            }

            // Test del metodo update()
            editore.setNome("jkrowling");
            EditoreDao.update(editore);
            System.out.println("\nEditore con id = 2 aggiornato:");
            System.out.println(editore);
            editori = EditoreDao.getAll();
            for (Editore f : editori) {
                System.out.println(f);
            }

            // Test del metodo delete()
            EditoreDao.delete(nuovoEditore.getId());
            System.out.println("\nEditore con id = " + nuovoEditore.getId() + " eliminato");

            // Test del metodo getAll() dopo l'eliminazione
            System.out.println("\nEditori presenti su DB dopo l'eliminazione:");
            editori = EditoreDao.getAll();
            for (Editore g : editori) {
                System.out.println(g);
            }
        } catch (SQLException e) {
            System.out.println("Connessione al database fallita");
            e.printStackTrace();
        }
    }
}
