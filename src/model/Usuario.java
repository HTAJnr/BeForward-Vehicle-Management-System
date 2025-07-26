package model;

public class Usuario 
{
    private String nome, senha;

    public Usuario(String nome, String senha)
    {
    	this.nome = nome;
        this.senha = senha;
    }
    
    // GETTERS E SETTERS
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getSenha() 
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    public String toString() 
    {
    	return nome+";"+senha+"\n";
    }
}