/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dao.VendaDao;
import Model.Venda;
import java.util.List;

/**
 *
 * @author anibal
 */
public class VendaController {
      //SALVAR
    public static String salvar(Venda venda){
        
        String resposta = null;
        
        //Tenta fazer a insercao
        try{
            
            VendaDao.salvar(venda);
        }catch (Exception e){
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
    
    
    //PROCURAR/LISTAR
    public static List<Venda> procurar(String user){
        List<Venda> listaResposta = null;
        
        //Tenta fazer a busca dos dados 
        try{
        
            if (user == null || "".equals(user)) {
                
                listaResposta = VendaDao.listar();
            } else {
              
                listaResposta = VendaDao.procurar(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaResposta;
    }
    
    //OBTER
    public static Venda obterUltima() {
        
        //Instancia venda para retornar no fim da funcao
        Venda venda =  new Venda();
        
        try 
        {
            //tenta obter o venda procurado
           
            venda = VendaDao.obterUltima();
        } 
        catch (Exception e) 
        {
            //em caso de erro imprime erro 
            e.printStackTrace();
        }

        return venda;
        
    }
    
}
