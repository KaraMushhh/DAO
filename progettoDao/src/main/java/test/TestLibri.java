package test;

import java.sql.*;
import java.util.List;

import genereDao.GenereDao;
import genereDao.GenereDaoImpl;
import genereDao.LibroDao;
import genereDao.LibroDaoImpl;
import model.Genere;
import model.Libro;

public class TestLibri {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/betacom";
        String username = "root";
        String password = "Ciccio1968";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connessione al database riuscita");

            // Creazione dell'oggetto GenereDaoImpl
            LibroDao libroDao = new LibroDaoImpl(connection);

            // Test del metodo getAll()
            System.out.println("Generi presenti su DB:");
            List<Libro> libri = libroDao.getAll();
            for (Libro libro : libri) {
                System.out.println(libro);
            }

            // Test del metodo getGenereById()
            System.out.println("\nLibro con id = 2:");
            Libro libro = libroDao.getLibroById(2);
            System.out.println(libro);

            // Test del metodo insert()
            Libro nuovoLibro = new Libro();
            nuovoLibro.setTitolo("Nuovo titolo");
            libroDao.insert(nuovoLibro);
            System.out.println("\nNuovo libro inserito:");
            System.out.println(nuovoLibro);
            libri = libroDao.getAll();
            for (Libro p : libri) {
                System.out.println(p);
            }

            // Test del metodo update()
            libro.setTitolo("la vita è bella");
            libroDao.update(libro);
            System.out.println("\nLibro con id = 2 aggiornato:");
            System.out.println(libro);
            libri = libroDao.getAll();
            for (Libro f : libri) {
                System.out.println(f);
            }

            // Test del metodo delete()
            libroDao.delete(nuovoLibro.getId());
            System.out.println("\nGenere con id = " + nuovoLibro.getId() + " eliminato");

            // Test del metodo getAll() dopo l'eliminazione
            System.out.println("\nGeneri presenti su DB dopo l'eliminazione:");
            libri = libroDao.getAll();
            for (Libro g : libri) {
                System.out.println(g);
            }
        } catch (SQLException e) {
            System.out.println("Connessione al database fallita");
            e.printStackTrace();
        }
    }
}