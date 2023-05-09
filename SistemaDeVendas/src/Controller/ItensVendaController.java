/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dao.ItensVendaDao;
import Model.ItemVenda;
import java.util.List;

/**
 *
 * @author anibal
 */
public class ItensVendaController {
    
      //SALVAR
    public static String salvar(ItemVenda itensVenda){
        
        String resposta = null;
        
        //Tenta fazer a insercao
        try{
            
            ItensVendaDao.salvar(itensVenda);
        }catch (Exception e){
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
    
    //OBTER ITENS DA VEMDA
    public static List<ItemVenda> obterItens(int idVenda){
        List<ItemVenda> listaResposta = null;
        
        //Tenta fazer a busca dos dados 
        try{
            
            listaResposta = ItensVendaDao.obterItens(idVenda);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaResposta;
    }
    
}
