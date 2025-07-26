package util;

import java.util.*;

import model.Cliente;

public class Calculos
{
	// CONTRUCTOR DA CLASSE PARA A INICIALIZACAO
	public Calculos() {}
	
	// METODO PARA O CALCULO DO VALOR TOTAL PAGO EM DIREITOS ADUANEIROS
	public float calcVTDireitosAduaneiros(ArrayList lista)
	{
		float v = 0;   // DECLARACAO E INICIALIZACAO DO ACUMULADOR DOS VALORES
		Cliente c;     // DECLARACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DE CADA OBJECTO CLIENTE
		
		for(int i = 0; i < lista.size(); i++)
		{
			c = (Cliente) lista.get(i);        // BUSCANDO O OBJECTO ESPECIFICO
			v += c.calcDireitosAduaneiros();   // ACUMULANDO O VALOR DOS DIREITOS ADUANEIROS PARA CADA OBJECTO
		}
		
		return v;   // RETORNA O VALOR ACUMULADO DE TODOS OS OBJECTOS
	}
	
	// METODO PARA O CALCULO DO VALOR TOTAL RECEBIDO
	public float calcValorTotal(ArrayList lista)
	{
		float v = 0;   // DECLARACAO E INICIALIZACAO DO ACUMULADOR DOS VALORES
		Cliente c;     // DECLARACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DE CADA OBJECTO CLIENTE
		
		for(int i = 0; i < lista.size(); i++)
		{
			c = (Cliente) lista.get(i);   // BUSCANDO O OBJECTO ESPECIFICO
			v += c.calcCustoFinal();      // ACUMULANDO O VALOR DO CUSTO FINAL PARA CADA OBJECTO
		}
		
		return v;   // RETORNA O VALOR ACUMULADO DE TODOS OS OBJECTOS
	}
	
	// METODO PARA O CALCULO DO VALOR LUCRADO/EM FALTA 
	public float calcSituacao(float v)
	{
		final float ORCAMENTO = 1900000;   // DECLARACAO E INICIALIZACAO DA CONSTANTE COM O VALOR DO ORCAMENTO
		return v -  ORCAMENTO;             // RETORNA A SUBTRACAO DO VALOR TOTAL COM O ORCAMENTO
	}

}
