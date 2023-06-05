/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import com.mysql.jdbc.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author anibal
 */
public class Conexao2 {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/SistemaDeVenda";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            
            throw new RuntimeException("Erro na conexao", ex);
        }
        
        

    }
     public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(SQLException e){
            Logger.getLogger(Conexao2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     
        public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch(SQLException e){
            Logger.getLogger(Conexao2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
        
         public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con,stmt);
        
        try{
            if(rs != null){
                rs.close();
            }
        }catch(SQLException e){
            Logger.getLogger(Conexao2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    

}
