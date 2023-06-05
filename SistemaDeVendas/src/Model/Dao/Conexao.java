/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anibal
 */
public class Conexao {

 
    public Connection con = null;

    public static Connection conectar() throws ClassNotFoundException,
            SQLException {

        Connection cn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaDeVenda", "root", "");

        } catch (Exception e) {

            System.out.println(String.valueOf(e));
        }

        return cn;
    }

   
}
