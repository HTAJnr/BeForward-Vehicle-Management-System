package util;

import java.util.*;

import model.Cliente;

public class Pesquisa 
{
	// CONTRUCTOR DA CLASSE PARA A INICIALIZACAO
	public Pesquisa() {}
		
	// METODO DE PESQUISA DO CLIENTE ATRAVEZ TELEFONE
	public int pesquisarClienteTel(ArrayList lista, long tel)
	{
		Cliente aux;   // DECLARACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DE CADA CLIENTE
		
		for(int i = 0; i < lista.size(); i++)
		{ 
			aux = (Cliente) lista.get(i);   //LEITURA E IDENTIFICACAO DOS OBJECTOS NO ARRAYLIST PARA PESQUISA
			
			// VERIFICA SE O TELEFONE EH IGUAIS AO RECEBIDO POR PARAMETRO
			if(aux.getTel() == tel)
				return i;   // RETORNA O INDICE CASO A CONDICAO SE VERIFIQUE 
		}
		return -1;  // RETORNA -1 CASO A CONDICAO NAO SE VERIFIQUE PARA NENHUM DOS OBJECTOS
	}
	
	// METODO DE PESQUISA DO CLIENTE ATRAVEZ CODIGO DE VIATURA
	public int pesquisarClienteCod(ArrayList lista, int cod)
	{
		Cliente aux;   // DECLARACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DE CADA CLIENTE
		
		for(int i = 0; i < lista.size(); i++)
		{
			aux = (Cliente) lista.get(i);   //LEITURA E IDENTIFICACAO DOS OBJECTOS NO ARRAYLIST PARA PESQUISA
			
			// VERIFICA SE O NOME E O CODIGO SAO IGUAIS AO RECEBIDOS POR PARAMETRO
			if(aux.getCodigo() == cod)
				return i;   // RETORNA O INDICE CASO A CONDICAO SE VERIFIQUE 
		}
		return -1;  // RETORNA -1 CASO A CONDICAO NAO SE VERIFIQUE PARA NENHUM DOS OBJECTOS
	}
}
