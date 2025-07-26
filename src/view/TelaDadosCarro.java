package view;

import javax.swing.*;

import model.*;
import util.FicheiroTexto;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class TelaDadosCarro extends JFrame
{
    private JLabel logoLabel, mainLabel, codigoLabel, marcaLabel, modeloLabel, cilindradaLabel, estadoLabel, dataCompraLabel, precoBaseLabel, codigoVal, cilindradaVal, precoBaseVal, anoLabel;
    private JLabel marcaErroLabel, modeloErroLabel, estadoErroLabel, dataErroLabel;
    private JComboBox marcaCombo, modeloCombo, diaCombo, mesCombo;
    private JRadioButton radioTransito, radioProcessamento, radioEntregaConcluida;
    private JButton btnVoltar, btnCancelar, btnGuardar;
    private JPanel radioPanel, dataPanel, buttonPanel, painelTopo;
    private ButtonGroup estadoGroup;
    private ImageIcon logo, volL, volP, doneL, doneP, canL, canP;
    private Container cont;
    private GridBagConstraints gbc;
    private String[] diasArr, marcasArray, modelosDaMarca, mesesArr = {"Mes", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    private ArrayList carros;
    private DecimalFormat mt, cil;
    private FicheiroTexto txt;
    
    public TelaDadosCarro(ArrayList lista, String nome, long contato, String tipo, String tipoUso, String tipoParticular, 
    		String estrangeiro, int anos, String dataConclusao, int qtdCarros, String tipoEmpresarial, String nomeInst, 
    		String manutencao, String nomeComercial)
    {
        super("Tela Registro");
        
        carros = new ArrayList();
        mt = new DecimalFormat("###,###,###.00 MZN");
        cil = new DecimalFormat("#### CC");
        txt = new FicheiroTexto();
        
        // CARREGAR DADOS DO FILE
        carregarDadosCarros();
        
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
    	doneL = new ImageIcon("./resources/images/doneL.png");
    	doneP = new ImageIcon("./resources/images/doneP.png");
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
        
        //TITULO
        mainLabel = new JLabel("                   Dados do Carro");
        mainLabel.setFont(titulo);
        mainLabel.setForeground(Color.WHITE);
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
         // LABEL - CODIGO
        codigoLabel = new JLabel("Codigo:");
        codigoLabel.setFont(fonte);
        codigoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 120, 5, 10);
        cont.add(codigoLabel, gbc);
        
        // CODIGO CONT
        codigoVal = new JLabel("");
        codigoVal.setFont(fontePlain);
        codigoVal.setForeground(Color.WHITE);
        codigoVal.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 350);
        cont.add(codigoVal, gbc);
        
        // LABEL - MARCA
        marcaLabel = new JLabel("Marca:");
        marcaLabel.setFont(fonte);
        marcaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 120, 5, 10);
        cont.add(marcaLabel, gbc);
        
        // CRIAR ARRAY DE MARCAS UNICAS
        marcasArray = obterMarcasUnicas();
        marcaCombo = new JComboBox(marcasArray);
        marcaCombo.setFont(fonteCB);
        marcaCombo.setPreferredSize(new Dimension(250, 35));
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 300);
        cont.add(marcaCombo, gbc);
        
        // LABEL - ERRO PARA MARCA
        marcaErroLabel = new JLabel(" ");
        marcaErroLabel.setFont(fonteErro);
        marcaErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 100, 10, 20);
        cont.add(marcaErroLabel, gbc);
        
        // LABEL - MODELO
        modeloLabel = new JLabel("Modelo:");
        modeloLabel.setFont(fonte);
        modeloLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 120, 5, 10);
        cont.add(modeloLabel, gbc);
        
        // COMBOBOX - MODELO
        modeloCombo = new JComboBox(new String[]{"Escolha o Modelo"});
        modeloCombo.setFont(fonteCB);
        modeloCombo.setPreferredSize(new Dimension(250, 35));
        modeloCombo.setEnabled(false);
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.gridwidth = 1; 
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 100, 5, 300);
        cont.add(modeloCombo, gbc);
        
        // LABEL - ERRO PARA MODELO
        modeloErroLabel = new JLabel(" ");
        modeloErroLabel.setFont(fonteErro);
        modeloErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 100, 10, 20);
        cont.add(modeloErroLabel, gbc);
        
        // LABEL - CILINDRADA
        cilindradaLabel = new JLabel("Cilindrada:");
        cilindradaLabel.setFont(fonte);
        cilindradaLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 120, 5, 10);
        cont.add(cilindradaLabel, gbc);
        
        // CILINDRADA - APARECE DE ACORDO COM O CARRO QUE ESCOLHE
        cilindradaVal = new JLabel("");
        cilindradaVal.setFont(fontePlain);
        cilindradaVal.setForeground(Color.WHITE);
        cilindradaVal.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 350);
        cont.add(cilindradaVal, gbc);
        
        // LABEL - ESTADO
        estadoLabel = new JLabel("Estado:");
        estadoLabel.setFont(fonte);
        estadoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 120, 5, 10);
        cont.add(estadoLabel, gbc);
        
        //RADIO BUTTON E PAINEL PARA ESTADO DA COMPRA
        radioPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        radioPanel.setBackground(corPrincipal);
        
        radioTransito = new JRadioButton("Em Transito", false);
        radioTransito.setFont(fontePlain);
        radioTransito.setForeground(Color.WHITE);
        radioTransito.setBackground(corPrincipal);
        
        radioProcessamento = new JRadioButton("Em Processamento", false);
        radioProcessamento.setFont(fontePlain);
        radioProcessamento.setForeground(Color.WHITE);
        radioProcessamento.setBackground(corPrincipal);
        
        radioEntregaConcluida = new JRadioButton("Entrega Concluída", false);
        radioEntregaConcluida.setFont(fontePlain);
        radioEntregaConcluida.setForeground(Color.WHITE);
        radioEntregaConcluida.setBackground(corPrincipal);
        
        estadoGroup = new ButtonGroup();
        estadoGroup.add(radioTransito);
        estadoGroup.add(radioProcessamento);
        estadoGroup.add(radioEntregaConcluida);
        
        radioPanel.add(radioTransito);
        radioPanel.add(radioProcessamento);
        radioPanel.add(radioEntregaConcluida);
        
        gbc.gridx = 1; gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 20);
        cont.add(radioPanel, gbc);
        
        // LABEL - ERRO PARA ESTADO
        estadoErroLabel = new JLabel(" ");
        estadoErroLabel.setFont(fonteErro);
        estadoErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 10, 10, 20);
        cont.add(estadoErroLabel, gbc);
        
        // LABEL - DATA DA COMPRA
        dataCompraLabel = new JLabel("Data da Compra: ");
        dataCompraLabel.setFont(fonte);
        dataCompraLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 120, 5, 10);
        cont.add(dataCompraLabel, gbc);
        
        dataPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        dataPanel.setBackground(corPrincipal);
        
        // DIA
        diasArr = new String[32];
        diasArr[0] = "Dia";
        for(int i = 1; i < 32; i++) 
            diasArr[i] = String.format("%02d", i);
        
        diaCombo = new JComboBox(diasArr);
        diaCombo.setFont(fonteCB);
        diaCombo.setPreferredSize(new Dimension(80, 35));
        
        // MES
        mesCombo = new JComboBox(mesesArr);
        mesCombo.setFont(fonteCB);
        mesCombo.setPreferredSize(new Dimension(100, 35));
        
        //ANO
        anoLabel = new JLabel("2025");
        anoLabel.setFont(fontePlain);
        anoLabel.setForeground(Color.WHITE);
        anoLabel.setPreferredSize(new Dimension(80, 35));
        
        dataPanel.add(diaCombo);
        dataPanel.add(mesCombo);
        dataPanel.add(anoLabel);
        
        gbc.gridx = 1; gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 10, 5, 250);
        cont.add(dataPanel, gbc);
        
        // LABEL - ERRO PARA DATA
        dataErroLabel = new JLabel(" ");
        dataErroLabel.setFont(fonteErro);
        dataErroLabel.setForeground(red);
        gbc.gridx = 1; gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 100, 10, 20);
        cont.add(dataErroLabel, gbc);
        
        // LABEL - PRECO BASE
        precoBaseLabel = new JLabel("Preço Base: ");
        precoBaseLabel.setFont(fonte);
        precoBaseLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 120, 5, 10);
        cont.add(precoBaseLabel, gbc);
        
        // PRECO BASE - APARECE DE ACORDO COM O CARRO QUE ESCOLHE
        precoBaseVal = new JLabel("");
        precoBaseVal.setFont(fontePlain);
        precoBaseVal.setForeground(Color.WHITE);
        precoBaseVal.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1; gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 350);
        cont.add(precoBaseVal, gbc);
        
        // BOTOES
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
        btnVoltar.setPreferredSize(new Dimension(140, 40));
        
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
        
        btnGuardar = new JButton("Guardar", doneP);
        btnGuardar.setRolloverIcon(doneL);
        btnGuardar.setFont(fonteButton);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setBackground(laranjaBase);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnGuardar.setOpaque(true);
        btnGuardar.setPreferredSize(new Dimension(140, 40));
        
        
        btnVoltar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                switch(tipo.toUpperCase())
                {
                	case "E": 	new TelaResEmpresarial(lista, nome, contato, tipo, qtdCarros, tipoEmpresarial, nomeInst, manutencao, nomeComercial, true);
                							dispose();
                							break;
                		
                	case "P":		new TelaResParticular(lista, nome, contato, tipo, tipoUso, tipoParticular, estrangeiro, dataConclusao, anos, true);
                							dispose();
                							break;
                }
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                existemDados();
            }
        });
        
        btnGuardar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                processarDados(lista, nome, contato, tipo, tipoUso, tipoParticular, estrangeiro, anos, dataConclusao, qtdCarros, tipoEmpresarial, nomeInst, manutencao, nomeComercial);
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
	    
	    btnGuardar.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	            btnGuardar.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            btnGuardar.setBackground(laranjaBase);
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
        buttonPanel.add(btnGuardar);
        
        gbc.gridx = 0; gbc.gridy = 13;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(30, 20, 20, 20);
        cont.add(buttonPanel, gbc);
        
        // Event Listeners
        marcaCombo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                int marcaSelecionada = marcaCombo.getSelectedIndex();
                
                if(marcaSelecionada == 0) 
                {
                    // Se "Escolha a Marca" estiver selecionado
                    atualizarModeloCombo(new String[]{"Escolha o Modelo"});
                    modeloCombo.setEnabled(false);
                    limparDadosVeiculo();
                } else 
                {
                    // Atualizar modelos baseado na marca selecionada
                    modelosDaMarca = obterModelosPorMarca(marcaSelecionada);
                    atualizarModeloCombo(modelosDaMarca);
                    modeloCombo.setEnabled(true);
                    limparDadosVeiculo();
                }
                
                // Limpar erro de marca quando selecionada
                if(marcaSelecionada > 0) 
                {
                    marcaErroLabel.setText(" ");
                }
            }
        });
        
        modeloCombo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	int marcaInd, modeloInd, CarroInd;
            	Carro carroSelecionado;
            	
                if(modeloCombo.getSelectedIndex() > 0 && marcaCombo.getSelectedIndex() > 0) 
                {
                    marcaInd = marcaCombo.getSelectedIndex();
                    modeloInd = modeloCombo.getSelectedIndex();
                    
                    // Buscar índice do carro selecionado
                    CarroInd = obterIndiceCarro(marcaInd, modeloInd);
                    
                    if(CarroInd != -1) 
                    {
                        carroSelecionado = (Carro) carros.get(CarroInd);
                        codigoVal.setText(String.valueOf(carroSelecionado.getCodigo()));
                        cilindradaVal.setText(cil.format(carroSelecionado.getCilindrada()));
                        precoBaseVal.setText(mt.format(carroSelecionado.getPreco()));
                        
                        // Limpar erro de modelo quando selecionado
                        modeloErroLabel.setText(" ");
                    }
                } else 
                {
                    limparDadosVeiculo();
                }
            }
        });
        
        setResizable(false);
        setSize(1000, 750);
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
    
    // Método para atualizar JComboBox 
    private void atualizarModeloCombo(String[] novosItens) 
    {
    	//Tendo em conta que o combobox usa um arraylist por trás, essa é a forma mais segura de atualiza-lo
        modeloCombo.removeAllItems();
        for(int i = 0; i < novosItens.length; i++) 
        {
            modeloCombo.addItem(novosItens[i]);
        }
    }
    
    // Método para carregar dados do arquivo DadosCarros.txt usando objeto Carro
    private void carregarDadosCarros() 
    {
    	String linha, marca, modelo;
    	StringTokenizer token;
    	int cilindrada;
    	float preco;
    	
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("./resources/data/DadosCarros.txt"));
            linha = br.readLine();
            
            while(linha != null) 
            {
                token = new StringTokenizer(linha, ";");
                
                marca = token.nextToken();
                modelo = token.nextToken();
                cilindrada = Integer.parseInt(token.nextToken());
                preco = Float.parseFloat(token.nextToken());
                
                // Criar objeto Carro e adicionar à lista
                Carro carro = new Carro(marca, modelo, cilindrada, preco);
                
                carros.add(carro);
                
                linha = br.readLine();
            }
            carros.trimToSize();
            br.close();
        } catch(FileNotFoundException fnf) { new TelaMsg("Cadastro Cliente", "Ficheiro com os Dados dos Carros não foi encontrado!", "Contacte o Suporte do Sistema!"); }
		catch(NumberFormatException nf) { new TelaMsg("Cadastro Cliente", nf.getMessage(), "Contacte o Suporte do Sistema!"); }
		catch(IOException io) { new TelaMsg("Cadastro Cliente", io.getMessage(), "Contacte o Suporte do Sistema!"); }
    }
    
    // Método para obter marcas únicas
    private String[] obterMarcasUnicas()
    {
        String marcasTemp[], marcasUnicas[], marca;
        int contador = 1;
        boolean existe = false;
        Carro aux;
        
        // Primeiro, contar quantas marcas únicas existem
        marcasTemp = new String[carros.size() + 1]; // +1 para "Escolha a Marca"
        marcasTemp[0] = "Escolha a Marca";
        
        for(int i = 0; i < carros.size(); i++)
        {
            aux = (Carro) carros.get(i);
            marca = aux.getMarca();
            
            existe = false; // RESET DA VARIÁVEL EXISTE
            
            // Verificar se a marca já existe no array
            for(int j = 0; j < contador; j++)
            {
                if(marcasTemp[j].equals(marca))
                {
                    existe = true;
                    break;
                }
            }
            
            // Se não existe, adicionar
            if(!existe)
            {
                marcasTemp[contador] = marca;
                contador++;
            }
        }
        
        // Criar array final com o tamanho correto
        marcasUnicas = new String[contador];
        for(int i = 0; i < contador; i++)
        {
            marcasUnicas[i] = marcasTemp[i];
        }
        
        return marcasUnicas;
    }
    
    // Método para obter modelos de uma marca específica
    private String[] obterModelosPorMarca(int marcaIndex)
    {
        // Obter marcas únicas primeiro
        String marcasUnicas[], marcaSelecionada, modelo, modelosTemp[], modelosDaMarca[];
        Carro aux;
        int contador = 1;
        boolean existe = false;
        
        marcasUnicas = obterMarcasUnicas();
        marcaSelecionada = marcasUnicas[marcaIndex];
        
        // Array temporário para armazenar modelos
        modelosTemp = new String[carros.size() + 1]; // +1 para "Escolha o Modelo"
        modelosTemp[0] = "Escolha o Modelo";
        
        for(int i = 0; i < carros.size(); i++)
        {
            aux = (Carro) carros.get(i);
            if(aux.getMarca().equals(marcaSelecionada))
            {
                modelo = aux.getModelo();
                
                // Verificar se o modelo já existe no array
                for(int j = 0; j < contador; j++)
                {
                    if(modelosTemp[j].equals(modelo))
                    {
                        existe = true;
                        break;
                    }
                }
                
                // Se não existe, adicionar
                if(!existe)
                {
                    modelosTemp[contador] = modelo;
                    contador++;
                }
            }
        }
        
        // Criar array final com o tamanho correto
        modelosDaMarca = new String[contador];
        for(int i = 0; i < contador; i++)
        {
            modelosDaMarca[i] = modelosTemp[i];
        }
        
        return modelosDaMarca;
    }
    
    // Método para obter o índice do carro selecionado
    private int obterIndiceCarro(int indMarca, int indModelo) 
    {
        String modelosDaMarca[], marcasUnicas[];
        String marcaSelecionada, modeloSelecionado ;
        Carro aux;
        
        marcasUnicas = obterMarcasUnicas();
        marcaSelecionada = marcasUnicas[indMarca];
        
        modelosDaMarca = obterModelosPorMarca(indMarca);
        modeloSelecionado = modelosDaMarca[indModelo];
        
        for(int i = 0; i < carros.size(); i++) 
        {
            aux = (Carro) carros.get(i);
            if(aux.getMarca().equals(marcaSelecionada) && aux.getModelo().equals(modeloSelecionado)) 
            {
                return i; // Retorna o índice do carro encontrado
            }
        }
        return -1; // Retorna -1 se não encontrar o carro
    }

    private boolean existemDados()
    {
    	// Verificar se há dados digitados
        boolean temDados = 	!codigoVal.getText().trim().isEmpty() || 
        					!radioEntregaConcluida.getText().trim().isEmpty() ||
        					!radioProcessamento.getText().trim().isEmpty() ||
        					!radioTransito.getText().trim().isEmpty() ||
                          	diaCombo.getSelectedIndex() > 0 ||
                          	mesCombo.getSelectedIndex() > 0;
        
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
    
    private void limparDadosVeiculo() 
    {
        codigoVal.setText("");
        cilindradaVal.setText("");
        precoBaseVal.setText("");
    }
    
    private void limparErros()
    {
        marcaErroLabel.setText(" ");
        modeloErroLabel.setText(" ");
        estadoErroLabel.setText(" ");
        dataErroLabel.setText(" ");
    }
    
    private void processarDados(ArrayList lista, String nome, long contato, String tipo, String tipoUso, String tipoParticular, 
    		String estrangeiro, int anos, String dataConclusao, int qtdCarros, String tipoEmpresarial, String nomeInst, 
    		String manutencao, String nomeComercial) 
    {
        boolean valido = true;
        String dia, mes, ano, estado, dataCompra;
        Carro aux;
        
        // Limpar erros anteriores
        limparErros();
        
        // Validar marca
        if(marcaCombo.getSelectedIndex() == 0) 
        {
            marcaErroLabel.setText("* Por favor, selecione uma marca");
            valido = false;
        }
        
        // Validar modelo
        if(modeloCombo.getSelectedIndex() == 0) 
        {
            modeloErroLabel.setText("* Por favor, selecione um modelo");
            valido = false;
        }
        
        // Verificar se um estado foi selecionado
        if(!radioTransito.isSelected() && !radioProcessamento.isSelected() && !radioEntregaConcluida.isSelected()) 
        {
            estadoErroLabel.setText("* Por favor, selecione um estado");
            valido = false;
        }
        
        // Verificar se uma data foi selecionada
        if(diaCombo.getSelectedIndex() == 0 || mesCombo.getSelectedIndex() == 0) 
        {
            dataErroLabel.setText("* Por favor, selecione uma data válida");
            valido = false;
        }
        
        // Se todos os dados são válidos
        if(valido) 
        {
        	// Obter valores selecionados
        	dia = diasArr[diaCombo.getSelectedIndex()];
        	int mesInd = mesCombo.getSelectedIndex();
        	mes = String.format("%02d", mesInd);
        	ano = anoLabel.getText();
        	dataCompra = dia + "/" + mes + "/" + ano;
            
            estado = "";
            
            if(radioTransito.isSelected()) 
                estado = "Em Transito";
            else if(radioProcessamento.isSelected()) 
                    estado = "Em Processamento";
            else if(radioEntregaConcluida.isSelected()) 
                    estado = "Entrega Concluida";
            
            // Obter o índice do carro selecionado
            int indiceCarro = obterIndiceCarro(marcaCombo.getSelectedIndex(), modeloCombo.getSelectedIndex());
            
            if(indiceCarro != -1) 
            {
            	Cliente obj = null;
                aux = (Carro) carros.get(indiceCarro);
                
                switch(tipo.toUpperCase()) 
                {
		                case "P":	tipo = "Particular";
		                			switch(tipoParticular.toUpperCase()) 
				                    {
				                        case "D":	obj = new Doutorado(contato, nome, dataCompra, estado, aux.getCodigo(), aux.getMarca(), aux.getModelo(), aux.getCilindrada(), aux.getPreco(), tipoUso, dataConclusao);
				                        			tipoParticular = "Doutorado";
						                            break;
						                            
				                        case "N":	obj = new Normal(contato, nome, dataCompra, estado, aux.getCodigo(), aux.getMarca(), aux.getModelo(), aux.getCilindrada(), aux.getPreco(), tipoUso, estrangeiro, anos);
				                        			tipoParticular = "Normal";
						                            break;  
				                    }
				                    break;
				                    
		                case "E": 	tipo = "Empresarial";
		                			switch(tipoEmpresarial.toUpperCase()) 
				                    {
				                        case "S": 	obj = new Estado(contato, nome, dataCompra, estado, aux.getCodigo(), aux.getMarca(), aux.getModelo(), aux.getCilindrada(), aux.getPreco(), qtdCarros, nomeInst, manutencao);
							                        tipoEmpresarial = "Estado";
						                            break;
						                            
				                        case "R":	obj = new Revendedor(contato, nome, dataCompra, estado, aux.getCodigo(), aux.getMarca(), aux.getModelo(), aux.getCilindrada(), aux.getPreco(), qtdCarros, nomeComercial);
							                        tipoEmpresarial = "Revendedor";
						                            break;  
				                    }
				                    break;
                	}
                
                // Verifique se obj foi criado corretamente antes de registrar
                if (obj != null) 
                {
                    lista.add(obj);
                    int indice = lista.indexOf(obj);
                    txt.registrarClientes(lista);
                    new TelaRecibo(lista, indice);
                }
                else
                    new TelaMsg("Tela Registro", "Falha ao Registrar o cliente", "Contacte o Suporte do Sistema!"); 
            }
            
            // Fechar a janela
            dispose();
        }
    }
}