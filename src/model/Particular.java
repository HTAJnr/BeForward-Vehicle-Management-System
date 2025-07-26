package model;
public abstract class Particular extends Cliente 
{
	// DECLARACAO DO ATRIBUTO DA CLASSE
	protected String tipoUso;
	
	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Particular (long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, String tipoUso)
	{
		super(tel,nome,dc,ec,cod,mar,mod,cil,preco);
		this.tipoUso = tipoUso;
	}
	
	// METODO DE CALCULO DAS TAXAS FIXAS 
	public float calcTaxasFixas()
	{
		//RETORNA A SOMA DAS TAXAS FIXAS
		return (TAXA_ADUANEIROS + TAXA_INSPECAO);
	}
	
	// METODO GET DE TAXAS FIXAS
	public float getTaxasFixas()
	{
		return calcTaxasFixas();
	}
	
	// METODO GET
	public String getTipoUsoViatura() { return tipoUso; }

	// METODO SET
	public void setTipoUsoViatura(String tipoUso) { this.tipoUso = tipoUso; }
	
	//METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return super.toString()+"P;"+tipoUso+";";
	}

}
