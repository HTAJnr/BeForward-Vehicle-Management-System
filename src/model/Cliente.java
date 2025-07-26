package model;

import java.io.*;
import util.CalculosInterface;

public abstract class Cliente implements CalculosInterface, Serializable
{
	// DECLARACAO DOS ATRIBUTOS DA CLASSE
	protected String nome, dataCompra, estadoCompra, marcaViat, modeloViat;
	protected int codigo, cilindradaViat;
	protected float preco;
	protected long tel;
	public static int contGeralRecibo = 0; //USADO NO RECIBO
	
	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Cliente (long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco)
	{
		this.tel = tel;
		this.nome = nome;
		this.dataCompra = dc;
		this.estadoCompra = ec;
		this.codigo = cod;
		this.marcaViat = mar;
		this.modeloViat = mod;
		this.cilindradaViat = cil;
		this.preco = preco;
		contGeralRecibo++;
	}
	
	// METODOS GETTERS
	public String getNome() { return nome; }
	public String getDataCompra() { return dataCompra; }
	public String getEstadoCompra() { return estadoCompra; }
	public String getMarca() {  return marcaViat; }
	public String getModelo() {  return modeloViat; }
	public int getCodigo() {  return codigo; }
	public int getCilindrada() {  return cilindradaViat;  }
	public float getPreco() {  return preco;  }
	public long getTel() {  return tel;  }

	//METODOS SETTERS
	public void setNome(String nome) { this.nome = nome; }
	public void setDataCompra(String dc) {  this.dataCompra = dc; }
	public void setEstadoCompra(String ec) { this.estadoCompra = ec; }
	public void setMarca(String mar) {  this.marcaViat = mar;  }
	public void setModelo(String mod) {  this.modeloViat = mod;  }
	public void setCodigo(int cod) {  this.codigo = cod; }
	public void setCilindrada(int cil) {  this.cilindradaViat = cil; }
	public void setPreco(float preco) {  this.preco = preco;  }
	public void setTel(long tel) {  this.tel = tel;  }
	
	//METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return tel+";"+nome+";"+dataCompra+";"+estadoCompra+";"+codigo+";"+marcaViat+";"+modeloViat+";"+cilindradaViat+";"+preco+";";
	}
}