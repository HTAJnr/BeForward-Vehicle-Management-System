package model;
public final class Normal extends Particular
{
	// DECLARACAO DOS ATRIBUTOS DA CLASSE
	private String est;
	private int qa;
	public static int cNORMAL = 0;   // DECLARACAO DO CONTADOR ESTATICO

	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Normal(long tel, String nome, String dc, String ec, int cod, String mar, String mod, int cil, float preco, String tipoUso, String est, int qa)
	{
		super(tel,nome,dc,ec,cod,mar,mod,cil,preco,tipoUso);
		this.est = est;
		this.qa = qa;
		cNORMAL++;                   // INCREMENTACAO DO CONTADOR ESTATICO
	}
	
	// CONSTRUCTOR PADRAO SEM PARAMETROS PARA INICIALIZACAO DOS DADOS
	public Normal()
	{
		this(0,"","","",0,"","",0,0,"","",0);
	}
	
	// METODO PARA O CALCULO DOS DIREITOS ADUANEIROS - SUBTOTAL 1
	public float calcDireitosAduaneiros()
	{
		return preco * DIREITOS_25;   // RETORNA O VALOR DOS DIREITOS ADUANEIROS SOBRE O PRECO
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
		return subtotal2() * IVA_16;   // RETORNA O VALOR DO IVA SOBRE O SUBTOTAL 2
	}
	
	public float subtotal3()
	{
		return subtotal2() + calcIva();   // RETORNA A SOMA DO IVA COM O SUBTOTAL 2
	}
	
	// METODO PARA O CALCULO DO DESCONTO - SUBTOTAL 4 
	public float calcDesconto()
	{
		//VERIFICA SE O CLIENTE ESTEVE NO ESTRANGEIRO POR MAIS DE 4 ANOS
		if(qa > 4)
			return subtotal3() * DESCONTO_3;   // RETORNA O VALOR DO DESCONTO SOBRE O SUBTOTAL 3
		return 0;                              // RETORNA 0 CASO NAO SE VERIFIQUE A CONDICAO
	}
	
	public float subtotal4()
	{
		return subtotal3() - calcDesconto();   //RETORNA A SUBTRACAO DO DESCONTO AO SUBTOTAL 3
	}
	
	// METODO PARA O CALCULO DO CUSTO TOTAL FINAL
	public float calcCustoFinal()
	{
		return calcTaxasFixas() + subtotal4();   // RETORNA A SOMA DAS TAXAS FIXAS COM O SUBTOTAL 4
	}

	// METODOS GETTERS
	public String getEstrangeiro() { return est; }
	public int getQuantAnos() {	return qa; }
	public float getCustoFinal() { return calcCustoFinal(); }

	// METODOS SETTERS
	public void setEstrangeiro(String est) { this.est = est; }
	public void setQuantAnos(int qa) { this.qa = qa; }
	
	// METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return super.toString()+"N;"+est+";"+qa;
	}
}
