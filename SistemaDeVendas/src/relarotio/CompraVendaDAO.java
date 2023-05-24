
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEMBE
 */
public class CompraVendaDAO {
    private Connection conn;

    public CompraVendaDAO() {
        // inicializa a conexão com o banco de dados
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "usuario", "senha");
    }

    public List<CompraVenda> getComprasVendas() throws SQLException {
        List<CompraVenda> comprasVendas = new ArrayList<>();

        String sql = "SELECT * FROM compras_vendas";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            CompraVenda compraVenda = new CompraVenda();
            compraVenda.setId(rs.getInt("id"));
            compraVenda.setTipo(rs.getString("tipo"));
            compraVenda.setDescricao(rs.getString("descricao"));
            compraVenda.setValor(rs.getDouble("valor"));
            compraVenda.setData(rs.getTimestamp("data").toLocalDateTime());

            comprasVendas.add(compraVenda);
        }

        rs.close();
        stmt.close();

        return comprasVendas;
    }
}
    

