package util;

import java.util.ArrayList;

import model.Cliente;
import view.TelaMsg;
import view.TelaOutputApenasTodos;

public class Ordenacoes 
{
	 public Ordenacoes() {}
	 
	 public void ordenarPorPrecoFinal(ArrayList lista) 
	 {
		 int ind_menor;
		 for (int i = 0; i < lista.size()-1; i++) 
		 {
			 ind_menor = localizarMenorPreco(lista, i);
			 if(i!=ind_menor)
				 troca(lista, i, ind_menor);
		 }
		 
		 new TelaMsg("Ordenação", "Dados Ordenados!", "Ordenação pelo preço");
		 new TelaOutputApenasTodos(lista);
	 }
	 
	 private int localizarMenorPreco(ArrayList lista, int inicio) 
	 {
		 int ind_menor = inicio; 
		 Cliente aux1, aux2;
		 
		 for( int k = inicio + 1; k < lista.size(); k++) 
		 {
			 aux1 = (Cliente) lista.get(k);
			 aux2 = (Cliente) lista.get(ind_menor);
			 			 
			 if(aux1.getPreco() < aux2.getPreco())
				 ind_menor = k;
		 }
		 return ind_menor;
	 }
	 
	 public void ordenarPorEstadoCompra(ArrayList lista) 
	 {
		 int ind_menor;
		 for (int i = 0; i < lista.size()-1; i++) 
		 {
			 ind_menor = localizarEstado(lista, i);
			 troca(lista, i, ind_menor);
		 }
		 
		 new TelaMsg("Ordenação", "Dados Ordenados!", "Ordenação pelo Estado");
		 new TelaOutputApenasTodos(lista);
	 }
	 
	 private int localizarEstado(ArrayList lista, int inicio) 
	 {
		 int ind_menor = inicio; 
		 Cliente aux1, aux2;
		 String s="";
		 
		 for( int k = inicio + 1; k < lista.size(); k++) 
		 {
			 aux1 = (Cliente) lista.get(k);			
			 aux2 = (Cliente) lista.get(ind_menor);
			 if(compararEstado(aux1.getEstadoCompra()) < compararEstado(aux2.getEstadoCompra()))
				 ind_menor = k;
		 }
		 return ind_menor;
	 }
	 
	 private int compararEstado(String estado) 
	 {
	     estado = estado.toLowerCase();
	     if (estado.equalsIgnoreCase("em transito")) return 0;
	     if (estado.equalsIgnoreCase("em processamento")) return 1;
	     if (estado.equalsIgnoreCase("entrega concluida")) return 2;
	     return 3; 
	 }
	 
	 private void troca(ArrayList lista, int a, int b) 
	 {
		 Cliente aux1, aux2;
		 aux1 = (Cliente) lista.get(a);
		 aux2 = (Cliente) lista.get(b);
		 lista.set(a, aux2);
		 lista.set(b, aux1); 
	 }
}