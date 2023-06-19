/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

/**
 *
 * @author pedro
 */
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
        
public class Elfo extends Personagem implements Personagem_interface{
    
    public Elfo(NomeProvider nomeProvider, String especie, String classe, int level, float pontos_dano){
    
        super(nomeProvider, especie, classe, level, pontos_dano);
    }
    
    public void mudar_nome(String novoNome){
        
        this.nome = novoNome;
        
        JOptionPane.showMessageDialog(null, "Nome foi alterado para "+this.nome);
    }
    
    @Override
    public void deletar(List<?> el){
    
        el.remove(this);
        JOptionPane.showMessageDialog(null, this.nome+" foi apagado de Elfos");
    };
       
    @Override
    public void descricao(JTextArea area){
    
        area.setText("Os elfos são uma espécie mística e graciosamente bela, muito presente no "
                + "mundo do RPG. Com sua aparência etérea e longevidade extraordinária, os elfos são"
                + " conhecidos por sua ligação profunda com a natureza e sua afinidade com a magia. "
                + "São seres imortais, dotados de uma graça e agilidade natural que lhes conferem vantagens"
                + " em combate e habilidades especiais.");
    }
}
