package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TelaSituacaoFinanceira extends JFrame 
{
    private JLabel logoLabel, tituloLabel, situacaoLabel, statusLabel, valorLabel, valorFormatadoLabel;
    private JButton btnOK;
    private Container cont;
    private GridBagConstraints gbc;
    private JPanel painelTopo;
    private DecimalFormat mt;
    
    public TelaSituacaoFinanceira(float valor) 
    {
        super("Situação Financeira");
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color red = new Color(255, 36 , 0);
    	Color green = new Color(34, 197, 94);
    	Color grey = new Color(190, 187, 183);
        
        
        cont.setBackground(corPrincipal);
        
        mt = new DecimalFormat("###,###,###.00 MT");
        
        ImageIcon logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
        ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());

        Font titulo = new Font("Segoe UI", Font.BOLD, 28);
        Font fonte = new Font("Segoe UI", Font.BOLD, 20);
        Font statusFont = new Font("Segoe UI", Font.BOLD, 24);
        Font valorFont = new Font("Segoe UI", Font.BOLD, 42);
        Font fonteButton = new Font("Segoe UI", Font.PLAIN, 14);
        
        // PAINEL TOPO QUE CONTEM O LOGO E O TITULO
        painelTopo = new JPanel();
        painelTopo.setLayout(new BorderLayout());
        painelTopo.setBackground(corPrincipal);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 40, 20);
        
        // LOGO
        logoLabel = new JLabel(logo);
        
        // TITULO
        tituloLabel = new JLabel("   Situação Financeira           ");
        tituloLabel.setFont(titulo);
        tituloLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(tituloLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
        // DETERMINAR SITUACAO E COR BASEADO NO VALOR
        String situacao;
        String valorTexto;
        Color corValor;
        
        if (valor > 0) 
        {
            situacao = "LUCRO";
            valorTexto = "Valor do lucro";
            corValor = green;
        } else 
        {
            situacao = "PREJUÍZO";
            valorTexto = "Valor em falta";
            corValor = red;
            valor = Math.abs(valor); // Converter para positivo
        }
        
        // LABEL - SITUACAO
        situacaoLabel = new JLabel("Situação");
        situacaoLabel.setFont(fonte);
        situacaoLabel.setForeground(grey);
        situacaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 10, 50);
        cont.add(situacaoLabel, gbc);
        
        // LABEL - STATUS (LUCRO/PREJUÍZO)
        statusLabel = new JLabel(situacao);
        statusLabel.setFont(statusFont);
        statusLabel.setForeground(corValor);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 30, 50);
        cont.add(statusLabel, gbc);
        
        // LABEL - TIPO DE VALOR
        valorLabel = new JLabel(valorTexto);
        valorLabel.setFont(fonte);
        valorLabel.setForeground(grey);
        valorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 10, 50);
        cont.add(valorLabel, gbc);
        
        // LABEL - VALOR
        valorFormatadoLabel = new JLabel(mt.format(valor));
        valorFormatadoLabel.setFont(valorFont);
        valorFormatadoLabel.setForeground(corValor);
        valorFormatadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 40, 50);
        cont.add(valorFormatadoLabel, gbc);
        
        // BOTAO
        btnOK = new JButton("OK");
        btnOK.setFont(fonteButton);
        btnOK.setBackground(laranjaBase);
        btnOK.setForeground(Color.WHITE);
        btnOK.setFocusPainted(false);
        btnOK.setContentAreaFilled(false);
        btnOK.setOpaque(true);
        btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOK.setPreferredSize(new Dimension(80, 40));
        
        btnOK.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	    		btnOK.setBackground(corPrincipal);
	        }
	        public void mouseExited(MouseEvent evt) 
	        {
	            btnOK.setBackground(laranjaBase);
	        }
	    });
        
        btnOK.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 20, 0);
        cont.add(btnOK, gbc);
        
        // Configuração da janela
        setResizable(false);
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}