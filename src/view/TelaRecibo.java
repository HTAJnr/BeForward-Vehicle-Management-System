package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

// Imports para PDF com iText
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import model.*;
import util.Remocoes;

import com.itextpdf.text.Font;

public class TelaRecibo extends JFrame 
{
    // Componentes da interface
    private JLabel tituloLabel, numeroReciboLabel, separadorLabel1, separadorLabel2, separadorLabel3,
    clienteLabel, nomeClienteLabel, contatoClienteLabel, tipoClienteLabel, 
    carroLabel, codigoCarroLabel, marcaCarroLabel, cilindradaCarroLabel, precoLabel, precoBaseLabel, descontoLabel, precoFinalLabel,
    estadoLabel, dataCompraLabel, observacoesLabel, rodapeLabel, direitosAduaneirosLabel, impostoConsumoLabel, ivaLabel, taxasFixasLabel;
    private JButton btnFechar, btnRemover;
    private ImageIcon delL, delP, canP, canL;
    private JPanel buttonPanel, reciboPanel, headerPanel, footerPanel;
    private JPopupMenu popupMenu;
    private JMenuItem menuSalvarComo;
    private Container cont;
    
    private Remocoes rem;

    private DecimalFormat mt;
    private float direitosAduaneiros, impostoConsumo, iva, taxasFixas, desconto, precoFinal;
    private String tipo = "", tipoEspecifico = "";
    
    public TelaRecibo(ArrayList<Cliente> lista, int i) 
    {
        super("Recibo de Compra - Sistema de Vendas");
          
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color grey = new Color(0, 0, 0); 
    	Color grey1 = new Color(120, 117, 113);   
    	
    	java.awt.Font arial24 = new java.awt.Font("Arial", java.awt.Font.BOLD, 28);
    	java.awt.Font arial18 = new java.awt.Font("Arial", java.awt.Font.BOLD, 18);
    	java.awt.Font arial16 = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);
    	java.awt.Font arial14 = new java.awt.Font("Arial", java.awt.Font.BOLD, 14);
    	java.awt.Font arial13 = new java.awt.Font("Arial", java.awt.Font.BOLD, 13);
    	java.awt.Font arial12 = new java.awt.Font("Arial", java.awt.Font.BOLD, 12);
    	java.awt.Font arial12i = new java.awt.Font("Arial", java.awt.Font.ITALIC, 12);
    	java.awt.Font fonteButton = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16);
    	
    	canL = new ImageIcon("./resources/images/closeL.png");
    	canP = new ImageIcon("./resources/images/close.png");
    	delL = new ImageIcon("./resources/images/deleteL.png");
    	delP = new ImageIcon("./resources/images/deleteP.png");
    	ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
        
    	rem = new Remocoes();
    	Cliente c = lista.get(i);
    	
        // TODOS OS ATRIBUTOS
        String nome, dataCompra, estado, marca, modelo;
        long contacto;
        int codigo, cilin;
        float preco;
        
        contacto = c.getTel();
        nome = c.getNome();
        dataCompra = c.getDataCompra();
        estado = c.getEstadoCompra();
        marca = c.getMarca();
        modelo = c.getModelo();
        codigo = c.getCodigo();
        cilin = c.getCilindrada(); 
        preco = c.getPreco();
        
        
        // CALCULAR VALORES USANDO METODOS DAS CLASSES
        calcularValores(lista);
        
        mt = new DecimalFormat("###,###,###.00 MT");
        
        // Configurar interface principal
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        cont.setBackground(corPrincipal);
        
        // CRIAR PAINEL PRINCIPAL DO RECIBO
        reciboPanel = new JPanel();
        reciboPanel.setLayout(new BorderLayout());
        reciboPanel.setBackground(Color.WHITE);
        reciboPanel.setBorder(BorderFactory.createCompoundBorder
        		(
            BorderFactory.createLineBorder(laranjaBase, 2),
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));
        
        // PAINEL DO CABEÇALHO
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        // TITULO PRINCIPAL COM DESTAQUE
        tituloLabel = new JLabel("RECIBO DE COMPRA");
        tituloLabel.setFont(arial24);
        tituloLabel.setForeground(grey);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        headerPanel.add(tituloLabel);
        
        // NUMERO DO RECIBO
        numeroReciboLabel = new JLabel("Recibo Nº: " + Cliente.contGeralRecibo);
        numeroReciboLabel.setFont(arial24);
        numeroReciboLabel.setForeground(new Color(100, 100, 100));
        numeroReciboLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numeroReciboLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        headerPanel.add(numeroReciboLabel);
        
        // SEPARADOR			  
        separadorLabel1 = new JLabel("===========================================================");
        separadorLabel1.setFont(arial12);
        separadorLabel1.setForeground(grey);
        separadorLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(separadorLabel1);
        
        reciboPanel.add(headerPanel, BorderLayout.NORTH);
        
        // PAINEL CENTRAL COM DADOS
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new GridBagLayout());
        centralPanel.setBackground(Color.WHITE);
        GridBagConstraints gbcCentral = new GridBagConstraints();
        
        int linha = 0;
        
        // SECÇÃO DO CLIENTE
        clienteLabel = new JLabel("DADOS DO CLIENTE");
        clienteLabel.setFont(arial16);
        clienteLabel.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.gridwidth = 2;
        gbcCentral.anchor = GridBagConstraints.CENTER;
        gbcCentral.insets = new Insets(20, 0, 12, 0);
        centralPanel.add(clienteLabel, gbcCentral);
        
        // TIPO DE CLIENTE
        if (c instanceof Doutorado)
        {
        	tipo  = "PARTICULAR";
        	tipoEspecifico = "DOUTORADO";
        }
        else if (c instanceof Normal) 
        {
        	tipo  = "PARTICULAR";
        	tipoEspecifico = "NORMAL";
        }
        else if (c instanceof Revendedor) 
        {
        	tipo  = "EMPRESARIAL";
        	tipoEspecifico = "REVENDEDOR";
        }
        else if (c instanceof Estado) 
        {
        	tipo  = "EMPRESARIAL";
        	tipoEspecifico = "ESTADO";
        }
        
        // DADOS DO CLIENTE
        nomeClienteLabel = new JLabel("Nome: " + nome);
        nomeClienteLabel.setFont(arial13);
        nomeClienteLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 5, 0);
        centralPanel.add(nomeClienteLabel, gbcCentral);
        
        contatoClienteLabel = new JLabel("Contato: " + contacto);
        contatoClienteLabel.setFont(arial13);
        contatoClienteLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(contatoClienteLabel, gbcCentral);
        
        tipoClienteLabel = new JLabel("Tipo: " + tipo +" - "+ tipoEspecifico);
        tipoClienteLabel.setFont(arial13);
        tipoClienteLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(tipoClienteLabel, gbcCentral);
                
        // SECÇÃO DO CARRO
        carroLabel = new JLabel("DADOS DO VEÍCULO");
        carroLabel.setFont(arial16);
        carroLabel.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(15, 0, 12, 0);
        centralPanel.add(carroLabel, gbcCentral);
        
        // DADOS DO CARRO
        codigoCarroLabel = new JLabel("Código: " + Carro.contCarros);
        codigoCarroLabel.setFont(arial13);
        codigoCarroLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 5, 0);
        centralPanel.add(codigoCarroLabel, gbcCentral);
        
        marcaCarroLabel = new JLabel("Marca/Modelo: " + marca+ " " +modelo);
        marcaCarroLabel.setFont(arial13);
        marcaCarroLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(marcaCarroLabel, gbcCentral);
        
        cilindradaCarroLabel = new JLabel("Cilindrada: " + cilin +" CC");
        cilindradaCarroLabel.setFont(arial13);
        cilindradaCarroLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(cilindradaCarroLabel, gbcCentral);
        
        estadoLabel = new JLabel("Estado: " + estado);
        estadoLabel.setFont(arial13);
        estadoLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(estadoLabel, gbcCentral);
        
        dataCompraLabel = new JLabel("Data da Compra: " + dataCompra);
        dataCompraLabel.setFont(arial13);
        dataCompraLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 15, 0);
        centralPanel.add(dataCompraLabel, gbcCentral);
        
        // SEPARADOR
        separadorLabel2 = new JLabel("===========================================================");
        separadorLabel2.setFont(arial12);
        separadorLabel2.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(10, 0, 15, 0);
        centralPanel.add(separadorLabel2, gbcCentral);
        
        // SECÇÃO DE VALORES
        precoLabel = new JLabel("VALORES E TAXAS");
        precoLabel.setFont(arial16);
        precoLabel.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(10, 0, 12, 0);
        centralPanel.add(precoLabel, gbcCentral);
        
        // VALORES DETALHADOS
        precoBaseLabel = new JLabel("Preço Base: " + mt.format(preco));
        precoBaseLabel.setFont(arial13);
        precoBaseLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 5, 0);
        centralPanel.add(precoBaseLabel, gbcCentral);
        
        direitosAduaneirosLabel = new JLabel("Direitos Aduaneiros: " + mt.format(direitosAduaneiros));
        direitosAduaneirosLabel.setFont(arial13);
        direitosAduaneirosLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(direitosAduaneirosLabel, gbcCentral);
        
        impostoConsumoLabel = new JLabel("Imposto sobre Consumo: " + mt.format(impostoConsumo));
        impostoConsumoLabel.setFont(arial13);
        impostoConsumoLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(impostoConsumoLabel, gbcCentral);
        
        ivaLabel = new JLabel("IVA: " + mt.format(iva));
        ivaLabel.setFont(arial13);
        ivaLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(ivaLabel, gbcCentral);
        
        taxasFixasLabel = new JLabel("Taxas Fixas (Despachante + Inspeção): " + mt.format(taxasFixas));
        taxasFixasLabel.setFont(arial13);
        taxasFixasLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(taxasFixasLabel, gbcCentral);
        
        // DESCONTO (SE APLICAVEL)
        if (desconto > 0) {
            descontoLabel = new JLabel("Desconto Aplicado: -" + mt.format(desconto));
            descontoLabel.setFont(arial13);
            descontoLabel.setForeground(new Color(220, 20, 60));
            gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
            centralPanel.add(descontoLabel, gbcCentral);
        }
        
        // SEPARADOR ANTES DO TOTAL
        separadorLabel3 = new JLabel("===========================================================");
        separadorLabel3.setFont(arial12);
        separadorLabel3.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(15, 0, 10, 0);
        centralPanel.add(separadorLabel3, gbcCentral);
        
        // PREFO FINAL DESTACADO
        precoFinalLabel = new JLabel("TOTAL A PAGAR: " + mt.format(precoFinal));
        precoFinalLabel.setFont(arial18);
        precoFinalLabel.setForeground(laranjaBase);
        precoFinalLabel.setOpaque(true);
        precoFinalLabel.setBackground(new Color(255, 245, 235));
        precoFinalLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 120, 0), 2),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(15, 0, 20, 0);
        centralPanel.add(precoFinalLabel, gbcCentral);
        
        reciboPanel.add(centralPanel, BorderLayout.CENTER);
        
        // PAINEL DO RODAPE
        footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        
        // OBSERVACOES PRINCIPAIS
        observacoesLabel = new JLabel("Obrigado pela sua preferência!");
        observacoesLabel.setFont(arial14);
        observacoesLabel.setForeground(grey);
        observacoesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        observacoesLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        footerPanel.add(observacoesLabel);
        
        // INTRUCCOES PARA O USUARIO
        rodapeLabel = new JLabel("Clique com o botão direito para salvar este recibo em PDF");
        rodapeLabel.setFont(arial12i);
        rodapeLabel.setForeground(grey);
        rodapeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerPanel.add(rodapeLabel);
        
        reciboPanel.add(footerPanel, BorderLayout.SOUTH);
        
        // ADICIONAR RECIBO AO CONTAINER PRINCIPAL
        JScrollPane scrollPane = new JScrollPane(reciboPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        scrollPane.setBackground(new Color(245, 245, 245));
        cont.add(scrollPane, BorderLayout.CENTER);
        
        // PAINEL DE BOTÕES
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        
        btnFechar = new JButton("Fechar", canP);
        btnFechar.setRolloverIcon(canL);
        btnFechar.setFont(fonteButton);
        btnFechar.setForeground(Color.WHITE);
        btnFechar.setBackground(laranjaBase);
        btnFechar.setFocusPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnFechar.setOpaque(true);
        btnFechar.setPreferredSize(new Dimension(140, 40));
        
        btnFechar.addActionListener
        (
        	new ActionListener() 
        	{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			}
        );
        
        //EFEITO AO PASSAR O MOUSE
	    btnFechar.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            btnFechar.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            btnFechar.setBackground(laranjaBase);
	        }
	    });
        
        buttonPanel.add(btnFechar);
        cont.add(buttonPanel, BorderLayout.SOUTH);
        
        // MENU POPUP
        popupMenu = new JPopupMenu();
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        menuSalvarComo = new JMenuItem("Salvar");
        menuSalvarComo.setFont(arial12);
        
        popupMenu.add(menuSalvarComo);
        
        // ADICIONAR POPUP AO PAINEL DO RECIBO
        reciboPanel.setComponentPopupMenu(popupMenu);
        
        // Evento do menu salvar como
        menuSalvarComo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	salvarPDFComo(contacto, nome, tipoEspecifico, dataCompra, estado, marca, modelo, codigo, cilin, preco); 
            }
        });
        
        // Evento do botão fechar
        btnFechar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });
        
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(650, 700));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public TelaRecibo(ArrayList<Cliente> lista, int i, String botao) 
    {
        super("Recibo de Compra - Sistema de Vendas");
          
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color grey = new Color(0, 0, 0);     
    	Color grey1 = new Color(120, 117, 113);    
    	
    	java.awt.Font arial24 = new java.awt.Font("Arial", java.awt.Font.BOLD, 28);
    	java.awt.Font arial18 = new java.awt.Font("Arial", java.awt.Font.BOLD, 18);
    	java.awt.Font arial16 = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);
    	java.awt.Font arial14 = new java.awt.Font("Arial", java.awt.Font.BOLD, 14);
    	java.awt.Font arial13 = new java.awt.Font("Arial", java.awt.Font.BOLD, 13);
    	java.awt.Font arial12 = new java.awt.Font("Arial", java.awt.Font.BOLD, 12);
    	java.awt.Font arial12i = new java.awt.Font("Arial", java.awt.Font.ITALIC, 12);
    	java.awt.Font fonteButton = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 16);
    	
    	canL = new ImageIcon("./resources/images/closeL.png");
    	canP = new ImageIcon("./resources/images/close.png");
    	delL = new ImageIcon("./resources/images/deleteL.png");
    	delP = new ImageIcon("./resources/images/deleteP.png");
    	
    	rem = new Remocoes();
    	Cliente c = lista.get(i);
    	
        // TODOS OS ATRIBUTOS
        String nome, dataCompra, estado, marca, modelo;
        long contacto;
        int codigo, cilin;
        float preco;
        
        contacto = c.getTel();
        nome = c.getNome();
        dataCompra = c.getDataCompra();
        estado = c.getEstadoCompra();
        marca = c.getMarca();
        modelo = c.getModelo();
        codigo = c.getCodigo();
        cilin = c.getCilindrada(); 
        preco = c.getPreco();
        
        
        // CALCULAR VALORES USANDO METODOS DAS CLASSES
        calcularValores(lista);
        
        mt = new DecimalFormat("###,###,###.00 MT");
        
        // Configurar interface principal
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        cont.setBackground(corPrincipal);
        
        // CRIAR PAINEL PRINCIPAL DO RECIBO
        reciboPanel = new JPanel();
        reciboPanel.setLayout(new BorderLayout());
        reciboPanel.setBackground(Color.WHITE);
        reciboPanel.setBorder(BorderFactory.createCompoundBorder
        		(
            BorderFactory.createLineBorder(laranjaBase, 2),
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));
        
        // PAINEL DO CABEÇALHO
        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        // TITULO PRINCIPAL COM DESTAQUE
        tituloLabel = new JLabel("RECIBO DE COMPRA");
        tituloLabel.setFont(arial24);
        tituloLabel.setForeground(grey);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        headerPanel.add(tituloLabel);
        
        // NUMERO DO RECIBO
        numeroReciboLabel = new JLabel("Recibo Nº: " + Cliente.contGeralRecibo);
        numeroReciboLabel.setFont(arial24);
        numeroReciboLabel.setForeground(new Color(100, 100, 100));
        numeroReciboLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numeroReciboLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        headerPanel.add(numeroReciboLabel);
        
        // SEPARADOR			  
        separadorLabel1 = new JLabel("===========================================================");
        separadorLabel1.setFont(arial12);
        separadorLabel1.setForeground(grey);
        separadorLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(separadorLabel1);
        
        reciboPanel.add(headerPanel, BorderLayout.NORTH);
        
        // PAINEL CENTRAL COM DADOS
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new GridBagLayout());
        centralPanel.setBackground(Color.WHITE);
        GridBagConstraints gbcCentral = new GridBagConstraints();
        
        int linha = 0;
        
        // SECÇÃO DO CLIENTE
        clienteLabel = new JLabel("DADOS DO CLIENTE");
        clienteLabel.setFont(arial16);
        clienteLabel.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.gridwidth = 2;
        gbcCentral.anchor = GridBagConstraints.CENTER;
        gbcCentral.insets = new Insets(20, 0, 12, 0);
        centralPanel.add(clienteLabel, gbcCentral);
        
        // TIPO DE CLIENTE
        if (c instanceof Doutorado)
        {
        	tipo  = "PARTICULAR";
        	tipoEspecifico = "DOUTORADO";
        }
        else if (c instanceof Normal) 
        {
        	tipo  = "PARTICULAR";
        	tipoEspecifico = "NORMAL";
        }
        else if (c instanceof Revendedor) 
        {
        	tipo  = "EMPRESARIAL";
        	tipoEspecifico = "EVENDEDOR";
        }
        else if (c instanceof Estado) 
        {
        	tipo  = "EMPRESARIAL";
        	tipoEspecifico = "ESTADO";
        }
        
        // DADOS DO CLIENTE
        nomeClienteLabel = new JLabel("Nome: " + nome);
        nomeClienteLabel.setFont(arial13);
        nomeClienteLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 5, 0);
        centralPanel.add(nomeClienteLabel, gbcCentral);
        
        contatoClienteLabel = new JLabel("Contato: " + contacto);
        contatoClienteLabel.setFont(arial13);
        contatoClienteLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(contatoClienteLabel, gbcCentral);
        
        tipoClienteLabel = new JLabel("Tipo: " + tipo + " - " + tipoEspecifico);
        tipoClienteLabel.setFont(arial13);
        tipoClienteLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(tipoClienteLabel, gbcCentral);
        
        // SECÇÃO DO CARRO
        carroLabel = new JLabel("DADOS DO VEÍCULO");
        carroLabel.setFont(arial16);
        carroLabel.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(15, 0, 12, 0);
        centralPanel.add(carroLabel, gbcCentral);
        
        // DADOS DO CARRO
        codigoCarroLabel = new JLabel("Código: " + Carro.contCarros);
        codigoCarroLabel.setFont(arial13);
        codigoCarroLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 5, 0);
        centralPanel.add(codigoCarroLabel, gbcCentral);
        
        marcaCarroLabel = new JLabel("Marca/Modelo: " + marca+ " " +modelo);
        marcaCarroLabel.setFont(arial13);
        marcaCarroLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(marcaCarroLabel, gbcCentral);
        
        cilindradaCarroLabel = new JLabel("Cilindrada: " + cilin + " CC");
        cilindradaCarroLabel.setFont(arial13);
        cilindradaCarroLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(cilindradaCarroLabel, gbcCentral);
        
        estadoLabel = new JLabel("Estado: " + estado);
        estadoLabel.setFont(arial13);
        estadoLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(estadoLabel, gbcCentral);
        
        dataCompraLabel = new JLabel("Data da Compra: " + dataCompra);
        dataCompraLabel.setFont(arial13);
        dataCompraLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 15, 0);
        centralPanel.add(dataCompraLabel, gbcCentral);
        
        // SEPARADOR
        separadorLabel2 = new JLabel("===========================================================");
        separadorLabel2.setFont(arial12);
        separadorLabel2.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(10, 0, 15, 0);
        centralPanel.add(separadorLabel2, gbcCentral);
        
        // SECÇÃO DE VALORES
        precoLabel = new JLabel("VALORES E TAXAS");
        precoLabel.setFont(arial16);
        precoLabel.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(10, 0, 12, 0);
        centralPanel.add(precoLabel, gbcCentral);
        
        // VALORES DETALHADOS
        precoBaseLabel = new JLabel("Preço Base: " + mt.format(preco));
        precoBaseLabel.setFont(arial13);
        precoBaseLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(5, 20, 5, 0);
        centralPanel.add(precoBaseLabel, gbcCentral);
        
        direitosAduaneirosLabel = new JLabel("Direitos Aduaneiros: " + mt.format(direitosAduaneiros));
        direitosAduaneirosLabel.setFont(arial13);
        direitosAduaneirosLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(direitosAduaneirosLabel, gbcCentral);
        
        impostoConsumoLabel = new JLabel("Imposto sobre Consumo: " + mt.format(impostoConsumo));
        impostoConsumoLabel.setFont(arial13);
        impostoConsumoLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(impostoConsumoLabel, gbcCentral);
        
        ivaLabel = new JLabel("IVA: " + mt.format(iva));
        ivaLabel.setFont(arial13);
        ivaLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(ivaLabel, gbcCentral);
        
        taxasFixasLabel = new JLabel("Taxas Fixas (Despachante + Inspeção): " + mt.format(taxasFixas));
        taxasFixasLabel.setFont(arial13);
        taxasFixasLabel.setForeground(grey1);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        centralPanel.add(taxasFixasLabel, gbcCentral);
        
        // DESCONTO (SE APLICAVEL)
        if (desconto > 0) {
            descontoLabel = new JLabel("Desconto Aplicado: -" + mt.format(desconto));
            descontoLabel.setFont(arial13);
            descontoLabel.setForeground(new Color(220, 20, 60));
            gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
            centralPanel.add(descontoLabel, gbcCentral);
        }
        
        // SEPARADOR ANTES DO TOTAL
        separadorLabel3 = new JLabel("===========================================================");
        separadorLabel3.setFont(arial12);
        separadorLabel3.setForeground(grey);
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(15, 0, 10, 0);
        centralPanel.add(separadorLabel3, gbcCentral);
        
        // PREFO FINAL DESTACADO
        precoFinalLabel = new JLabel("TOTAL A PAGAR: " + mt.format(precoFinal));
        precoFinalLabel.setFont(arial18);
        precoFinalLabel.setForeground(laranjaBase);
        precoFinalLabel.setOpaque(true);
        precoFinalLabel.setBackground(new Color(255, 245, 235));
        precoFinalLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 120, 0), 2),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        gbcCentral.gridx = 0; gbcCentral.gridy = linha++;
        gbcCentral.insets = new Insets(15, 0, 20, 0);
        centralPanel.add(precoFinalLabel, gbcCentral);
        
        reciboPanel.add(centralPanel, BorderLayout.CENTER);
        
        // PAINEL DO RODAPE
        footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        
        // OBSERVACOES PRINCIPAIS
        observacoesLabel = new JLabel("Obrigado pela sua preferência!");
        observacoesLabel.setFont(arial14);
        observacoesLabel.setForeground(grey);
        observacoesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        observacoesLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        footerPanel.add(observacoesLabel);
        
        // INTRUCCOES PARA O USUARIO
        rodapeLabel = new JLabel("Clique com o botão direito para salvar este recibo em PDF");
        rodapeLabel.setFont(arial12i);
        rodapeLabel.setForeground(grey);
        rodapeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        footerPanel.add(rodapeLabel);
        
        reciboPanel.add(footerPanel, BorderLayout.SOUTH);
        
        // ADICIONAR RECIBO AO CONTAINER PRINCIPAL
        JScrollPane scrollPane = new JScrollPane(reciboPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        scrollPane.setBackground(new Color(245, 245, 245));
        cont.add(scrollPane, BorderLayout.CENTER);
        
        // PAINEL DE BOTÕES
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        
        btnFechar = new JButton("Fechar", canP);
        btnFechar.setRolloverIcon(canL);
        btnFechar.setFont(fonteButton);
        btnFechar.setForeground(Color.WHITE);
        btnFechar.setBackground(laranjaBase);
        btnFechar.setFocusPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnFechar.setOpaque(true);
        btnFechar.setPreferredSize(new Dimension(140, 40));
        
       	btnRemover = new JButton(botao, delP);
   	    btnRemover.setRolloverIcon(delL);
        btnRemover.setFont(fonteButton);
        btnRemover.setForeground(Color.WHITE);
        btnRemover.setBackground(laranjaBase);
        btnRemover.setFocusPainted(false);
        btnRemover.setContentAreaFilled(false);
        btnRemover.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnRemover.setOpaque(true);
        btnRemover.setPreferredSize(new Dimension(140, 40));
        
        btnRemover.addActionListener
        (
        	new ActionListener() 
        	{
				public void actionPerformed(ActionEvent e)
				{
					// Criar a janela de confirmação
	                TelaConfirmacao telaConfirmacao = new TelaConfirmacao(
	                    "Remover Cliente",
	                    "Deseja realmente remover esse cliente?",
	                    "Essa operação não ser desfeita!"
	                );
	                
	                // Adicionar listener aos botões para saber quando foi clicado
	                telaConfirmacao.btnConfirmar.addActionListener(new ActionListener() 
	                { 
	                    public void actionPerformed(ActionEvent evt) 
	                    {
	                    	telaConfirmacao.dispose();
	                    	rem.removerCliente(lista, i);
	                        dispose(); 
	                    }
	                });
				}
			}
        );
        
        btnFechar.addActionListener
        (
        	new ActionListener() 
        	{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			}
        );
        
        //EFEITO AO PASSAR O MOUSE
	    btnRemover.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            btnRemover.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            btnRemover.setBackground(laranjaBase);
	        }
	    });
	    
	    btnFechar.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            btnFechar.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            btnFechar.setBackground(laranjaBase);
	        }
	    });
        
        buttonPanel.add(btnFechar);
        buttonPanel.add(btnRemover);
        cont.add(buttonPanel, BorderLayout.SOUTH);
        
        // MENU POPUP
        popupMenu = new JPopupMenu();
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        menuSalvarComo = new JMenuItem("Salvar");
        menuSalvarComo.setFont(arial12);
        
        popupMenu.add(menuSalvarComo);
        
        // ADICIONAR POPUP AO PAINEL DO RECIBO
        reciboPanel.setComponentPopupMenu(popupMenu);
        
        // EVENTOS 
        
        // Evento do menu salvar como
        menuSalvarComo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	salvarPDFComo(contacto, nome, tipoEspecifico, dataCompra, estado, marca, modelo, codigo, cilin, preco); 
            }
        });
        
        // Evento do botão fechar
        btnFechar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });
        
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(650, 700));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    private void calcularValores(ArrayList lista) 
    {
    	int i = lista.size() - 1;
    	Cliente cliente = (Cliente) lista.get(i);
    	
        // CALCULAR DIREITOS ADUANEIROS
        direitosAduaneiros = cliente.calcDireitosAduaneiros();
        
        // CALCULAR IMPOSTO SOBRE CONSUMO
        impostoConsumo = cliente.calcImposto();
        
        // CALCULAR IVA
        iva = cliente.calcIva();
        
        // CALCULAR TAXAS FIXAS 
        if (cliente instanceof Particular) 
        {
            taxasFixas = ((Particular) cliente).calcTaxasFixas();
        } else if (cliente instanceof Empresarial) 
        {
            taxasFixas = ((Empresarial) cliente).calcTaxasFixas();
        } else 
        {
            taxasFixas = 0;
        }
        
        // CALCULAR DESCONTO USANDO O METODO CORRECTO DE CADA CLASSE
        if (cliente instanceof Doutorado) 
            desconto = ((Doutorado) cliente).calcDesconto();
        else if (cliente instanceof Normal) 
            desconto = ((Normal) cliente).calcDesconto();
        else if (cliente instanceof Revendedor) 
            desconto = ((Revendedor) cliente).calcDesconto();
        else if (cliente instanceof Estado) 
            desconto = ((Estado) cliente).calcDesconto();
        else 
            desconto = 0; // Para outros tipos de cliente
        
        // CALCULAR PRECO FINAL USANDO O METODO DA CLASSE
        precoFinal = cliente.calcCustoFinal();
    }
    
    private void salvarPDFComo(long contacto, String nome, String tipoEspecifico, String dataCompra, String estado, String marca, String modelo, int codigo, int cilin, float preco)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Recibo Como PDF");
        fileChooser.setSelectedFile(new File("BeForwardRecibo_" + Cliente.contGeralRecibo + ".pdf"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() 
        {
            public boolean accept(File f) 
            {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".pdf");
            }
            public String getDescription() 
            {
                return "Arquivos PDF (*.pdf)";
            }
        });
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) 
        {
            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getAbsolutePath();
            
            // Garantir que o arquivo tenha extensão .pdf
            if (!fileName.toLowerCase().endsWith(".pdf")) 
                fileName += ".pdf";
            
            salvarPDF(fileName, contacto, nome, tipoEspecifico, dataCompra, estado, marca, modelo, codigo, cilin, preco);
        }
    }

    private void salvarPDF(String nomeArquivo, long contacto, String nome, String tipoEspecifico, String dataCompra, String estado, String marca, String modelo, int codigo, int cilin, float preco)
    {
        try 
        {
            // Criar documento PDF com margens específicas
            Document documento = new Document(PageSize.A4, 40, 40, 50, 50);
            
            // Criar o escritor PDF
            PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
            
            // Abrir o documento
            documento.open();
            
            // Definir fontes exatamente como na tela
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.BLACK);
            Font numeroReciboFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, new BaseColor(100, 100, 100));
            Font secaoFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
            Font textoFont = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, new BaseColor(120, 117, 113));
            Font separadorFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
            Font totalFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(255, 106, 0));
            Font rodapeFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
            Font instrucaoFont = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.BLACK);
            
            // === CABEÇALHO ===
            // Título principal
            Paragraph titulo = new Paragraph("RECIBO DE COMPRA", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(5);
            documento.add(titulo);
            
            // Número do recibo
            Paragraph numeroRec = new Paragraph("Recibo Nº: " + Cliente.contGeralRecibo, numeroReciboFont);
            numeroRec.setAlignment(Element.ALIGN_CENTER);
            numeroRec.setSpacingAfter(15);
            documento.add(numeroRec);
            
            // Separador 1
            Paragraph sep1 = new Paragraph("===========================================================", separadorFont);
            sep1.setAlignment(Element.ALIGN_CENTER);
            sep1.setSpacingAfter(10);
            documento.add(sep1);
            
            // === DADOS DO CLIENTE ===
            Paragraph clienteTitulo = new Paragraph("DADOS DO CLIENTE", secaoFont);
            clienteTitulo.setAlignment(Element.ALIGN_CENTER);
            clienteTitulo.setSpacingAfter(12);
            documento.add(clienteTitulo);
            
            // Dados do cliente com indentação
            Paragraph nomeCliente = new Paragraph("Nome: " + nome, textoFont);
            nomeCliente.setIndentationLeft(20);
            nomeCliente.setSpacingAfter(5);
            documento.add(nomeCliente);
            
            Paragraph contatoCliente = new Paragraph("Contato: " + contacto, textoFont);
            contatoCliente.setIndentationLeft(20);
            contatoCliente.setSpacingAfter(5);
            documento.add(contatoCliente);
            
            Paragraph tipoCliente = new Paragraph("Tipo: " + tipo + " - " + tipoEspecifico, textoFont);
            tipoCliente.setIndentationLeft(20);
            tipoCliente.setSpacingAfter(15);
            documento.add(tipoCliente);
            
            // === DADOS DO VEÍCULO ===
            Paragraph carroTitulo = new Paragraph("DADOS DO VEÍCULO", secaoFont);
            carroTitulo.setAlignment(Element.ALIGN_CENTER);
            carroTitulo.setSpacingAfter(12);
            documento.add(carroTitulo);
            
            // Dados do veículo com indentação
            Paragraph codigoCarro = new Paragraph("Código: " + codigo, textoFont);
            codigoCarro.setIndentationLeft(20);
            codigoCarro.setSpacingAfter(5);
            documento.add(codigoCarro);
            
            Paragraph marcaCarro = new Paragraph("Marca/Modelo: " + marca + " " + modelo, textoFont);
            marcaCarro.setIndentationLeft(20);
            marcaCarro.setSpacingAfter(5);
            documento.add(marcaCarro);
            
            Paragraph cilindradaCarro = new Paragraph("Cilindrada: " + cilin + " CC", textoFont);
            cilindradaCarro.setIndentationLeft(20);
            cilindradaCarro.setSpacingAfter(5);
            documento.add(cilindradaCarro);
            
            Paragraph estadoCarro = new Paragraph("Estado: " + estado, textoFont);
            estadoCarro.setIndentationLeft(20);
            estadoCarro.setSpacingAfter(5);
            documento.add(estadoCarro);
            
            Paragraph dataCompraDoc = new Paragraph("Data da Compra: " + dataCompra, textoFont);
            dataCompraDoc.setIndentationLeft(20);
            dataCompraDoc.setSpacingAfter(15);
            documento.add(dataCompraDoc);
            
            // Separador 2
            Paragraph sep2 = new Paragraph("===========================================================", separadorFont);
            sep2.setAlignment(Element.ALIGN_CENTER);
            sep2.setSpacingBefore(10);
            sep2.setSpacingAfter(5);
            documento.add(sep2);
            
            // === VALORES E TAXAS ===
            Paragraph valoresTitulo = new Paragraph("VALORES E TAXAS", secaoFont);
            valoresTitulo.setAlignment(Element.ALIGN_CENTER);
            valoresTitulo.setSpacingAfter(12);
            documento.add(valoresTitulo);
            
            // Valores detalhados com indentação
            Paragraph precoBase = new Paragraph("Preço Base: " + mt.format(preco), textoFont);
            precoBase.setIndentationLeft(20);
            precoBase.setSpacingAfter(5);
            documento.add(precoBase);
            
            Paragraph direitosAduaneirosDoc = new Paragraph("Direitos Aduaneiros: " + mt.format(direitosAduaneiros), textoFont);
            direitosAduaneirosDoc.setIndentationLeft(20);
            direitosAduaneirosDoc.setSpacingAfter(5);
            documento.add(direitosAduaneirosDoc);
            
            Paragraph impostoConsumoDoc = new Paragraph("Imposto sobre Consumo: " + mt.format(impostoConsumo), textoFont);
            impostoConsumoDoc.setIndentationLeft(20);
            impostoConsumoDoc.setSpacingAfter(5);
            documento.add(impostoConsumoDoc);
            
            Paragraph ivaDoc = new Paragraph("IVA: " + mt.format(iva), textoFont);
            ivaDoc.setIndentationLeft(20);
            ivaDoc.setSpacingAfter(5);
            documento.add(ivaDoc);
            
            Paragraph taxasFixasDoc = new Paragraph("Taxas Fixas (Despachante + Inspeção): " + mt.format(taxasFixas), textoFont);
            taxasFixasDoc.setIndentationLeft(20);
            taxasFixasDoc.setSpacingAfter(5);
            documento.add(taxasFixasDoc);
            
            // Desconto se aplicável
            if (desconto > 0) 
            {
                Font descontoFont = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, new BaseColor(220, 20, 60));
                Paragraph descontoDoc = new Paragraph("Desconto Aplicado: -" + mt.format(desconto), descontoFont);
                descontoDoc.setIndentationLeft(20);
                descontoDoc.setSpacingAfter(5);
                documento.add(descontoDoc);
            }
            
            // Separador 3
            Paragraph sep3 = new Paragraph("===========================================================", separadorFont);
            sep3.setAlignment(Element.ALIGN_CENTER);
            sep3.setSpacingBefore(10);
            sep3.setSpacingAfter(5);
            documento.add(sep3);
            
            // === TOTAL DESTACADO ===
            Paragraph totalPagar = new Paragraph("TOTAL A PAGAR: " + mt.format(precoFinal), totalFont);
            totalPagar.setAlignment(Element.ALIGN_CENTER);
            totalPagar.setSpacingBefore(5);
            totalPagar.setSpacingAfter(5);
            documento.add(totalPagar);
            
            // === RODAPÉ ===
            Paragraph observacoes = new Paragraph("Obrigado pela sua preferência!", rodapeFont);
            observacoes.setAlignment(Element.ALIGN_CENTER);
            observacoes.setSpacingBefore(5);
            documento.add(observacoes);
            
            Paragraph instrucoes = new Paragraph("Clique com o botão direito para salvar este recibo em PDF", instrucaoFont);
            instrucoes.setAlignment(Element.ALIGN_CENTER);
            documento.add(instrucoes);
            
            // Fechar documento
            documento.close();
            
            // Mostrar mensagem de sucesso
            new TelaMsg("Salvar PDF", "PDF salvo com sucesso!\nArquivo: " + Cliente.contGeralRecibo, "Verifique a sua pasta de documentos");
                
        } catch (Exception ex) 
        {
            // Mostrar mensagem de erro
            new TelaMsg("Salvar PDF", "Erro ao salvar PDF: " + ex.getMessage(), "Por favor, Contacte o Suporte do Sistema");
            ex.printStackTrace();
        }
    }
}