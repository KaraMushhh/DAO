package it.betacom.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.itextpdf.text.Element;

import it.betacom.service.PrintService;
import model.Autore;
import model.Editore;
import model.Genere;
import model.Libro;
import genereDao.LibroDao;
import genereDao.LibroDaoImpl;
public class PrintServiceImpl<T> implements PrintService<T>{
	private List<Libro> list;
	private List<Genere> list2;
	private List<Editore> list3;
	private List<Autore> list4;
	 
	@Override
	public void saveListAsPdf() {
		 String url = "jdbc:mysql://localhost:3306/betacom";
	        String username = "root";
	        String password = "Ciccio1968";
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            System.out.println("Connessione al database riuscita");

	            // Creazione dell'oggetto GenereDaoImpl
	            LibroDao libroDao = new LibroDaoImpl(connection);
	            Document document = new Document();
	            java.io.OutputStream out;

	            try {
	            	out = new FileOutputStream(new File("C:/Users/matti/output.pdf"));
	                PdfWriter.getInstance(document, out);
	                document.open();
	                document.add(new Paragraph("stampa dei file nel pdf!"));
	                Paragraph paragraph = new Paragraph();
	                for (int i=0; i<libroDao.getAll().size(); i++)
	                {
	                	paragraph.add(new Paragraph("/n" + libroDao.getAll().get(i)));
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            } 
	            
	            finally {
	                document.close();
	            }
	            
	            
	} catch (SQLException e) {
        System.out.println("Connessione al database fallita");
        e.printStackTrace();
	}
	}

	@Override
	public void saveListAsCsv() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveListAsTxt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAsPdf(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAsCsv(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAsTxt(T t) {
		// TODO Auto-generated method stub
		
	}

}
