/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anibal
 */
public class Validacao {
     //VALIDACAO DE PRODUTO (CAMPOS OBRIGATÓRIOS)
    public static String ProdutoCamposVazios(String nome, String quantidade, 
            String custo, String valor)
    {
        String retorno = "";
        
        if(nome.equalsIgnoreCase("") || nome == "")
        {
            retorno += "Nome\n";
        }

        if(quantidade.equalsIgnoreCase("") || quantidade == "")
        {
            retorno += "Quantidade\n";
        }

        if(custo.equalsIgnoreCase("") || custo == "")
        {
            retorno += "Custo\n";
        }
        if(valor.equalsIgnoreCase("") || valor == "")
        {
            retorno += "Valor\n";
        }
            return retorno;
      }
    
    
     //VALIDACAO DE PRODUTO (TAMANHO DOS CAMPOS)
    public static String ProdutoCamposTamanho(String nome, String quantidade, 
            String custo, String valor){
        String resposta = "";
        
        if (nome.length()>40){
            
            resposta += "\nNome (tamanho máximo: 40)";
        }
        
        if (quantidade.length()>3){
            
            resposta += "\nQuantidade (tamanho máximo: 3)";
        }
        
        if (custo.length()>8){
            
            resposta += "\n (tamanho máximo: 8)";
        }
        
        if (valor.length()>8){
            
            resposta += "\nValor (tamanho máximo: 8)";
        }
        
        return resposta;
    }
    
        public static boolean vendaUsusario(String user){
        
      
        if(user.equalsIgnoreCase("") || user == "")
        {
            return false;
        }
     return true;
    }
}
