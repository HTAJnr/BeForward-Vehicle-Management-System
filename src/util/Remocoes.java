package util;

import java.util.*;
import model.*;
import view.TelaMsg;

public class Remocoes 
{
	// CONTRUCTOR DA CLASSE PARA A INICIALIZACAO
	public Remocoes() {}
	
	// METODO DE REMOCAO E ARMAZENAMENTO DOS CLIENTES COM ENTREGAS CONCLUIDAS
	public void removerCliente(ArrayList<Cliente> array, int posicao) 
	{
		Cliente c;          // DECLARACAO DA VARIAVEL DE ARMAZENAMENTO TEMPORARIO DE CADA OBJECTO CLIENTE
        
        c = array.get(posicao);
        
        //DECREMENTA O CONTADOR STATIC COM BASE NO TIPO DE CLIENTE 
        if (c instanceof Doutorado)
            Doutorado.cDOUTORADO--;
        else 
        {
        	if (c instanceof Normal)
        		Normal.cNORMAL--;
        	else
        	{
        		if (c instanceof Revendedor)
        			Revendedor.cREVENDEDOR--;
        		else 
        		{
        			if (c instanceof Estado)
        				Estado.cESTADO--;
        		}
        	}
        }
        
        //REMOVE O CLIENTE DO ARRAY ORIGINAL
        array.remove(posicao);
        // AJUSTA O TAMANHO DO ARRAYLIST COM BASE NO NOVO TAMANHO APOS REMOCOES 
        array.trimToSize();
        
        new TelaMsg("Remocao do cliente", "Cliente Removido com sucesso", "Pesquise o cliente para confirmar a remocao");
    }	
}
