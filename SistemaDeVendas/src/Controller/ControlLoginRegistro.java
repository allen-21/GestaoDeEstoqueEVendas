/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Administrador;

import Model.Dao.UsuarioDao;
import Model.Usuario;

import View.Login;
import View.MenuAdmin;
import View.MenuVendedor;
import View.RegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author anibal
 */
public class ControlLoginRegistro implements ActionListener {
    //instanciando as classses

    UsuarioDao met = new UsuarioDao();
    Usuario x = new Usuario() {};
    Administrador y = new Administrador();
    Login log = new Login();
    RegistroUsuario reg = new RegistroUsuario();
    MenuAdmin cm ;
    
    

    public ControlLoginRegistro(Login log, RegistroUsuario reg, Usuario user, Administrador admin) {

        this.log = log;
        this.reg = reg;
        this.y= admin;
        
        this.x = user;

        //Registro de usuarios
        this.reg.btRegistrar.addActionListener(this);
        this.reg.btRegistrarAdmin.addActionListener(this);
       
        

        //Login
        this.log.btEntrar.addActionListener(this);

    }

    public void Registrar() {
        x.setNome(reg.tNome.getText());
        x.setApelido(reg.tApelido.getText());
        x.setMorada(reg.tMorada.getText());
        x.setUser(reg.tUsuario.getText());
        x.setSenha(reg.tSenha.getText());
        x.setTelefone(reg.txtTelefone.getText());
        

        if (met.InsertUser(x)) {
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar");
        }

    }
    
      public void RegistrarAdmin() {
        y.setNome(reg.tNome.getText());
        y.setApelido(reg.tApelido.getText());
        y.setMorada(reg.tMorada.getText());
        y.setUser(reg.tUsuario.getText());
        y.setSenha(reg.tSenha.getText());
        y.setTelefone(reg.txtTelefone.getText());

        if (met.InsertAdmin(y)) {
            JOptionPane.showMessageDialog(null, "Admintrador Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar");
        }

    }
  

      
      //Tela de login
    public void LoginUser() {
        MenuAdmin ma = new MenuAdmin();
        MenuVendedor mv = new MenuVendedor();
       
        String us = log.tUser.getText();
        String pw = log.tPass.getText();
        
        String txtnome;
        txtnome = us;
        
       
        

        if (met.Autenticar(us, pw)) {

           mv.setVisible(true);
          
            JOptionPane.showMessageDialog(null, "Login feito com Sucesso " + txtnome);
            
            
           
        }else if(met.AutenticarAdmin(us,pw)) {
            ma.setVisible(true);
            JOptionPane.showMessageDialog(null, "Login feito com Sucesso " + txtnome);

            // ma.recebendo(log.tUser.getText());
          
            
          
           
        }else{
            JOptionPane.showMessageDialog(null, "Error Verifique seus dados");
        }

    }
   

    //accao do botao ao ser clicado
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reg.btRegistrar) {
            Registrar();
        }
        if (ae.getSource() == reg.btRegistrarAdmin){
            RegistrarAdmin();
          
        }
      

        if (ae.getSource() == log.btEntrar) {
            LoginUser();
        
           }
        }
    
    
     //OBTER POR user
    public static Usuario obter(String usuario) {
        
        //Instancia user para retornar no fim da funcao
        Usuario user = new Usuario() {
                };
        
        try 
        {
            
            user = UsuarioDao.obter(usuario);
        } 
        catch (Exception e) 
        {
            return user = null;
        }

        return user;
    }
        
        

    }


