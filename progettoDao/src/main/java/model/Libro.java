package model;
import model.Editore;
import model.Genere;

import java.time.LocalDate;

import model.Autore;

public class Libro {
	private int codiceL;
    private String titolo;
    private int numPag;
    private LocalDate date;
    Autore autore = new Autore();
    
    public Libro(int codiceL, String titolo, int numPag, LocalDate date, Editore editore, Genere genere, Autore autore ) {
        this.codiceL = codiceL;
        this.titolo = titolo;
        this.numPag = numPag;
        this.date = date;
        editore.getId();
        genere.getId();
        autore.getId();
        
    }
    public Libro() {
        this.codiceL = 0;
        this.titolo = null;
        this.numPag = 0;
        this.date = null;
        
    }
    public int getId() {
        return codiceL;
    }

    public void setId(int codiceL) {
        this.codiceL = codiceL;
    }

    public String getTitolo() {
        return titolo;
    }
    
    public int getnumPag() {
        return numPag;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
    public void setDate(LocalDate date) {
    	this.date = date;
    }
    public LocalDate getDate() {
    	return date;
    }
    public Autore setAutore() {
    	Autore autore = new Autore();
    	return autore;
    }
    public Editore setEditore() {
    	Editore editore = new Editore();
    	return editore;
    }
    public Genere setGenere() {
    	Genere genere = new Genere();
    	return genere;
    }
    
    public int getIDautore()
    {
    	return autore.getId();
    }
    
    public String getNomeAutore(String s)
    {
    	String a = autore.getNome();
    	s=a;
    	return s;
    }
    
    public  String getSessoAutore()
    {
    	return autore.getSesso();
    }
    
    public  String getNazioneAutore()
    {
    	return autore.getNazione();
    }
   
    @Override
    public String toString()
    {
    	return "{id:" + codiceL + " "  + "titolo" + " " + titolo + " " + "numPag" + " " + numPag + " " + "CodiceA"
        + " " + getNomeAutore("p") + " " + "codiceG" + " " + setGenere() + " " + "codiceE" + " " + setEditore() +  "}";
    }
}
