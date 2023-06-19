/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author pedro
 */
public class Escrever{
    
    private static final String FILE_PATH = "C:/Users/pedro/OneDrive/Documentos/NetBeansProjects/"
            + "RPG/src/main/java/com/mycompany/rpg/resultado.txt";
    
    public static void escreverLista (List<?> dados, String tipo) throws Excessao{
        
        try{
            FileWriter abrir = new FileWriter(FILE_PATH, true);
            BufferedWriter arquivo_saida = new BufferedWriter(abrir);
            String inicio = tipo;
            arquivo_saida.write(inicio);
            arquivo_saida.newLine();
            for(Object d: dados){

                arquivo_saida.write(d.toString());
                arquivo_saida.newLine();
            }
            arquivo_saida.close();
        } catch (IOException e) {
            e.printStackTrace();
        throw new Excessao();
        } 
    }
    
   public static void mostrarResultado(JTextArea textArea){
    try {
        FileReader abrir = new FileReader(FILE_PATH);
        BufferedReader arquivo_entrada = new BufferedReader(abrir);

        String line;
        while ((line = arquivo_entrada.readLine()) != null) {
            textArea.append(line + "\n");
        }

        arquivo_entrada.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
