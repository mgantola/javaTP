package Entidades;

public class Vehiculo {
	private String patente;
	private String descVehiculo;
	private Entidades.Categoria oCategoria;
	
	public Vehiculo(){}
	
	public Vehiculo(String patente, String descVehiculo, Entidades.Categoria oCategoria)
	{
		this.patente=patente;
		this.descVehiculo=descVehiculo;
		this.oCategoria=oCategoria;
	}
	
	public void setPatente(String patente)
	{
		this.patente=patente;	
	}
	public String getPatente()
	{
		return this.patente;
	}
	
	public void setDescVehiculo(String descVehiculo)
	{
		this.descVehiculo=descVehiculo;	
	}
	public String getDescVehiculo()
	{
		return this.descVehiculo;
	}
	
	public void setCategoria(Entidades.Categoria oCategoria)
	{
		this.oCategoria=oCategoria;	
	}
	public Entidades.Categoria getCategoria()
	{
		return this.oCategoria;
	}
}
