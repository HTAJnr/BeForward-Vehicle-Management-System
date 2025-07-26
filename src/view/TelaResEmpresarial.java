package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaResEmpresarial extends JFrame
{
    private JLabel logoLabel, mainLabel, quantidadeLabel, tipoEmpresarialLabel, nomeIntituicaoLabel, manutencaoLabel, nomeComercialLabel, quantidadeErroLabel, tipoEmpresarialErroLabel, nomeIntituicaoErroLabel, estrangeiroErroLabel, nomeComercialErroLabel;
    private JRadioButton radioEstado, radioRevendedor, radioSim, radioNao;
    private JComboBox quantidadeCombo;
    private JTextField nomeIntituicaoField, nomeComercialField;
    private JButton btnVoltar, btnCancelar, btnContinuar;
    private JPanel radioPanel1, radioPanel2, buttonPanel, painelTopo;
    private ButtonGroup tipoEmpresarialGroup, manutencaoGroup;
    private ImageIcon logo, volL, volP, contL, contP, canL, canP;
    private Container cont;
    private GridBagConstraints gbc;
    private String[] quantidadeArray;
    
    public TelaResEmpresarial(ArrayList lista, String nome, long contato, String tipo, int quantidade, String tipoEmpresarial, String nomeInstituicao, String manutencao, String nomeComercial, boolean voltou)
    {
        super("Tela Registro");
        
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color red = new Color(255, 36 , 0);
    	
    	cont.setBackground(corPrincipal);
    	
    	logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
    	volL = new ImageIcon("./resources/images/voltarL.png");
    	volP = new ImageIcon("./resources/images/voltarP.png");
    	contL = new ImageIcon("./resources/images/contL.png");
    	contP = new ImageIcon("./resources/images/contP.png");
    	canL = new ImageIcon("./resources/images/closeL.png");
    	canP = new ImageIcon("./resources/images/close.png");
    	
    	Font titulo = new Font("Segoe UI", Font.BOLD, 38);      
    	Font fonte = new Font("SansSerif", Font.BOLD, 18);
    	Font fontePlain = new Font("SansSerif", Font.PLAIN, 18);
    	Font fonteCB = new Font("SansSerif", Font.PLAIN, 16);
    	Font fonteErro = new Font("SansSerif", Font.BOLD, 14);
    	Font fonteButton = new Font("SansSerif", Font.BOLD, 16);
    	
    	//PAINEL TOPO QUE CONTEM O LOGO E O TITULO
    	painelTopo = new JPanel();
    	painelTopo.setLayout(new BorderLayout());
    	painelTopo.setBackground(corPrincipal);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.gridwidth = 2;
    	gbc.anchor = GridBagConstraints.NORTHWEST;
    	gbc.fill = GridBagConstraints.HORIZONTAL; 
    	gbc.insets = new Insets(20, 20, 60, 20);   

    	//LOGO
    	logoLabel = new JLabel(logo);
        
        // TITULO
        mainLabel = new JLabel("    Registro de Cliente Empresarial     ");
        mainLabel.setFont(titulo);
        mainLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
        // QUANTIDADE DE CARROS
        quantidadeLabel = new JLabel("Quantidade de Carros:");
        quantidadeLabel.setFont(fonte);
        quantidadeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 90, 5, 10);
        cont.add(quantidadeLabel, gbc);
        
        //ARRAY DE QUANTIDADE PARA O COMBOBOX
        quantidadeArray = new String[1001];
        quantidadeArray[0] = "Nr Carros";
        for(int i = 1; i <= 1000; i++) 
        	quantidadeArray[i] = String.valueOf(i);
        
        //COMBOBOX QUANTIDADE
        quantidadeCombo = new JComboBox(quantidadeArray);
        quantidadeCombo.setFont(fonteCB);
        quantidadeCombo.setPreferredSize(new Dimension(380, 35));
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 80);
        cont.add(quantidadeCombo, gbc);
        
        //LABEL DE ERRO PARA QUANTIDADE
        quantidadeErroLabel = new JLabel(" ");
        quantidadeErroLabel.setFont(fonteErro);
        quantidadeErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 130, 10, 20);
        cont.add(quantidadeErroLabel, gbc);
        
        //LABEL - TIPO DE EMPRESARIAL
        tipoEmpresarialLabel = new JLabel("Tipo de Empresarial:");
        tipoEmpresarialLabel.setFont(fonte);
        tipoEmpresarialLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 90, 5, 10);
        cont.add(tipoEmpresarialLabel, gbc);
        
        //RADIO BUTTON E PAINEL PARA TIPOS DE EMPRESARIAL
        radioPanel1 = new JPanel(new GridLayout(1, 2, 10, 0));
        tipoEmpresarialGroup = new ButtonGroup();
        radioPanel1.setBackground(corPrincipal);
        
        radioEstado = new JRadioButton("Estado", false);
        radioEstado.setFont(fontePlain);
        radioEstado.setForeground(Color.WHITE);
        radioEstado.setBackground(corPrincipal);
        radioRevendedor = new JRadioButton("Revendedor", false);
        radioRevendedor.setFont(fontePlain);
        radioRevendedor.setForeground(Color.WHITE);
        radioRevendedor.setBackground(corPrincipal);
        
        tipoEmpresarialGroup.add(radioEstado);
        tipoEmpresarialGroup.add(radioRevendedor);
        
        radioPanel1.add(radioEstado);
        radioPanel1.add(radioRevendedor);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 90, 5, 10);
        cont.add(radioPanel1, gbc);
        
        //LABEL DE ERRO PARA TIPOS DE EMPRESARIAL
        tipoEmpresarialErroLabel = new JLabel(" ");
        tipoEmpresarialErroLabel.setFont(fonteErro);
        tipoEmpresarialErroLabel.setForeground(red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.insets = new Insets(0, 130, 10, 20);
        cont.add(tipoEmpresarialErroLabel, gbc);
        
        //LABEL - NOME INSTITUICAO
        nomeIntituicaoLabel = new JLabel("Nome da Intituição:");
        nomeIntituicaoLabel.setFont(fonte);
        nomeIntituicaoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 90, 5, 10);
        cont.add(nomeIntituicaoLabel, gbc);
        
        //TEXT FIELD - NOME INSTITUICAO
        nomeIntituicaoField = new JTextField(27);
        nomeIntituicaoField.setFont(fontePlain);
        nomeIntituicaoField.setPreferredSize(new Dimension(300, 35));
        nomeIntituicaoField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        nomeIntituicaoField.setEnabled(false);
        
        // (Placeholder) para Nome Intituição
        nomeIntituicaoField.setText("   Digite o nome da instituição");
        nomeIntituicaoField.setForeground(Color.GRAY);
        
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 10, 5, 80);
        cont.add(nomeIntituicaoField, gbc);
        
        //LABEL - ERRO PARA NOME INSTITUICAO
        nomeIntituicaoErroLabel = new JLabel(" ");
        nomeIntituicaoErroLabel.setFont(fonteErro);
        nomeIntituicaoErroLabel.setForeground(red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.insets = new Insets(0, 130, 10, 20);
        cont.add(nomeIntituicaoErroLabel, gbc);
        
        // LABEL - ESTEVE NO ESTRANGEIRO
        manutencaoLabel = new JLabel("Inclui Manutenção?");
        manutencaoLabel.setFont(fonte);
        manutencaoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 90, 5, 10);
        cont.add(manutencaoLabel, gbc);
        
        //RADIO BUTTON E PAINEL PARA ESTEVE NO ESTRANGEIRO
        radioPanel2 = new JPanel(new GridLayout(1, 2, 75, 0));
        manutencaoGroup = new ButtonGroup();
        radioPanel2.setBackground(corPrincipal);
        
        radioSim = new JRadioButton("Sim", false);
        radioSim.setFont(fontePlain);
        radioSim.setForeground(Color.WHITE);
        radioSim.setBackground(corPrincipal);
        
        radioNao = new JRadioButton("Não", false);
        radioNao.setFont(fontePlain);
        radioNao.setForeground(Color.WHITE);
        radioNao.setBackground(corPrincipal);
        
        radioSim.setEnabled(false);
        radioNao.setEnabled(false);
        
        manutencaoGroup.add(radioSim);
        manutencaoGroup.add(radioNao);
        
        radioPanel2.add(radioSim);
        radioPanel2.add(radioNao);
        
        gbc.gridx = 1; gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 90, 5, 80);
        cont.add(radioPanel2, gbc);
        
        //LABEL - ERRO PARA ESTEVE NO ESTRANGEIRO
        estrangeiroErroLabel = new JLabel(" ");
        estrangeiroErroLabel.setFont(fonteErro);
        estrangeiroErroLabel.setForeground(red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 8;
        gbc.insets = new Insets(0, 130, 10, 20);
        cont.add(estrangeiroErroLabel, gbc);
        
        //LABEL - NOME COMERCIAL
        nomeComercialLabel = new JLabel("Nome Comercial:");
        nomeComercialLabel.setFont(fonte);
        nomeComercialLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 90, 5, 10);
        cont.add(nomeComercialLabel, gbc);
        
        //TEXT FIELD - NOME COMERCIAL
        nomeComercialField = new JTextField(27);
        nomeComercialField.setFont(fontePlain);
        nomeComercialField.setPreferredSize(new Dimension(300, 35));
        nomeComercialField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Placeholder para Nome Comercial
        nomeComercialField.setText("   Digite o nome comercial");
        nomeComercialField.setForeground(Color.GRAY);
        nomeComercialField.setEnabled(false);
        
        gbc.gridx = 1; gbc.gridy = 9;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 10, 5, 80);
        cont.add(nomeComercialField, gbc);
        
        //LABEL - ERRO PARA NOME COMERCIAL
        nomeComercialErroLabel = new JLabel(" ");
        nomeComercialErroLabel.setFont(fonteErro);
        nomeComercialErroLabel.setForeground(red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 10;
        gbc.insets = new Insets(0, 130, 15, 20);
        cont.add(nomeComercialErroLabel, gbc);
        
        //BOTOES
        buttonPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        buttonPanel.setBackground(corPrincipal); 
        
        btnVoltar = new JButton("Voltar", volP);
        btnVoltar.setRolloverIcon(volL);
        btnVoltar.setFont(fonteButton);
        btnVoltar.setBackground(laranjaBase);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnVoltar.setOpaque(true);
        btnVoltar.setPreferredSize(new Dimension(150, 40));

        btnCancelar = new JButton("Cancelar", canP);
        btnCancelar.setRolloverIcon(canL);
        btnCancelar.setFont(fonteButton);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(laranjaBase);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnCancelar.setOpaque(true);
        btnCancelar.setPreferredSize(new Dimension(140, 40));
        
        btnContinuar = new JButton("Continuar", contP);
        btnContinuar.setRolloverIcon(contL);
        btnContinuar.setFont(fonteButton);
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setBackground(laranjaBase);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setContentAreaFilled(false);
        btnContinuar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnContinuar.setOpaque(true);
        btnContinuar.setPreferredSize(new Dimension(140, 40));
        
        limparCampos();
        voltamOsDados(voltou, quantidade, tipoEmpresarial, nomeInstituicao, manutencao, nomeComercial);
        
        btnVoltar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                new TelaRegistrar(lista, nome, tipo, contato, true);
                dispose();
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	existemDados();
            }
        });
        
       btnContinuar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                processarDados(lista, nome, contato, tipo);
            }
        });
        
        // Troquei para FocusListener porque MouseListener so faz o texto desaparecer quando passo o mouse por cima
        nomeComercialField.addFocusListener
        (
        	new FocusAdapter() 
        	{
				public void focusGained(FocusEvent e) 
				{
					if (nomeComercialField.getText().equals("Digite o nome comercial")) 
					{
	                    nomeComercialField.setText("");
	                    nomeComercialField.setForeground(Color.BLACK);
	                }	
				}
				
				@Override
				public void focusLost(FocusEvent e) 
				{
					if (nomeComercialField.getText().isEmpty()) 
					{
	                    nomeComercialField.setText("");
	                    nomeComercialField.setForeground(Color.GRAY);
	                }	
				}
		});
        
        nomeIntituicaoField.addFocusListener
        (
            	new FocusAdapter()
            	{
    				
    				@Override
    				public void focusGained(FocusEvent e)  
    				{
    					if (nomeIntituicaoField.getText().equals("Digite o nome da instituição"))
    					{
    	                    nomeIntituicaoField.setText("");
    	                    nomeIntituicaoField.setForeground(Color.BLACK);
    	                }
    				}
    				
    				@Override
    				public void focusLost(FocusEvent e)
    				{
    					if (nomeIntituicaoField.getText().isEmpty())
    					{
    	                    nomeIntituicaoField.setText("Digite o nome da instituição");
    	                    nomeIntituicaoField.setForeground(Color.GRAY);
    	                }
    				}
    		});
        
        	radioEstado.addItemListener
        	(
        		new ItemListener() 
        		{
					@Override
					public void itemStateChanged(ItemEvent e) 
					{
						if (e.getStateChange() == ItemEvent.SELECTED) 
						{
							nomeIntituicaoField.setEnabled(true);
							radioSim.setEnabled(true);
							radioNao.setEnabled(true);
							
							nomeComercialField.setEnabled(false);
							// Resetar o campo comercial para placeholder quando desabilitado
							nomeComercialField.setText("Digite o nome comercial");
							nomeComercialField.setForeground(Color.GRAY);
						}
					}
			});
        	
        	radioRevendedor.addItemListener
        	(
        		new ItemListener() 
        		{
					@Override
					public void itemStateChanged(ItemEvent e) 
					{
						if (e.getStateChange() == ItemEvent.SELECTED) 
						{
							nomeIntituicaoField.setEnabled(false);
							radioSim.setEnabled(false);
							radioNao.setEnabled(false);
							manutencaoGroup.clearSelection();
							
							nomeComercialField.setEnabled(true);
							// Resetar o campo instituição para placeholder quando desabilitado
							nomeIntituicaoField.setText("Digite o nome da instituição");
							nomeIntituicaoField.setForeground(Color.GRAY);
						}
					}
			});
        	
        	//EFEITO AO PASSAR O MOUSE
    	    btnVoltar.addMouseListener(new MouseAdapter() 
    	    {
    	    	public void mouseEntered(MouseEvent evt) 
    	        {
    	            btnVoltar.setBackground(corPrincipal);
    	        }
    	    	
    	        public void mouseExited(MouseEvent evt) 
    	        {
    	            btnVoltar.setBackground(laranjaBase);
    	        }
    	    });
    	    
    	    btnContinuar.addMouseListener(new MouseAdapter() 
    	    {
    	    	public void mouseEntered(MouseEvent evt) 
    	        {
    	            btnContinuar.setBackground(corPrincipal);
    	        }
    	        public void mouseExited(MouseEvent evt) 
    	        {
    	            btnContinuar.setBackground(laranjaBase);
    	        }
    	    });
    	    
    	    btnCancelar.addMouseListener(new MouseAdapter() 
    	    {
    	    	public void mouseEntered(MouseEvent evt) 
    	        {
    	            btnCancelar.setBackground(corPrincipal);
    	        }
    	        public void mouseExited(MouseEvent evt) 
    	        {
    	            btnCancelar.setBackground(laranjaBase);
    	        }
    	    });
        
        buttonPanel.add(btnVoltar);
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnContinuar);
        
        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);
        cont.add(buttonPanel, gbc);
        
        setResizable(false);
        setSize(900, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        boolean temDados = 	!radioNao.getText().trim().isEmpty() || 
                          	!radioSim.getText().trim().isEmpty() ||
                          	!radioEstado.getText().trim().isEmpty() ||
                          	!radioRevendedor.getText().trim().isEmpty() || 
                          	quantidadeCombo.getSelectedIndex() > 0;
        
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
    
    private void processarDados(ArrayList lista, String nome, long contato, String tipo)
    {
        boolean valido = true;
        String tipoEmpresarial = "", manutencao = "", nomeInstituicao = "", nomeComercial = "";
        int quantidade = 0;
        
        // Limpar erros anteriores
        limparErros();
        
        // Restaurar bordas normais
        nomeIntituicaoField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        nomeComercialField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Validar Quantidade (sempre obrigatório)
        if(quantidadeCombo.getSelectedIndex() == 0)
        {
            quantidadeErroLabel.setText("* Selecione a quantidade de carros");
            valido = false;
        }
        else
        {
            quantidade = Integer.parseInt(quantidadeArray[quantidadeCombo.getSelectedIndex()]);
        }
        
        // Validar Tipo de Empresarial (sempre obrigatório)
        if(radioEstado.isSelected())
            tipoEmpresarial = "E";
        else if(radioRevendedor.isSelected())
            tipoEmpresarial = "R";
        else
        {
            tipoEmpresarialErroLabel.setText("* Selecione o tipo de empresarial");
            valido = false;
        }
        
        // Validações específicas baseadas no tipo empresarial
        if(radioEstado.isSelected())
        {
            // Para tipo Estado: validar nome da instituição e manutenção
            nomeInstituicao = nomeIntituicaoField.getText().trim();
            if(nomeInstituicao.isEmpty() || nomeInstituicao.equals("Digite o nome da instituição"))
            {
                nomeIntituicaoErroLabel.setText("* Digite o nome da instituição");
                nomeIntituicaoField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
            }
            
            // Validar se inclui manutenção
            if(radioSim.isSelected())
            {
                manutencao = "Sim";
            }
            else if(radioNao.isSelected())
            {
                manutencao = "Nao";
            }
            else
            {
                estrangeiroErroLabel.setText("* Selecione se inclui manutenção");
                valido = false;
            }
        }
        else if(radioRevendedor.isSelected())
        {
            // Para tipo Revendedor: validar apenas nome comercial
            nomeComercial = nomeComercialField.getText().trim();
            if(nomeComercial.isEmpty() || nomeComercial.equals("Digite o nome comercial"))
            {
                nomeComercialErroLabel.setText("* Digite o nome comercial");
                nomeComercialField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
            }
        }
        
        // Se tudo está valido, avançar
        if(valido)
        {
            new TelaDadosCarro(lista, nome, contato, tipo, "", "", "", 0, "", quantidade, tipoEmpresarial, nomeInstituicao, manutencao, nomeComercial);
            
            limparCampos();
            dispose();
        }
    }
    
    private void limparErros()
    {
        quantidadeErroLabel.setText(" ");
        tipoEmpresarialErroLabel.setText(" ");
        nomeIntituicaoErroLabel.setText(" ");
        estrangeiroErroLabel.setText(" ");
        nomeComercialErroLabel.setText(" ");
    }
    
    private void limparCampos()
    {
        quantidadeCombo.setSelectedIndex(0);
        tipoEmpresarialGroup.clearSelection();
        manutencaoGroup.clearSelection();
        
        nomeIntituicaoField.setText("Digite o nome da instituição");
        nomeIntituicaoField.setForeground(Color.GRAY);
        
        nomeComercialField.setText("Digite o nome comercial");
        nomeComercialField.setForeground(Color.GRAY);
        
        limparErros();
    }
    
    private void voltamOsDados(boolean voltou, int quantidade, String tipoEmpresarial, String nomeInstituicao, String manutencao, String nomeComercial)
    {
        if(voltou)
        {
            // Restaurar quantidade
            if(quantidade > 0)
            {
                for(int i = 1; i < quantidadeArray.length; i++)
                {
                    if(quantidadeArray[i].equals(String.valueOf(quantidade)))
                    {
                        quantidadeCombo.setSelectedIndex(i);
                        break;
                    }
                }
            }
            
            // Restaurar tipo empresarial
            if(tipoEmpresarial != null && !tipoEmpresarial.isEmpty())
            {
                if(tipoEmpresarial.equalsIgnoreCase("E"))
                {
                    radioEstado.setSelected(true);
                    // Habilitar campos relacionados ao Estado
                    nomeIntituicaoField.setEnabled(true);
                    radioSim.setEnabled(true);
                    radioNao.setEnabled(true);
                    nomeComercialField.setEnabled(false);
                    
                    if(nomeInstituicao == null || nomeInstituicao.isEmpty()) 
                    {
                        nomeIntituicaoField.setText("Digite o nome da instituição");
                        nomeIntituicaoField.setForeground(Color.GRAY);
                    }
                }
                else if(tipoEmpresarial.equalsIgnoreCase("R"))
                {
                    radioRevendedor.setSelected(true);
                    // Habilitar campos relacionados ao Revendedor
                    nomeComercialField.setEnabled(true);
                    nomeIntituicaoField.setEnabled(false);
                    radioSim.setEnabled(false);
                    radioNao.setEnabled(false);
                    
                    if(nomeComercial == null || nomeComercial.isEmpty()) 
                    {
                        nomeComercialField.setText("Digite o nome comercial");
                        nomeComercialField.setForeground(Color.GRAY);
                    }
                }
            }
            
            // Restaurar nome instituição
            if(nomeInstituicao != null && !nomeInstituicao.isEmpty() && radioEstado.isSelected())
            {
                nomeIntituicaoField.setText(nomeInstituicao);
                nomeIntituicaoField.setForeground(Color.BLACK);
            }
            
            // Restaurar manutenção
            if(manutencao != null && !manutencao.isEmpty())
            {
                if(manutencao.equalsIgnoreCase("Sim"))
                    radioSim.setSelected(true);
                else if(manutencao.equalsIgnoreCase("Nao"))
                    radioNao.setSelected(true);
            }
            
            // Restaurar nome comercial
            if(nomeComercial != null && !nomeComercial.isEmpty() && radioRevendedor.isSelected())
            {
                nomeComercialField.setText(nomeComercial);
                nomeComercialField.setForeground(Color.BLACK);
            }
        }
    }
}