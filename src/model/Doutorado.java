package model;

public final class Doutorado extends Particular
{
	private String dataConclusaoDoutoramento;                 // DECLARACAO DO ATRIBUTO DA CLASSE
	public static int cDOUTORADO = 0;     // DECLARACAO DO CONTADOR ESTATICO
	
	// CONSTRUCTOR COM PARAMETROS PARA A LIGACAO NA HERANCA E CARREGAMENTO DE DADOS
	public Doutorado (long tel, String nome, String data, String ec, int cod, String mar, String mod, int cil, float preco, String tipoUso, String dcd)
	{
		super(tel,nome,data,ec,cod,mar,mod,cil,preco,tipoUso);
		this.dataConclusaoDoutoramento = dcd;
		cDOUTORADO++;                 // INCREMENTACAO DO CONTADOR ESTATICO
	}
	
	// CONSTRUCTOR PADRAO SEM PARAMETROS PARA INICIALIZACAO DOS DADOS
	public Doutorado()
	{
		this(0,"","","",0,"","",0,0,"","");
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
		return subtotal2() * IVA_16;   // RETORNA O VALOR DO IVA SOBRE O SUBTOTAL 2
	}
	
	public float subtotal3()
	{
		return subtotal2() + calcIva();   // RETORNA A SOMA DO IVA COM O SUBTOTAL 2
	}
	
	// METODO PARA O CALCULO DO DESCONTO - SUBTOTAL 4
	public float calcDesconto()
	{
		//DECLARACAO E INICIALIZACAO DAS VARIAVEIS PARA A EXTRACCAO DO DIA E MES EM FORMATO INTEIRO
		int mes = Integer.parseInt(dataConclusaoDoutoramento.substring(0,2));
		int dia = Integer.parseInt(dataConclusaoDoutoramento.substring(3,5));
		
		//INSTRUCAO QUE VERIFICA SE O CLIENTE CONCLUIU O DOTOURAMENTO ATE O DIA DOS TRABALHADORES
		if(mes < 5 || (mes == 5 && dia == 1))
			return subtotal3() * DESCONTO_3;   // RETORNA O VALOR DO DESCONTO SOBRE O SUBTOTAL 3
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
	public String getDataConclusaoDoutoramento() { return dataConclusaoDoutoramento; }
	public float getCustoFinal() { return calcCustoFinal(); }
	
	// METODO SET
	public void setDataConclusaoDoutoramento(String dcd) { this.dataConclusaoDoutoramento = dcd; }
	
	// METODO TOSTRING
	public String toString()
	{
		// RETORNA OS DADOS EXACTAMENTE NO FORMATO ORIGINAL DO FICHEIRO DE TEXTO
		return super.toString()+"D;"+dataConclusaoDoutoramento;
	}
}
