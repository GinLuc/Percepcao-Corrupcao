//Classe responsável pela leitura dos dados em formato ".csv" e suas inserções dentro do programa
package Model;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Model.DadosIndices;
import java.util.Scanner;



public class Dados  {
 



public static void comecaPrograma(String nome) {
    int i = 0; 
    
 
    
            String arquivoCSV = "Dados_Completos.csv";
            BufferedReader br = null;
            String registro = null;
            String csvDivisor = ";";
        
        
            try {

                br = new BufferedReader(new FileReader(arquivoCSV));

                while ((registro = br.readLine()) != null) {
                    String[] campos = registro.split(csvDivisor);
                                        
                 String pais = campos[2];
                    int ano = Integer.parseInt(campos[0]);
                    int indice = Integer.parseInt (campos[1]);

                    new DadosIndices(pais, ano, indice);


                }
                //Necessário para a RuntimeException!!!
                DadosIndices.getDados(nome);
              

            }


            catch (FileNotFoundException e) {
                e.printStackTrace();
            } 

            catch (IOException e) {
                e.printStackTrace();
            } 
            finally {
                if (br != null) {
                    try {

                        br.close();
                    } 
                    catch (IOException e) {
                         e.printStackTrace();
                    }
                }
        }
    }  
     
            
    
}
   
