package util;

public interface CalculosInterface
{
	// DECLARACAO E INICIALIZACAO DAS CONSTANTES ESTATISTICAS DOS VALORES DE DIREITOS ADUANEIROS, IMPOSTO, IVA, DESCONTO E TAXAS FIXAS
	public static final float DIREITOS_25 = 25/100f, DIREITOS_15 = 15/100f, IMPOSTO = 10/100f, IVA_16 = 16/100f, IVA_8 = 8/100f, DESCONTO_5 = 5/100f, DESCONTO_3 = 3/100f;
	public static final int TAXA_ADUANEIROS = 10000, TAXA_INSPECAO = 5000;
	
	public abstract float calcTaxasFixas();          // METODO PARA O CALCULO DAS TAXAS FIXAS
	public abstract float calcDireitosAduaneiros();  // METODO PARA O CALCULO DOS DIREITOS ADUANEIROS
	public abstract float calcImposto();             // METODO PARA O CALCULO DO IMPOSTO
	public abstract float calcIva();                 // METODO PARA O CALCULO DO IVA
	public abstract float calcDesconto();            // METODO PARA O CALCULO DO DESCONTO            
	public abstract float calcCustoFinal();          // METODO PARA O CALCULO DO CUSTO FINAL
}
