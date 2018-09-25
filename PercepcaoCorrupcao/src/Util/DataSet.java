/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;



import Model.Dados;
import Model.DadosIndices;
import java.util.ArrayList;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author GianL
 */
public class DataSet  {
   

    
    
    
    public static DefaultCategoryDataset CriaDataSet () {
        
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        
        
        for(DadosIndices dados : DadosIndices.getDadosTotais()) {
            ds.addValue(dados.getIndice(), dados.getPais(), String.valueOf(dados.getAno()));
        }
        
        
        return (ds);
        
        
    }
    
    
}
