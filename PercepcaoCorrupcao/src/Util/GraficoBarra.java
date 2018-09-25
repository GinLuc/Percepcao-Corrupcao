/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

//import static Util.DataSet.CriaDataSet;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;





public class GraficoBarra extends DataSet {
    
    
    
    public static  JFreeChart GeraGraficoBarra() {
        
        JFreeChart grafico = ChartFactory.createBarChart("Indice de Percepção de Corrupção", "Ano", 
    "Indice", CriaDataSet(), PlotOrientation.VERTICAL, true, true, false);
        
        
        return (grafico);
    }
    
    public static JPanel getPanel() {
        return new ChartPanel(GeraGraficoBarra());
    }
    
    
}
