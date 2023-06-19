/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author pedro
 */
public class Humano extends Personagem implements Personagem_interface{
    
    public Humano(NomeProvider nomeProvider, String especie, String classe, int level, float pontos_dano){
    
        super(nomeProvider, especie, classe, level, pontos_dano);
    }
    
    public void mudar_classe(String nova_classe){
        
        this.classe = nova_classe;
  
        JOptionPane.showMessageDialog(null, "Classe de "+this.nome+" foi alterada para "+this.classe);
    }
    
    @Override
    public void deletar(List<?> h){
        
        h.remove(this);
        JOptionPane.showMessageDialog(null, this.nome+" foi apagado de Humanos");
    };
    
    @Override
    public void descricao(JTextArea area){
    
        area.append("Os humanos são uma das espécies mais comuns e versáteis no mundo do RPG. "
                + "São seres inteligentes e adaptáveis, conhecidos por sua habilidade em se adaptar "
                + "a diferentes ambientes e situações. Com sua anatomia bipedal, possuem uma ampla gama "
                + "de habilidades físicas e mentais que lhes permitem se destacar em várias profissões e classes.");
    }
}
