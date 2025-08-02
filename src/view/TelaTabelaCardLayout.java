package view;

import java.awt.*;
import javax.swing.*;

import model.Cliente;
import util.Tabelas;

import java.util.*;

public class TelaTabelaCardLayout extends JFrame
{
	private Container cont;
	private JTabbedPane tabbedPane;
	private Tabelas t;
	private JTable tabTodos, tabP, tabE, tabPN, tabPD, tabER, tabEE;
	
	private String [] titulos = {
			"Todos Clientes",
			"Clientes Particulares",
			"Clientes Empresariais",
			"Clientes Particulares Normais",
			"Clientes Particulares Dotourados",
			"Clientes Empresariais Revendedores",
			"Clientes Empresariais Estado" };
	
	private String [] titTodos = {"Tipo","Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Custo Final"};
	private String [] titPart = {"Tipo","Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Tipo de uso da viatura","Custo Final"};
	private String [] titEmpr = {"Tipo","Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Quant de Viaturas","Custo Final"};
	private String [] titPartDou = {"Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Data de conclusao do dotouramento","Custo Final"};
	private String [] titPartNor = {"Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Esteve no estrangeiro","Anos fora do pais","Custo Final"};
	private String [] titEmprRev = {"Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Nome comercial","Custo Final"};
	private String [] titEmprEst = {"Telefone","Nome do Cliente","Data da Compra","Estado da Compra" ,"Codigo","Marca","Modelo","Cilindrada","Nome da instituicao","Manutencao","Custo Final"};
	
	public TelaTabelaCardLayout(ArrayList<Cliente> array)
	{
		super("Visualizacao dos dados dos clientes");
		cont = getContentPane();
		t = new Tabelas();
		tabbedPane = new JTabbedPane();
		Color laranja = new Color(255, 106, 0);
		
		ImageIcon logoWindow = new ImageIcon("./resources/images/BeForward_L.png");
		setIconImage(logoWindow.getImage());
		
		tabTodos = new JTable(t.criarTabelaTodos(array, titTodos), titTodos);
		tabP = new JTable(t.criarTabelaParticular(array, titPart), titPart);
		tabE = new JTable(t.criarTabelaEmpresarial(array, titEmpr), titEmpr);
		tabPN = new JTable(t.criarTabelaNormal(array, titPartNor), titPartNor);
		tabPD = new JTable(t.criarTabelaDotourado(array, titPartDou), titPartDou);
		tabER = new JTable(t.criarTabelaRevendedor(array, titEmprRev), titEmprRev);
		tabEE = new JTable(t.criarTabelaEstado(array, titEmprEst), titEmprEst);
		
		tabTodos.setEnabled(false);
		tabP.setEnabled(false);
		tabE.setEnabled(false);
		tabPN.setEnabled(false);
		tabPD.setEnabled(false);
		tabER.setEnabled(false); 
		tabEE.setEnabled(false);
		
		// Personalizar a cor das tabelas
		personalizarTabela(tabTodos, laranja);
		personalizarTabela(tabP, laranja);
		personalizarTabela(tabE, laranja);
		personalizarTabela(tabPN, laranja);
		personalizarTabela(tabPD, laranja);
		personalizarTabela(tabER, laranja);
		personalizarTabela(tabEE, laranja);

		
		tabbedPane.add(titulos[0], new JScrollPane(tabTodos));
		tabbedPane.add(titulos[1], new JScrollPane(tabP));
		tabbedPane.add(titulos[2], new JScrollPane(tabE));
		tabbedPane.add(titulos[3], new JScrollPane(tabPN));
		tabbedPane.add(titulos[4], new JScrollPane(tabPD));
		tabbedPane.add(titulos[5], new JScrollPane(tabER));
		tabbedPane.add(titulos[6], new JScrollPane(tabEE));
		
		cont.add(tabbedPane, BorderLayout.CENTER);
		
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
