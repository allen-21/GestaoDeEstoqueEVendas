
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEMBE
 */
public class CompraVendaService {

    List<CompraVenda> getComprasVendas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<CompraVenda> getComprasVendas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public class CompraVendaService {
    private CompraVendaDAO dao;

    public CompraVendaService() {
        dao = new CompraVendaDAO();
    }

    public List<CompraVenda> getComprasVendas() throws SQLException {
        return dao.getComprasVendas();
    }
}
}
