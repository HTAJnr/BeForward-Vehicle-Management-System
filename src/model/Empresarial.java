package model;

public abstract class Empresarial extends Cliente
{
	// DECLARACAO DOS ATRIBUTOS DA CLASSE
	protected int qv;
	
	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Empresarial (long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, int qv)
	{
		super(tel,nome,dc,ec,cod,mar,mod,cil,preco);
		this.qv = qv;
	}
	
	// METODO DE CALCULO DAS TAXAS FIXAS 
	public float calcTaxasFixas()
	{
		// RETORNA O PRODUTO DA A SOMA DAS TAXAS PELA QUANTIDADE DE VIATURAS
		return (TAXA_ADUANEIROS + TAXA_INSPECAO) * qv;
	}
	
	// METODO GET DE TAXAS FIXAS
	public float getTaxasFixas()
	{
		return calcTaxasFixas();
	}
	
	// METODO GET
	public int getQuantViaturas() { return qv; }

	// METODO SET
	public void setQuantViaturas(int qv) { this.qv = qv; }

	// METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return super.toString()+"E;"+qv+";";
	}
}
