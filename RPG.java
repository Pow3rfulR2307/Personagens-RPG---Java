/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rpg;

/**
 *
 * @author pedro
 */
//import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RPG {

    public static void main(String[] args) {
        
        LerCSV lerCSV = new LerCSV();
        try{
        lerCSV.lerInformacoes();
        }catch(Excessao e){ JOptionPane.showMessageDialog(null, "Erro de abertura de arquivo");}
        
        List<Humano> humanos = lerCSV.getHumanos();
        List<Elfo> elfos = lerCSV.getElfos();
        List<Troll> trolls = lerCSV.getTrolls();
        
        SwingUtilities.invokeLater(() -> {
            
            InterfaceGrafica interface_grafica = new InterfaceGrafica();
            interface_grafica.criar_e_mostrar(humanos, elfos, trolls);
            interface_grafica.OptionPaneFormatacao();
        });
    }
}

class InterfaceGrafica {
    
    public void OptionPaneFormatacao() {
        UIManager.put("OptionPane.background", Color.BLACK);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Panel.background", Color.BLACK);
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.BOLD, 16));
    }
    
    public void criar_e_mostrar(List<Humano> humanos, List<Elfo> elfos, List<Troll>trolls) {
        JFrame menu = new JFrame("MENU PRINCIPAL");
        menu.setSize(1920, 1080);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.getContentPane().setBackground(Color.BLACK);
        menu.setLayout(null);

        BotaoUI botaoUI = new BotaoUI();

        JButton listarHumanos = botaoUI.botaoListagem("Lista de Humanos", humanos);
        listarHumanos.setBounds(100, 70, 500, 50);
        
        JButton listarElfos = botaoUI.botaoListagem("Lista de Elfos", elfos);
        listarElfos.setBounds(100, 150, 500, 50);
        
        JButton listarTrolls = botaoUI.botaoListagem("Lista de Trolls", trolls);
        listarTrolls.setBounds(100, 230, 500, 50);

        JButton editarClasse = botaoUI.botaoClasse("Editar classe(Humanos)", humanos);
        editarClasse.setBounds(100, 310, 500, 50);
        
        JButton editarNome = botaoUI.botaoNome("Editar nome(Elfos)", elfos);
        editarNome.setBounds(100, 390, 500, 50);
        
        JButton editarDano = botaoUI.botaoDano("Editar dano(Trolls)", trolls);
        editarDano.setBounds(100, 470, 500, 50);
        
        JButton criar = botaoUI.criarPersonagem(humanos, elfos, trolls);
        criar.setBounds(700, 230, 500, 50);
        
        JButton serializado = botaoUI.botaoSerializados("Verificar Objetos Serializados");
        serializado.setBounds(700, 310, 500, 50);
        
        JButton apagar = botaoUI.procurarApagar("Apagar", humanos, elfos, trolls);
        apagar.setBounds(700, 390, 500, 50);
        
        JButton escreverSaida = botaoUI.procurarEscrita("Escrever no Arquivo", humanos, elfos, trolls);
        escreverSaida.setBounds(700, 470, 500, 50);
        
        menu.add(listarHumanos);
        menu.add(listarElfos);
        menu.add(listarTrolls);
        menu.add(editarClasse);
        menu.add(editarNome);
        menu.add(editarDano);
        menu.add(criar);
        menu.add(serializado);
        menu.add(apagar);
        menu.add(escreverSaida);

        menu.setVisible(true);
    }
}