// Desenvolvido com ❤️ pelos estudantes do Instituto Superior de Ciências de Tecnologias de Moçambique

package view;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Usuario;

public class TelaLogin extends JFrame
{
	private Container cont;
	private ArrayList array;
	private Icon logo, show, passL, user, novoL, novoP, exitL, exitP, logL, logP;
	private JLabel userLabel, userErro, passErro, passLabel, mainLabel, logoLabel, sistemaLabel;
	private JComboBox userCB;
	private JPasswordField passField;
	private JCheckBox olho;
	private JButton entrar, sair, novo;
	private JPanel painelTopo, painelButton, painelSenha, painelTit;
	private String users[];
	private GridBagConstraints gbc, gtit;
	
	public TelaLogin()
	{
		super("Login - BeForward");
		
		array = new ArrayList();
		cont = getContentPane();
    	cont.setLayout(new GridBagLayout());
    	gbc = new GridBagConstraints();
    	
    	Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color red = new Color(255, 36 , 0);
    	
        cont.setBackground(corPrincipal);
		
		logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
        show = new ImageIcon("./resources/images/show.png");
        passL = new ImageIcon("./resources/images/key.png");
        user = new ImageIcon("./resources/images/user.png");
        novoL = new ImageIcon("./resources/images/newUserL.png");
        novoP = new ImageIcon("./resources/images/newUserP.png");
        exitL = new ImageIcon("./resources/images/exitL.png");
        exitP = new ImageIcon("./resources/images/exitP.png");
        logL = new ImageIcon("./resources/images/loginL.png");
        logP = new ImageIcon("./resources/images/loginP.png");
        
    	Font titulo = new Font("Segoe UI", Font.BOLD, 42);        
    	Font subtitulo = new Font("Segoe UI", Font.BOLD, 38);
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
    	mainLabel = new JLabel("BE FORWARD MZ");
    	mainLabel.setFont(titulo);
    	mainLabel.setForeground(laranjaBase);
    	gtit.anchor = GridBagConstraints.CENTER;
    	gtit.gridy = 0;
    	painelTit.add(mainLabel, gtit);

    	// SISTEMA
    	sistemaLabel = new JLabel("Sistema de Gestão de Viaturas");
    	sistemaLabel.setFont(subtitulo);
    	sistemaLabel.setForeground(Color.WHITE);
    	gtit.anchor = GridBagConstraints.CENTER;
    	gtit.gridy = 1;
    	painelTit.add(sistemaLabel, gtit);

    	// PAINEL TOPO COM BORDERLAYOUT
    	painelTopo = new JPanel(new BorderLayout());
    	painelTopo.setBackground(corPrincipal);;

    	//ADICIONA O TITULO E SUBTITULO NO TOPO
    	painelTopo.add(logoLabel, BorderLayout.WEST);
    	painelTopo.add(painelTit, BorderLayout.CENTER);

    	// ADICIONA O PAINEL TOPO AO CONTAINER
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.gridwidth = 2;      
    	gbc.fill = GridBagConstraints.NONE;
    	gbc.anchor = GridBagConstraints.CENTER;
    	gbc.insets = new Insets(10, 10, 320, 10);
    	cont.add(painelTopo, gbc);
        
        //LABEL - NOME
        userLabel = new JLabel(" Usuario: ");         
        userLabel.setIcon(user);
        userLabel.setFont(fonte);
        userLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;                      
        gbc.gridwidth = 1;                                   
        gbc.anchor = GridBagConstraints.EAST;                
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(-420, 160, 5, 10);            
        cont.add(userLabel, gbc);
        
         
        //COMBOBOX - NOME
        lerDoFich();
        users = usuarios();
        userCB = new JComboBox(users);
        userCB.setFont(fonteCB);
        userCB.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(-420, 10, 5, 40);
        cont.add(userCB, gbc);
        
        //LABEL - ERRO PARA NOME
        userErro = new JLabel(" ");
        userErro.setFont(fonteErro);
        userErro.setForeground(red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.insets = new Insets(-355, 100, 5, 0);
        cont.add(userErro, gbc);
       
        //LABEL - SENHA
        passLabel = new JLabel(" Senha:");
        passLabel.setIcon(passL);
        passLabel.setFont(fonte);
        passLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(-270, 160, 5, 10);
        cont.add(passLabel, gbc);
        
        // PAINEL - SENHA
        painelSenha = new JPanel(new BorderLayout());
        painelSenha.setBackground(Color.WHITE);
        painelSenha.setPreferredSize(new Dimension(300, 35)); 

        // CAMPO DE SENHA
        passField = new JPasswordField();
        passField.setPreferredSize(new Dimension(270, 35)); 
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
        gbc.insets = new Insets(-270, 0, 5, 40);
        cont.add(painelSenha, gbc);
        
        //LABEL - ERRO PARA SENHA
        passErro = new JLabel(" ");
        passErro.setFont(fonteErro);
        passErro.setForeground(red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.insets = new Insets(-205, 100, 5, 0);
        cont.add(passErro, gbc);
        
        
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

        novo = new JButton("Novo Usuario", novoP);
        novo.setRolloverIcon(novoL);
        novo.setFont(fonteButton);
        novo.setBackground(laranjaBase);
        novo.setForeground(Color.WHITE);
        novo.setFocusPainted(false);
        novo.setContentAreaFilled(false);
        novo.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        novo.setOpaque(true);
        novo.setPreferredSize(new Dimension(150, 40));

        novo.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		new TelaNovoUsuario(array);
        		dispose();
        	}
        });
        
        entrar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		processarDados();
        	}
        });
        
        sair.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		System.exit(0);
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
	    
	    novo.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	    		novo.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	        	novo.setBackground(laranjaBase);
	        }
	    });
    
		painelButton.add(novo);
		painelButton.add(sair);
		painelButton.add(entrar);
		
		gbc.gridx = 0; gbc.gridy = 11;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(-60, 20, 20, 20);
		cont.add(painelButton, gbc);
    
        
    	setResizable(false);
    	setSize(1280, 800); 
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setLocationRelativeTo(null);
	}
	
	public String[] usuarios()
	{
		Usuario u;
		String x[] = new String[array.size()+1];
		
		x[0] = "Selecione um Usuario";
		
		for(int i = 0; i < array.size(); i++)
		{
			u = (Usuario) array.get(i);
			x[i+1] = u.getNome();
		}
		return x;
	}

	
	public void lerDoFich()
	{
		StringTokenizer x;
		String uL, nome, senha;
		
		try
		{
			FileReader fr = new FileReader("./resources/data/DadosUsuarios.txt");
			BufferedReader br = new BufferedReader(fr);
			
			uL = br.readLine();
			
			while(uL != null)
			{
				x = new StringTokenizer(uL, ";");
				nome = x.nextToken();
				senha = x.nextToken();
				
				Usuario u = new Usuario(nome, senha);
				array.add(u);
				
				uL = br.readLine();
			}
			br.close();
			array.trimToSize();
			
		} catch(FileNotFoundException fnf) { new TelaMsg("Login no Sistema", "Ficheiro dos Usuarios não encontrado!", "Contacte o Suporte do Sistema!"); }
		catch(NumberFormatException nf) { new TelaMsg("Login no Sistema", nf.getMessage(), "Contacte o Suporte do Sistema!"); }
		catch(IOException io) { new TelaMsg("Login no Sistema", io.getMessage(), "Contacte o Suporte do Sistema!"); }
	}
	
	public void processarDados()
	{
		Color red = new Color(255, 36 , 0);
		boolean valido1 = false, valido2 = false;
		String passI = "";
		
		if(userCB.getSelectedIndex() == 0)
			userErro.setText("* Seleccione o usuario");
		else
			valido1 = true;
		
		passI = passField.getText().trim();
		if(passI.isEmpty())
		{
			passField.setBorder(BorderFactory.createLineBorder(red, 2));
			passErro.setText("* Campo senha é obrigatório");
		}
		else
			valido2 = true;
		
		if(valido1 == true && valido2 == true)
		{
			int indice = (userCB.getSelectedIndex()) - 1;
			Usuario u = (Usuario) array.get(indice);
			
			
			if(u.getSenha().equals(passI))
			{
				new TelaMenu();
				new TelaMsg("Boas-vindas", "BEM-VINDO, "+u.getNome()+"!", "Clique no botão direito do mouse para ver instruções!");
				dispose();
			}
			else
			{
				passField.setBorder(BorderFactory.createLineBorder(red, 2));
				passErro.setText("* Senha incorrecta");
			}
			
		}
	}
        
	public static void main(String [] args)
	{
		new TelaLogin();
	}
}
