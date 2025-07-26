package model;
public final class Estado extends Empresarial
{
	private String nomeIns, man;     // DECLARACAO DO ATRIBUTO DA CLASSE
	public static int cESTADO = 0;   // DECLARACAO DO CONTADOR ESTATICO
	
	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Estado(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, int qv, String nomeIns, String man)
	{
		super(tel,nome,dc,ec,cod,mar,mod,cil,preco,qv);
		this.nomeIns = nomeIns;
		this.man = man;
		cESTADO++;                   // INCREMENTACAO DO CONTADOR ESTATICO
	}
	
	// CONSTRUCTOR PADRAO SEM PARAMETROS PARA INICIALIZACAO DOS DADOS
	public Estado()
	{
		this(0,"","","",0,"","",0,0,0,"","");
	}
	
	// METODO PARA O CALCULO DOS DIREITOS ADUANEIROS - SUBTOTAL 1
	public float calcDireitosAduaneiros()
	{
		return 0;   // RETORNA 0, POIS ESTA ISENTO
	}
	
	public float subtotal1()
	{
		return preco + calcDireitosAduaneiros();   // RETORNA A SOMA DO VALOR DOS DIREITOS ADUANEIROS COM O PRECO
	}
	
	// METODO PARA O CALCULO DO IMPOSTO - SUBTOTAL 2
	public float calcImposto()
	{
		return 0;   // RETORNA 0, POIS ESTA ISENTO
	}
	
	public float subtotal2()
	{
		return subtotal1() + calcImposto();   // RETORNA A SOMA DO IMPOSTO COM O SUBTOTAL 1
	}
	
	// METODO PARA O CALCULO DO IVA - SUBTOTAL 3
	public float calcIva()
	{
		return 0;   // RETORNA 0, POIS ESTA ISENTO
	}
	
	public float subtotal3()
	{
		return subtotal2() + calcIva();   // RETORNA A SOMA DO IVA COM O SUBTOTAL 2
	}
	
	// METODO PARA O CALCULO DO DESCONTO - SUBTOTAL 4 
	public float calcDesconto()
	{
		return 0;   // RETORNA 0, POIS ESTA ISENTO
	}
	
	public float subtotal4()
	{
		return subtotal3() - calcDesconto();   // RETORNA A SUBTRACAO DO DESCONTO AO SUBTOTAL 3
	}
	
	// METODO PARA O CALCULO DO CUSTO TOTAL FINAL
	public float calcCustoFinal()
	{
		return calcTaxasFixas() + subtotal4();   // RETORNA A SOMA DAS TAXAS FIXAS COM O SUBTOTAL 4
	}
	
	// METODOS GETTERS
	public String getNomeInstituicao() { return nomeIns; }
	public String getManutencao() { return man; }
	public float getCustoFinal() { return calcCustoFinal(); }
	
	// METODOS SETTERS
	public void setNomeInstituicao(String nomeIns) { this.nomeIns = nomeIns; }
	public void setManutencao(String man) { this.man = man; }
	
	// METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return super.toString()+"S;"+nomeIns+";"+man;
	}
}
