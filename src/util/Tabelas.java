package util;

import java.util.*;

import model.*;

import java.text.DecimalFormat;

public class Tabelas 
{
	private Cliente c;
	private DecimalFormat mt, tel, cil;
	private ArrayList array1;
	
	public Tabelas()
	{	
		mt = new DecimalFormat("###,###,###,###.00 MZN");
		tel = new DecimalFormat("+258 #########");
		cil = new DecimalFormat("#### cc");
	}
	
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DE TODOS OS CLIENTES
	public String[][] criarTabelaTodos(ArrayList<Cliente> array, String[] tit)
	{
		String[][] x = new String[array.size()][tit.length];
		String t = "";
		
		for(int i=0; i<array.size(); i++)
		{
			c = (Cliente) array.get(i);
			
			if (c instanceof Doutorado)
            	t = "PART. DOTOURADO";
			else if (c instanceof Normal)
        			t = "PART. NORMAL";
        	 else if (c instanceof Revendedor) 
        				t = "EMPR. REVENDEDOR";
        		  else if (c instanceof Estado) 
        					t = "EMPR. ESTADO";
			
			x[i][0] = t;
			x[i][1] = tel.format(c.getTel());
			x[i][2] = c.getNome();
			x[i][3] = c.getDataCompra();
			x[i][4] = c.getEstadoCompra();
			x[i][5] = c.getCodigo()+"";
			x[i][6] = c.getMarca();
			x[i][7] = c.getModelo();
			x[i][8] = cil.format(c.getCilindrada());
			x[i][9] = mt.format(c.getPreco());
		}
		return x;
	}
	
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DOS CLIENTES PARTICULARES
	public String[][] criarTabelaParticular(ArrayList<Cliente> array, String[] tit)
	{
		Particular o;
		array1 = new ArrayList();
		String t = "";
		
		for(int i=0; i<array.size(); i++)
		{
			c = array.get(i);
			if(c instanceof Normal || c instanceof Doutorado)
				array1.add(c);
		}
		
		String x[][] = new String[array1.size()][tit.length];
		
		for(int i=0; i<array1.size(); i++)
		{
			o = (Particular) array1.get(i);
			
			if (o instanceof Doutorado)
	            t = "PART. DOTOURADO";
		    else
		    
	    		t = "PART. NORMAL";
			
			x[i][0] = t;
			x[i][1] = tel.format(o.getTel());
			x[i][2] = o.getNome();
			x[i][3] = o.getDataCompra();
			x[i][4] = o.getEstadoCompra();
			x[i][5] = o.getCodigo()+"";
			x[i][6] = o.getMarca();
			x[i][7] = o.getModelo();
			x[i][8] = cil.format(o.getCilindrada());
			x[i][9] = o.getTipoUsoViatura();
			x[i][10] = mt.format(o.getPreco());
		}
		return x;
	}
	
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DOS CLIENTES PARTICULARES NORMAIS
	public String[][] criarTabelaNormal(ArrayList<Cliente> array, String[] tit)
	{
		Normal o;
		array1 = new ArrayList();
		for(int i=0; i<array.size(); i++)
		{
			c = array.get(i);
			if(c instanceof Normal)
				array1.add(c);
		}
		
		String x[][] = new String[array1.size()][tit.length];
		
		for(int i=0; i<array1.size(); i++)
		{
			o = (Normal) array1.get(i);
			
			x[i][0] = tel.format(o.getTel());
			x[i][1] = o.getNome();
			x[i][2] = o.getDataCompra();
			x[i][3] = o.getEstadoCompra();
			x[i][4] = o.getCodigo()+"";
			x[i][5] = o.getMarca();
			x[i][6] = o.getModelo();
			x[i][7] = cil.format(o.getCilindrada());
			x[i][8] = o.getEstrangeiro();
			x[i][9] = o.getQuantAnos()+"";
			x[i][10] = mt.format(o.getPreco());
		}
		return x;
	}
	
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DOS CLIENTES PARTICULARES DOTOURADOS
	public String[][] criarTabelaDotourado(ArrayList<Cliente> array, String[] tit)
	{
		Doutorado o;
		array1 = new ArrayList();
		for(int i=0; i<array.size(); i++)
		{
			c = array.get(i);
			if(c instanceof Doutorado)
				array1.add(c);
		}
		
		String x[][] = new String[array1.size()][tit.length];
		
		for(int i=0; i<array1.size(); i++)
		{
			o = (Doutorado) array1.get(i);
			
			x[i][0] = tel.format(o.getTel());
			x[i][1] = o.getNome();
			x[i][2] = o.getDataCompra();
			x[i][3] = o.getEstadoCompra();
			x[i][4] = o.getCodigo()+"";
			x[i][5] = o.getMarca();
			x[i][6] = o.getModelo();
			x[i][7] = cil.format(o.getCilindrada());
			x[i][8] = o.getDataConclusaoDoutoramento();
			x[i][9] = mt.format(o.getPreco());
		}
		return x;
	}
	
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DOS CLIENTES EMPRESARIAIS
	public String[][] criarTabelaEmpresarial(ArrayList<Cliente> array, String[] tit)
	{
		Empresarial o;
		array1 = new ArrayList();
		for(int i=0; i<array.size(); i++)
		{
			c = array.get(i);
			if(c instanceof Revendedor || c instanceof Estado)
				array1.add(c);
		}
		
		String x[][] = new String[array1.size()][tit.length];
		
		for(int i=0; i<array1.size(); i++)
		{
			o = (Empresarial) array1.get(i);
			String t = "";
			
			if (o instanceof Revendedor) 
    			t = "EMPR. REVENDEDOR";
			else 
				t = "EMPR. ESTADO";
			
			x[i][0] = t;
			x[i][1] = tel.format(o.getTel());
			x[i][2] = o.getNome();
			x[i][3] = o.getDataCompra();
			x[i][4] = o.getEstadoCompra();
			x[i][5] = o.getCodigo()+"";
			x[i][6] = o.getMarca();
			x[i][7] = o.getModelo();
			x[i][8] = cil.format(o.getCilindrada());
			x[i][9] = o.getQuantViaturas()+"";
			x[i][10] = mt.format(o.getPreco());
		}
		return x;
	}
		
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DOS CLIENTES EMPRESARIAIS REVENDEDORES
	public String[][] criarTabelaRevendedor(ArrayList<Cliente> array, String[] tit)
	{
		Revendedor o;
		array1 = new ArrayList();
		for(int i=0; i<array.size(); i++)
		{
			c = array.get(i);
			if(c instanceof Revendedor)
				array1.add(c);
		}
		
		String x[][] = new String[array1.size()][tit.length];
		
		for(int i=0; i<array1.size(); i++)
		{
			o = (Revendedor) array1.get(i);
			
			x[i][0] = tel.format(o.getTel());
			x[i][1] = o.getNome();
			x[i][2] = o.getDataCompra();
			x[i][3] = o.getEstadoCompra();
			x[i][4] = o.getCodigo()+"";
			x[i][5] = o.getMarca();
			x[i][6] = o.getModelo();
			x[i][7] = cil.format(o.getCilindrada());
			x[i][8] = o.getNomedoComercial();
			x[i][9] = mt.format(o.getPreco());
		}
		return x;
	}
	
	// METODO PARA A CRIACAO DE ARRAY BIDIMENSIONAL PARA ARMAZENAMENTO DOS DADOS DOS CLIENTES EMPRESARIAIS ESTADO
	public String[][] criarTabelaEstado(ArrayList<Cliente> array, String[] tit)
	{
		Estado o;
		array1 = new ArrayList();
		for(int i=0; i<array.size(); i++)
		{
			c = array.get(i);
			if(c instanceof Estado)
				array1.add(c);
		}
		
		String x[][] = new String[array1.size()][tit.length];
		
		for(int i=0; i<array1.size(); i++)
		{
			o = (Estado) array1.get(i);
			
			x[i][0] = tel.format(o.getTel());
			x[i][1] = o.getNome();
			x[i][2] = o.getDataCompra();
			x[i][3] = o.getEstadoCompra();
			x[i][4] = o.getCodigo()+"";
			x[i][5] = o.getMarca();
			x[i][6] = o.getModelo();
			x[i][7] = cil.format(o.getCilindrada());
			x[i][8] = o.getNomeInstituicao();
			x[i][9] = o.getManutencao();
			x[i][10] = mt.format(o.getPreco());
		}
		return x;
	}

}
