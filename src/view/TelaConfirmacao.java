package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaConfirmacao extends JFrame 
{
    private JLabel logoLabel, mensagemLabel, descricaoLabel;
    JButton btnConfirmar; // Para Garantir acesso em outras telas
	private JButton btnCancelar;
    private Container cont;
    private GridBagConstraints gbc;
    private ImageIcon logo, conP, conL, canL, canP;
    private JPanel painelTopo, painelBotoes;
    private static boolean confirmado = false;
    
    public TelaConfirmacao(String titulo, String mensagem, String descricao) 
    {
        super(titulo);
        cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        Color corPrincipal = new Color(26, 27, 30);
        Color laranjaBase = new Color(255, 106, 0);
        Color grey = new Color(190, 187, 183);
        
        cont.setBackground(corPrincipal);
        
        logo = new ImageIcon("./resources/images/BeForward_LOGO.png");
      	canL = new ImageIcon("./resources/images/closeL.png");
      	canP = new ImageIcon("./resources/images/close.png");
      	conP = new ImageIcon("./resources/images/doneP.png");
      	conL = new ImageIcon("./resources/images/doneL.png");
        
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
        
        // Painel para os botões
        painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        painelBotoes.setBackground(corPrincipal);
        
        // Botão Confirmar
        btnConfirmar = new JButton("Confirmar", conP);
        btnConfirmar.setRolloverIcon(conL);
        btnConfirmar.setFont(fonteButton);
        btnConfirmar.setBackground(laranjaBase);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setOpaque(true);
        btnConfirmar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnConfirmar.setPreferredSize(new Dimension(110, 40));
        
        // Efeito hover botão Confirmar
        btnConfirmar.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent evt) 
            {
                btnConfirmar.setBackground(corPrincipal);
            }
            
            public void mouseExited(MouseEvent evt) 
            {
                btnConfirmar.setBackground(laranjaBase);
            }
        });
        
        // Botão Cancelar
        btnCancelar = new JButton("Cancelar", canP);
        btnCancelar.setRolloverIcon(canL);
        btnCancelar.setFont(fonteButton);
        btnCancelar.setBackground(laranjaBase);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.setBorder(BorderFactory.createLineBorder(new Color(230, 150, 0), 2));
        btnCancelar.setPreferredSize(new Dimension(100, 40));
        
        // Efeito hover botão Cancelar
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
        
        btnCancelar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                confirmado = false;
                dispose();
            }
        });
        
        addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                confirmado = false;
                dispose();
            }
        });
        
        painelBotoes.add(btnConfirmar);
        painelBotoes.add(btnCancelar);
        
        gbc.gridx = 0;
        if(descricao != null && !descricao.trim().isEmpty()) 
            gbc.gridy = 5; 
        else 
            gbc.gridy = 4;
        
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 20, 0);
        cont.add(painelBotoes, gbc);
        
        // Configuração da janela
        setResizable(false);
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
    }
    
    public static boolean confirmacao(String titulo, String mensagem, String descricao) 
    {
        confirmado = false;
        new TelaConfirmacao(titulo, mensagem, descricao);
        return confirmado;
    }
}