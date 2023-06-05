/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.ItemVenda;
import Model.Produto;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anibal
 */
public class ItensVendaDao {

    public static void salvar(ItemVenda itemVenda)
            throws Exception,SQLException {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
       
        
     
        String sql = "INSERT INTO itemVenda(idVenda, idItem, "
                + "nomeProduto, idProduto, qtdItens, valor, valorTotal) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
           
            ps = cn.prepareStatement(sql);

            ps.setInt(1, itemVenda.getIdVenda());
            ps.setInt(2, itemVenda.getIdItem());
            ps.setString(3, itemVenda.getNome());
            ps.setInt(4, itemVenda.getId());
            ps.setInt(5, itemVenda.getQuantidade());
            ps.setFloat(6, itemVenda.getValor());
            ps.setFloat(7, itemVenda.getValorTotal()); 
           
            ps.executeUpdate();
        } finally {

            if (ps != null && !ps.isClosed()) {
                ps.close();
            }

            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }
        
    }
      

    public static List<ItemVenda> obterItens(Integer id) throws Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String sql = "SELECT idVenda, idItem, nomeProduto, idProduto, qtdItens, "
                + "valorTotal, valor FROM itemVenda WHERE idVenda =?";

        List<ItemVenda> listaItensVenda = null;

        ResultSet result = null;

        try {

            ps = cn.prepareStatement(sql);

            ps.setInt(1, id);
            result = ps.executeQuery();

            while (result.next()) {
                if (listaItensVenda == null) {
                    listaItensVenda = new ArrayList<ItemVenda>();
                }
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setIdVenda(result.getInt("idVenda"));
                itemVenda.setIdItem(result.getInt("idItem"));
                itemVenda.setNome(result.getString("nomeProduto"));
                itemVenda.setId(result.getInt("idProduto"));
                itemVenda.setQuantidade(result.getInt("qtdItens"));
                itemVenda.setValorTotal(result.getFloat("valorTotal"));
                itemVenda.setValor(result.getFloat("valor"));

                listaItensVenda.add(itemVenda);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }
        return listaItensVenda;
    }
    
    public static void updateOrInsertItem(ItemVenda itemVenda) throws Exception,SQLException {
        try {
            if (existsItem(itemVenda)) {
                updateItem(itemVenda);
            } else {
                insertItem(itemVenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean existsItem(ItemVenda itemVenda) throws Exception,SQLException  {
        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String selectSql = "SELECT idVenda FROM itemVenda WHERE idVenda = ? AND idItem = ? AND nomeProduto = ? LIMIT 1";
        try {
            ps.setInt(1, itemVenda.getIdVenda());
            ps.setInt(2, itemVenda.getIdItem());
            ps.setString(3, itemVenda.getNome());
            try (ResultSet resultSet = ps.executeQuery()) {
                return resultSet.next();
            }
        }  finally {
            
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }
    }

    private static void updateItem(ItemVenda itemVenda) throws Exception,SQLException  {
         Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String updateSql = "UPDATE itemVenda SET qtdItens = ?, valorTotal = ?, valor = ? WHERE idVenda = ? AND idItem = ? AND nomeProduto = ?";
        try  {
            ps.setInt(1, itemVenda.getQuantidade());
            ps.setDouble(2, itemVenda.getValorTotal());
            ps.setDouble(3, itemVenda.getValor());
            ps.setInt(4, itemVenda.getIdVenda());
            ps.setInt(5, itemVenda.getIdItem());
            ps.setString(6, itemVenda.getNome());
            ps.executeUpdate();
        }
        finally {
            
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }
    }

    private static void insertItem(ItemVenda itemVenda) throws Exception,SQLException  {
        
        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
       
        
     
        String sql = "INSERT INTO itemVenda(idVenda, idItem, "
                + "nomeProduto, idProduto, qtdItens, valor, valorTotal) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
           
            ps = cn.prepareStatement(sql);

            ps.setInt(1, itemVenda.getIdVenda());
            ps.setInt(2, itemVenda.getIdItem());
            ps.setString(3, itemVenda.getNome());
            ps.setInt(4, itemVenda.getId());
            ps.setInt(5, itemVenda.getQuantidade());
            ps.setFloat(6, itemVenda.getValor());
            ps.setFloat(7, itemVenda.getValorTotal()); 
           
            ps.executeUpdate();
        } finally {

            if (ps != null && !ps.isClosed()) {
                ps.close();
            }

            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }
      
        }
    
    
     public List<ItemVenda> listartb() {

         Connection  con = Conexao2.getConnection();
          PreparedStatement ps = null;
           ResultSet result = null;
           List<ItemVenda> itemVendas = new ArrayList<>();
         
        try {
           ps = con.prepareStatement("SELECT * FROM itemVenda");
           result = ps.executeQuery();

            while (result.next()) {
                   ItemVenda itemVenda = new ItemVenda();
                itemVenda.setIdVenda(result.getInt("idVenda"));
                itemVenda.setIdItem(result.getInt("idItem"));
                itemVenda.setNome(result.getString("nomeProduto"));
                itemVenda.setId(result.getInt("idProduto"));
                itemVenda.setQuantidade(result.getInt("qtdItens"));
                itemVenda.setValorTotal(result.getFloat("valorTotal"));
                itemVenda.setValor(result.getFloat("valor"));

                itemVendas.add(itemVenda);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItensVendaDao.class.getName()).log(Level.SEVERE, null, ex);

        }finally{
            Conexao2.closeConnection((com.mysql.jdbc.Connection) con, ps, result);
        }
        return itemVendas ;

    }
}

