package view;

import javax.swing.*;

import model.Cliente;
import util.Alteracoes;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaAlterar extends JFrame
{
	private Container cont;
	private JLabel logoLabel, mainLabel, nomeLabel, ecALabel, ecNLabel, nomeCliente, ecCliente, erroLabel;
	private JRadioButton eC, eP, eT;
	private ButtonGroup bg;
	private JPanel radioPanel, buttonPanel, painelTopo;
	private JButton alte, sair;
	private ImageIcon logo, altL, altP, canL, canP;
	private GridBagConstraints gbc;
	private Alteracoes alt;
	
	public TelaAlterar(ArrayList<Cliente> array, int ind)
	{
		super("Alterar Estado de Compra");
		cont = getContentPane();
		cont.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		alt = new Alteracoes();
		
		Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color red = new Color(255, 36 , 0);
    	
        cont.setBackground(corPrincipal);
    	
    	logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
    	altL = new ImageIcon("./resources/images/alterarL.png");
    	altP = new ImageIcon("./resources/images/alterarP.png");
    	canL = new ImageIcon("./resources/images/closeL.png");
    	canP = new ImageIcon("./resources/images/close.png");
    	
    	Font titulo = new Font("Segoe UI", Font.BOLD, 40);
    	Font fonte = new Font("SansSerif", Font.BOLD, 18);
    	Font fontePlain = new Font("SansSerif", Font.PLAIN, 18);
    	Font fonteErro = new Font("SansSerif", Font.BOLD, 13);
    	Font fonteButton = new Font("SansSerif", Font.BOLD, 16);
    	
    	//PAINEL TOPO QUE CONTEM O LOGO E O TITULO
    	painelTopo = new JPanel();
    	painelTopo.setLayout(new BorderLayout());
    	painelTopo.setBackground(corPrincipal);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.gridwidth = 2;
    	gbc.anchor = GridBagConstraints.NORTHWEST;
      	gbc.fill = GridBagConstraints.NONE;      
      	gbc.insets = new Insets(10, 20, 60, 20);
    	
    	//LOGO
    	logoLabel = new JLabel(logo);
    	
    	//TITULO
    	mainLabel = new JLabel("        Alterar Estado de Compra     ");
    	mainLabel.setFont(titulo);
    	mainLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
		
		
		// LABEL - NOME
		nomeLabel = new JLabel("Nome do Cliente: ");
		nomeLabel.setFont(fonte);
		nomeLabel.setForeground(Color.WHITE);
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(15, 190, 5, 10);
        cont.add(nomeLabel, gbc);
		
		// NOME DO CLIENTE
        nomeCliente = new JLabel(array.get(ind).getNome()); 
        nomeCliente.setFont(fontePlain);
        nomeCliente.setForeground(Color.WHITE);
        nomeCliente.setPreferredSize(new Dimension(300, 25));
        gbc.gridx = 1; gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(15, 60, 5, 5);
        cont.add(nomeCliente, gbc);
		
		// LABEL - ESTADO DA COMPRA ATUAL
		ecALabel = new JLabel("Estado de Compra Atual: ");
		ecALabel.setFont(fonte);
		ecALabel.setForeground(Color.WHITE);
		gbc.gridx = 0; gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(15, 190, 5, 10);
        cont.add(ecALabel, gbc);
		
		// ESTADO DA COMPRA ATUAL
        ecCliente = new JLabel(array.get(ind).getEstadoCompra());
        ecCliente.setFont(fontePlain);
        ecCliente.setForeground(Color.WHITE);
        ecCliente.setPreferredSize(new Dimension(300, 25));
        gbc.gridx = 1; gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(15, 60, 5, 5);
        cont.add(ecCliente, gbc);
		
		// LABEL - NOVO ESTADO DA COMPRA
		ecNLabel = new JLabel("Novo Estado de Compra: ");
		ecNLabel.setFont(fonte);
		ecNLabel.setForeground(Color.WHITE);
		gbc.gridx = 0; gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(15, 190, 5, 10);
        cont.add(ecNLabel, gbc);
        
		// RADIO BUTTONS
		eC = new JRadioButton("Entrega Concluída", false);
		eC.setFont(fontePlain);
		eC.setForeground(Color.WHITE);
		eC.setBackground(corPrincipal);
		
		eP = new JRadioButton("Em Processamento", false);
		eP.setFont(fontePlain);
		eP.setForeground(Color.WHITE);
		eP.setBackground(corPrincipal);
		
		eT = new JRadioButton("Em Trânsito", false);
		eT.setFont(fontePlain);
		eT.setForeground(Color.WHITE);
		eT.setBackground(corPrincipal);
		
		// GRUPO DOS RADIO BUTTONS
		bg = new ButtonGroup();
		bg.add(eC); 
		bg.add(eP); 
		bg.add(eT);
		
		// PAINEL PARA OS RADIO BUTTONS
		radioPanel = new JPanel(new GridLayout(3, 1, 0, 10));
		radioPanel.setBackground(corPrincipal);
		radioPanel.add(eP);
		radioPanel.add(eT);
		radioPanel.add(eC);
		
		// LÓGICA PARA HABILITAÇÃO DOS RADIO BUTTONS
		String estadoAtual = array.get(ind).getEstadoCompra();
		if(estadoAtual.equalsIgnoreCase("Entrega Concluida"))
		{
			eC.setEnabled(false);
			eP.setEnabled(true);
			eT.setEnabled(true);
		}
		else if(estadoAtual.equalsIgnoreCase("Em Transito"))
		{
			eC.setEnabled(true);
			eP.setEnabled(true);
			eT.setEnabled(false);
		}
		else if(estadoAtual.equalsIgnoreCase("Em Processamento"))
		{
			eC.setEnabled(true);
			eP.setEnabled(false);
			eT.setEnabled(true);
		}
		
		gbc.gridx = 1; gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(15, 60, 5, 5);
        cont.add(radioPanel, gbc);
        
        // LABEL - ERRO PARA VALIDAÇÃO
        erroLabel = new JLabel(" ");
        erroLabel.setFont(fonteErro);
        erroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 15, 20);
        cont.add(erroLabel, gbc);
        
        // BOTÕES
        sair = new JButton("Cancelar", canP);
        sair.setRolloverIcon(canL);
        sair.setFont(fonteButton);
        sair.setForeground(Color.WHITE);
        sair.setBackground(laranjaBase);
        sair.setFocusPainted(false);
        sair.setContentAreaFilled(false);
        sair.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        sair.setOpaque(true);
        sair.setPreferredSize(new Dimension(140, 40));
        
        alte = new JButton("Alterar", altP);
        alte.setRolloverIcon(altL);
        alte.setFont(fonteButton);
        alte.setForeground(Color.WHITE);
        alte.setBackground(laranjaBase);
        alte.setFocusPainted(false);
        alte.setContentAreaFilled(false);
        alte.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        alte.setOpaque(true);
        alte.setPreferredSize(new Dimension(140, 40));
        
        // ACTION LISTENER PARA BOTÃO SAIR
        sair.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e)
        	{
        		existemDados();
        	}
		});
        
        // ACTION LISTENER PARA BOTÃO ALTERAR COM VALIDAÇÃO
        alte.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e)
        	{
        		processarAlteracao(array, ind);
        	}
		});
        
        //EFEITO AO PASSAR O MOUSE
	    sair.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            sair.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            sair.setBackground(laranjaBase);
	        }
	    });
	    
	    alte.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            alte.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            alte.setBackground(laranjaBase);
	        }
	    });
        
        // PAINEL PARA OS BOTÕES
        buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(corPrincipal);
        buttonPanel.add(sair); 
        buttonPanel.add(alte);
        
        gbc.gridx = 0; gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(20, 20, 20, 20);
        cont.add(buttonPanel, gbc);
        
        setResizable(false);
    	setSize(900, 650); 
    	setVisible(true);
    	setLocationRelativeTo(null);
    	
    	addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e) 
            {
            	existemDados();
            }
        });
	}
	
	private boolean existemDados()
    {
    	// Verificar se há dados digitados
        boolean temDados = !eC.getText().trim().isEmpty() || 
                          !eT.getText().trim().isEmpty() ||
                          !eP.getText().trim().isEmpty();
        
        if(temDados)
        {
        	TelaConfirmacao telaConfirmacao = new TelaConfirmacao(
                    "Cancelar Operação",
                    "Deseja cancelar esta operação?",
                    "Dados não salvos serão perdidos!"
                );
        	
        	telaConfirmacao.btnConfirmar.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                	 telaConfirmacao.dispose();
                    // Usuário confirmou
                	TelaMsg telaMensagem = new TelaMsg("Cancelamento da operação", "Operação Cancelada!", " ");
                	 telaMensagem.addWindowListener(new WindowAdapter() 
                     {
                         public void windowClosed(WindowEvent e) 
                         {
                             dispose(); 
                         }
                     });
                    dispose(); // Fechar a janela principal
                }
            });
        	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }else
        	dispose();
        return temDados;
    }
	
	// MÉTODO PARA PROCESSAR A ALTERAÇÃO COM VALIDAÇÃO
	private void processarAlteracao(ArrayList<Cliente> array, int ind)
	{
		String novoEstado = "";
		boolean valido = true;
		
		// Limpar erro anterior
		erroLabel.setText(" ");
		
		// Validar se algum radio button foi selecionado
		if(eC.isSelected())
			novoEstado = "Entrega Concluida";
		else if(eP.isSelected())
			novoEstado = "Em Processamento";
		else if(eT.isSelected())
			novoEstado = "Em Transito";
		else
		{
			erroLabel.setText("* Selecione um novo estado de compra");
			valido = false;
		}
		
		// Se válido, fazer a alteração
		if(valido)
		{
			// Verificar se o estado selecionado é diferente do atual
			String estadoAtual = array.get(ind).getEstadoCompra();
			if(novoEstado.equalsIgnoreCase(estadoAtual))
			{
				erroLabel.setText("* Selecione um estado diferente do atual");
			}
			else
			{
				alt.alterarEstadoCompra(array, ind, novoEstado);
				dispose();
			}
		}
	}
}