package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaResParticular extends JFrame
{
    private JLabel logoLabel, mainLabel, tipoUsoLabel, tipoParticularLabel, estrangeiroLabel, anosLabel, conclusaoLabel, tipoUsoErroLabel, tipoParticularErroLabel, estrangeiroErroLabel, anosErroLabel, conclusaoErroLabel;
    private JRadioButton radioPessoal, radioProfissional, radioNormal, radioDoutorado, radioSim, radioNao;
    private JComboBox anosCombo, diaCombo, mesCombo, anoCombo;
    private JButton btnVoltar, btnCancelar, btnContinuar;
    private JPanel painelTopo, radioPanel1, radioPanel2, radioPanel3, dataPanel, buttonPanel;
    private ButtonGroup tipoUsoGroup, tipoParticularGroup, estrangeiroGroup;
    private ImageIcon logo, volL, volP, contL, contP, canL, canP;
    private Container cont;
    private GridBagConstraints gbc;
    private String[] diasArr, mesesArr = {"Mes", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}, anosDataArr, anosArr;
    
    public TelaResParticular(ArrayList lista, String nome, long contato, String tipo, String tipoUso, String tipoParticular, String EsteveEstrangeiro, String dataConclusao, int qtdAnos, boolean voltou)
    {
        super("Tela Registro");
        
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	
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
        
        //TITULO
        mainLabel = new JLabel("     Registro de Cliente Particular");
        mainLabel.setFont(titulo);
        mainLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
        //LABEL - TIPO DE USO
        tipoUsoLabel = new JLabel("Tipo de Uso:");
        tipoUsoLabel.setFont(fonte);
        tipoUsoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(15, 20, 5, 10);
        cont.add(tipoUsoLabel, gbc);
        
        //RADIO BUTTON E PAINEL PARA TIPO DE USO
        radioPanel1 = new JPanel(new GridLayout(1, 2, 50, 0));
        radioPanel1.setBackground(corPrincipal);
        
        radioPessoal = new JRadioButton("Pessoal", false);
        radioPessoal.setFont(fontePlain);
        radioPessoal.setForeground(Color.WHITE);
        radioPessoal.setBackground(corPrincipal);
        radioProfissional = new JRadioButton("Profissional", false);
        radioProfissional.setFont(fontePlain);
        radioProfissional.setForeground(Color.WHITE);
        radioProfissional.setBackground(corPrincipal);
        
        tipoUsoGroup = new ButtonGroup();
        tipoUsoGroup.add(radioPessoal);
        tipoUsoGroup.add(radioProfissional);
        
        radioPanel1.add(radioPessoal);
        radioPanel1.add(radioProfissional);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 80);
        cont.add(radioPanel1, gbc);
        
        // LABEL - ERRO PARA TIPO DE USO
        tipoUsoErroLabel = new JLabel(" ");
        tipoUsoErroLabel.setFont(fonteErro);
        tipoUsoErroLabel.setForeground(Color.red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.insets = new Insets(0, 120, 10, 20);
        cont.add(tipoUsoErroLabel, gbc);
        
        // LABEL - TIPO DE PARTICULAR
        tipoParticularLabel = new JLabel("Tipo de Particular:");
        tipoParticularLabel.setFont(fonte);
        tipoParticularLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 10);
        cont.add(tipoParticularLabel, gbc);
        
        //RADIO BUTTON E PAINEL PARA TIPO DE PARTICULAR
        radioPanel2 = new JPanel(new GridLayout(1, 2, 63, 0));
        radioPanel2.setBackground(corPrincipal);
        
        radioNormal = new JRadioButton("Normal", false);
        radioNormal.setFont(fontePlain);
        radioNormal.setForeground(Color.WHITE);
        radioNormal.setBackground(corPrincipal);
        
        radioDoutorado = new JRadioButton("Doutorado", false);
        radioDoutorado.setFont(fontePlain);
        radioDoutorado.setForeground(Color.WHITE);
        radioDoutorado.setBackground(corPrincipal);
        
        tipoParticularGroup = new ButtonGroup();
        tipoParticularGroup.add(radioNormal);
        tipoParticularGroup.add(radioDoutorado);
        
        radioPanel2.add(radioNormal);
        radioPanel2.add(radioDoutorado);
        
        gbc.gridx = 1; gbc.gridy = 3;        
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 85);
        cont.add(radioPanel2, gbc);
        
        //LABEL - ERRO PARA TIPO DE PARTICULAR
        tipoParticularErroLabel = new JLabel(" ");
        tipoParticularErroLabel.setFont(fonteErro);
        tipoParticularErroLabel.setForeground(Color.red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.insets = new Insets(0, 120, 10, 20);
        cont.add(tipoParticularErroLabel, gbc);
        
        // LABEL - ESTEVE NO ESTRANGEIRO
        estrangeiroLabel = new JLabel("Esteve no Estrangeiro:");
        estrangeiroLabel.setFont(fonte);
        estrangeiroLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 10);
        cont.add(estrangeiroLabel, gbc);
        
        //RADIO BUTTON E PAINEL PARA ESTEVE NO ESTRANGEIRO
        radioPanel3 = new JPanel(new GridLayout(1, 2, 117, 0));
        radioPanel3.setBackground(corPrincipal);
        
        radioSim = new JRadioButton("Sim", false);
        radioSim.setFont(fontePlain);
        radioSim.setForeground(Color.WHITE);
        radioSim.setBackground(corPrincipal);
        radioSim.setEnabled(false);
        
        radioNao = new JRadioButton("Não", false);
        radioNao.setFont(fontePlain);
        radioNao.setForeground(Color.WHITE);
        radioNao.setBackground(corPrincipal);
        radioNao.setEnabled(false);
        
        estrangeiroGroup = new ButtonGroup();
        estrangeiroGroup.add(radioSim);
        estrangeiroGroup.add(radioNao);
        
        radioPanel3.add(radioSim);
        radioPanel3.add(radioNao);
        
        gbc.gridx = 1; gbc.gridy = 5;   
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(15, 10, 5, 133);
        cont.add(radioPanel3, gbc);
        
        //LABEL - ERRO PARA ESTRANGEIRO
        estrangeiroErroLabel = new JLabel(" ");
        estrangeiroErroLabel.setFont(fonteErro);
        estrangeiroErroLabel.setForeground(Color.red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.insets = new Insets(0, 120, 10, 20);
        cont.add(estrangeiroErroLabel, gbc);
        
        //LABEL - QUANT DE ANOS
        anosLabel = new JLabel("Nr de anos fora:");
        anosLabel.setFont(fonte);
        anosLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 10);
        cont.add(anosLabel, gbc);
        
        //ARRAY DE QUANTIDADE PARA O COMBOBOX
        anosArr = new String[75];
        anosArr[0] = "Nr Anos";
        for(int i = 1; i < 75; i++) 
        	anosArr[i] = String.valueOf(i);
        
        //COMBOBOX QUANTIDADE
        anosCombo = new JComboBox(anosArr);
        anosCombo.setFont(fonteCB); 
        anosCombo.setPreferredSize(new Dimension(150, 35));
        anosCombo.setEnabled(false);
        gbc.gridx = 1; gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 250, 5, 20);
        cont.add(anosCombo, gbc);
        
        //LABEL - ERRO PARA ANOS
        anosErroLabel = new JLabel(" ");
        anosErroLabel.setFont(fonteErro);
        anosErroLabel.setForeground(Color.red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 8;
        gbc.insets = new Insets(0, 65, 10, 20);
        cont.add(anosErroLabel, gbc);
        
        //LABEL - DATA DE CONCLUSAO DO DOTOURAMENTO
        conclusaoLabel = new JLabel("Data de Conclusão: ");
        conclusaoLabel.setFont(fonte);
        conclusaoLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 20, 5, 10);
        cont.add(conclusaoLabel, gbc);
        
        dataPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        dataPanel.setBackground(corPrincipal);
        
        //ARRAY DE NR DE DIAS PARA O COMBOBOX
        diasArr = new String[31];
        diasArr[0] = "Dia";
        for(int i = 1; i < 31; i++) 
        	diasArr[i] =  String.format("%02d", (i));
        
        //COMBOBOX DIAS
        diaCombo = new JComboBox(diasArr);
        diaCombo.setFont(fonteCB);
        diaCombo.setPreferredSize(new Dimension(80, 35));
        diaCombo.setEnabled(false);
        
        //COMBOBOX MES
        mesCombo = new JComboBox(mesesArr);
        mesCombo.setFont(fonteCB);
        mesCombo.setPreferredSize(new Dimension(100, 35));
        mesCombo.setEnabled(false);
        
        //ARRAY DE ANOS PARA O COMBOBOX
        anosDataArr = new String[76];
        anosDataArr[0] = "Anos";
        for(int i = 1; i < 76; i++) 
            anosDataArr[i] = String.valueOf(1949 + i);
        
        //COMBOBOX ANOS
        anoCombo = new JComboBox(anosDataArr);
        anoCombo.setFont(fonteCB);
        anoCombo.setPreferredSize(new Dimension(120, 35));
        anoCombo.setEnabled(false);
        
        dataPanel.add(diaCombo);
        dataPanel.add(mesCombo);
        dataPanel.add(anoCombo);
        
        gbc.gridx = 1; gbc.gridy = 9;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 70, 5, 20);
        cont.add(dataPanel, gbc);
        
        //LABEL - ERRO PARA DATA DE CONCLUSAO
        conclusaoErroLabel = new JLabel(" ");
        conclusaoErroLabel.setFont(fonteErro);
        conclusaoErroLabel.setForeground(Color.red);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1; gbc.gridy = 10;
        gbc.insets = new Insets(0, 80, 15, 20);
        cont.add(conclusaoErroLabel, gbc);
        
        //BOTOES
        buttonPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        buttonPanel.setBackground(corPrincipal);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(fonteButton);

        // Cor laranja moderna 
        Color laranjaModerna = new Color(255, 102, 0); 

        btnVoltar.setBackground(laranjaModerna);
        btnVoltar.setForeground(Color.WHITE);

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
        voltamOsDados(voltou, tipoUso, tipoParticular, EsteveEstrangeiro, dataConclusao, qtdAnos);
        
        btnVoltar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                new TelaRegistrar(lista, nome, tipo,contato, true);
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
                processarDados(lista, nome, contato, tipo);;
            }
        });
        
        radioNormal.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    radioSim.setEnabled(true);
                    radioNao.setEnabled(true);
                    
                    diaCombo.setEnabled(false);
                    mesCombo.setEnabled(false);
                    anoCombo.setEnabled(false);
                    diaCombo.setSelectedIndex(0);
                    mesCombo.setSelectedIndex(0);
                    anoCombo.setSelectedIndex(0);
                }
            }
        });
        
        radioDoutorado.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    // Desabilitar campos de estrangeiro
                    radioSim.setEnabled(false);
                    radioNao.setEnabled(false);
                    estrangeiroGroup.clearSelection();
                    
                    // Desabilitar e resetar quantidade de anos
                    anosCombo.setEnabled(false);    	
                    anosCombo.setSelectedIndex(0);
                    
                    // Habilitar campos de data
                    diaCombo.setEnabled(true);
                    mesCombo.setEnabled(true);
                    anoCombo.setEnabled(true);
                }
            }
        });
        
        radioSim.addItemListener(new ItemListener() 
        {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    anosCombo.setEnabled(true);
                }
            }
        });
        
        radioNao.addItemListener(new ItemListener() 
        {	
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    anosCombo.setEnabled(false);    	
                    anosCombo.setSelectedIndex(0);
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
                          	!radioDoutorado.getText().trim().isEmpty() ||
                          	!radioNormal.getText().trim().isEmpty() || 
                          	!radioProfissional.getText().trim().isEmpty() ||
                          	!radioPessoal.getText().trim().isEmpty() ||
                          	anoCombo.getSelectedIndex() > 0 ||
                          	anosCombo.getSelectedIndex() > 0 ||
                          	diaCombo.getSelectedIndex() > 0 ||
                          	mesCombo.getSelectedIndex() > 0 ;
        
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
        String tipoUso = "", tipoParticular = "", estrangeiro = "", dataConclusao = "", dia, mes, ano;
        int anosFora = 0;
        
        // Limpar erros anteriores
        limparErros();
        
        // Validar Tipo de Uso
        if(radioProfissional.isSelected()) 
            tipoUso = "Profissional";
        else if(radioPessoal.isSelected()) 
            tipoUso = "Pessoal";
        else 
        {
            tipoUsoErroLabel.setText("* Selecione o tipo de uso");
            valido = false;
        }
        
        // Validar Tipo de Particular 
        if(radioDoutorado.isSelected()) 
            tipoParticular = "D";
        else if(radioNormal.isSelected()) 
            tipoParticular = "N";
        else 
        {
            tipoParticularErroLabel.setText("* Selecione o tipo de particular");
            valido = false;
        }
        
        // Validações específicas baseadas no tipo de particular
        if(radioNormal.isSelected()) 
        {
            // Para tipo Normal: validar apenas campos de estrangeiro
            if(radioSim.isSelected()) 
            {
                estrangeiro = "Sim";
                // Validar quantos anos se "Sim" foi selecionado
                if(anosCombo.getSelectedIndex() == 0) 
                {
                    anosErroLabel.setText("* Selecione quantos anos esteve no estrangeiro");
                    valido = false;
                }
                else 
                {
                    anosFora = Integer.parseInt(anosArr[anosCombo.getSelectedIndex()]);
                }
            }
            else if(radioNao.isSelected()) 
            {
                estrangeiro = "Nao";
            }
            else 
            {
                estrangeiroErroLabel.setText("* Selecione se esteve no estrangeiro");
                valido = false;
            }
        }
        else if(radioDoutorado.isSelected()) 
        {
            // Para tipo Doutorado: validar apenas data de conclusão
            if(diaCombo.getSelectedIndex() == 0 || mesCombo.getSelectedIndex() == 0 || anoCombo.getSelectedIndex() == 0) 
            {
                conclusaoErroLabel.setText("* Selecione uma data completa");
                valido = false;
            }
            else 
            {
                dia = diasArr[diaCombo.getSelectedIndex()];
                ano = anosDataArr[anoCombo.getSelectedIndex()];
                
                // Converter indice do mes selecionado para número formatado
                int mesInd = mesCombo.getSelectedIndex();
                mes = String.format("%02d", mesInd);
                
                dataConclusao = mes + "/" + dia + "/" + ano;
            }
        }
        
        //Se tudo estiver valido
        if(valido)
        {
     	   new TelaDadosCarro(lista, nome, contato, tipo, tipoUso, tipoParticular, estrangeiro, anosFora, dataConclusao, 0, "", "", "", "");
            
            limparCampos();
            dispose();
        }
    }
    
    private void limparErros()
    {
        tipoUsoErroLabel.setText(" ");
        tipoParticularErroLabel.setText(" ");
        estrangeiroErroLabel.setText(" ");
        anosErroLabel.setText(" ");
        conclusaoErroLabel.setText(" ");
    }
    
    private void limparCampos()
    {
    	tipoUsoGroup.clearSelection();
    	tipoParticularGroup.clearSelection(); 
    	estrangeiroGroup.clearSelection();
    	anoCombo.setSelectedIndex(0);
    	anosCombo.setSelectedIndex(0);
    	diaCombo.setSelectedIndex(0);
    	mesCombo.setSelectedIndex(0);
    	limparErros();
    }
    
    private void voltamOsDados(boolean voltou, String tipoUso, String tipoParticular, String EsteveEstrangeiro, String dataConclusao, int qtdAnos)
    {
        if(voltou)
        {
            // Restaurar Tipo Uso
            if(radioPessoal.getText().equalsIgnoreCase(tipoUso))
                radioPessoal.setSelected(true);
            else if(radioProfissional.getText().equalsIgnoreCase(tipoUso))
                    radioProfissional.setSelected(true);
            
            // Restaurar Tipo particular
            if(tipoParticular.equalsIgnoreCase("N"))
            {
            		radioNormal.setSelected(true);
            		
            		// Restaurar Esteve no estrangeiro
                    if(radioSim.getText().equalsIgnoreCase("Sim"))
                    {
                    	radioSim.setEnabled(true);
                    	radioSim.setSelected(true);
                    	
                    	if(radioSim.isSelected())
                    	{
                    		anosCombo.setEnabled(true);
                    		for(int i = 1; i < anosArr.length; i++)
                    			if(anosArr[i].equals(qtdAnos+""))
                    				anosCombo.setSelectedIndex(i);
                    	}
                    }
                    else if(radioNao.getText().equalsIgnoreCase("Não"))
                    {
            			radioNao.setSelected(true);
            			anosCombo.setSelectedIndex(0);
            			anosCombo.setEnabled(false);
                    }
            }
            else if(tipoParticular.equalsIgnoreCase("D"))
            {
    			radioDoutorado.setSelected(true);
    			anosCombo.setSelectedIndex(0);
    			anosCombo.setEnabled(false);
    			diaCombo.setEnabled(true);
                mesCombo.setEnabled(true);
                anoCombo.setEnabled(true); 	
    			
    			// Restaurar data apenas se não estiver vazia
                if(dataConclusao != null && !dataConclusao.isEmpty() && dataConclusao.contains("/"))
                {
                    StringTokenizer token = new StringTokenizer(dataConclusao, "/");
                    if(token.countTokens() == 3)
                    {
                        String dia = token.nextToken();
                        String mes = token.nextToken(); 
                        String ano = token.nextToken();
                        
                        // Restaurar dia
                        for(int i = 1; i < diasArr.length; i++)
                        {
                            if(diasArr[i].equals(dia))
                            {
                                diaCombo.setSelectedIndex(i);
                                break;
                            }
                        }
                        
                        // Restaurar mes
                        try 
                        {
                            int mesNumerico = Integer.parseInt(mes); // Converte o mes em indice, ex: "02" para 2
                            if(mesNumerico >= 1 && mesNumerico <= 12) 
                            {
                                mesCombo.setSelectedIndex(mesNumerico);
                            }
                        } catch(NumberFormatException e) 
                        {
                            // Se não conseguir converter, deixa no indice 0
                            mesCombo.setSelectedIndex(0);
                        }
                        
                        // Restaurar ano
                        for(int i = 1; i < anosDataArr.length; i++)
                        {
                            if(anosDataArr[i].equals(ano))
                            {
                                anoCombo.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                }
             }
        }
    }
}