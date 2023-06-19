/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author pedro
 */
public class Personagem implements Serializable {

    private static final String FILE_PATH = "C:/Users/pedro/OneDrive/Documentos/NetBeansProjects/"
            + "RPG/src/main/java/com/mycompany/rpg/listaPersonagem.ser";

    protected String nome;
    protected NomeProvider nomeProvider;
    private String especie;
    protected String classe;
    protected int level;
    protected float pontos_dano;

    public Personagem(NomeProvider nomeProvider, String especie, String classe,
            int level, float pontos_dano) {

        this.nomeProvider = nomeProvider;
        this.nome = this.nomeProvider.getNome();
        this.especie = especie;
        this.classe = classe;
        this.level = level;
        this.pontos_dano = pontos_dano;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Espécie: " + especie + ", Classe: " + classe + ", Level: " + level + ", Pontos de Dano: " + pontos_dano;
    }

    public static void salvar_personagens(List<Humano> h, List<Troll> t, List<Elfo>el){
        try {
            FileOutputStream arquivoSaida = new FileOutputStream(FILE_PATH, true);
            ObjectOutputStream gravador = new ObjectOutputStream(arquivoSaida);

            List<Personagem> personagens = new ArrayList<>();
            
            personagens.addAll(h);
            personagens.addAll(el);
            personagens.addAll(t);
            for (Object personagem: personagens){
                gravador.writeObject(personagem);            
            }

            gravador.close();
            arquivoSaida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> retornarSerializados() {
    List<Object> objetos = new ArrayList<>();

    try {
        FileInputStream arquivoEntrada = new FileInputStream(FILE_PATH);
        ObjectInputStream stream = new ObjectInputStream(arquivoEntrada);

        while (arquivoEntrada.available() > 0) {
            Object objeto = stream.readObject();
            objetos.add(objeto);
        }

        stream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return objetos;
    }
    public void descricao(JTextArea area){
    
        area.setText("Aqui é uma descrição de uma espécie!");
    }
}
