/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;



/**
 *
 * @author GianL
 */


public class GraficoLinha extends DataSet {
    DataSet dataset = new DataSet();

    
    public  JFreeChart GeraGraficoLinha() {
        
        
        
        JFreeChart grafico = ChartFactory.createLineChart("Indice de Percepção de Corrupção", "Ano", 
    "Indice", CriaDataSet(), PlotOrientation.VERTICAL, true, true, false);
        
        return (grafico);
    }
    
    public JPanel getPanel() {
        return new ChartPanel(GeraGraficoLinha());
    }
    
    
    
}
