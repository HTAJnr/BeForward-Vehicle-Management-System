package view;

import javax.swing.*;

import model.*;

import java.awt.*;
import java.awt.event.*;

public class TelaQuantidadeClientes extends JFrame 
{
    private JLabel logoLabel, mainLabel;
    private JLabel particularLabel, empresarialLabel;
    private JLabel doutoradoLabel, normalLabel, revendedorLabel, estadoLabel;
    private JButton btnOK;
    private Container cont;
    private GridBagConstraints gbc;
    private JPanel painelTopo;
    
    public TelaQuantidadeClientes() 
    {
        super("Quantidade de Clientes");
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color grey = new Color(190, 187, 183);
        
        cont.setBackground(corPrincipal);

        Font titulo = new Font("Segoe UI", Font.BOLD, 28);
        Font fonte = new Font("Segoe UI", Font.BOLD, 20);
        
        ImageIcon logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
        ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
        
        // PAINEL TOPO QUE CONTEM O LOGO E O TITULO
        painelTopo = new JPanel();
        painelTopo.setLayout(new BorderLayout());
        painelTopo.setBackground(corPrincipal);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 20, 30, 20);
        
        // LOGO
        logoLabel = new JLabel(logo);
        
        // TITULO
        mainLabel = new JLabel("        Quantidade de Clientes      ");
        mainLabel.setFont(titulo);
        mainLabel.setForeground(Color.WHITE);
        
        painelTopo.add(logoLabel, BorderLayout.WEST);
        painelTopo.add(mainLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
        // CABECALHO PRINCIPAL - PARTICULAR E EMPRESARIAL
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        
        // LABEL - "PARTICULAR"
        particularLabel = new JLabel("Particular");
        particularLabel.setFont(fonte);
        particularLabel.setForeground(laranjaBase);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 20, 0);
        cont.add(particularLabel, gbc);
        
        // LABEL - "EMPRESARIAL"
        empresarialLabel = new JLabel("Empresarial");
        empresarialLabel.setFont(fonte);
        empresarialLabel.setForeground(laranjaBase);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        cont.add(empresarialLabel, gbc);
        
        // Linha dos subcabeçalhos
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        
        // Normal
        normalLabel = new JLabel("Normal");
        normalLabel.setFont(fonte);
        normalLabel.setForeground(laranjaBase);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 30, 10, 30);
        cont.add(normalLabel, gbc);
        
        // Doutorado
        doutoradoLabel = new JLabel("Doutorado");
        doutoradoLabel.setFont(fonte);
        doutoradoLabel.setForeground(laranjaBase);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 30, 10, 30);
        cont.add(doutoradoLabel, gbc);
        
        // Estado
        estadoLabel = new JLabel("Estado");
        estadoLabel.setFont(fonte);
        estadoLabel.setForeground(laranjaBase);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 30, 10, 30);
        cont.add(estadoLabel, gbc);
        
        // Revendedor
        revendedorLabel = new JLabel("Revendedor");
        revendedorLabel.setFont(fonte);
        revendedorLabel.setForeground(laranjaBase);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 30, 10, 30);
        cont.add(revendedorLabel, gbc);
        
        // Linha dos valores
        gbc.anchor = GridBagConstraints.CENTER;
        
        // Valor Normal
        JLabel normalValorLabel = new JLabel(String.valueOf(Normal.cNORMAL));
        normalValorLabel.setFont(fonte);
        normalValorLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 30, 25, 30);
        cont.add(normalValorLabel, gbc);
        
        // Valor Doutorado
        JLabel doutoradoValorLabel = new JLabel(String.valueOf(Doutorado.cDOUTORADO));
        doutoradoValorLabel.setFont(fonte);
        doutoradoValorLabel.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 30, 25, 30);
        cont.add(doutoradoValorLabel, gbc);
        
        // Valor Estado
        JLabel estadoValorLabel = new JLabel(String.valueOf(Estado.cESTADO));
        estadoValorLabel.setFont(fonte);
        estadoValorLabel.setForeground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 30, 25, 30);
        cont.add(estadoValorLabel, gbc);
        
        // Valor Revendedor
        JLabel revendedorValorLabel = new JLabel(String.valueOf(Revendedor.cREVENDEDOR));
        revendedorValorLabel.setFont(fonte);
        revendedorValorLabel.setForeground(Color.WHITE);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 30, 25, 30);
        cont.add(revendedorValorLabel, gbc);
        
        // Separator linha 
        JSeparator separator1 = new JSeparator();
        separator1.setForeground(grey);
        separator1.setBackground(grey);
        separator1.setPreferredSize(new Dimension(0, 2)); 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 30, 10, 30);
        cont.add(separator1, gbc);
        
        // Total de Clientes
        int totalClientes = Normal.cNORMAL + Doutorado.cDOUTORADO + Estado.cESTADO + Revendedor.cREVENDEDOR;
        JLabel totalLabel = new JLabel("Total de Clientes:  " + totalClientes);
        totalLabel.setFont(fonte);
        totalLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4; 
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 25, 0);
        cont.add(totalLabel, gbc);
        
        // Botão OK centralizado
        btnOK = new JButton("OK");
        btnOK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnOK.setBackground(laranjaBase);
        btnOK.setForeground(Color.WHITE);
        btnOK.setFocusPainted(false);
        btnOK.setContentAreaFilled(false);
        btnOK.setOpaque(true);
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
        gbc.gridy = 6;
        gbc.gridwidth = 4;
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