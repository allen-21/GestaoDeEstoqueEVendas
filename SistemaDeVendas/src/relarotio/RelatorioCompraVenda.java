
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TEMBE
 */
public class RelatorioCompraVenda {
    public CompraVendaService service;

    public RelatorioCompraVenda() {
        service = new CompraVendaService();
    }

    public void gerarRelatorio() throws SQLException {
        List<CompraVenda> comprasVendas = service.getComprasVendas();

        double totalCompras = 0;
        double totalVendas = 0;

        System.out.println("RELATÓRIO DE COMPRA E VENDA");

        for (CompraVenda compraVenda : comprasVendas) {
            if (compraVenda.getTipo().equals("Compra")) {
                totalCompras += compraVenda.getValor();
            } else {
                totalVendas += compraVenda.getValor();
            }

            System.out.println(compraVenda.getTipo() + " - " + compraVenda.getDescricao() + " - " + compraVenda.getValor() + " - " + compraVenda.getData());
        }

        System.out.println("Total de Compras: " + totalCompras);
        System.out.println("Total de Vendas: " + totalVendas);
    }
}

