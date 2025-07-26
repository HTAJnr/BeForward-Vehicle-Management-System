package util;

import java.util.*;

import model.Cliente;
import view.TelaMsg;
import view.TelaRecibo;

public class Alteracoes
{
	
	public Alteracoes() {}
	
	public void alterarEstadoCompra(ArrayList<Cliente> array, int pos, String ec)
	{
		Cliente c = array.get(pos);
		c.setEstadoCompra(ec);
		new TelaRecibo(array, pos);
		
		new TelaMsg("Alteracao do estado de Compra", "Estado de compra alterado com sucesso!", "Pesquise o cliente e verifique a alteracao");
	}

}
