/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dao;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anibal
 */
public class ProdutoDAO  {


    public static void salvar(Produto produto) throws SQLException,Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String sql = "INSERT INTO produto (nome, categoria, quantidade, custo, "
                + "valor, descricao) VALUES (?, ?, ?, ?, ?,? );";
        ps = cn.prepareStatement(sql);

        try {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setInt(3, produto.getQuantidade());
            ps.setFloat(4, produto.getCusto());
            ps.setFloat(5, produto.getValor());
            ps.setString(6, produto.getDescricao());
            ps.execute();
            
        } finally {

            if (ps != null && !ps.isClosed()) {
                ps.close();
            }

            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }

    }

   
    public static void atualizar(Produto produtoAtualizado) throws SQLException,Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        String sql = "UPDATE produto SET nome = ?, categoria = ? , quantidade = ?,"
                + " custo = ?, valor = ?, descricao = ? WHERE id = ?;";

        try {

            ps = cn.prepareStatement(sql);

            ps.setString(1, produtoAtualizado.getNome());
            ps.setString(2, produtoAtualizado.getCategoria());
            ps.setInt(3, produtoAtualizado.getQuantidade());
            ps.setFloat(4, produtoAtualizado.getCusto());
            ps.setFloat(5, produtoAtualizado.getValor());
            ps.setString(6, produtoAtualizado.getDescricao());
            ps.setInt(7, produtoAtualizado.getId());

            //Executa o comando no banco de dados
            ps.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }

    }

   
    public static void excluir(int id) throws SQLException, Exception {
        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;

        String sql = "DELETE FROM produto WHERE id=?";

        try {

            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            //Executa o comando no banco de dados
            ps.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (cn != null && !cn.isClosed()) {
                cn.close();
            }
        }

    }

    public static Produto obter(int id) throws SQLException, Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT * FROM produto WHERE id =?";

        try {

            ps = cn.prepareStatement(sql);

            ps.setInt(1, id);
            result = ps.executeQuery();

            if (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setCusto(result.getFloat("custo"));
                produto.setValor(result.getFloat("valor"));
                produto.setDescricao(result.getString("descricao"));

                return produto;
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


    public static List<Produto> listar() throws SQLException, Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        ResultSet result = null;

        String sql = "SELECT id, nome, categoria, quantidade, custo, valor, descricao  "
                + "FROM produto";
        List<Produto> listaProdutos = null;

        try {

            ps = cn.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setCusto(result.getFloat("custo"));
                produto.setValor(result.getFloat("valor"));
                produto.setDescricao(result.getString("descricao"));
                listaProdutos.add(produto);
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
        return listaProdutos;

    }

   
    public static List<Produto> procurar(String nome) throws SQLException, Exception {

        Connection cn = Conexao.conectar();
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT id, nome, categoria, quantidade, custo, valor, descricao  "
                + "FROM produto WHERE nome LIKE (?)";
        List<Produto> listaProdutos = null;

        try {

            ps = cn.prepareStatement(sql);

            ps.setString(1, "%" + nome + "%");

            result = ps.executeQuery();

            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setCategoria(result.getString("categoria"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setCusto(result.getFloat("custo"));
                produto.setValor(result.getFloat("valor"));
                produto.setDescricao(result.getString("descricao"));
                listaProdutos.add(produto);
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
        return listaProdutos;

    }

}
