package view;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import model.Usuario;
import util.FicheiroTexto;

public class TelaNovoUsuario extends JFrame 
{
	private Container cont;
	private GridBagConstraints gbc, gtit;
	private JLabel logoLabel, userLabel, userErroLabel, passErroLabel, passLabel, mainLabel, forcaLabel, minLabel, numLabel, maiuLabel, espLabel;
	private JTextField userField;
	private JPasswordField passField;
	private JCheckBox olho;
	private JButton entrar, sair, voltar;
	private JPanel painelButton, painelTopo, painelTit, painelSenha;
	private Icon logo, show, passL, user, exitL, exitP, logL, logP, volL, volP;
	private int pontos1 = 0;
	private FicheiroTexto txt;
	
	public TelaNovoUsuario(ArrayList<Usuario> array)
	{
		super("Login - BeForward");
		
		cont = getContentPane();
    	cont.setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints();
    	txt = new FicheiroTexto();
    	
    	Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color red = new Color(255, 36 , 0);
    	
        cont.setBackground(corPrincipal);
		
		logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
        show = new ImageIcon("./resources/images/show.png");
        passL = new ImageIcon("./resources/images/key.png");
        user = new ImageIcon("./resources/images/user.png");
        exitL = new ImageIcon("./resources/images/exitL.png");
        exitP = new ImageIcon("./resources/images/exitP.png");
        logL = new ImageIcon("./resources/images/loginL.png");
        logP = new ImageIcon("./resources/images/loginP.png");
        volL = new ImageIcon("./resources/images/voltarP.png");
        volP = new ImageIcon("./resources/images/voltarP.png");
        
    	Font titulo = new Font("Segoe UI", Font.BOLD, 42);    
    	Font fonte = new Font("SansSerif", Font.BOLD, 18);
    	Font fontePlain = new Font("SansSerif", Font.PLAIN, 18);
    	Font fontePlainE = new Font("SansSerif", Font.BOLD, 16);
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

    	// PAINEL DIREITO COM TITULO E SUBTITULO
    	painelTit = new JPanel(new GridBagLayout());
    	gtit = new GridBagConstraints();
    	painelTit.setBackground(corPrincipal);
    	gtit.gridx = 0;
    	gtit.anchor = GridBagConstraints.WEST;
    	gtit.insets = new Insets(2, 2, 2, 2);
    	
    	// LOGO
    	logoLabel = new JLabel(logo);

    	// TÍTULO 
    	mainLabel = new JLabel("Cadastro Do Novo Usuario");
    	mainLabel.setFont(titulo);
    	mainLabel.setForeground(Color.WHITE);
    	gtit.anchor = GridBagConstraints.CENTER;
    	gtit.gridy = 0;
    	painelTit.add(mainLabel, gtit);
    	
    	painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
    	
        //LABEL - NOME
    	userLabel = new JLabel(" Usuario: ");          
        userLabel.setIcon(user);
        userLabel.setFont(fonte);
        userLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;                   
        gbc.gridwidth = 1;                              
        gbc.anchor = GridBagConstraints.WEST;           
        gbc.insets = new Insets(70, 100, 5, 10);        
        cont.add(userLabel, gbc);
				
		//TEXT FIELD - NOME
		userField = new JTextField(25);
        userField.setFont(fontePlain);
        userField.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 1; gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(70, 10, 5, 20);
        cont.add(userField, gbc);
        
		//LABEL - ERRO PARA NOME
        userErroLabel = new JLabel(" ");
        userErroLabel.setFont(fonteErro);
        userErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(2, 130, 5, 5);  
        cont.add(userErroLabel, gbc);
		
		// LABEL - SENHA
        passLabel = new JLabel(" Senha:");
        passLabel.setIcon(passL);
        passLabel.setFont(fonte);
        passLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 100, 5, 10);
        cont.add(passLabel, gbc);
        
        // PAINEL - SENHA
        painelSenha = new JPanel(new BorderLayout());
        painelSenha.setBackground(Color.WHITE);
        painelSenha.setPreferredSize(new Dimension(350, 35));

        // CAMPO DE SENHA
        passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(330, 35)); 
        passField.setFont(fontePlain);
        painelSenha.add(passField, BorderLayout.CENTER);

        // BOTÃO OLHO
        olho = new JCheckBox(show);
        olho.setPreferredSize(new Dimension(25, 30));
        olho.setFocusPainted(false);
        olho.setBorderPainted(false);
        olho.setContentAreaFilled(false);
        painelSenha.add(olho, BorderLayout.EAST);

        // ACTION LISTENER DO CHECK BOX QUE ALTERA O ICON E MOSTRA O PASSWORD
        olho.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	//VERIFICA SE P CHECKBOX ESTA SELECIONADO OU NAO#
                if (olho.isSelected()) 
                {
                    //MOSTRAR A SENHA
                    passField.setEchoChar((char) 0); 
                    olho.setIcon(new ImageIcon("./resources/images/hide.png"));
                } 
                else 
                {
                    //DES MOSTRAR A SENHA
                    passField.setEchoChar('•');
                    olho.setIcon(new ImageIcon("./resources/images/show.png"));
                }
            }
        });

          
        painelSenha.add(olho, BorderLayout.EAST);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(20, 10, 5, 20); 
        cont.add(painelSenha, gbc);
        
        // LABEL - ERRO PARA SENHA
        passErroLabel = new JLabel(" ");
        passErroLabel.setFont(fonteErro);
        passErroLabel .setForeground(red);
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 130, 5, 5); 
        cont.add(passErroLabel , gbc);
        
        // LABEL - FORCA DA SENHA
		forcaLabel = new JLabel(" ");
		forcaLabel.setFont(fontePlainE);
		forcaLabel.setForeground(Color.WHITE);
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 140, 5, 5); 
        cont.add(forcaLabel, gbc);
        
        passField.getDocument().addDocumentListener(new DocumentListener() 
        {
            public void insertUpdate(DocumentEvent e) 
            {
                atualizarSenha();
            }

            public void removeUpdate(DocumentEvent e) 
            {
                atualizarSenha();
            }

            //Default
            public void changedUpdate(DocumentEvent e) { }

            private void atualizarSenha()
            {
            	passErroLabel.setText(" ");
                String senha = new String(passField.getPassword());
                atualizarForcaSenha(senha);
            }
        });
		
		minLabel = new JLabel("* Mínimo 5 caracteres");
		minLabel.setForeground(Color.WHITE);
		minLabel.setFont(fonteErro);
		gbc.gridx = 1; gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 140, 5, 5); 
        cont.add(minLabel, gbc);
		
		numLabel = new JLabel("* Pelo menos 1 número");
		numLabel.setForeground(Color.WHITE);
		numLabel.setFont(fonteErro);
		gbc.gridx = 1; gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(1, 140, 5, 5); 
        cont.add(numLabel, gbc);
		
		maiuLabel = new JLabel("* Letras maiúsculas e minúsculas");
		maiuLabel.setForeground(Color.WHITE);
		maiuLabel.setFont(fonteErro);
		gbc.gridx = 1; gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(1, 140, 5, 5); 
        cont.add(maiuLabel, gbc);
		
		espLabel = new JLabel("* Pelo menos 1 caractere especial");
		espLabel.setForeground(Color.WHITE);
		espLabel.setFont(fonteErro);
		gbc.gridx = 1; gbc.gridy = 8;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(1, 140, 5, 5); 
        cont.add(espLabel, gbc);
		
		//BOTOES
        painelButton = new JPanel(new GridLayout(1, 2, 20, 0));
        painelButton.setBackground(corPrincipal);
        
        sair = new JButton("Sair", exitP);
        sair.setRolloverIcon(exitL);
        sair.setFont(fonteButton);
        sair.setBackground(laranjaBase);
        sair.setForeground(Color.WHITE);
        sair.setFocusPainted(false);
        sair.setContentAreaFilled(false);
        sair.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        sair.setOpaque(true);
        sair.setPreferredSize(new Dimension(150, 40));

        entrar = new JButton("Entrar", logP);
        entrar.setRolloverIcon(logL);
        entrar.setFont(fonteButton);
        entrar.setBackground(laranjaBase);
        entrar.setForeground(Color.WHITE);
        entrar.setFocusPainted(false);
        entrar.setContentAreaFilled(false);
        entrar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        entrar.setOpaque(true);
        entrar.setPreferredSize(new Dimension(150, 40));

        voltar = new JButton("Voltar", volP);
        voltar.setRolloverIcon(volL);
        voltar.setFont(fonteButton);
        voltar.setBackground(laranjaBase);
        voltar.setForeground(Color.WHITE);
        voltar.setFocusPainted(false);
        voltar.setContentAreaFilled(false);
        voltar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        voltar.setOpaque(true);
        voltar.setPreferredSize(new Dimension(150, 40));
        
        voltar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		boolean tem = existemDados();
        		
        		if(tem)
        		{
        			new TelaLogin();
        			dispose();
        		}
        	}
        });       
        
        entrar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		processarDados(array);
        	}
        });
        
        sair.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		existemDados();
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
	    
	    entrar.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            entrar.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	        	entrar.setBackground(laranjaBase);
	        }
	    });
	    
	    voltar.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	    		voltar.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	        	voltar.setBackground(laranjaBase);
	        }
	    });
    
		painelButton.add(voltar);
		painelButton.add(sair);
		painelButton.add(entrar);
		
		gbc.gridx = 0; gbc.gridy = 11;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(50, 20, 20, 20);
		cont.add(painelButton, gbc);
		
		setResizable(false);
    	setSize(1280, 800); 
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
        boolean temDados = !userField.getText().trim().isEmpty() || 
                          !passField.getText().trim().isEmpty();
        
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
	
	private void atualizarForcaSenha(String senha)
	{
		int pontos = 0;
		
	    // VERIFICA SE CONTEM 5 CARACTERS 
	    if (senha.length() >= 5)
	    {
	        pontos++;
	        minLabel.setForeground(Color.GREEN);
	    } 
	    else 
	        minLabel.setForeground(Color.WHITE);

	    /* VERIFICA SE CONTEM NUMERO
	    	. - caracter
        	\\d - numero (0-9).
        	. - de novo caracter
         */
	    
	    if (senha.matches(".*\\d.*")) 
	    {
	        pontos++;
	        numLabel.setForeground(Color.GREEN);
	    } 
	    else 
	        numLabel.setForeground(Color.WHITE);

	    //VERIFICA SE CONTEM LETRA MAIUSCULA E MINUSCULA
	    boolean temMin = senha.matches(".*[a-z].*");
	    boolean temMai = senha.matches(".*[A-Z].*");

	    if (temMin == true && temMai == true) 
	    {
	        pontos++;
	        maiuLabel.setForeground(Color.GREEN);
	    } 
	    else 
	        maiuLabel.setForeground(Color.WHITE);

	    //VERIFICA SE CONTEM CARACTER ESPECIAL
	    if (senha.matches(".*[!@#$%^&()].*")) 
	    {
	        pontos++;
	        espLabel.setForeground(Color.GREEN);
	    } 
	    else 
	        espLabel.setForeground(Color.WHITE);
	    
	    
        String forca;
       
	    if (pontos == 0 || pontos == 1)
	        forca = "Fraca";
	    else 
	    {	
	    	if (pontos == 2 || pontos == 3) 
	        	forca = "Média";
	        else 
	        	forca = "Forte";
	    }
	    pontos1= pontos;

        forcaLabel.setText("Força da senha: " + forca);
    }
	
	public void processarDados(ArrayList<Usuario> array)
	{
		Color red = new Color(255, 36 , 0);
		String nomeI = "", passI = "";
		boolean passou = true;
		
		//VALIDAR NOME
		nomeI = userField.getText().trim();
        if(nomeI.isEmpty() || nomeI.length() < 2) 
        {
            userErroLabel.setText("* Campo nome é obrigatório");
            userField.setBorder(BorderFactory.createLineBorder(red, 2));
            passou = false;
        }
        else
        	userErroLabel.setText(" ");
        
        //VALIDAR SENHA
        passI = passField.getText().trim();
        if(pontos1 < 4)
        {
        	passErroLabel.setText("* Senha não forte!");
        	forcaLabel.setText(" ");
        	passField.setBorder(BorderFactory.createLineBorder(red, 2)); 
        }
        else
        {
        	passErroLabel.setText(" ");
        	if(passou == true)
        	{
			    Usuario u = new Usuario(nomeI, passI);
			    array.add(u);
                txt.registrarUsuarios(array);
                new TelaMsg("Cadastro de Usuário", "Novo usuário Cadastrado!", "Aproveite sua experiencia no sistema!");
			    new TelaMenu();
			    dispose();
        	}
        	else
        	{
        		userErroLabel.setText("* Campo nome é obrigatório");
                userField.setBorder(BorderFactory.createLineBorder(red, 2));  
        	}
        }
	}
}