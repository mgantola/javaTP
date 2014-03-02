package Entidades;

public class Precio {
	private Entidades.Categoria oCategoria;
	private String fecDesdePrecio;
	private float importe;
	
	public Precio(){}
	
	public Precio(Entidades.Categoria oCategoria, String fecDesdePrecio, float importe)
	{
		this.oCategoria=oCategoria;
		this.fecDesdePrecio=fecDesdePrecio;
		this.importe=importe;
	}

	public void setCategoria(Entidades.Categoria oCategoria)
	{
		this.oCategoria=oCategoria;
	}
	public Entidades.Categoria getCategoria()
	{
		return this.oCategoria;
	}
	
	public void setFecDesdePrecio(String fecDesdePrecio)
	{
		this.fecDesdePrecio=fecDesdePrecio;
	}
	public String getFecDesdePrecio()
	{
		return this.fecDesdePrecio;
	}
	
	public void setImporte(float importe)
	{
		this.importe=importe;
	}
	public float getImporte()
	{
		return this.importe;
	}
}
