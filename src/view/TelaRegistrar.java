package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaRegistrar extends JFrame
{
	private ImageIcon logo, contL, contP, canL, canP;
	private JLabel nomeLabel, contatoLabel, tipoLabel, mainLabel, nomeErroLabel, contatoErroLabel, tipoErroLabel, logoLabel;
	private JTextField nomeField, contatoField;
    private JButton btnCancelar, btnContinuar;
    private JPanel radioPanel, buttonPanel;
    private JRadioButton radioParticular, radioEmpresarial;
    private ButtonGroup tipoCGroup;
    private JPanel painelTopo;
    private Container cont;
    private GridBagConstraints gbc;
    
    public TelaRegistrar(ArrayList lista, String nome, String tipo, long contato, boolean voltou)
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
    	contL = new ImageIcon("./resources/images/contL.png");
    	contP = new ImageIcon("./resources/images/contP.png");
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
    	gbc.fill = GridBagConstraints.HORIZONTAL; 
    	gbc.insets = new Insets(20, 20, 60, 20); 

    	//LOGO
    	logoLabel = new JLabel(logo);
    	
    	//TITULO
    	mainLabel = new JLabel("       Registro de Cliente            "); 
    	mainLabel.setFont(titulo);
    	mainLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
        //LABEL - NOME
        nomeLabel = new JLabel("Nome do Cliente: ");         
        nomeLabel.setFont(fonte);
        nomeLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;                        
        gbc.gridwidth = 1;                                   
        gbc.anchor = GridBagConstraints.WEST;                
        gbc.insets = new Insets(15, 80, 5, 10);              
        cont.add(nomeLabel, gbc);
        
        //TEXT FIELD - NOME
        nomeField = new JTextField(25);
        nomeField.setFont(fontePlain);
        nomeField.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 1; gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(15, 10, 5, 80);
        cont.add(nomeField, gbc);
        
        //LABEL - ERRO PARA NOME
        nomeErroLabel = new JLabel(" ");
        nomeErroLabel.setFont(fonteErro);
        nomeErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 43, 5, 20);
        cont.add(nomeErroLabel, gbc);
        
        // LABEL - CONTACTO
        contatoLabel = new JLabel("Contacto do Cliente: ");
        contatoLabel.setFont(fonte);
        contatoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 80, 5, 10);
        cont.add(contatoLabel, gbc);
        
        // TEXT FIELD - CONTACTO
        contatoField = new JTextField(25);
        contatoField.setFont(fontePlain);
        contatoField.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 10, 5, 80); 
        cont.add(contatoField, gbc);
        
        // LABEL - ERRO PARA CONTACTO
        contatoErroLabel = new JLabel(" ");
        contatoErroLabel.setFont(fonteErro);
        contatoErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 43, 10, 20);
        cont.add(contatoErroLabel, gbc);
        
        // LABEL - TIPO
        tipoLabel = new JLabel("Tipo de Cliente:");
        tipoLabel.setFont(fonte);
        tipoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 80, 5, 10);
        cont.add(tipoLabel, gbc);
        
        // RADIO BUTTON E PAINEL PARA TIPO DE CLIENTE
        radioPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        radioPanel.setBackground(corPrincipal);
        
        radioParticular = new JRadioButton("Particular", false);
        radioParticular.setFont(fontePlain);
        radioParticular.setForeground(Color.WHITE);
        radioParticular.setBackground(corPrincipal);
        radioEmpresarial = new JRadioButton("Empresarial", false);
        radioEmpresarial.setFont(fontePlain);
        radioEmpresarial.setForeground(Color.WHITE);
        radioEmpresarial.setBackground(corPrincipal);
        
        tipoCGroup = new ButtonGroup();
        tipoCGroup.add(radioParticular);
        tipoCGroup.add(radioEmpresarial);
        
        radioPanel.add(radioParticular);
        radioPanel.add(radioEmpresarial);
        
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.fill = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 40, 5, 20); 
        cont.add(radioPanel, gbc);
        
        // LABEL - ERRO PARA TIPO DE CLIENTE
        tipoErroLabel = new JLabel(" ");
        tipoErroLabel.setFont(fonteErro);
        tipoErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 43, 5, 20);
        cont.add(tipoErroLabel, gbc);
        
        voltamOsDados(voltou, nome, tipo, contato);
        
        // Painel para os botões
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
       
        btnCancelar.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
			{
					existemDados();
			}
		});
        
        btnContinuar.addActionListener
        (
        	new ActionListener() 
        	{
				public void actionPerformed(ActionEvent e)
				{
					processarDados(lista);
				}
			}
        );
        
        //EFEITO AO PASSAR O MOUSE
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
        
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnContinuar);
        
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);
        cont.add(buttonPanel, gbc);
    
    	setResizable(false);
    	setSize(900, 550); 
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
    
    private void processarDados(ArrayList lista) 
    {
    	Color red = new Color(255, 36 , 0);
        boolean valido = true;
        String nome, inputContato, tipo = "";
        long contato = 0;
        
        // Limpar mensagens de erro anteriores e resetar bordas
        limparErros();
        
        // Validar Nome
        nome = nomeField.getText().trim();
        if(nome.isEmpty() || nome.length() < 2) 
        {
            nomeErroLabel.setText("* Campo nome é obrigatório");
            nomeField.setBorder(BorderFactory.createLineBorder(red, 2));
            valido = false;
        }
        
        // Validar Contato
        inputContato = contatoField.getText().trim();
        if(inputContato.isEmpty()) 
        {
            contatoErroLabel.setText("* Campo contato é obrigatório");
            contatoField.setBorder(BorderFactory.createLineBorder(red, 2));
            valido = false;
        } else 
        {
            try 
            {
                contato = Long.parseLong(inputContato);
                if(contato < 820000000 || contato > 879999999) 
                {
                    contatoErroLabel.setText("* Valido apenas numeros nacionais (82-87)");
                    contatoField.setBorder(BorderFactory.createLineBorder(red, 2));
                    valido = false;
                }
            } catch(NumberFormatException e) 
            {
                contatoErroLabel.setText("* Apenas números são permitidos");
                contatoField.setBorder(BorderFactory.createLineBorder(red, 2));
                valido = false;
            }
        }
        
        // Validar Tipo
        if(radioEmpresarial.isSelected()) 
            tipo = "Empresarial";
        else if(radioParticular.isSelected()) 
            tipo = "Particular";
        else 
        {
            tipoErroLabel.setText("* Selecione o tipo de cliente");
            valido = false;
        }
        
        // Se tudo está válido
        if(valido) 
        {
            switch(tipo.toUpperCase()) 
            {
                case "EMPRESARIAL":		new TelaResEmpresarial(lista, nome, contato, "E", 0, "", "", "", "", false);
					                    dispose();
					                    break;
                    
                case "PARTICULAR":    	new TelaResParticular(lista, nome, contato, "P", "", "", "", "", 0, false);
					                    dispose();
					                    break;
            }
        }
    }
    
    private void limparErros()
    {
    	// Limpar mensagens
    	nomeErroLabel.setText(" ");
    	contatoErroLabel.setText(" ");
    	tipoErroLabel.setText(" ");
    	
    	// Resetar bordas para o padrão
    	nomeField.setBorder(null);
    	contatoField.setBorder(null);
    }
    
    private boolean existemDados()
    {
    	// Verificar se há dados digitados
        boolean temDados = !nomeField.getText().trim().isEmpty() || 
                          !contatoField.getText().trim().isEmpty() ||
                          !radioEmpresarial.getText().trim().isEmpty() ||
                          !radioParticular.getText().trim().isEmpty();
        
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
        } else
            dispose();
        return temDados;
    }
    
    private void voltamOsDados(boolean voltou, String nome, String tipo, long contato)
    {
    	if(voltou)
    	{
    		// Restaurar Nome
    		nomeField.setText(nome);
    		
    		// Restaurar Contato
        	contatoField.setText(contato+"");
        	
        	// Restaurar Tipo
        	if(radioEmpresarial.getText().equalsIgnoreCase(tipo))
        		radioEmpresarial.setSelected(true);
        	else
        		if(radioParticular.getText().equalsIgnoreCase(tipo))
        				radioParticular.setSelected(true);
    	}
    }
}