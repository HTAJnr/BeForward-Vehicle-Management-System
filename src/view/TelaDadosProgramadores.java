package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaDadosProgramadores extends JFrame 
{
    private JPanel panel;
    private JButton btnAnterior, btnProximo, btnVoltar;
    private JLabel titulo, nome, contacto, codigo, nomeF, contactoF, codigoF;
    private Container cont;
    private int indiceAtual = 0;

    Color corPrincipal = new Color(26, 27, 30);
	Color laranjaBase = new Color(255, 106, 0);
	Color branco = new Color(255, 255, 255);

    private String[][] programadores = {
            {"Dikshy Guinésh", "202*****",  "+258 8********"},
            {"Saymara Chambal", "202*****", "+258 8********"},
            {"Hélder Júnior", "202*****", "+258 8********"},
    };

    public TelaDadosProgramadores() 
    {
        super("Perfil dos Programadores");
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        
        setSize(700, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        cont.setBackground(corPrincipal);
    	Font tit = new Font("Segoe UI", Font.BOLD, 36);      
    	Font fonte = new Font("SansSerif", Font.BOLD, 18);
    	Font fonteButton = new Font("SansSerif", Font.BOLD, 16);
    	
    	ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
    	
        // TITULO
        titulo = new JLabel("Dados dos Programadores", JLabel.CENTER);
        titulo.setFont(tit);
        titulo.setForeground(branco); 
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        cont.add(titulo, BorderLayout.NORTH);

        // Painel dos campos
        panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBackground(corPrincipal);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nome = new JLabel("                                Nome:");
        nome.setForeground(branco);
        nome.setFont(fonte);
        
        codigo = new JLabel("                               Codigo:");
        codigo.setForeground(branco);
        codigo.setFont(fonte);
        
        contacto = new JLabel("                               Contacto:");
        contacto.setForeground(branco);
        contacto.setFont(fonte);
        
        nomeF = new JLabel(" ");
        nomeF.setForeground(branco);
        nomeF.setFont(fonte);
        
        contactoF = new JLabel(" ");
        contactoF.setForeground(branco);
        contactoF.setFont(fonte);
        
        codigoF = new JLabel(" ");
        codigoF.setForeground(branco);
        codigoF.setFont(fonte);
        
        panel.add(nome);
        panel.add(nomeF);
        panel.add(codigo);
        panel.add(codigoF);
        panel.add(contacto);
        panel.add(contactoF);
        cont.add(panel, BorderLayout.CENTER);
        
        // Painel dos botoes
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(corPrincipal);

        btnAnterior = new JButton("Anterior");
        btnAnterior.setFont(fonteButton);
        btnAnterior.setBackground(laranjaBase);
        btnAnterior.setForeground(Color.WHITE);
        btnAnterior.setFocusPainted(false);
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnAnterior.setOpaque(true);
        btnAnterior.setPreferredSize(new Dimension(150, 40));
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(fonteButton);
        btnVoltar.setBackground(laranjaBase);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnVoltar.setOpaque(true);
        btnVoltar.setPreferredSize(new Dimension(150, 40));
        
        btnProximo = new JButton("Proximo");
        btnProximo.setFont(fonteButton);
        btnProximo.setBackground(laranjaBase);
        btnProximo.setForeground(Color.WHITE);
        btnProximo.setFocusPainted(false);
        btnProximo.setContentAreaFilled(false);
        btnProximo.setBorder(BorderFactory.createLineBorder(new Color(230, 120, 0), 2));
        btnProximo.setOpaque(true);
        btnProximo.setPreferredSize(new Dimension(150, 40));
        
        btnAnterior.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                navegar(-1);  // Chamada do método navegar para ir ao programador anterior
            }
        });

        btnProximo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                navegar(1);  // Chamada do método navegar para ir ao próximo programador
            }
        });

        btnVoltar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();         
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
	    
	    btnAnterior.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	    		btnAnterior.setBackground(corPrincipal);
	        }
	    	
	        public void mouseExited(MouseEvent evt) 
	        {
	        	btnAnterior.setBackground(laranjaBase);
	        }
	    });
	    
	    btnProximo.addMouseListener(new MouseAdapter() 
	    {
	    	public void mouseEntered(MouseEvent evt) 
	        {
	    		btnProximo.setBackground(corPrincipal);
	        }
	    	
	        public void mouseExited(MouseEvent evt) 
	        {
	        	btnProximo.setBackground(laranjaBase);
	        }
	    });
				
        buttonPanel.add(btnAnterior);
        buttonPanel.add(btnProximo);
        buttonPanel.add(btnVoltar);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        cont.add(buttonPanel, BorderLayout.SOUTH);

        atualizarDados();
        setVisible(true);
    }

    
    private void atualizarDados() 
    {
        nomeF.setText(programadores[indiceAtual][0]);
        codigoF.setText(programadores[indiceAtual][1]);
        contactoF.setText(programadores[indiceAtual][2]);
    }

    private void navegar(int direcao) 
    {
        if (direcao == -1) 
        {
        	// SE FOR O 1o ELEMENTO E TENTAR IR PARA O ANTERIOR, VOLTA PARA O ULTIMO
            if (indiceAtual == 0) 
                indiceAtual = programadores.length - 1;
            else 
                indiceAtual--;
        } 
        else 
        {
        	if (direcao == 1) 
        	{
        		
        		// SE FOR O ULTIMO ELEMENTO E TENTAR IR PARA O PROXIMO, VOLTA PARA O 1o
		        if (indiceAtual == programadores.length - 1) 
		            indiceAtual = 0;
		        else 
		            indiceAtual++;
        	}
        }

        atualizarDados();  // ACTUALIZA OS DADOS DPS DE MUDAR O INDICE
    }


    public static void main(String[] args) 
    {
        new TelaDadosProgramadores();
    }
}