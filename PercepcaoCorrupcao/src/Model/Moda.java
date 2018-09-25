/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;   
import java.util.HashSet;   
import java.util.Iterator;   
import java.util.Map;   
import java.util.Set;  


public class Moda {
    private  static Map valores = new HashMap();   
    //public Moda() {}   
    public static void adicionar (int numero) {  
        
        Integer n = new Integer(numero);   
        /** Verifica se já existe esse elemento no mapa */  
        if (valores.get(n) != null) {   
            valores.put(n, new Integer(((Integer)valores.get(n)).intValue() + 1));   
        }   
        else {   
            valores.put(n, new Integer(1));   
        }   
    }   
    public static Map getValores() {   
        return valores;   
    }   
    public  static Set calcular() {   
        /** Maior valor encontrado até o momento */  
        Integer maior = null;   
        Set resultado = new HashSet();   
        Iterator iterator = valores.keySet().iterator();   
        while (iterator.hasNext()) {   
            /** Número atual sendo avaliado */  
            Integer valor = (Integer)iterator.next();   
            /** Quantidade de ocorrências do número atual */  
            Integer current = (Integer)valores.get(valor);   
            if (maior == null) {   
                maior = current;   
            }   
            /** Encontrou um número com mais ocorrências */  
            if (maior.compareTo(current) <= 0) {   
                maior = current;   
                resultado.add(valor);   
            }   
        }   
        iterator = resultado.iterator();   
        while (iterator.hasNext()) {   
            Integer numero = (Integer)iterator.next();   
            /**  
             * Não tem o mesmo número de ocorrências que o maior número de  
             * ocorrências encontrado?  
             */  
            if (((Integer)valores.get(numero)).compareTo(maior) < 0) {   
                iterator.remove(); // Já era!   
            }   
        }   
        return resultado;   
    }
}
