/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




/**
 *
 * @author anibal
 */
public class Venda {

      private Integer id;
    private Date data;
    private Float subtotal;
    private Float pagamentoDinheiro;
    private Float pagamentoCartao;
    private Usuario usuario;
    private ArrayList<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
    private Integer qtdItens;
    
    public Venda() {
        usuario = new Usuario() {};
       itensVenda = new ArrayList<ItemVenda>();
    }
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataString(){
        SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
        return fd.format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getPagamentoDinheiro() {
        return pagamentoDinheiro;
    }

    public void setPagamentoDinheiro(Float pagamentoDinheiro) {
        this.pagamentoDinheiro = pagamentoDinheiro;
    }

    public Float getPagamentoCartao() {
        return pagamentoCartao;
    }

    public void setPagamentoCartao(Float pagamentoCartao) {
        this.pagamentoCartao = pagamentoCartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

  
    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
    public void adicionarItem(ItemVenda itemVenda){
        this.itensVenda.add(itemVenda);
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }
    
    
    


}
