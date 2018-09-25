/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GianL
 */
public class DadosIndices {
    private String pais;
    private int ano;
    private int indice;
    
    static ArrayList<Integer> vFrequencia = new ArrayList<>();

    
    
    private static  ArrayList <DadosIndices> DadosExtraidos = new ArrayList<DadosIndices>();
    
        public DadosIndices(String pais, int ano, int indice) {
                this.pais = pais;
                this.indice = indice;
                this.ano = ano;
                DadosExtraidos.add(this);
        }
        
   
        
        public  static ArrayList <DadosIndices> getDados (String nome) throws IOException {
            ArrayList<DadosIndices> num = new ArrayList<DadosIndices>();
            if ("Brasil".equalsIgnoreCase(nome) || "Japao".equalsIgnoreCase(nome) || "Iraque".equalsIgnoreCase(nome)) {
                for(DadosIndices dados : DadosExtraidos) {
                    if (nome.equalsIgnoreCase(dados.getPais())) {
                        num.add(dados);
                    }
                }
            
            } else {
                throw new RuntimeException("Pais Invalido!!!");
                
            }
            
            return num;
        }
        
        public  static ArrayList <DadosIndices> getDadosTotais () {
            return DadosExtraidos;
        }
        
    //Getters e Setters
        

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }
    
    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    
    
    //Cálculos
    
    
    
    public  static double getMedia (String nome) {
         
        int i, qt = 0;
        double Soma = 0;
        
        
       for(DadosIndices dados : DadosExtraidos) {
               if (nome.equalsIgnoreCase(dados.getPais())) {
                   Soma += dados.getIndice();
                   qt++;
               }
       }
       //System.out.println("Media: " + (Soma/qt));
        return (Soma / qt);
    }
    
    public  static double getMediana(String nome) {
      ArrayList<Integer> valores = new ArrayList<>();
      
        int pc;
        int i;
        
        for(DadosIndices dados : DadosExtraidos) {
               if (nome.equalsIgnoreCase(dados.getPais())) {
                      valores.add(dados.getIndice());
                      
               }
       }
             pc = valores.size() / 2;
             
        //System.out.println("\nVALORES : " + valores);
        //System.out.println("Mediana: " + ((valores.get(pc) + valores.get(pc + 1)) / 2));
        return ((valores.get(pc) + valores.get(pc + 1)) / 2);
    }
        
        
        
     public  static double getDesvioMedio(String nome) {
        int i;
        double media = getMedia(nome), Soma = 0;
        
        for(DadosIndices dados : DadosExtraidos) {
            if (nome.equalsIgnoreCase(dados.getPais())) {
                Soma = (Soma + Math.pow((dados.getIndice() -  media), 2));
            }
        }
        //System.out.println("\n\nDesvio Medio(Variancia): " + (Soma / (DadosExtraidos.size() - 1)));
        return (Soma / (DadosExtraidos.size() - 1));
   
        
    }
    
     public static double getDesvioPadrao(String nome) {

        double dv = getDesvioMedio(nome);
        
        
        //System.out.println("\n\nDesvio Padrao: " + (Math.sqrt(dv)));
        return (Math.sqrt(dv));
        
    }
    
   
    
    public static double CoefVariacaoDados(String nome) {
        double dp = getDesvioPadrao(nome), media =  getMedia(nome);
        
        //System.out.println("\n\nCoeficiente de Variacao: " + ((dp / media) * 100));
        return ((dp / media) * 100);
        
    }

    
    public static String  getModa (String nome) { 
        
        ArrayList<Integer> valores = new ArrayList<>();
        int v2 = 0;
        int v1 = 0;
        
        
       /* for (int i = 0; i < vFrequencia.size(); i++) {
            int f1 = vFrequencia.get(i);
            int f2 = 0;
            if (f1 < vFrequencia.get(i)) {
                f2 = f1;
                v2 = vFrequencia.get(i);
                f1 = vFrequencia.get(i);
                v1 = vFrequencia.indexOf(i);
               
            }
            
            
        }
        
        return(v1 + "," + v2);*/
        
        
       valores.clear();
        for(DadosIndices dados : DadosExtraidos) {
            if (nome.equalsIgnoreCase(dados.getPais())) {
                valores.add(dados.getIndice());
            }
        }
        //Adicionando Valores no MapHash
        for (int i = 0; i < valores.size(); i++) {
            Moda.adicionar(valores.get(i));
        }
        
         //System.out.println("\nMapa dos valores: " + Moda.getValores());
        
       return("\nModa dos valores: " + Moda.calcular()); 
       
        
    }
    
    
    public static ArrayList<String> getFrequenciaAbsoluta(String nome) {
        ArrayList<Integer> valores = new ArrayList<>();
        
        ArrayList<String> frequenciamostrada = new ArrayList<>();
      
        for(DadosIndices dados : DadosExtraidos) {
            if (nome.equalsIgnoreCase(dados.getPais())) {
                valores.add(dados.getIndice());
            }
        }
        Map <Integer, Integer> map = new HashMap <Integer, Integer>();
		for (int i = 0; i < valores.size(); i++) {
			Integer qtde = map.get(valores.get(i));
			if (qtde == null) {
				qtde = 0;
			}
			
			qtde++;
			map.put(valores.get(i), qtde);
		}
                
        
        //System.out.println("\n\nTabela de Frequencia do " + nome + ":\n");
        
        for(Integer d : map.keySet()) {
			//System.out.println("\nIndice: " + d + "\tFrequencia: " + map.get(d) + "\n");
                        //frequenciamostrada.concat(" \nIndice: " + d + "\tFrequencia: " + map.get(d) + "\n");
                        frequenciamostrada.add("\nIndice: " + d + "\tFrequencia: " + map.get(d) + "\n");
                         
		}
        
       return (frequenciamostrada); 
    }

    



}
