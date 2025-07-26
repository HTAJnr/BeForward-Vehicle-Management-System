package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaMsg extends JFrame 
{
    private JLabel logoLabel, mensagemLabel, descricaoLabel;
    private JButton btnOK;
    private Container cont;
    private GridBagConstraints gbc;
    private JPanel painelTopo;
    
    public TelaMsg(String titulo, String mensagem, String descricao) 
    {
        super(titulo);
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
    	Color laranjaBase = new Color(255, 106, 0);
    	Color grey = new Color(190, 187, 183);
    	
        cont.setBackground(corPrincipal);
        
        ImageIcon logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
        
    	Font subtitulo = new Font("Segoe UI", Font.BOLD, 28);
    	Font fonte = new Font("SansSerif", Font.BOLD, 18);
    	Font fonteButton = new Font("SansSerif", Font.BOLD, 16);
        
        // PAINEL TOPO QUE CONTEM O LOGO CENTRALIZADO
        painelTopo = new JPanel();
        painelTopo.setLayout(new BorderLayout());
        painelTopo.setBackground(corPrincipal);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 40, 20);
        
        // LOGO CENTRALIZADA
        logoLabel = new JLabel(logo);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        painelTopo.add(logoLabel, BorderLayout.CENTER);
        cont.add(painelTopo, gbc);
        
        // Mensagem principal centralizada
        mensagemLabel = new JLabel(mensagem);
        mensagemLabel.setFont(subtitulo);
        mensagemLabel.setForeground(Color.WHITE);
        mensagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 30, 50);
        cont.add(mensagemLabel, gbc);
        
        // Descrição centralizada (se fornecida)
        if (descricao != null && !descricao.trim().isEmpty()) 
        {
            descricaoLabel = new JLabel(descricao);
            descricaoLabel.setFont(fonte);
            descricaoLabel.setForeground(grey);
            descricaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 50, 40, 50);
            cont.add(descricaoLabel, gbc);
        }
        
        // Botão OK centralizado
        btnOK = new JButton("OK");
        btnOK.setFont(fonteButton);
        btnOK.setBackground(laranjaBase);
        btnOK.setForeground(Color.WHITE);
        btnOK.setFocusPainted(false);
        btnOK.setContentAreaFilled(false);
        btnOK.setOpaque(true);
        btnOK.setPreferredSize(new Dimension(80, 40));
        
        // Efeito hover
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
        if(descricao != null && !descricao.trim().isEmpty()) 
        	gbc.gridy = 5; 
        else gbc.gridy =  4;
        
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 20, 0);
        cont.add(btnOK, gbc);
        
        // Configuração da janela
        setResizable(false);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}