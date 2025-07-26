package model;

public class Carro 
{
	private String marca, modelo;
    private int cilindrada, codigo;
    private float preco;
    public static int contCarros = 1050;
    
    public Carro(String marca, String modelo, int cilindrada, float preco) 
    {
    	this.codigo = contCarros++;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.preco = preco;
    }
    
    public Carro()
    {
    	this("","",0,0F);
    }

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public String getModelo() 
	{
		return modelo;
	}

	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}

	public int getCilindrada() 
	{
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) 
	{
		this.cilindrada = cilindrada;
	}

	public float getPreco() 
	{
		return preco;
	}

	public void setPreco(float preco) 
	{
		this.preco = preco;
	}

	@Override
	public String toString() 
	{
		return codigo + ";" + marca + ";" + modelo + ";" + cilindrada + ";" + preco + "\n";
	}
}
