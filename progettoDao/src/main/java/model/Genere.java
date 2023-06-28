package model;

public class Genere {
    private int id;
    private String nome;

    public Genere(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Genere() {
        this.id = 0;
        this.nome = null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString()
    {
    	return "{id:" + id + "nome categoria" + nome +"}";
    }
}