/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anibal
 */
public abstract class Usuario {
    
    private int id;
    private String nome;
    private String apelido;
    private String morada;
    private String User;
    private String senha;
    private String telefone;

    public Usuario() {
    }

    public Usuario(String nome, String apelido, String morada, String usuario, String senha) {
        this.nome = nome;
        this.apelido = apelido;
        this.morada = morada;
        this.User = usuario;
        this.senha = senha;
    }

    public Usuario(String nome, String apelido, String telefone) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

  
    
    
}
