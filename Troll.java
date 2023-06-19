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
public class Troll extends Personagem implements Personagem_interface{
    
    public Troll(NomeProvider nomeProvider, String especie, String classe, int level, float pontos_dano){
    
        super(nomeProvider, especie, classe, level, pontos_dano);
    }
    
    public void mudar_pontos_dano(float novoDano){
        
        this.pontos_dano = novoDano;
        
        JOptionPane.showMessageDialog(null, "Dano de"+nome+" foi alterado para "+pontos_dano);
    }
    
    @Override
    public void deletar(List<?> t){
    
        t.remove(this);
        JOptionPane.showMessageDialog(null, this.nome+" foi apagado de Trolls");
    };
    
    @Override
    public void descricao(JTextArea area){
    
        area.setText("Os trolls são uma espécie robusta e temível no mundo do RPG. Caracterizados"
                + " por sua estatura impressionante, pele resistente e força física formidável, os trolls"
                + " são conhecidos como poderosos combatentes e sobreviventes em ambientes hostis.Os trolls são"
                + " criaturas noturnas e se adaptaram a viver em locais remotos, como montanhas, cavernas escuras e florestas sombrias."
                + " Sua pele grossa e resistente lhes confere uma proteção natural contra ataques físicos, tornando-os difíceis de serem derrotados"
                + " em combate. Além disso, possuem uma capacidade de regeneração surpreendente, podendo se curar rapidamente de ferimentos graves.");
    }
}
