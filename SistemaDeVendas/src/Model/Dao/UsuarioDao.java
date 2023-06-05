/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anibal
 */
public class UsuarioDao {

    //Metodos para inserir usuario e administrador a Base de dados
    public static boolean InsertUser(Usuario x) throws ClassNotFoundException, SQLException {
        Connection cn = Conexao.conectar();

        PreparedStatement ps = null;

        String sql = "insert into Usuario (apelido,usuario,senha) values (?,?,?)";

        try {
            ps = cn.prepareStatement(sql);
            
            ps.setString(1, x.getApelido());
           
            ps.setString(2, x.getUser());
            ps.setString(3, x.getSenha());
            
            ps.execute();
            cn.close();

            return true;

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;

    }

    public static boolean InsertAdmin(Usuario x) throws ClassNotFoundException, SQLException {
        Connection cn = Conexao.conectar();

        PreparedStatement ps = null;

        String sql = "insert into Administrador (apelido,usuario,senha) values (?,?,?)";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getApelido());
           
            ps.setString(2, x.getUser());
            ps.setString(3, x.getSenha());
            ps.execute();
            cn.close();

            return true;

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;

    }

    //Metodos para Autenticar os dados para o login
    public static boolean Autenticar(String Puser, String Ppsw) throws ClassNotFoundException, SQLException {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select usuario,senha from Usuario where usuario=? and senha =?";

        try {

            ps = cn.prepareStatement(sql);
            ps.setString(1, Puser);
            ps.setString(2, Ppsw);
            rs = ps.executeQuery();

            while (rs.next()) {

                cn.close();
                return true;
            }

        } catch (Exception e) {

            System.out.println(e);
        }
        return false;

    }

    public static boolean AutenticarAdmin(String Puser, String Ppsw) throws ClassNotFoundException, SQLException {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select usuario,senha from Administrador where usuario=? and senha =?";

        try {

            ps = cn.prepareStatement(sql);
            ps.setString(1, Puser);
            ps.setString(2, Ppsw);
            rs = ps.executeQuery();

            while (rs.next()) {

                cn.close();
                return true;
            }

        } catch (Exception e) {

            System.out.println(e);
        }
        return false;

    }

    public static Usuario obter(String usuario)
            throws Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Usuario WHERE usuario =?";

        try {

            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario() {
                };

                user.setId(rs.getInt("Id"));
              
                user.setApelido(rs.getString("apelido"));
                
                user.setUser(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
             

                return user;
            }
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }
        return null;
    }

}
