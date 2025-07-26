package model;
public final class Revendedor extends Empresarial
{
	private String nomeCom;                // DECLARACAO DO ATRIBUTO DA CLASSE
	public static int cREVENDEDOR = 0;     // DECLARACAO DO CONTADOR ESTATICO
	
	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Revendedor(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, int qv, String nomeCom)
	{
		super(tel,nome,dc,ec,cod,mar,mod,cil,preco,qv);
		this.nomeCom = nomeCom;
		cREVENDEDOR++;                   // INCREMENTACAO DO CONTADOR ESTATICO
	}
	
	// CONSTRUCTOR PADRAO SEM PARAMETROS PARA INICIALIZACAO DOS DADOS
	public Revendedor()
	{
		this(0,"","","",0,"","",0,0,0,"");
	}

	// METODO PARA O CALCULO DOS DIREITOS ADUANEIROS - SUBTOTAL 1
	public float calcDireitosAduaneiros()
	{
		return preco * DIREITOS_15;   // RETORNA O VALOR DOS DIREITOS ADUANEIROS SOBRE O PRECO
	}
	
	public float subtotal1()
	{
		return preco + calcDireitosAduaneiros();   // RETORNA A SOMA DO VALOR DOS DIREITOS ADUANEIROS COM O PRECO
	}
	
	// METODO PARA O CALCULO DO IMPOSTO - SUBTOTAL 2
	public float calcImposto()
	{
		//VERIFICA SE A CILINDRADA E SUPURIOR A 2.000 cc
		if(cilindradaViat > 2000)
			return subtotal1() * IMPOSTO;   // RETORNA O VALOR DO IMPOSTO SOBRE O SUBTOTAL 1
		return 0;                           // RETORNA 0 CASO NAO SE VERIFIQUE A CONDICAO
	}
	
	public float subtotal2()
	{
		return subtotal1() + calcImposto();   // RETORNA A SOMA DO IMPOSTO COM O SUBTOTAL 1
	}
	
	// METODO PARA O CALCULO DO IVA - SUBTOTAL 3
	public float calcIva()
	{
		return subtotal2() * IVA_8;   // RETORNA O VALOR DO IVA SOBRE O SUBTOTAL 2
	}
	
	public float subtotal3()
	{
		return subtotal2() + calcIva();   // RETORNA A SOMA DO IVA COM O SUBTOTAL 2
	}
	
	// METODO PARA O CALCULO DO DESCONTO - SUBTOTAL 4 
	public float calcDesconto()
	{
		//VERIFICA SE A QUANTIDADE DE VIATURAS COMPRADAS PELO CLIENTE E IGUAL OU SUPERIOR A 5
		if(qv >= 5)
			return subtotal3() * DESCONTO_5;   // RETORNA O VALOR DO DESCONTO SOBRE O SUBTOTAL 3
		return 0;                              // RETORNA 0 CASO NAO SE VERIFIQUE A CONDICAO
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
	public String getNomedoComercial() { return nomeCom; }
	public float getCustoFinal() { return calcCustoFinal(); }
	
	// METODO SET
	public void setNomedoComercial(String nomeCom) { this.nomeCom = nomeCom; }
	
	// METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return super.toString()+"R;"+nomeCom;
	}
	
	
}
