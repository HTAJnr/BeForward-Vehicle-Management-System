package util;

import java.util.*;

import model.Usuario;
import view.TelaMsg;
import model.Cliente;

import java.io.*;

public class FicheiroTexto
{
	public FicheiroTexto() {}
	
	public void registrarUsuarios(ArrayList<Usuario> lista)
	{
	    try
	    {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/data/DadosUsuarios.txt", true));
	        int i = lista.size() - 1;
	        Usuario aux = lista.get(i);
	        bw.write(aux.toString());
	        bw.flush();
	        bw.close();
	    } 
	    catch(FileNotFoundException fnf) { new TelaMsg("Login no Sistema", "Ficheiro dos Usuarios não encontrado!", "Contacte o Suporte do Sistema!"); }
		catch(IOException io) { new TelaMsg("Login no Sistema", io.getMessage(), "Contacte o Suporte do Sistema!"); }
	}
	
	public void registrarClientes(ArrayList<Cliente> lista)
	{
	    try
	    {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/data/DadosClientes.txt", true));
	        int i = lista.size() - 1;
	        Cliente aux = lista.get(i);
	        bw.write(aux.toString()+"\n");
	        bw.flush();
	        bw.close();
	    } catch(FileNotFoundException fnf) { new TelaMsg("Login no Sistema", "Ficheiro dos Usuarios não encontrado!", "Contacte o Suporte do Sistema!"); }
		catch(IOException io) { new TelaMsg("Login no Sistema", io.getMessage(), "Contacte o Suporte do Sistema!"); }
	}
}
