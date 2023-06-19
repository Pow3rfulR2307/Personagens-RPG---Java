/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class LerCSV implements Serializable{
    private static final String FILE_PATH = "C:/Users/pedro/OneDrive/Documentos/NetBeansProjects/"
            + "RPG/src/main/java/com/mycompany/rpg/listaRpg.csv";
    
    public List<Humano> listaHumanos = new ArrayList<>();
    public List<Elfo> listaElfos = new ArrayList<>();
    public List<Troll> listaTrolls = new ArrayList<>();
    public void lerInformacoes() throws Excessao{
       
        boolean linha1 = true;
        
        try {
            FileReader arquivo = new FileReader(FILE_PATH);
            BufferedReader buffer = new BufferedReader(arquivo);
            
            String str;
            
            while ((str = buffer.readLine()) != null) {
                if (linha1){
                    //System.out.println(str);
                    linha1 = false;
                    continue;
                }
                String[] dados = str.split(",");
                String nome = dados[0];
                String especie = dados[1];
                String classe = dados[2];
                int level = Integer.parseInt(dados[3]);
                float pontos_dano = Float.parseFloat(dados[4]);
                
                NomeProvider nomeProvider = new NomeProvider(nome);
                switch (especie){
                
                    case "Humano":
                    case "Humana":
                        listaHumanos.add(new Humano(nomeProvider, especie, classe, level, pontos_dano));
                        break;
                    case "Troll":
                        listaTrolls.add(new Troll(nomeProvider, especie, classe, level, pontos_dano));
                        break;
                    default:
                        listaElfos.add(new Elfo(nomeProvider, especie, classe, level, pontos_dano));
                        break;
                }
            }
            Personagem.salvar_personagens(listaHumanos, listaTrolls, listaElfos);
        }catch (IOException  e) {
            e.getStackTrace();
            throw new Excessao();
        }
    }
    
    public List<Humano> getHumanos(){
    
        return listaHumanos;
    }
    
    public List<Troll> getTrolls(){
    
        return listaTrolls;
    }
    
    public List<Elfo> getElfos(){
    
        return listaElfos;
    } 
}
