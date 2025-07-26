package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaManual extends JFrame
{
    // Componentes
    private Container cont;
    private JPanel painelCentral, botaoPanel, card1, card2, card3, card4, card5;
    private JScrollPane scrollPane;
    private JLabel titulo, tituloCard1, textoCard1_1, textoCard1_2, textoCard1_3, 
                   tituloCard2, textoCard2_1, textoCard2_2, textoCard2_3, textoCard2_4,
                   tituloCard3, textoCard3_1, textoCard3_2, textoCard3_3, textoCard3_4,
                   tituloCard4, textoCard4_1, textoCard4_2, textoCard4_3, textoCard4_4,
                   tituloCard5, textoCard5_1, textoCard5_2, textoCard5_3;
    private JButton botao;
    
    // Cores
    private Color corPrincipal = new Color(26, 27, 30);
    private Color laranjaBase = new Color(255, 106, 0);
    private Color cinzaCard = new Color(60, 63, 65);
    private Color cinzaTexto = new Color(200, 200, 200);
    private Color cinzaBorda = new Color(80, 83, 85);
    
    // Fontes padronizadas
    private Font tit = new Font("Segoe UI", Font.BOLD, 32);
    private Font subtitulo = new Font("Segoe UI", Font.BOLD, 14);
    private Font textoNormal = new Font("Segoe UI", Font.PLAIN, 12);
    
    public TelaManual()
    {
        super("Manual de Uso - BeForward");
        
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        cont.setBackground(corPrincipal);
        
        // TITULO
        titulo = new JLabel("Manual de Instruções", SwingConstants.CENTER);
        titulo.setFont(tit);
        titulo.setForeground(laranjaBase);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        cont.add(titulo, BorderLayout.NORTH);
        
        // PAINEL CENTRAL
        painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(corPrincipal);
        painelCentral.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        // CARD 1 - Primeiros Passos
        card1 = criarCard(140);
        GridBagConstraints gbcCard1 = criarConstraintsCard();
        
        tituloCard1 = new JLabel("1. Primeiros Passos");
        tituloCard1.setFont(subtitulo);
        tituloCard1.setForeground(Color.WHITE); 
        gbcCard1.gridy = 0;
        gbcCard1.insets = new Insets(0, 0, 10, 0);
        card1.add(tituloCard1, gbcCard1);
        
        textoCard1_1 = new JLabel("• Clique no menu 'Ficheiro' em seguida 'ler do ficheiro' para carregar os dados");
        textoCard1_1.setFont(textoNormal);
        textoCard1_1.setForeground(cinzaTexto);
        gbcCard1.gridy = 1;
        gbcCard1.insets = new Insets(0, 0, 5, 0);
        card1.add(textoCard1_1, gbcCard1);
        
        textoCard1_2 = new JLabel("• Certifique-se de ler o Ficheiro 'DadosCliente.txt' localizado na pasta 'resources/data' ");
        textoCard1_2.setFont(textoNormal);
        textoCard1_2.setForeground(cinzaTexto);
        gbcCard1.gridy = 2;
        gbcCard1.insets = new Insets(0, 0, 5, 0);
        card1.add(textoCard1_2, gbcCard1);
        
        textoCard1_3 = new JLabel("• Uma tela será aberta e você só terá de selecionar o ficheiro");
        textoCard1_3.setFont(textoNormal);
        textoCard1_3.setForeground(cinzaTexto);
        gbcCard1.gridy = 3;
        gbcCard1.insets = new Insets(0, 0, 0, 0);
        card1.add(textoCard1_3, gbcCard1);
        
        gbc.gridx = 0; gbc.gridy = 0;
        painelCentral.add(card1, gbc);
       
        // CARD 2 - Gestão de Clientes
        card2 = criarCard(160);
        GridBagConstraints gbcCard2 = criarConstraintsCard();
        
        tituloCard2 = new JLabel("2. Operações");
        tituloCard2.setFont(subtitulo);
        tituloCard2.setForeground(Color.WHITE);
        gbcCard2.gridy = 0;
        gbcCard2.insets = new Insets(0, 0, 10, 0);
        card2.add(tituloCard2, gbcCard2);
        
        textoCard2_1 = new JLabel("• No menu 'Operações' poderá adicionar, remover ou pesquisar por clientes");
        textoCard2_1.setFont(textoNormal);
        textoCard2_1.setForeground(cinzaTexto);
        gbcCard2.gridy = 1;
        gbcCard2.insets = new Insets(0, 0, 5, 0);
        card2.add(textoCard2_1, gbcCard2);
        
        textoCard2_2 = new JLabel("• Essas operações requerem que conheça o codigo ou numero de telefone do cliente");
        textoCard2_2.setFont(textoNormal);
        textoCard2_2.setForeground(cinzaTexto);
        gbcCard2.gridy = 2;
        gbcCard2.insets = new Insets(0, 0, 5, 0);
        card2.add(textoCard2_2, gbcCard2);
        
        textoCard2_3 = new JLabel("• Podera tambem alterar o estado de compra de um cliente e ordenar a lista de clientes");
        textoCard2_3.setFont(textoNormal);
        textoCard2_3.setForeground(cinzaTexto);
        gbcCard2.gridy = 3;
        gbcCard2.insets = new Insets(0, 0, 5, 0);
        card2.add(textoCard2_3, gbcCard2);
        
        textoCard2_4 = new JLabel("• A ordenação é feita com base no preço ou estado de compra");
        textoCard2_4.setFont(textoNormal);
        textoCard2_4.setForeground(cinzaTexto);
        gbcCard2.gridy = 4;
        gbcCard2.insets = new Insets(0, 0, 0, 0);
        card2.add(textoCard2_4, gbcCard2);
        
        gbc.gridy = 1;
        painelCentral.add(card2, gbc);
        
        // CARD 3 - Gestão de Veículos
        card3 = criarCard(160);
        GridBagConstraints gbcCard3 = criarConstraintsCard();
        
        tituloCard3 = new JLabel("3. Consulta");
        tituloCard3.setFont(subtitulo);
        tituloCard3.setForeground(Color.WHITE);
        gbcCard3.gridy = 0;
        gbcCard3.insets = new Insets(0, 0, 10, 0);
        card3.add(tituloCard3, gbcCard3);
        
        textoCard3_1 = new JLabel("• No menu 'Consulta', poderá ver dados estatisticos");
        textoCard3_1.setFont(textoNormal);
        textoCard3_1.setForeground(cinzaTexto);
        gbcCard3.gridy = 1;
        gbcCard3.insets = new Insets(0, 0, 5, 0);
        card3.add(textoCard3_1, gbcCard3);
        
        textoCard3_2 = new JLabel("• Desde o Valor total obtido em direitos aduaneiros, O custo total global da empresa");
        textoCard3_2.setFont(textoNormal);
        textoCard3_2.setForeground(cinzaTexto);
        gbcCard3.gridy = 2;
        gbcCard3.insets = new Insets(0, 0, 5, 0);
        card3.add(textoCard3_2, gbcCard3);
        
        textoCard3_3 = new JLabel("• A situação financeira e a quantidade de clientes, para alem de visualizar todos dados dos clientes atendidos");
        textoCard3_3.setFont(textoNormal);
        textoCard3_3.setForeground(cinzaTexto);
        gbcCard3.gridy = 3;
        gbcCard3.insets = new Insets(0, 0, 5, 0);
        card3.add(textoCard3_3, gbcCard3);
        
        textoCard3_4 = new JLabel("• Poderá também gerar um pdf das compras com Entrega Concluída e Em Trânsito");
        textoCard3_4.setFont(textoNormal);
        textoCard3_4.setForeground(cinzaTexto);
        gbcCard3.gridy = 4;
        gbcCard3.insets = new Insets(0, 0, 0, 0);
        card3.add(textoCard3_4, gbcCard3);
        
        gbc.gridy = 2;
        painelCentral.add(card3, gbc);
        
        // CARD 4 - Processamento de Vendas
        card4 = criarCard(160);
        GridBagConstraints gbcCard4 = criarConstraintsCard();
        
        tituloCard4 = new JLabel("4. Extra");
        tituloCard4.setFont(subtitulo);
        tituloCard4.setForeground(Color.WHITE);
        gbcCard4.gridy = 0;
        gbcCard4.insets = new Insets(0, 0, 10, 0);
        card4.add(tituloCard4, gbcCard4);
        
        textoCard4_1 = new JLabel("• Aceda ao menu 'Extra' para ouvir musica");
        textoCard4_1.setFont(textoNormal);
        textoCard4_1.setForeground(cinzaTexto);
        gbcCard4.gridy = 1;
        gbcCard4.insets = new Insets(0, 0, 5, 0);
        card4.add(textoCard4_1, gbcCard4);
        
        textoCard4_2 = new JLabel("• O menu 'Encerrar' permite voltar a tela de login ou fechar completamente o programa");
        textoCard4_2.setFont(textoNormal);
        textoCard4_2.setForeground(cinzaTexto);
        gbcCard4.gridy = 2;
        gbcCard4.insets = new Insets(0, 0, 5, 0);
        card4.add(textoCard4_2, gbcCard4);
        
        textoCard4_3 = new JLabel("• Mas podera voltar a tela de login clicando duas vezes em qualquer parte da tela principal");
        textoCard4_3.setFont(textoNormal);
        textoCard4_3.setForeground(cinzaTexto);
        gbcCard4.gridy = 3;
        gbcCard4.insets = new Insets(0, 0, 5, 0);
        card4.add(textoCard4_3, gbcCard4);
        
        textoCard4_4 = new JLabel("• A opção 'Open' no menu 'Ficheiro' permite abrir qualquer coisa no seu computador, desde que não tenha senha");
        textoCard4_4.setFont(textoNormal);
        textoCard4_4.setForeground(cinzaTexto);
        gbcCard4.gridy = 4;
        gbcCard4.insets = new Insets(0, 0, 0, 0);
        card4.add(textoCard4_4, gbcCard4);
        
        gbc.gridy = 3;
        painelCentral.add(card4, gbc);
        
        // CARD 5 - Dicas Importantes
        card5 = criarCard(140);
        GridBagConstraints gbcCard5 = criarConstraintsCard();
        
        tituloCard5 = new JLabel("5. Dicas Importantes");
        tituloCard5.setFont(subtitulo);
        tituloCard5.setForeground(Color.WHITE);
        gbcCard5.gridy = 0;
        gbcCard5.insets = new Insets(0, 0, 10, 0);
        card5.add(tituloCard5, gbcCard5);
        
        textoCard5_1 = new JLabel("• Os dados são automaticamente guardados em ficheiros");
        textoCard5_1.setFont(textoNormal);
        textoCard5_1.setForeground(cinzaTexto);
        gbcCard5.gridy = 1;
        gbcCard5.insets = new Insets(0, 0, 5, 0);
        card5.add(textoCard5_1, gbcCard5);
        
        textoCard5_2 = new JLabel("• Não elimine os ficheiros de dados para manter o histórico");
        textoCard5_2.setFont(textoNormal);
        textoCard5_2.setForeground(cinzaTexto);
        gbcCard5.gridy = 2;
        gbcCard5.insets = new Insets(0, 0, 5, 0);
        card5.add(textoCard5_2, gbcCard5);
        
        textoCard5_3 = new JLabel("• Contacte sempre o suporte em caso de duvida");
        textoCard5_3.setFont(textoNormal);
        textoCard5_3.setForeground(cinzaTexto);
        gbcCard5.gridy = 3;
        gbcCard5.insets = new Insets(0, 0, 0, 0);
        card5.add(textoCard5_3, gbcCard5);
        
        gbc.gridy = 4;
        painelCentral.add(card5, gbc);
        
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
        
        botao = new JButton("Fechar");
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
        setSize(800, 800); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    // Método auxiliar para criar cards
    private JPanel criarCard(int altura)
    {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(cinzaCard);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(cinzaBorda, 1),
            BorderFactory.createEmptyBorder(15, 25, 15, 25)
        ));
        card.setPreferredSize(new Dimension(700, altura));
        return card;
    }
    
    // Método auxiliar para criar constraints dos cards
    private GridBagConstraints criarConstraintsCard()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        return gbc;
    }
}