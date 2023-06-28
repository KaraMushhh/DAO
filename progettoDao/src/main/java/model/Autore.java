package model;

public class Autore {
	private int codiceA;
    private String nomeA;
    private String sesso;
    private String nazione;
    
    public Autore(int codiceA, String nomeA, String sesso, String nazione) {
        this.codiceA = codiceA;
        this.nomeA = nomeA;
        this.sesso = sesso;
        this.nazione = nazione;
    }
    public Autore() {
        this.codiceA = 0;
        this.nomeA = null;
        this.sesso = null;
        this.nazione = null;
    }
    public int getId() {
        return codiceA;
    }

    public void setId(int codiceA) {
        this.codiceA = codiceA;
    }

    public String getNome() {
        return nomeA;
    }
    
    public String getSesso() {
        return sesso;
    }
    
    public String getNazione() {
        return nazione;
    }

    public void setNome(String nomeA) {
        this.nomeA = nomeA;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    public void setNazione(String nazione) {
        this.nazione = nazione;
    }
    
    @Override
    public String toString()
    {
    	return "{id:" + codiceA + "nome autore" + nomeA + "sesso" + sesso + "nazione" + nazione + "}";
    }
}
