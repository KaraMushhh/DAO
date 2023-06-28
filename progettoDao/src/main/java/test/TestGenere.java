package test;

import java.sql.*;
import java.util.List;

import genereDao.GenereDao;
import genereDao.GenereDaoImpl;
import model.Genere;

public class TestGenere {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/betacom";
        String username = "root";
        String password = "Ciccio1968";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connessione al database riuscita");

            // Creazione dell'oggetto GenereDaoImpl
            GenereDao genereDao = new GenereDaoImpl(connection);

            // Test del metodo getAll()
            System.out.println("Generi presenti su DB:");
            List<Genere> generi = genereDao.getAll();
            for (Genere genere : generi) {
                System.out.println(genere);
            }

            // Test del metodo getGenereById()
            System.out.println("\nGenere con id = 2:");
            Genere genere = genereDao.getGenereById(2);
            System.out.println(genere);

            // Test del metodo insert()
            Genere nuovoGenere = new Genere();
            nuovoGenere.setNome("Nuovo genere");
            genereDao.insert(nuovoGenere);
            System.out.println("\nNuovo genere inserito:");
            System.out.println(nuovoGenere);
            generi = genereDao.getAll();
            for (Genere p : generi) {
                System.out.println(p);
            }

            // Test del metodo update()
            genere.setNome("Romanzo");
            genereDao.update(genere);
            System.out.println("\nGenere con id = 2 aggiornato:");
            System.out.println(genere);
            generi = genereDao.getAll();
            for (Genere f : generi) {
                System.out.println(f);
            }

            // Test del metodo delete()
            genereDao.delete(nuovoGenere.getId());
            System.out.println("\nGenere con id = " + nuovoGenere.getId() + " eliminato");

            // Test del metodo getAll() dopo l'eliminazione
            System.out.println("\nGeneri presenti su DB dopo l'eliminazione:");
            generi = genereDao.getAll();
            for (Genere g : generi) {
                System.out.println(g);
            }
        } catch (SQLException e) {
            System.out.println("Connessione al database fallita");
            e.printStackTrace();
        }
    }
}
