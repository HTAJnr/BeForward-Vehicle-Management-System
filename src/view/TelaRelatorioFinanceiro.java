package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TelaRelatorioFinanceiro extends JFrame 
{
    private JLabel logoLabel, tituloLabel, valorTotalLabel;
    private JButton btnOK;
    private Container cont;
    private GridBagConstraints gbc;
    private JPanel painelTopo;
    private DecimalFormat mt;
    
    public TelaRelatorioFinanceiro(String textoDescricao, float valorTotal) 
    {
        super(textoDescricao);
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	
        cont.setBackground(corPrincipal);
        
        mt = new DecimalFormat("###,###,##0.00 MT");
        
        ImageIcon logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
        
        Font titulo = new Font("Segoe UI", Font.BOLD, 26);
        Font valorFont = new Font("Segoe UI", Font.BOLD, 42);
        Font fonteButton = new Font("Segoe UI", Font.PLAIN, 14);
        
        // PAINEL TOPO QUE CONTEM O LOGO E O TITULO
        painelTopo = new JPanel();
        painelTopo.setLayout(new GridLayout(2, 1));
        painelTopo.setBackground(corPrincipal);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 40, 20);
        
        // LOGO
        logoLabel = new JLabel(logo);
        
        // TITULO - agora usa o textoDescricao
        tituloLabel = new JLabel(" " + textoDescricao);
        tituloLabel.setFont(titulo);
        tituloLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel);
        painelTopo.add(tituloLabel);
        cont.add(painelTopo, gbc);
        
        // LABEL - VALOR
        valorTotalLabel = new JLabel(mt.format(valorTotal));
        valorTotalLabel.setFont(valorFont);
        valorTotalLabel.setForeground(laranjaBase);
        valorTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 30, 50);
        cont.add(valorTotalLabel, gbc);
        
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
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 20, 0);
        cont.add(btnOK, gbc);
        
        setResizable(false);
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}