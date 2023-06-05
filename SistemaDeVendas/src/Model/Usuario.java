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
  
    private String apelido;

    private String User;
    private String senha;
    

    public Usuario() {
    }

    public Usuario( String apelido,  String usuario, String senha) {
        
        this.apelido = apelido;
      
        this.User = usuario;
        this.senha = senha;
    }

    public Usuario( String apelido) {
        
        this.apelido = apelido;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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
