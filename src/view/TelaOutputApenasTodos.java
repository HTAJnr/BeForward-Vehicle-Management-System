package view;

import java.awt.*;
import javax.swing.*;

import model.Cliente;
import util.Tabelas;

import java.util.*;

public class TelaOutputApenasTodos extends JFrame
{
	private Container cont;
	private Tabelas t;
	private JTable tabTodos;
	
	private String [] titTodos = {"Tipo","Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Custo Final"};
	
	public TelaOutputApenasTodos(ArrayList<Cliente> array)
	{
		super("Visualizacao dos dados de todos os clientes");
		cont = getContentPane();
		t = new Tabelas();
		
		tabTodos = new JTable(t.criarTabelaTodos(array, titTodos), titTodos);
		tabTodos.setEnabled(false);
		Color laranja = new Color(255, 106, 0);
		personalizarTabela(tabTodos, laranja);
		
		cont.add(new JScrollPane(tabTodos), BorderLayout.CENTER);
		
		setSize(1280, 800); 
		setVisible(true);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void personalizarTabela(JTable tabela, Color corCabecalho) 
	{
	    tabela.getTableHeader().setBackground(corCabecalho);
	    tabela.getTableHeader().setForeground(Color.WHITE);
	    tabela.setBackground(Color.WHITE);
	    tabela.setForeground(Color.BLACK);
	}
}
