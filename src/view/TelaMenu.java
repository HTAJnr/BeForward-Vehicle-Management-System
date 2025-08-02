package view;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import util.Calculos;
import util.GerarPDF;
import util.Ordenacoes;

public class TelaMenu extends JFrame
{
	private Container cont;
	private ArrayList array;
	private JMenuBar bar;
	private JMenu fich, oper, orde, hist, extra, cliente, encerrar;
	private JMenuItem ler, open, regis, remo, pesq, alte, ordepr, ordeec, quant, custo, direitos, situacao, listar, musica, voltar, exit, gerar;
	private JMenuItem dadosprog, about;
	private ImageIcon folderI, folderOpenI, fileI, operI, histI, extraI, closeI, logoutI, exitI, cliI, cliRemI, cliRegI, cliPesI, altECI, ordeI, diradI, somaI, sitI, quantI, dadosI, pdfI, musicI, ordPrI, ordEcI, programI, aboutI;
	private Image backgroundImage;
	private JPopupMenu popupMenu;
	private Calculos cal;
	private Ordenacoes ord;
	private boolean passou = false;
	
	public TelaMenu()
	{
		super("Menu - BeForward");
		cont = getContentPane();
		array = new ArrayList();

		cal = new Calculos();
		ord = new Ordenacoes();

        cont.setBackground(new Color(30, 30, 30));
		bar = new JMenuBar();
		setJMenuBar(bar);
		bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 165, 0))); 
		
		folderI = new ImageIcon("./resources/images/folderG.png");
		folderOpenI = new ImageIcon("./resources/images/folderopen.png");
		fileI = new ImageIcon("./resources/images/fileopen.png");
		operI = new ImageIcon("./resources/images/operacoes.png");
		cliI = new ImageIcon("./resources/images/person.png");
		cliRemI = new ImageIcon("./resources/images/personRemove.png");
		cliRegI = new ImageIcon("./resources/images/personAdd.png");
		cliPesI = new ImageIcon("./resources/images/personSearch.png");
		altECI = new ImageIcon("./resources/images/alterar.png");
		ordeI = new ImageIcon("./resources/images/ordenar.png");
		ordPrI = new ImageIcon("./resources/images/ordenarMove.png");
		ordEcI = new ImageIcon("./resources/images/ordenarSwap.png");
		histI = new ImageIcon("./resources/images/history.png");
		diradI = new ImageIcon("./resources/images/valorDA.png");
		somaI = new ImageIcon("./resources/images/soma.png"); 
		sitI = new ImageIcon("./resources/images/situation.png");
		quantI = new ImageIcon("./resources/images/quant.png");
		dadosI = new ImageIcon("./resources/images/dados.png"); 
		pdfI = new ImageIcon("./resources/images/pdf.png");
		extraI = new ImageIcon("./resources/images/extraa.png");
		musicI = new ImageIcon("./resources/images/music.png");
		logoutI = new ImageIcon("./resources/images/logout.png");
		closeI = new ImageIcon("./resources/images/cancelCircle.png");
		exitI = new ImageIcon("./resources/images/close.png");
		programI = new ImageIcon("./resources/images/program.png");
		aboutI = new ImageIcon("./resources/images/about.png");
		
		backgroundImage = new ImageIcon("./resources/images/BFBmz.png").getImage();
		
		ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());

        // Painel com fundo desenhado
        JPanel backgroundPanel = new JPanel()
        {
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);
        
		fich = new JMenu("Ficheiro");          fich.setIcon(folderI);      fich.setMnemonic('F');         fich.setToolTipText("Abrir, salvar ou ler dados");
		oper = new JMenu("Operacoes");         oper.setIcon(operI);        oper.setMnemonic('O');         oper.setToolTipText("Gerir cliente, acompanhar compra e organizar dados");
		cliente = new JMenu("Cliente");        cliente.setIcon(cliI);      cliente.setMnemonic('C');      cliente.setToolTipText("Gerir cliente");
		orde = new JMenu("Ordenar");           orde.setIcon(ordeI);        orde.setMnemonic('R');         orde.setToolTipText("Ordenar os dados do cliente");
		hist = new JMenu("Consulta");          hist.setIcon(histI);        hist.setMnemonic('H');         hist.setToolTipText("Consultar dados consolidados da empresa");
		extra = new JMenu("Extra");            extra.setIcon(extraI);      extra.setMnemonic('E');        extra.setToolTipText("Opções adicionais");
		encerrar = new JMenu("Encerrar");      encerrar.setIcon(closeI);   encerrar.setMnemonic('X');     encerrar.setToolTipText("Encerrar sessão ou sair");
		
		ler = new JMenuItem("Ler Do Ficheiro");             ler.setIcon(fileI);           ler.setMnemonic('L');                   ler.setToolTipText("Ler dados do ficheiro");
		open = new JMenuItem("Open");                       open.setIcon(folderOpenI);    open.setMnemonic('P');                  open.setToolTipText("Abrir ficheiros");
		regis = new JMenuItem("Registar");                  regis.setIcon(cliRegI);       regis.setMnemonic('R');                 regis.setToolTipText("Adicionar novo cliente ao sistema");
		remo = new JMenuItem("Remover");                    remo.setIcon(cliRemI);        remo.setMnemonic('M');                  remo.setToolTipText("Eliminar cliente do registo");
		pesq = new JMenuItem("Pesquisar");                  pesq.setIcon(cliPesI);        pesq.setMnemonic('P');                  pesq.setToolTipText("Pesquisar um cliente");
		alte = new JMenuItem("Alterar Estado De Compra");   alte.setIcon(altECI);         alte.setMnemonic('A');                  alte.setToolTipText("Actualizar o estado de uma compra");
		ordepr = new JMenuItem("Por Preco");                ordepr.setIcon(ordEcI);       ordepr.setMnemonic('P');                ordepr.setToolTipText("Ordenar os dados do cliente por preço");
		ordeec = new JMenuItem("Por Estado De Compra");     ordeec.setIcon(ordPrI);       ordeec.setMnemonic('E');                ordeec.setToolTipText("Ordenar os dados do cliente por estado de compra");
		direitos = new JMenuItem("Valor Obtido nos DA");    direitos.setIcon(diradI);     direitos.setMnemonic('D');              direitos.setToolTipText("Valor total recebido em direitos aduaneiros");
		custo = new JMenuItem("Custo Total Global");        custo.setIcon(somaI);         custo.setMnemonic('C');                 custo.setToolTipText("Custo acumulado de todas as operações da empresa");
		situacao = new JMenuItem("Situacao da Empresa");    situacao.setIcon(sitI);       situacao.setMnemonic('S');              situacao.setToolTipText("Resumo financeiro e operacional da empresa");
		quant = new JMenuItem("Quantidade de Clientes");    quant.setIcon(quantI);        quant.setMnemonic('Q');                 quant.setToolTipText("Número total de clientes registados na plataforma");
		listar = new JMenuItem("Visualizar Dados dos Clientes"); listar.setIcon(dadosI);          listar.setMnemonic('L');        listar.setToolTipText("Dados detalhados dos clientes");
		gerar = new JMenuItem("Gerar PDF");                      gerar.setIcon(pdfI);             gerar.setMnemonic('G');         gerar.setToolTipText("Gerar PDF das listas");
		musica = new JMenuItem("Musica");                        musica.setIcon(musicI);          musica.setMnemonic('M');        musica.setToolTipText("Reproduz músicas");
		voltar = new JMenuItem("Voltar Ao Login");               voltar.setIcon(logoutI);         voltar.setMnemonic('L');        voltar.setToolTipText("Retorna à tela de login");
		exit = new JMenuItem("Exit");                            exit.setIcon(exitI);             exit.setMnemonic('X');          exit.setToolTipText("Encerra o programa");

		regis.setEnabled(false);
		remo.setEnabled(false);
		pesq.setEnabled(false);
		alte.setEnabled(false);
		ordepr.setEnabled(false);
		ordeec.setEnabled(false);
		direitos.setEnabled(false);
		custo.setEnabled(false);
		situacao.setEnabled(false);
		quant.setEnabled(false);
		listar.setEnabled(false); 
		gerar.setEnabled(false);
		
		dadosprog = new JMenuItem("Programadores");    dadosprog.setIcon(programI);
		about = new JMenuItem("About");                about.setIcon(aboutI);
		
		//ACTION LISTENER DA OPCAO PARA LER DO FICHEIRO
		ler.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				if(passou == false)
				{
					if(x.getSource() == ler)
					{
						JFileChooser chosenFile = new JFileChooser() ;
						chosenFile.setCurrentDirectory(new File("."));
						int response = chosenFile.showOpenDialog(null);
									 
						if (response == JFileChooser. APPROVE_OPTION)
						{
							File file = new File (chosenFile.getSelectedFile().getAbsolutePath());
							
							if (file != null && file.exists()) 
							{
					            String nomeArquivo = file.getName();
					            
					            if (nomeArquivo.equals("DadosClientes.txt")) 
					            {
					                try 
					                {
					                    lerDoFicheiro(file.getAbsolutePath());
					                    passou = true;
					                } catch (Exception e) 
					                {
					                	new TelaMsg("Leitura do Ficheiro", "Erro ao ler o arquivo: "+ e.getMessage(), "Consulte o suporte Tecnico");
					                }
					            } else 
					            {
					            	new TelaMsg("Leitura do Ficheiro", "Arquivo inválido!", "Por favor, selecione 'DadosCliente.txt'");
					            }
							}
						}
					}
				}
				else
					new TelaMsg("Leitura do Ficheiro", "Ficheiro De Texto Ja Foi Lido!", "Teste as outras funções do programa!");
					
			}
		});
		
		//ACTION LISTENER DA OPCAO PARA ABRIR OS FICHEIROS
		open.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				openFile();
			}
	
		});
		
		//ACTION LISTENER DA OPCAO DE REGISTRAR NOVO CLIENTE
		regis.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				new TelaRegistrar(array,"", "", 0, false);
			}
		});
		
		//ACTION LISTENER DA OPCAO DE REMOVER CLIENTE PELO CONTACTO
		remo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new TelaPesquisar(array, "Remover", "        Remover Cliente     ");
			}
		});
		
		
		//ACTION LISTENER DA OPCAO DE PESQUISAR CLIENTE
		pesq.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				new TelaPesquisar(array, "Pesquisar", "        Pesquisar Cliente     ");
			}
		});
		
		//ACTION LISTENER DA OPCAO DE ALTERAR ESTADO DE COMPRA DO CLIENTE
		alte.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new TelaPesquisar(array, "Alterar", "        Alterar Estado de Compra     ");
			}
		});
		
		//ACTION LISTENER DA OPCAO DE ORDANAR POR PRECO
		ordepr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ord.ordenarPorPrecoFinal(array);
			}
		});
		
		//ACTION LISTENER DA OPCAO DE ORDANAR POR ESTADO DE COMPRA
		ordeec.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ord.ordenarPorEstadoCompra(array);
			}
		});
		
		//ACTION LISTENER DA OPCAO DE VISUALIZAR VALOR TOTAL OBTIDOS EM DIREITOS ADUANEIROS
		direitos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				adapValorTotalDireitosAduaneiros();
			}
		});
		
		//ACTION LISTENER DA OPCAO DE VISUALIZAR VALOR TOTAL GLOBAL
		custo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				adapValorTotal();
			}
		});
		
		//ACTION LISTENER DA OPCAO DE VISUALIZAR A SITUACAO DA EMPRESA
		situacao.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				adapSituacao();
			}
		});
		
		//ACTION LISTENER DA OPCAO DE VISUALIZAR A QUANTIDADE DE CLIENTES
		quant.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				new TelaQuantidadeClientes();
			}
		});
		
		//ACTION LISTENER DA OPCAO DE LISTAR TODOS OS DADOS
		listar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new TelaTabelaCardLayout(array);
			}
		});
		
		//ACTION LISTENER DA OPCAO DE GERAR PDF
		gerar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new GerarPDF(array);
			}
		});
		
		//ACTION LISTENER DA OPCAO DE ESCUTAR MUSICA	
		musica.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent x)
			{
				new TelaMusica();
			}
		});
		
		//ACTION LISTENER DA OPCAO PARA VOLTAR A TELA DO LOGIN
		voltar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new TelaLogin();
				dispose();
			}
		});
		
		//ACTION LISTENER DA OPCAO PARA SAIR DO PROGRAMA
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
		    {
		        TelaMsg telaMensagem = new TelaMsg("Encerramento do programa", "Programa Encerrado!", "Obrigado por utilizar os nossos serviços!");
		        telaMensagem.addWindowListener(new WindowAdapter()
		        {
		            public void windowClosed(WindowEvent e)
		            {
		                System.exit(0);
		            }
		        });
		    }
		});
		
		fich.add(ler); fich.add(open);
		bar.add(fich);
		
		cliente.add(regis); cliente.add(remo); cliente.add(pesq);
		orde.add(ordepr); orde.add(ordeec);
		oper.add(cliente); oper.add(alte); oper.add(orde);
		bar.add(oper);
		
		hist.add(direitos); hist.add(custo); hist.add(situacao); hist.add(quant); hist.add(listar); hist.add(gerar);
		bar.add(hist);
		
		extra.add(musica);
		bar.add(extra);
		
		encerrar.add(voltar); encerrar.add(exit);
		bar.add(encerrar);
		
		// MENU POPUP
        popupMenu = new JPopupMenu();
        popupMenu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        JPopupMenu pop = new JPopupMenu();
		
        JMenuItem opGuide = new JMenuItem("Manual do Utilizador");
        opGuide.addActionListener(new ActionListener() 
        {
			public void actionPerformed(ActionEvent e) 
			{
				new TelaManual();
			}
		});
        pop.add(opGuide);
        
		JMenuItem opPerfil = new JMenuItem("Programadores");
        opPerfil.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
            	new TelaDadosProgramadores();
            }
        });
        pop.add(opPerfil);
        
		JMenuItem opProg = new JMenuItem("About");
        opProg.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	new TelaAbout();
            }
        });
        pop.add(opProg);
        
		addMouseListener(new MouseAdapter() 
		{
				public void mousePressed(MouseEvent e)
            	{
                    // Verifica se o botão direito do mouse foi pressionado
                	if (SwingUtilities.isRightMouseButton(e)) 
                	{
	                	{
	                		pop.show(TelaMenu.this, e.getX(), e.getY());
	                	}
                	}
            	}
        });
		
        addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) 
            {
                // Verifica se foi um duplo clique
                if (e.getClickCount() == 2) 
                {
                	 // Criar a janela de confirmação
                    TelaConfirmacao telaConfirmacao = new TelaConfirmacao(
                        "Voltar ao Login",
                        "Deseja voltar para a tela de Login?",
                        "Todas operações serão salvas automaticamente!"
                    );
                    
                    // Adicionar listener aos botões para saber quando foi clicado
                    telaConfirmacao.btnConfirmar.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent evt) 
                        {
                            dispose(); // Fechar a janela principal
                            new TelaLogin();
                        }
                    });
                }
            }
        });
        
        setVisible(true);
		setResizable(false);
		setSize(1280, 800); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e) 
            {
                // Criar a janela de confirmação
                TelaConfirmacao telaConfirmacao = new TelaConfirmacao(
                    "Sair do programa",
                    "Deseja realmente sair do programa?",
                    "Todas operações serão salvas automaticamente!"
                );
                
                // Adicionar listener aos botões para saber quando foi clicado
                telaConfirmacao.btnConfirmar.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) 
                    {
                    	// Fechar a tela de confirmação
                        telaConfirmacao.dispose();
                        // Usuário confirmou - sair do programa
                        TelaMsg telaMensagem = new TelaMsg("Encerramento do programa", 
                            "Programa Encerrado!", "Obrigado por utilizar os nossos serviços!");
                        telaMensagem.addWindowListener(new WindowAdapter() 
                        {
                            public void windowClosed(WindowEvent e) 
                            {
                                System.exit(0);
                            }
                        });
                        dispose(); // Fechar a janela principal
                    }
                });
            }
        });
	}

	// METODO PARA A LEITURA DO FICHEIRO DE TEXTO
	public void lerDoFicheiro(String dadosCliente)
	{
		// DECLARACAO DAS VARIAVEIS PARA A LEITURA
		StringTokenizer x;
		String uL, nome, dc, ec, mar, mod, tipoUso = "", dcd, est, nomeCom, nomeIns, man;
		int cod, cil, qa, qv = 0;
		float preco;
		long tel;
		char c1, c2;
		
		try
		{
			// DECLARACAO E INICIALIZACAO DAS CLASSES DE LEITURA DO FICHEIRO DO TEXTO
			BufferedReader br = new BufferedReader(new FileReader(dadosCliente));
			
			// INICIALIZACAO DO CONTROLADOR DE LINHAS E LEITURA DA PRIMEIRA LINHA DO FICHEIRO
			uL = br.readLine();
			
			while(uL != null)
			{
				// INICIALIZACAO DA CLASSE QUE SEPARA OS DADOS E O SEU RESPECTIVO DELIMITADOR
				x = new StringTokenizer(uL,";");
				
				// ARMAZENAMENTO DOS DADOS NAS RESPECTIVAS VARIAVEIS
				tel = Long.parseLong(x.nextToken());
				nome = x.nextToken();
				dc = x.nextToken();
				ec = x.nextToken();
				cod = Integer.parseInt(x.nextToken());
				mar = x.nextToken();
				mod = x.nextToken();
				cil = Integer.parseInt(x.nextToken());
				preco = Float.parseFloat(x.nextToken());
				
				c1 = x.nextToken().charAt(0);   // LEITURA E ARMAZENAMENTO DO CRITERIO DO PRIMEIRO NIVEL DE HERANCA
				
				// SWITCH CASE DO PRIMEIRO NIVEL DE HERANCA
				switch(c1)
				{
						// CASE DOS OBJECTOS DO TIPO PARTICULAR  
						case 'P': case 'p': 	tipoUso = x.nextToken();
												break;
						
						// CASE DOS OBJECTOS DO TIPO EMPRESARIAL
						case 'E': case 'e': 	qv = Integer.parseInt(x.nextToken());
												break;
				}
				
				c2 = x.nextToken().charAt(0);   // LEITURA E ARMAZENAMENTO DO CRITERIO DO SEGUNDO NIVEL DE HERANCA
				
				// SWITCH CASE DO OBJECTO FINAL
				switch(c2)
				{
						// CASE DO OBJECTO FINAL DO TIPO PARTICULAR DOUTORADO 
						case 'D': case 'd': 	dcd = x.nextToken();
												// CHAMADA DO METODO DE CRIACAO DO OBJECTO
												criarDOUTORADO(tel, nome, dc, ec, cod, mar, mod, cil, preco, tipoUso, dcd);
												break;
						
						// CASE DO OBJECTO FINAL DO TIPO PARTICULAR NORMAL
						case 'N': case 'n': 	est = x.nextToken();
												qa = Integer.parseInt(x.nextToken());
												// CHAMADA DO METODO DE CRIACAO DO OBJECTO
												criarNORMAL(tel, nome, dc, ec, cod, mar, mod, cil, preco, tipoUso, est, qa);
												break;
						
						// CASE DO OBJECTO FINAL DO TIPO EMPRESARIAL REVENDEDOR
						case 'R': case 'r': 	nomeCom = x.nextToken();
												// CHAMADA DO METODO DE CRIACAO DO OBJECTO
												criarREVENDEDOR(tel, nome, dc, ec, cod, mar, mod, cil, preco, qv, nomeCom);
												break;
						
						// CASE DO OBJECTO FINAL DO TIPO EMPRESARIAL ESTADO
						case 'S': case 's': 	nomeIns = x.nextToken();
												man = x.nextToken();
												// CHAMADA DO METODO DE CRIACAO DO OBJECTO
												criarESTADO(tel, nome, dc, ec, cod, mar, mod, cil, preco, qv, nomeIns, man);
												break;
				}
				// LEITURA DA LINHA SEGUINTE DO FICHEIRO DE TEXTO
				uL = br.readLine();
			}
			br.close();
			array.trimToSize();   // AJUSTE DO TAMANHO DO ARRAYLIST COM BASE NO NOVO TAMANHO APOS ADICOES
			
			new TelaMsg("Leitura do Ficheiro", "Ficheiro De Texto Foi Lido Com Sucesso!", "Teste as outras funções do programa!");
			
			regis.setEnabled(true);
			remo.setEnabled(true);
			pesq.setEnabled(true);
			alte.setEnabled(true);
			ordepr.setEnabled(true);
			ordeec.setEnabled(true);
			direitos.setEnabled(true);
			custo.setEnabled(true);
			situacao.setEnabled(true);
			quant.setEnabled(true);
			listar.setEnabled(true); 
			gerar.setEnabled(true);
		
			
		} catch(FileNotFoundException fnf) { new TelaMsg("Login no Sistema", "Ficheiro dos Clientes não encontrado!", "Contacte o Suporte do Sistema!"); }
		catch(NumberFormatException nf) { new TelaMsg("Login no Sistema", nf.getMessage(), "Contacte o Suporte do Sistema!"); }
		catch(IOException io) { new TelaMsg("Login no Sistema", io.getMessage(), "Contacte o Suporte do Sistema!"); }	
	}
	
	// METODO DE CRIACAO DO OBJECTO FINAL DO TIPO PARTICULAR DOUTORADO
	public void criarDOUTORADO(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, String tipoUso, String dcd)
	{
		// DECLARACAO E INICIALIZACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DO OBJECTO DOTOURADO 
		Doutorado d = new Doutorado();
		
		// ALTERACAO DOS DADOS PELOS VALORES LIDOS
		d.setTel(tel);
		d.setNome(nome);
		d.setDataCompra(dc);
		d.setEstadoCompra(ec);
		d.setCodigo(cod);
		d.setMarca(mar);
		d.setModelo(mod);
		d.setCilindrada(cil);
		d.setPreco(preco);
		d.setTipoUsoViatura(tipoUso);
		d.setDataConclusaoDoutoramento(dcd);
		
		// ADICAO DOS DADOS OBJECTO NO ARRAYLIST
		array.add(d);
	}
	
	// METODO DE CRIACAO DO OBJECTO FINAL DO TIPO PARTICULAR NORMAL
	public void criarNORMAL(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, String tipoUso, String est, int qa)
	{
		// DECLARACAO E INICIALIZACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DO OBJECTO NORMAL
		Normal n = new Normal();
		
		// ALTERACAO DOS DADOS PELOS VALORES LIDOS
		n.setTel(tel);
		n.setNome(nome);
		n.setDataCompra(dc);
		n.setEstadoCompra(ec);
		n.setCodigo(cod);
		n.setMarca(mar);
		n.setModelo(mod);
		n.setCilindrada(cil);
		n.setPreco(preco);
		n.setTipoUsoViatura(tipoUso);
		n.setEstrangeiro(est);
		n.setQuantAnos(qa);
		
		// ADICAO DOS DADOS OBJECTO NO ARRAYLIST
		array.add(n);
	}
	
	// METODO DE CRIACAO DO OBJECTO FINAL DO TIPO EMPRESARIAL REVENDEDOR
	public void criarREVENDEDOR(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, int qv, String nomeCom)
	{
		// DECLARACAO E INICIALIZACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DO OBJECTO REVENDEDOR
		Revendedor r = new Revendedor();
		
		// ALTERACAO DOS DADOS PELOS VALORES LIDOS
		r.setTel(tel);
		r.setNome(nome);
		r.setDataCompra(dc);
		r.setEstadoCompra(ec);
		r.setCodigo(cod);
		r.setMarca(mar);
		r.setModelo(mod);
		r.setCilindrada(cil);
		r.setPreco(preco);
		r.setQuantViaturas(qv);
		r.setNomedoComercial(nomeCom);
		
		// ADICAO DOS DADOS OBJECTO NO ARRAYLIST
		array.add(r);
	}
	
	// METODO DE CRIACAO DO OBJECTO FINAL DO TIPO EMPRESARIAL ESTADO
	public void criarESTADO(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, int qv, String nomeIns, String man)
	{
		// DECLARACAO E INICIALIZACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DO OBJECTO ESTADO
		Estado e = new Estado();
		
		// ALTERACAO DOS DADOS PELOS VALORES LIDOS
		e.setTel(tel);
		e.setNome(nome);
		e.setDataCompra(dc);
		e.setEstadoCompra(ec);
		e.setCodigo(cod);
		e.setMarca(mar);
		e.setModelo(mod);
		e.setCilindrada(cil);
		e.setPreco(preco);
		e.setQuantViaturas(qv);
		e.setNomeInstituicao(nomeIns);
		e.setManutencao(man);
		
		// ADICAO DOS DADOS OBJECTO NO ARRAYLIST
		array.add(e);
	}
    private void openFile() 
    {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setDialogTitle("Open File");

	    // Configura  es adicionais (filtros, diret rio inicial, etc.)
	    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

	    int result = fileChooser.showOpenDialog(null);
	    if (result == JFileChooser.APPROVE_OPTION) 
	    {
	        File selectedFile = fileChooser.getSelectedFile();
	        if (Desktop.isDesktopSupported()) 
	        {
	            try 
	            {
	                Desktop.getDesktop().open(selectedFile);
	            } catch (IOException e)
	            {
	                JOptionPane.showMessageDialog(null, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } 
	        else 
	        {
	            JOptionPane.showMessageDialog(null, "Desktop is not supported on this platform.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
    	
    }
    
    //ADAPTADOR - VALOR TOTAL PAGO EM DIREITOS ADUANEIROS
  	public void adapValorTotalDireitosAduaneiros()
  	{
  		float v = cal.calcVTDireitosAduaneiros(array);   // CHAMADA DO METODO DE CALCULO DO VALOR TOTAL PAGO EM DIREITOS ADUANEIROS E ARMAZENAMENTO NA RESPECTIVA VARIAVEL
  		new TelaRelatorioFinanceiro("VALOR TOTAL PAGO EM DIREITOS ADUANEIROS", v);		   	 // CHAMADA DO METODO PARA A VISUALIZACAO DO VALOR TOTAL PAGO EM DIREITOS ADUANEIROS
  	}
  	
  	// ADAPTADOR - CUSTO TOTAL PAGO A EMPRESA
 	public void adapValorTotal()
 	{
 		float v = cal.calcValorTotal(array);   // CHAMADA DO METODO DE CALCULO DO CUSTO TOTAL E ARMAZENAMENTO NA RESPECTIVA VARIAVEL
 		new TelaRelatorioFinanceiro("CUSTO TOTAL PAGO A EMPRESA", v);		   	                // CHAMADA DO METODO PARA A VISUALIZACAO DO CUSTO TOTAL
 	}
  	
  	// ADAPTADOR - VERIFICAR A SITUACAO DA EMPRESA E O VALOR
 	public void adapSituacao()
 	{
 		// DECLARACAO DAS VARIAVEIS
 		float vt, valS;
 		
 		vt = cal.calcValorTotal(array);        // CHAMADA DO METODO DE CALCULO DO VALOR TOTAL
 		valS = cal.calcSituacao(vt);           // CHAMADA DO METODO DE CALCULO DO VALOR EM FALTA
 		new TelaSituacaoFinanceira(valS);      // CHAMADA DO METODO DE VISUALIZACAO DA SITUACAO DA EMPRESA
 	}
}