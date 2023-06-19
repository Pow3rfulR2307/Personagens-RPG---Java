/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

/**
 *
 * @author pedro
 */
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BotaoUI extends JButton {

    private boolean hover;

    public BotaoUI() {

        init();
    }

    private void init() {
        setForeground(Color.WHITE);
        setFont(new Font("Sans Serif", Font.BOLD, 16));
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setFocusPainted(false);
        setOpaque(false); // Define o fundo como transparente
        setContentAreaFilled(false); // Remove a área preenchida

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (hover) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            g2.setColor(Color.WHITE);
            g2.fillRect(0, height - 3, width, 10);

            g2.dispose();
        }
    }

    private void customizarCampo(JTextField textField) {

        textField.setBackground(null);
        textField.setForeground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        textField.setCaretColor(Color.WHITE);
    }

    public JButton botaoListagem(String texto, List<?> dados) {

        BotaoUI button = new BotaoUI();
        button.setText(texto);

        button.addActionListener(e -> {
            JFrame lista = new JFrame(texto);
            lista.setSize(1280, 720);

            JTextArea areaTexto = new JTextArea();
            areaTexto.setEditable(false);

            StringBuilder stringBuilder = new StringBuilder();
            for (Object data : dados) {
                stringBuilder.append(data).append("\n");
            }
            areaTexto.setText(stringBuilder.toString());

            JScrollPane scrollPane = new JScrollPane(areaTexto);
            lista.add(scrollPane);

            lista.setVisible(true);
        });
        return button;
    }

    public JButton botaoSerializados(String texto) {
        BotaoUI button = new BotaoUI();
        button.setText(texto);

        button.addActionListener(e -> {
            List<Object> objetos = Personagem.retornarSerializados();
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            for (Object objeto : objetos) {
                textArea.append(objeto.toString() + "\n");
            }

            JFrame frame = new JFrame();
            frame.add(new JScrollPane(textArea));
            frame.setSize(1280, 720);
            frame.setVisible(true);

        });

        return button;
    }

    public JButton botaoClasse(String texto, List<Humano> humanos) {

        BotaoUI botaoProcurar = new BotaoUI();
        botaoProcurar.setText(texto);

        botaoProcurar.addActionListener(e -> {
            JFrame verificarHumano = new JFrame(texto);
            verificarHumano.setSize(1280, 720);
            verificarHumano.setLayout(null);
            verificarHumano.getContentPane().setBackground(Color.BLACK);

            JTextField nome = new JTextField(15);
            customizarCampo(nome);

            JTextField level = new JTextField(15);
            customizarCampo(level);

            JTextField nova_classe = new JTextField(15);
            customizarCampo(nova_classe);

            BotaoUI verificarButton = new BotaoUI();
            verificarButton.setText("Verificar e Atualizar Classe");

            BotaoUI botaoDeletar = new BotaoUI();
            botaoDeletar.setText("Deletar humano");

            verificarButton.addActionListener(ev -> {
                String nomeText = nome.getText();
                int levelValue = Integer.parseInt(level.getText());
                String classeText = nova_classe.getText();

                for (Humano h : humanos) {
                    if (h.nome.equals(nomeText) && h.level == levelValue) {

                        h.mudar_classe(classeText);
                    }
                }

            });

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(100, 50, 100, 30);
            nomeLabel.setForeground(Color.WHITE);

            nome.setBounds(100, 80, 300, 30);

            JLabel levelLabel = new JLabel("Level:");
            levelLabel.setBounds(100, 130, 100, 30);
            levelLabel.setForeground(Color.WHITE);

            level.setBounds(100, 160, 300, 30);

            JLabel nova_classeLabel = new JLabel("Nova Classe:");
            nova_classeLabel.setBounds(100, 210, 100, 30);
            nova_classeLabel.setForeground(Color.WHITE);

            nova_classe.setBounds(100, 240, 300, 30);

            verificarButton.setBounds(100, 290, 300, 30);

            verificarHumano.add(nomeLabel);
            verificarHumano.add(nome);
            verificarHumano.add(levelLabel);
            verificarHumano.add(level);
            verificarHumano.add(nova_classeLabel);
            verificarHumano.add(nova_classe);
            verificarHumano.add(verificarButton);

            verificarHumano.setVisible(true);
        });
        return botaoProcurar;
    }

    /////////////////////////////////////////////////////////////////////////
    public JButton botaoNome(String texto, List<Elfo> elfos) {

        BotaoUI botaoProcurar = new BotaoUI();
        botaoProcurar.setText(texto);

        botaoProcurar.addActionListener(e -> {
            JFrame verificarElfo = new JFrame(texto);
            verificarElfo.setSize(1280, 720);
            verificarElfo.setLayout(null);
            verificarElfo.getContentPane().setBackground(Color.BLACK);

            JTextField nome = new JTextField(15);
            customizarCampo(nome);

            JTextField level = new JTextField(15);
            customizarCampo(level);

            JTextField novo_nome = new JTextField(15);
            customizarCampo(novo_nome);

            BotaoUI verificarButton = new BotaoUI();
            verificarButton.setText("Verificar e Atualizar Nome");

            verificarButton.addActionListener(ev -> {
                String nomeText = nome.getText();
                int levelValue = Integer.parseInt(level.getText());
                String NewNomeText = novo_nome.getText();

                for (Elfo el : elfos) {
                    if (el.nome.equals(nomeText) && el.level == levelValue) {

                        el.mudar_nome(NewNomeText);
                    }
                }

            });

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(100, 50, 100, 30);
            nomeLabel.setForeground(Color.WHITE);

            nome.setBounds(100, 80, 300, 30);

            JLabel levelLabel = new JLabel("Level:");
            levelLabel.setBounds(100, 130, 100, 30);
            levelLabel.setForeground(Color.WHITE);

            level.setBounds(100, 160, 300, 30);

            JLabel novo_nomeLabel = new JLabel("Novo Nome:");
            novo_nomeLabel.setBounds(100, 210, 100, 30);
            novo_nomeLabel.setForeground(Color.WHITE);

            novo_nome.setBounds(100, 240, 300, 30);

            verificarButton.setBounds(100, 290, 300, 30);

            verificarElfo.add(nomeLabel);
            verificarElfo.add(nome);
            verificarElfo.add(levelLabel);
            verificarElfo.add(level);
            verificarElfo.add(novo_nomeLabel);
            verificarElfo.add(novo_nome);
            verificarElfo.add(verificarButton);

            verificarElfo.setVisible(true);
        });
        return botaoProcurar;
    }

    ////////////////////////////////////////////////////////////
    public JButton botaoDano(String texto, List<Troll> trolls) {

        BotaoUI botaoProcurar = new BotaoUI();
        botaoProcurar.setText(texto);

        botaoProcurar.addActionListener(e -> {
            JFrame verificarTroll = new JFrame(texto);
            verificarTroll.setSize(1280, 720);
            verificarTroll.setLayout(null);
            verificarTroll.getContentPane().setBackground(Color.BLACK);

            JTextField nome = new JTextField(15);
            customizarCampo(nome);

            JTextField level = new JTextField(15);
            customizarCampo(level);

            JTextField novo_dano = new JTextField(15);
            customizarCampo(novo_dano);

            BotaoUI verificarButton = new BotaoUI();
            verificarButton.setText("Verificar e Atualizar Dano");

            verificarButton.addActionListener(ev -> {
                String nomeText = nome.getText();
                int levelValue = Integer.parseInt(level.getText());
                float danoValue = Float.parseFloat(novo_dano.getText());

                for (Troll t : trolls) {
                    if (t.nome.equals(nomeText) && t.level == levelValue) {

                        t.mudar_pontos_dano(danoValue);
                    }
                }

            });

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(100, 50, 100, 30);
            nomeLabel.setForeground(Color.WHITE);

            nome.setBounds(100, 80, 300, 30);

            JLabel levelLabel = new JLabel("Level:");
            levelLabel.setBounds(100, 130, 100, 30);
            levelLabel.setForeground(Color.WHITE);

            level.setBounds(100, 160, 300, 30);

            JLabel novo_danoLabel = new JLabel("Novo Dano:");
            novo_danoLabel.setBounds(100, 210, 100, 30);
            novo_danoLabel.setForeground(Color.WHITE);

            novo_dano.setBounds(100, 240, 300, 30);

            verificarButton.setBounds(100, 290, 300, 30);

            verificarTroll.add(nomeLabel);
            verificarTroll.add(nome);
            verificarTroll.add(levelLabel);
            verificarTroll.add(level);
            verificarTroll.add(novo_danoLabel);
            verificarTroll.add(novo_dano);
            verificarTroll.add(verificarButton);

            verificarTroll.setVisible(true);
        });
        return botaoProcurar;
    }

    public JButton procurarEscrita(String texto, List<Humano> h, List<Elfo> el, List<Troll> t) {

        BotaoUI botaoEscrever = new BotaoUI();
        botaoEscrever.setText(texto);

        botaoEscrever.addActionListener(e -> {

            JFrame escolherEspecie = new JFrame(texto);
            escolherEspecie.setSize(1280, 720);
            escolherEspecie.setLayout(null);
            escolherEspecie.getContentPane().setBackground(Color.BLACK);

            String[] opcoes = {"Escrever Humanos", "Escrever Elfos", "Escrever Trolls"};

            JComboBox<String> listaOpcoes = new JComboBox<>(opcoes);
            listaOpcoes.setBounds(100, 140, 500, 50);

            BotaoUI escreverEspecie = new BotaoUI();
            escreverEspecie.setText("Escrever espécie");
            
            BotaoUI verificarSaida = new BotaoUI();
            verificarSaida.setText("Verificar Saída");

            escreverEspecie.addActionListener(ev -> {

                String opcaoSelecionada = (String) listaOpcoes.getSelectedItem();

                switch (opcaoSelecionada) {

                    case "Escrever Humanos":
                        try {
                        Escrever.escreverLista(h, "-------HUMANOS-------");
                    } catch (Excessao ex) {
                        JOptionPane.showMessageDialog(null, "Erro de abertura de arquivo");
                    }
                    break;

                    case "Escrever Elfos":
                        
                        try {
                        Escrever.escreverLista(el, "-------ELFOS-------");
                    } catch (Excessao ex) {
                        JOptionPane.showMessageDialog(null, "Erro de abertura de arquivo");
                    }
                    break;

                    default:
                        try {
                        Escrever.escreverLista(t, "-------TROLLS-------");
                    } catch (Excessao ex) {
                        JOptionPane.showMessageDialog(null, "Erro de abertura de arquivo");
                    }
                    break;
                }
            });
            
            verificarSaida.addActionListener(ev ->{
            
                JFrame listaUsuario = new JFrame("Lista usuário");
                listaUsuario.setSize(1280, 720);
                
                JTextArea areaTexto = new JTextArea();
                areaTexto.setEditable(false);
                
                Escrever.mostrarResultado(areaTexto);
                
                JScrollPane scrollPane = new JScrollPane(areaTexto);
                listaUsuario.add(scrollPane);
                listaUsuario.setVisible(true);
            });

            JLabel especieLabel = new JLabel("Escolha a Espécie:");
            especieLabel.setBounds(100, 100, 500, 30);
            especieLabel.setForeground(Color.WHITE);

            escreverEspecie.setBounds(100, 200, 300, 30);
            verificarSaida.setBounds(100, 300, 300, 30);

            escolherEspecie.add(especieLabel);
            escolherEspecie.add(listaOpcoes);
            escolherEspecie.add(escreverEspecie);
            escolherEspecie.add(verificarSaida);

            escolherEspecie.setVisible(true);
        });

        return botaoEscrever;
    }

    ////////////////////////////////////////////////////////////////////////
    public JButton procurarApagar(String texto, List<Humano> h, List<Elfo> el, List<Troll> t) {

        BotaoUI botaoApagar = new BotaoUI();
        botaoApagar.setText(texto);

        botaoApagar.addActionListener(e -> {

            JFrame apagarPersonagem = new JFrame(texto);
            apagarPersonagem.setSize(1280, 720);
            apagarPersonagem.setLayout(null);
            apagarPersonagem.getContentPane().setBackground(Color.BLACK);

            JTextField nome = new JTextField(15);
            customizarCampo(nome);

            JTextField level = new JTextField(15);
            customizarCampo(level);

            String[] opcoes = {"Apagar Humano", "Apagar Elfo", "Apagar Troll"};

            JComboBox<String> listaOpcoes = new JComboBox<>(opcoes);
            listaOpcoes.setBounds(100, 240, 500, 50);

            BotaoUI apagarObjeto = new BotaoUI();
            apagarObjeto.setText("Apagar Objeto");

            apagarObjeto.addActionListener(ev -> {

                String nomeText = nome.getText();
                int levelValue = Integer.parseInt(level.getText());
                String opcaoSelecionada = (String) listaOpcoes.getSelectedItem();

                switch (opcaoSelecionada) {

                    case "Apagar Humano":
                        for (Humano hum : h) {
                            if (hum.nome.equals(nomeText) && hum.level == levelValue) {
                                hum.deletar(h);
                            }
                        }
                        break;

                    case "Apagar Elfo":
                        for (Elfo elf : el) {
                            if (elf.nome.equals(nomeText) && elf.level == levelValue) {
                                elf.deletar(el);
                            }
                        }
                        break;

                    default:
                        for (Troll tr : t) {
                            if (tr.nome.equals(nomeText) && tr.level == levelValue) {
                                tr.deletar(t);
                            }
                        }
                        break;
                }
            });

            JLabel especieLabel = new JLabel("Escolha a Espécie:");
            especieLabel.setBounds(100, 210, 500, 30);
            especieLabel.setForeground(Color.WHITE);

            apagarObjeto.setBounds(100, 290, 300, 30);

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(100, 50, 100, 30);
            nomeLabel.setForeground(Color.WHITE);

            nome.setBounds(100, 80, 300, 30);

            JLabel levelLabel = new JLabel("Level:");
            levelLabel.setBounds(100, 130, 100, 30);
            levelLabel.setForeground(Color.WHITE);

            level.setBounds(100, 160, 300, 30);

            apagarPersonagem.add(nomeLabel);
            apagarPersonagem.add(nome);
            apagarPersonagem.add(levelLabel);
            apagarPersonagem.add(level);
            apagarPersonagem.add(especieLabel);
            apagarPersonagem.add(listaOpcoes);
            apagarPersonagem.add(apagarObjeto);

            apagarPersonagem.setVisible(true);
        });

        return botaoApagar;
    }
    
    public JButton criarPersonagem(List<Humano> h, List<Elfo> elf, List<Troll>tr){
    
        BotaoUI botaoCriar = new BotaoUI();
        botaoCriar.setText("Criar Personagem");

        botaoCriar.addActionListener(e -> {

            JFrame criarPersonagem = new JFrame("Criar Personagem");
            criarPersonagem.setSize(1280, 720);
            criarPersonagem.setLayout(null);
            criarPersonagem.getContentPane().setBackground(Color.BLACK);

            String[] opcoes = {"Humano", "Elfo", "Troll"};

            JTextField nome = new JTextField(15);
            customizarCampo(nome);

            JTextField classe = new JTextField(15);
            customizarCampo(classe);
            
            JTextField level = new JTextField(15);
            customizarCampo(level);
            
            JTextField pontos_dano = new JTextField(15);
            customizarCampo(pontos_dano);
            
            JComboBox<String> listaOpcoes = new JComboBox<>(opcoes);
            listaOpcoes.setBounds(100, 400, 500, 50);
            
            
            JLabel areaLabel = new JLabel("Descrição:");
            areaLabel.setBounds(600, 40, 500, 30);
            areaLabel.setForeground(Color.WHITE);
            
            JTextArea areaTexto = new JTextArea();
            areaTexto.setBounds(600, 70, 600,200);
            areaTexto.setLineWrap(true); 
            areaTexto.setWrapStyleWord(true); 
            
            Font font = new Font("Arial", Font.BOLD, 14);
            areaTexto.setFont(font);
            
            BotaoUI botaoFinalizar = new BotaoUI();
            botaoFinalizar.setText("Criar");

            botaoFinalizar.addActionListener(ev -> {
                
                String nomeText = nome.getText();
                String classeText = classe.getText();
                int levelValue = Integer.parseInt(level.getText());
                float dano = Float.parseFloat(pontos_dano.getText());
                String opcaoSelecionada = (String) listaOpcoes.getSelectedItem();

                NomeProvider nomeProvider = new NomeProvider(nomeText);
                switch (opcaoSelecionada) {

                    case "Humano":
                        Humano hum = new Humano(nomeProvider, opcaoSelecionada, classeText, levelValue, dano);
                        hum.descricao(areaTexto);
                        h.add(hum);
                        break;

                    case "Elfo":
                        Elfo el = new Elfo(nomeProvider, opcaoSelecionada, classeText, levelValue, dano);
                        el.descricao(areaTexto);
                        elf.add(el);
                        break;

                    default:
                        Troll t = new Troll(nomeProvider, opcaoSelecionada, classeText, levelValue, dano);
                        t.descricao(areaTexto);
                        tr.add(t);
                        break;
                }
            });
            JLabel especieLabel = new JLabel("Escolha a Espécie:");
            especieLabel.setBounds(100, 370, 500, 30);
            especieLabel.setForeground(Color.WHITE);

            botaoFinalizar.setBounds(100, 450, 300, 30);

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setBounds(100, 50, 100, 30);
            nomeLabel.setForeground(Color.WHITE);

            nome.setBounds(100, 80, 300, 30);
            
            JLabel classeLabel = new JLabel("Classe:");
            classeLabel.setBounds(100, 130, 100, 30);
            classeLabel.setForeground(Color.WHITE);

            classe.setBounds(100, 160, 300, 30);
            
            JLabel levelLabel = new JLabel("Level:");
            levelLabel.setBounds(100, 210, 100, 30);
            levelLabel.setForeground(Color.WHITE);

            level.setBounds(100, 240, 300, 30);
            
            JLabel danoLabel = new JLabel("Dano:");
            danoLabel.setBounds(100, 290, 100, 30);
            danoLabel.setForeground(Color.WHITE);

            pontos_dano.setBounds(100, 320, 300, 30);
            
            criarPersonagem.add(especieLabel);
            criarPersonagem.add(listaOpcoes);
            criarPersonagem.add(botaoFinalizar);
            criarPersonagem.add(nomeLabel);
            criarPersonagem.add(nome);
            criarPersonagem.add(classeLabel);
            criarPersonagem.add(classe);
            criarPersonagem.add(levelLabel);
            criarPersonagem.add(level);
            criarPersonagem.add(danoLabel);
            criarPersonagem.add(pontos_dano);
            criarPersonagem.add(areaTexto);

            criarPersonagem.setVisible(true);
        });
        return botaoCriar;
    }
}
