/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.ItemVenda;
import Model.Produto;
import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anibal
 */
public class VendaDao {

    public static void salvar(Venda venda) throws Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String sql = "INSERT INTO vendas(id, data, qtdItens, "
                + "subtotal, pagamentoDinheiro, pagamentoCartao, user) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?);";

        try {

            ResultSet result = null;
            ps = cn.prepareStatement(sql);
            ps.setInt(1, venda.getId());
            java.sql.Timestamp data = new java.sql.Timestamp(venda.getData().getTime());
            ps.setTimestamp(2, data);
            ps.setInt(3, venda.getItensVenda().size());
            ps.setFloat(4, venda.getSubtotal());
            ps.setFloat(5, venda.getPagamentoDinheiro());
            ps.setFloat(6, venda.getPagamentoCartao());
            ps.setString(7, venda.getUsuario().getUser());

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

    public static Venda obterUltima() throws Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String sql = "SELECT MAX(id) qtdVendas FROM vendas";

        ResultSet result = null;

        try {

            ps = cn.prepareStatement(sql);

            result = ps.executeQuery();

            if (result.next()) {
                Venda venda = new Venda();
                venda.setId(result.getInt("qtdVendas"));

                return venda;
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
        return null;
    }

    public List<Venda> listartb() {

        Connection con = Conexao2.getConnection();
        PreparedStatement ps = null;
        ResultSet result = null;
        List<Venda> vendas = new ArrayList<>();

        try {
            ps = con.prepareStatement("SELECT * FROM vendas");
            result = ps.executeQuery();

            while (result.next()) {

                Venda venda = new Venda();
                venda.setId(result.getInt("id"));
                Date data = new Date(result.getTimestamp("data").getTime());
                venda.setData(data);
                venda.setQtdItens(result.getInt("qtdItens"));
                venda.setSubtotal(result.getFloat("subtotal"));
                venda.setPagamentoDinheiro(result.getFloat("pagamentoDinheiro"));
                venda.setPagamentoCartao(result.getFloat("pagamentoCartao"));
                venda.getUsuario().setUser(result.getString("user"));
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            Conexao2.closeConnection((com.mysql.jdbc.Connection) con, ps, result);
        }
        return vendas;

    }

    public static List<Venda> listar() throws Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String sql = "SELECT id, data, qtdItens, subtotal, pagamentoDinheiro, "
                + "pagamentoCartao, user "
                + "FROM vendas";
        List<Venda> listaVendas = null;

        ResultSet result = null;

        try {

            ps = cn.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Venda>();
                }
                Venda venda = new Venda();
                venda.setId(result.getInt("id"));
                Date data = new Date(result.getTimestamp("data").getTime());
                venda.setData(data);
                venda.setQtdItens(result.getInt("qtdItens"));
                venda.setSubtotal(result.getFloat("subtotal"));
                venda.setPagamentoDinheiro(result.getFloat("pagamentoDinheiro"));
                venda.setPagamentoCartao(result.getFloat("pagamentoCartao"));
                venda.getUsuario().setUser(result.getString("user"));

                listaVendas.add(venda);
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
        return listaVendas;

    }

    public static List<Venda> procurar(String user)
            throws Exception {

        Connection cn = Conexao.conectar();
        String sql = "SELECT id, data, qtdItens, subtotal, pagamentoDinheiro, "
                + "pagamentoCartao, user "
                + "FROM vendas WHERE user LIKE (?)";
        List<Venda> listaVendas = null;

        ResultSet result = null;
        PreparedStatement ps = null;

        try {

            ps = cn.prepareStatement(sql);

            ps.setString(1, "%" + user + "%");

            result = ps.executeQuery();

            while (result.next()) {
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Venda>();
                }
                Venda venda = new Venda();
                venda.setId(result.getInt("id"));
                Date data = new Date(result.getTimestamp("data").getTime());
                venda.setData(data);
                venda.setQtdItens(result.getInt("qtdItens"));
                venda.setSubtotal(result.getFloat("subtotal"));
                venda.setPagamentoDinheiro(result.getFloat("pagamentoDinheiro"));
                venda.setPagamentoCartao(result.getFloat("pagamentoCartao"));

                venda.getUsuario().setUser(result.getString("user"));
                listaVendas.add(venda);
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
        return listaVendas;
    }

}
