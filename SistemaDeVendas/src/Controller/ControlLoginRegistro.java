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
import View.TelaUsuario;

import View.RegistroUsuario;
import View.TelaVendedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author anibal
 */
public class ControlLoginRegistro implements ActionListener {
    //instanciando as classses

    UsuarioDao met = new UsuarioDao();
    Usuario x = new Usuario() {
    };
    Administrador y = new Administrador();
    Login log = new Login();
    RegistroUsuario reg = new RegistroUsuario();

    public ControlLoginRegistro(Login log, RegistroUsuario reg, Usuario user, Administrador admin) {

        this.log = log;
        this.reg = reg;
        this.y = admin;

        this.x = user;

        //Registro de usuarios
        this.reg.btRegistrar.addActionListener(this);
        this.reg.btRegistrarAdmin.addActionListener(this);

        //Login
        this.log.btEntrar.addActionListener(this);
        this.log.btnRegistrar.addActionListener(this);

    }

    public void Registrar() throws ClassNotFoundException, SQLException {
      
        x.setApelido(reg.tApelido.getText());
        
        x.setUser(reg.tUsuario.getText());
        x.setSenha(reg.tSenha.getText());
      

        if (met.InsertUser(x)) {
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            LimparRegistro();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar");
        }

    }

    public void RegistrarAdmin() throws ClassNotFoundException, SQLException {
      
        y.setApelido(reg.tApelido.getText());
     
        y.setUser(reg.tUsuario.getText());
        y.setSenha(reg.tSenha.getText());
   

        if (met.InsertAdmin(y)) {
            JOptionPane.showMessageDialog(null, "Admintrador Registrado");
            LimparRegistro();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Registrar");
        }

    }

    public void Limpar() {
        log.tUser.setText("");
        log.tPass.setText("");
    }
    public void LimparRegistro(){
    
        reg.tApelido.setText("");
        reg.tSenha.setText("");
        reg.tUsuario.setText("");

        
    }

    //Tela de login
    public void LoginUser() throws ClassNotFoundException, SQLException {
       
        String us = log.tUser.getText();
        String pw = log.tPass.getText();

        if (met.Autenticar(us, pw)) {

            new TelaUsuario(us).setVisible(true);
           
           

            JOptionPane.showMessageDialog(null, "Login feito com Sucesso ");
            Limpar();

        } else if (met.AutenticarAdmin(us, pw)) {

            new MenuAdmin(us).setVisible(true);

            JOptionPane.showMessageDialog(null, "Login feito com Sucesso ");

            // ma.recebendo(log.tUser.getText());
            Limpar();

        } else {
            JOptionPane.showMessageDialog(null, "Error Verifique seus dados");
        }

    }

    //accao do botao ao ser clicado
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == reg.btRegistrar) {
            try {
                Registrar();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlLoginRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControlLoginRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ae.getSource() == reg.btRegistrarAdmin) {
            try {
                RegistrarAdmin();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlLoginRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControlLoginRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (ae.getSource() == log.btEntrar) {
            try {
                LoginUser();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControlLoginRegistro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControlLoginRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (ae.getSource() == log.btnRegistrar) {
            reg.setVisible(true);
        }
    }

    //OBTER POR user
    public static Usuario obter(String usuario) {

        //Instancia user para retornar no fim da funcao
        Usuario user = new Usuario() {
        };

        try {

            user = UsuarioDao.obter(usuario);
        } catch (Exception e) {
            return user = null;
        }

        return user;
    }

}
