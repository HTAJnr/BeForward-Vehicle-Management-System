package view;

import javax.swing.*;

import util.Pesquisa;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaPesquisar extends JFrame
{
	private JLabel logoLabel, mainLabel, telefoneLabel, telefoneErroLabel, codigoLabel, codigoErroLabel;
	private JTextField telefoneField, codigoField;
    private JButton btnCancelar, btnPesquisar;
    private JPanel buttonPanel, radioPanel, painelTopo;
    private JRadioButton radioTelefone, radioCodigo;
    private ButtonGroup radioGroup;
    private ImageIcon logo, pesL, pesP, canL, canP;
    private Container cont;
    private GridBagConstraints gbc;
    private Pesquisa pes;
    
    public TelaPesquisar(ArrayList lista, String tipo, String tit)
    {
    	super("Pesquisar Cliente");
    	cont = getContentPane();
    	cont.setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints();
    	
    	pes = new Pesquisa();
    	
    	Color corPrincipal = new Color(26, 27, 30);
      	Color laranjaBase = new Color(255, 106, 0);
      	Color red = new Color(255, 36 , 0);
      	
        cont.setBackground(corPrincipal);
      	
      	logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
      	pesL = new ImageIcon("./resources/images/searchL.png");
      	pesP = new ImageIcon("./resources/images/searchP.png");
      	canL = new ImageIcon("./resources/images/closeL.png");
      	canP = new ImageIcon("./resources/images/close.png");
      	ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
      	
      	Font titulo = new Font("Segoe UI", Font.BOLD, 38);
      	Font fonte = new Font("SansSerif", Font.BOLD, 18);
      	Font fontePlain = new Font("SansSerif", Font.PLAIN, 18);
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
      	gbc.fill = GridBagConstraints.NONE;
      	gbc.insets = new Insets(10, 20, 60, 20);

      	//LOGO
      	logoLabel = new JLabel(logo);
          
	    //TITULO
	    mainLabel = new JLabel(tit);
	    mainLabel.setFont(titulo);
	    mainLabel.setForeground(Color.WHITE);
	      
	    painelTopo.add(logoLabel, BorderLayout.WEST);
	    painelTopo.add(mainLabel, BorderLayout.CENTER);
	    cont.add(painelTopo, gbc);
    	
        //RADIO BUTTON E PAINEL PARA TIPO DE PESQUISA
        radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        radioPanel.setBackground(corPrincipal);
        
        radioTelefone = new JRadioButton("Pesquisar por Contacto", true);
        radioTelefone.setFont(fonte);
        radioTelefone.setForeground(Color.WHITE);
        radioTelefone.setBackground(corPrincipal);
        
        radioCodigo = new JRadioButton("Pesquisar por Código", false);
        radioCodigo.setFont(fonte);
        radioCodigo.setForeground(Color.WHITE);
        radioCodigo.setBackground(corPrincipal);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(radioTelefone);
        radioGroup.add(radioCodigo);
        
        radioPanel.add(radioTelefone);
        radioPanel.add(radioCodigo);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 20, 20, 20);
        cont.add(radioPanel, gbc);
        
        // LABEL - TELEFONE
        telefoneLabel = new JLabel("Contacto: ");
        telefoneLabel.setFont(fonte);
        telefoneLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 20, 5, 10);
        cont.add(telefoneLabel, gbc);
        
        // TEXT FIELD - TELEFONE
        telefoneField = new JTextField(30);
        telefoneField.setFont(fontePlain);
        telefoneField.setPreferredSize(new Dimension(300, 35));
        telefoneField.setEnabled(true);
        gbc.gridx = 1; gbc.gridy = 2; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 10, 5, 20);
        cont.add(telefoneField, gbc);
        
        // LABEL - ERRO PARA TELEFONE
        telefoneErroLabel = new JLabel(" ");
        telefoneErroLabel.setFont(fonteErro);
        telefoneErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 10, 20);
        cont.add(telefoneErroLabel, gbc);
        
        // LABEL - CODIGO
        codigoLabel = new JLabel("Código da Viatura: ");
        codigoLabel.setFont(fonte);
        codigoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 20, 5, 10);
        cont.add(codigoLabel, gbc);
        
        // TEXT FIELD - CODIGO
        codigoField = new JTextField(30);
        codigoField.setFont(fontePlain);
        codigoField.setPreferredSize(new Dimension(300, 35));
        codigoField.setEnabled(false);
        gbc.gridx = 1; gbc.gridy = 4; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 10, 5, 20);
        cont.add(codigoField, gbc);
        
        // LABEL - ERRO PARA CODIGO
        codigoErroLabel = new JLabel(" ");
        codigoErroLabel.setFont(fonteErro);
        codigoErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 10, 10, 20);
        cont.add(codigoErroLabel, gbc);
        
        
        radioTelefone.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    telefoneField.setEnabled(true);
                    codigoField.setEnabled(false);
                }
            }
        });
        
        radioCodigo.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    codigoField.setEnabled(true);
                    telefoneField.setEnabled(false);
                }
            }
        });
        
        // BOTOES
        buttonPanel = new JPanel(new GridLayout(1,2, 20, 0));
        buttonPanel.setBackground(corPrincipal);
        
        btnCancelar = new JButton("Cancelar", canP);
        btnCancelar.setRolloverIcon(canL);
        btnCancelar.setFont(fonteButton);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(laranjaBase);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnCancelar.setOpaque(true);btnCancelar.setPreferredSize(new Dimension(140, 40));
        
        btnPesquisar = new JButton("Pesquisar", pesP);
        btnPesquisar.setRolloverIcon(pesL);
        btnPesquisar.setFont(fonteButton);
        btnPesquisar.setForeground(Color.WHITE);
        btnPesquisar.setBackground(laranjaBase);
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnPesquisar.setOpaque(true);
        btnPesquisar.setPreferredSize(new Dimension(140, 40));
        
        btnCancelar.addActionListener
        (
        	new ActionListener() 
        	{
				public void actionPerformed(ActionEvent e) 
				{
					 existemDados();
				}
			}
        );
        
        btnPesquisar.addActionListener
        (
        	new ActionListener() 
        	{
				public void actionPerformed(ActionEvent e)
				{
					pesquisarCliente(lista, tipo);
				}
			}
        );
        
        //EFEITO AO PASSAR O MOUSE
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
	    
	    btnPesquisar.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            btnPesquisar.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            btnPesquisar.setBackground(laranjaBase);
	        }
	    });
        
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnPesquisar);
        
        
        gbc.gridx = 0; gbc.gridy = 6;
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
        boolean temDados = !codigoField.getText().trim().isEmpty() || 
                          !telefoneField.getText().trim().isEmpty();
        
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
    
    private void pesquisarCliente(ArrayList lista, String tipo) 
    {
        boolean valido = true;
        int i = -1;
        // Limpar mensagens de erro anteriores e resetar bordas
        limparErros();
        
        // Verificar se algum radio button foi selecionado
        if (!radioTelefone.isSelected() && !radioCodigo.isSelected()) 
        {
            telefoneErroLabel.setText("* Selecione um tipo de pesquisa");
            valido = false;
        } else if (radioTelefone.isSelected()) 
        {
            // Validar pesquisa por telefone
            String inputTelefone = telefoneField.getText().trim();
            if(inputTelefone.isEmpty()) 
            {
                telefoneErroLabel.setText("* Campo telefone é obrigatório");
                telefoneField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
            } else 
            {
                try 
                {
                    long telefone = Long.parseLong(inputTelefone);
                    if(telefone < 820000000 || telefone > 879999999) 
                    {
                        telefoneErroLabel.setText("* Válido apenas números nacionais (82-87)");
                        telefoneField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        valido = false;
                    } else 
                    {
                        i = pes.pesquisarClienteTel(lista, telefone);
                        if(i == -1) 
                        {
                            telefoneErroLabel.setText("* Cliente não encontrado");
                            telefoneField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                            valido = false;
                        }
                    }
                } catch(NumberFormatException e) 
                {
                    telefoneErroLabel.setText("* Apenas números são permitidos");
                    telefoneField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    valido = false;
                }
            }
        } else if (radioCodigo.isSelected()) 
        {
            // Validar pesquisa por código
            String inputCodigo = codigoField.getText().trim();
            if(inputCodigo.isEmpty()) 
            {
                codigoErroLabel.setText("* Campo código é obrigatório");
                codigoField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                valido = false;
            } else 
            {
                try 
                {
                    int codigo = Integer.parseInt(inputCodigo);
                    if(codigo < 1000 || codigo > 9999) 
                    {
                        codigoErroLabel.setText("* Código deve ter 4 dígitos (1000 - 9999)");
                        codigoField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                        valido = false;
                    } else 
                    {
                        i = pes.pesquisarClienteCod(lista, codigo);
                        if(i == -1) 
                        {
                            codigoErroLabel.setText("* Cliente não encontrado");
                            codigoField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                            valido = false;
                        }
                    }
                } catch(NumberFormatException e) 
                {
                    codigoErroLabel.setText("* Apenas números são permitidos");
                    codigoField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    valido = false;
                }
            }
        }
        
        // Se a validação passou e cliente foi encontrado, abrir tela correspondente
        if(valido && i != -1) 
        {
            switch(tipo.toUpperCase())
            {
                case "REMOVER":		new TelaRecibo(lista, i, "Remover");
                                    dispose();
                                    break;
                                    
                case "PESQUISAR":	new TelaRecibo(lista, i);
                                    dispose();
                                    break;
                
                case "ALTERAR":		new TelaAlterar(lista, i);
                                    dispose();
                                    break;
            }
        }
        
    }
    
    private void limparErros()
    {
    	// Limpar mensagens
    	telefoneErroLabel.setText(" ");
    	codigoErroLabel.setText(" ");
    	
    	// Resetar bordas para o padrão
    	telefoneField.setBorder(null);
    	codigoField.setBorder(null);
    }
}