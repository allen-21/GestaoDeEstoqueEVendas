/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dao.ProdutoDAO;
import Model.Produto;
import java.util.List;

/**
 *
 * @author anibal
 */
public class ProdutoController {
      //SALVAR
    public static String salvar(Produto produto){
        
        String resposta = null;
        
        //Tenta fazer a insercao
        try{
           
            ProdutoDAO.salvar(produto);
        }catch (Exception e){
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        
        return resposta;
    }
   
    //PROCURAR/LISTAR
    public static List<Produto> procurar(String nome){
        List<Produto> listaResposta = null;
        
        //Tenta fazer a busca dos dados 
        try{
        
            if (nome == null || "".equals(nome)) {
               
                listaResposta = ProdutoDAO.listar();
            } else {
               
                listaResposta = ProdutoDAO.procurar(nome);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaResposta;
    }
    
    //ATUALIZAR
    public static String atualizar(Produto produto) 
    {
        String resposta = null;

        try
        {
            //tenta fazer a atualização
            
            ProdutoDAO.atualizar(produto);
        } 
        catch (Exception e) 
        {   
            //em caso de erro retorna para a classe que chamou com o erro
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        return resposta;        
    }
    
    //EXCLUIR
    public static String excluir(Integer id) 
    {
        String resposta = null;

        try 
        {   
            //tenta excluir 
            
            ProdutoDAO.excluir(id);
        } catch (Exception e) 
        {
            //em caso de erro retorna erro para a classe que chamou
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
        }
        return resposta;
    }
    
    //OBTER
    public static Produto obter(Integer id) {
        
        //Instancia produto para retornar no fim da funcao
        Produto produto =  new Produto();
        
        try 
        {
            //tenta obter o produto procurado
           
            produto = ProdutoDAO.obter(id);
        } 
        catch (Exception e) 
        {
            //em caso de erro imprime erro 
            e.printStackTrace();
        }

        return produto;
        
    }
        //OBTER
    public static Produto Listar() {
        
        //Instancia produto para retornar no fim da funcao
        Produto produto =  new Produto();
        
        try 
        {
            //tenta obter o produto procurado
           
            produto = (Produto) ProdutoDAO.listar();
        } 
        catch (Exception e) 
        {
            //em caso de erro imprime erro 
            e.printStackTrace();
        }

        return produto;
        
    }
    
}
