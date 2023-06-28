package test;
import java.sql.*;
import java.util.List;



import genereDao.AutoreDao;
import genereDao.AutoreDaoImpl;
import model.Autore;


public class TestAutore {

	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/betacom";
	        String username = "root";
	        String password = "Ciccio1968";
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            System.out.println("Connessione al database riuscita");

	            // Creazione dell'oggetto GenereDaoImpl
	            AutoreDao autoreDao = new AutoreDaoImpl(connection);

	            // Test del metodo getAll()
	            System.out.println("Autori presenti su DB:");
	            List<Autore> autori = autoreDao.getAll();
	            for (Autore autore : autori) {
	                System.out.println(autore);
	            }

	            // Test del metodo getGenereById()
	            System.out.println("\nAutore con codiceA = 2:");
	            Autore autore = autoreDao.getAutoreById(2);
	            System.out.println(autore);

	            // Test del metodo insert()
	            Autore nuovoAutore = new Autore();
	            
	            nuovoAutore.setNome("Nuovo autore");
	            nuovoAutore.setSesso("Nuova sesso");
	            nuovoAutore.setNazione("Nuova nazione");
	            autoreDao.insert(nuovoAutore);
	            System.out.println("\nNuovo autore inserito:");
	            System.out.println(nuovoAutore);
	            autori = autoreDao.getAll();
	            for (Autore p : autori) {
	                System.out.println(p);
	            }

	            // Test del metodo update()
	            autore.setNome("jkrowling");
	            autoreDao.update(autore);
	            System.out.println("\nAutore con id = 2 aggiornato:");
	            System.out.println(autore);
	            autori = autoreDao.getAll();
	            for (Autore f : autori) {
	                System.out.println(f);
	            }

	            // Test del metodo delete()
	            autoreDao.delete(nuovoAutore.getId());
	            System.out.println("\nEditore con id = " + nuovoAutore.getId() + " eliminato");

	            // Test del metodo getAll() dopo l'eliminazione
	            System.out.println("\nEditori presenti su DB dopo l'eliminazione:");
	            autori = autoreDao.getAll();
	            for (Autore g : autori) {
	                System.out.println(g);
	            }
	        } catch (SQLException e) {
	            System.out.println("Connessione al database fallita");
	            e.printStackTrace();
	        }
	    }
	}

