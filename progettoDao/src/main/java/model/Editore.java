package model;

public class Editore {
	private int codiceE;
    private String nome;
    private String sede;
    
    public Editore(int codiceE, String nome, String sede) {
        this.codiceE = codiceE;
        this.nome = nome;
        this.sede = sede;
    }
    public Editore() {
        this.codiceE = 0;
        this.nome = null;
        this.sede = null;
    }
    public int getId() {
        return codiceE;
    }

    public void setId(int codiceE) {
        this.codiceE = codiceE;
    }

    public String getNome() {
        return nome;
    }
    
    public String getSede() {
        return sede;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSede(String sede) {
        this.sede = sede;
    }
    
    @Override
    public String toString()
    {
    	return "{id:" + codiceE + "nome categoria" + nome + "sede" + sede + "}";
    }
}

