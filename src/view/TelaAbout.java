package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaAbout extends JFrame
{
    // Componentes
    private Container cont;
    private JPanel painelCentral, botaoPanel, card1, card2, card3;
    private JScrollPane scrollPane;
    private JLabel titulo, tituloCard1, textoCard1_1, textoCard1_2, textoCard1_3, tituloCard2, textoCard2_1, textoCard2_2, textoCard2_3, tituloCard3, textoCard3_1, textoCard3_2, textoCard3_3, textoCard3_4, textoCard3_5;
    private JButton botao;
    
    // Cores
    private Color corPrincipal = new Color(26, 27, 30);
    private Color laranjaBase = new Color(255, 106, 0);
    private Color cinzaCard = new Color(60, 63, 65);
    private Color cinzaTexto = new Color(200, 200, 200);
    private Color cinzaBorda = new Color(80, 83, 85);
    private Color cinzaClaro = new Color(160, 160, 160);
    
    // Fontes padronizadas
    private Font tit = new Font("Segoe UI", Font.BOLD, 32);
    private Font subtitulo = new Font("Segoe UI", Font.BOLD, 14);
    private Font textoNormal = new Font("Segoe UI", Font.PLAIN, 12);
    private Font textoBold = new Font("Segoe UI", Font.BOLD, 12);
    private Font textoItalic = new Font("Segoe UI", Font.ITALIC, 12);
    
    public TelaAbout()
    {
        super("About - BeForward");
        
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        cont.setBackground(corPrincipal);
        
        // TITULO
        titulo = new JLabel("BeForward Mz", SwingConstants.CENTER);
        titulo.setFont(tit);
        titulo.setForeground(laranjaBase);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        cont.add(titulo, BorderLayout.NORTH);
        
        ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
        
        // PAINEL CENTRAL
        painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(corPrincipal);
        painelCentral.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        // CARD 1 - Descrição do Sistema
        card1 = new JPanel(new GridBagLayout());
        card1.setBackground(cinzaCard);
        card1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(cinzaBorda, 1),
            BorderFactory.createEmptyBorder(0, 25, 0, 25)
        ));
        card1.setPreferredSize(new Dimension(700, 130));
        
        GridBagConstraints gbcCard1 = new GridBagConstraints();
        gbcCard1.gridx = 0;
        gbcCard1.anchor = GridBagConstraints.CENTER;
        
        tituloCard1 = new JLabel("Sobre o Sistema");
        tituloCard1.setFont(subtitulo);
        tituloCard1.setForeground(Color.WHITE); 
        gbcCard1.gridy = 0;
        gbcCard1.insets = new Insets(0, 0, 10, 0);
        card1.add(tituloCard1, gbcCard1);
        
        textoCard1_1 = new JLabel("Sistema desenvolvido para organizar as informações relacionadas às operações realizadas na Be Forward.");
        textoCard1_1.setFont(textoNormal);
        textoCard1_1.setForeground(cinzaTexto);
        gbcCard1.gridy = 1;
        gbcCard1.insets = new Insets(0, 0, 3, 0);
        card1.add(textoCard1_1, gbcCard1);
        
        textoCard1_2 = new JLabel("A aplicação permite visualizar, registar e gerir os dados de forma prática,");
        textoCard1_2.setFont(textoNormal);
        textoCard1_2.setForeground(cinzaTexto);
        gbcCard1.gridy = 2;
        gbcCard1.insets = new Insets(0, 0, 3, 0);
        card1.add(textoCard1_2, gbcCard1);
        
        textoCard1_3 = new JLabel("garantindo maior controlo e clareza no acesso às informações.");
        textoCard1_3.setFont(textoNormal);
        textoCard1_3.setForeground(cinzaTexto);
        gbcCard1.gridy = 3;
        gbcCard1.insets = new Insets(0, 0, 0, 0);
        card1.add(textoCard1_3, gbcCard1);
        
        gbc.gridx = 0; gbc.gridy = 0;
        painelCentral.add(card1, gbc);
       
        // CARD 2 - Tecnologias
        card2 = new JPanel(new GridBagLayout());
        card2.setBackground(cinzaCard);
        card2.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(cinzaBorda, 1),
            BorderFactory.createEmptyBorder(0, 25, 0, 25)
        ));
        card2.setPreferredSize(new Dimension(700, 130));
        
        GridBagConstraints gbcCard2 = new GridBagConstraints();
        gbcCard2.gridx = 0;
        gbcCard2.anchor = GridBagConstraints.CENTER;
        
        tituloCard2 = new JLabel("Tecnologias Utilizadas");
        tituloCard2.setFont(subtitulo);
        tituloCard2.setForeground(Color.WHITE);
        gbcCard2.gridy = 0;
        gbcCard2.insets = new Insets(0, 0, 10, 0);
        card2.add(tituloCard2, gbcCard2);
        
        textoCard2_1 = new JLabel("• Java - Linguagem de programação principal");
        textoCard2_1.setFont(textoNormal);
        textoCard2_1.setForeground(cinzaTexto);
        gbcCard2.gridy = 1;
        gbcCard2.insets = new Insets(0, 0, 3, 0);
        card2.add(textoCard2_1, gbcCard2);
        
        textoCard2_2 = new JLabel("• Swing - Interface gráfica");
        textoCard2_2.setFont(textoNormal);
        textoCard2_2.setForeground(cinzaTexto);
        gbcCard2.gridy = 2;
        gbcCard2.insets = new Insets(0, 0, 3, 0);
        card2.add(textoCard2_2, gbcCard2);
        
        textoCard2_3 = new JLabel("• I/O - Leitura e gravação de dados em ficheiros externos");
        textoCard2_3.setFont(textoNormal);
        textoCard2_3.setForeground(cinzaTexto);
        gbcCard2.gridy = 3;
        gbcCard2.insets = new Insets(0, 0, 0, 0);
        card2.add(textoCard2_3, gbcCard2);
        
        gbc.gridy = 1;
        painelCentral.add(card2, gbc);
        
        // CARD 3 - Desenvolvedores
        card3 = new JPanel(new GridBagLayout());
        card3.setBackground(cinzaCard);
        card3.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(cinzaBorda, 1),
            BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));
        card3.setPreferredSize(new Dimension(700, 170));
        
        GridBagConstraints gbcCard3 = new GridBagConstraints();
        gbcCard3.gridx = 0;
        gbcCard3.anchor = GridBagConstraints.CENTER;
        
        tituloCard3 = new JLabel("Equipe de Desenvolvimento");
        tituloCard3.setFont(subtitulo);
        tituloCard3.setForeground(Color.WHITE);
        gbcCard3.gridy = 0;
        gbcCard3.insets = new Insets(0, 0, 10, 0);
        card3.add(tituloCard3, gbcCard3);
        
        textoCard3_1 = new JLabel("Desenvolvedores:");
        textoCard3_1.setFont(textoBold);
        textoCard3_1.setForeground(Color.WHITE);
        gbcCard3.gridy = 1;
        gbcCard3.insets = new Insets(0, 0, 3, 0);
        card3.add(textoCard3_1, gbcCard3);
        
        textoCard3_2 = new JLabel("Dikshy Guinésh • Hélder Junior • Saymara Chambal");
        textoCard3_2.setFont(textoNormal);
        textoCard3_2.setForeground(cinzaTexto);
        gbcCard3.gridy = 2;
        gbcCard3.insets = new Insets(0, 0, 8, 0);
        card3.add(textoCard3_2, gbcCard3);
        
        textoCard3_3 = new JLabel("Orientadores:");
        textoCard3_3.setFont(textoBold);
        textoCard3_3.setForeground(Color.WHITE);
        gbcCard3.gridy = 3;
        gbcCard3.insets = new Insets(0, 0, 3, 0);
        card3.add(textoCard3_3, gbcCard3);
        
        textoCard3_4 = new JLabel("Darmite Lacmane • Délio Polana");
        textoCard3_4.setFont(textoNormal);
        textoCard3_4.setForeground(cinzaTexto);
        gbcCard3.gridy = 4;
        gbcCard3.insets = new Insets(0, 0, 8, 0);
        card3.add(textoCard3_4, gbcCard3);
        
        textoCard3_5 = new JLabel("Trabalho final - Programação Orientada a Objetos II");
        textoCard3_5.setFont(textoItalic);
        textoCard3_5.setForeground(cinzaClaro);
        gbcCard3.gridy = 5;
        gbcCard3.insets = new Insets(0, 0, 0, 0);
        card3.add(textoCard3_5, gbcCard3);
        
        gbc.gridy = 2;
        painelCentral.add(card3, gbc);
        
        // SCROLL PANE para o painel central
        scrollPane = new JScrollPane(painelCentral);
        scrollPane.setBackground(corPrincipal);
        scrollPane.getViewport().setBackground(corPrincipal);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        cont.add(scrollPane, BorderLayout.CENTER);
        
        // BOTÃO
        botaoPanel = new JPanel();
        botaoPanel.setBackground(corPrincipal);
        
        botao = new JButton("OK");
        botao.setFont(textoNormal);
        botao.setBackground(laranjaBase);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setContentAreaFilled(false);
        botao.setOpaque(true);
        botao.setPreferredSize(new Dimension(80, 35));
        
        // Efeito hover
        botao.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                botao.setBackground(corPrincipal);
            }
            
            public void mouseExited(MouseEvent evt)
            {
                botao.setBackground(laranjaBase);
            }
        });
        
        botao.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        
        botaoPanel.add(botao);
        botaoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        cont.add(botaoPanel, BorderLayout.SOUTH);
        
        setResizable(false);
        setSize(800, 720); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}