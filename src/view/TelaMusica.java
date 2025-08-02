package view;

import javax.sound.sampled.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMusica extends JFrame
{
	private Container cont;
	private JLabel icon;
	private JPanel panel;
	private JButton play, pause, reset;
	private ImageIcon icone, play1, play2, pause1, pause2, re1, re2;
	private Clip clip;
	
	public TelaMusica()
	{
		super("MOVE - Adam Port");
		// MOVE - Adam Port, Stryv, Keinemusik, Orso, Malachiii
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		
		icone = new ImageIcon("./resources/images/moveSONG.jpg");
		play1 = new ImageIcon("./resources/images/play1.png");
        play2 = new ImageIcon("./resources/images/play2.png");
        pause1 = new ImageIcon("./resources/images/pause1.png");
        pause2 = new ImageIcon("./resources/images/pause2.png");
        re1 = new ImageIcon("./resources/images/refresh1.png");
        re2 = new ImageIcon("./resources/images/refresh2.png");
        
        ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
        
        icon = new JLabel(icone, SwingConstants.CENTER);
        cont.add(icon, BorderLayout.CENTER);
        
        try
        {
        	File file = new File("./resources/audio/moveee.wav");
        	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        	clip = AudioSystem.getClip();
        	clip.open(audioStream);
        	
        	panel = new JPanel();
        	panel.setBackground(Color.BLACK);
        	
        	play = new JButton("Play", play1);
        	play.setRolloverIcon(play2);
        	play.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			clip.start();
        		}
        	});
        	
        	pause = new JButton("Pause", pause1);
        	pause.setRolloverIcon(pause2);
        	pause.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			clip.stop();
        		}
        	});
        	
        	reset = new JButton("Reset", re1);
        	reset.setRolloverIcon(re2);
        	reset.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			clip.setMicrosecondPosition(0);
        		}
        	});
        	
        	panel.add(play); panel.add(pause); panel.add(reset);
        	
        	cont.add(panel, BorderLayout.SOUTH);
        }
        catch(UnsupportedAudioFileException f)
        {
        	JOptionPane.showMessageDialog(null, f.getMessage());
        }
        
        catch(IOException io)
        {
        	JOptionPane.showMessageDialog(null, io.getMessage());
        }
        
        catch(LineUnavailableException l)
        {
        	JOptionPane.showMessageDialog(null, l.getMessage());
        }
        
        addWindowListener(new WindowAdapter()
        {
        	public void windowClosing(WindowEvent e)
        	{
        		clip.stop();
        	}
        });
        
        setSize(250,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
	}
	
	public static void main(String[] args)
    {
        new TelaMusica();
    }
}
