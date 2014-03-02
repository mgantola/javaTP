package Entidades;

public class Reparacion {
	private Entidades.Vehiculo oVehiculo;
	private String fecDesde;
	private String fecHasta;
	
	public Reparacion(){}
	
	public Reparacion(Entidades.Vehiculo oVehiculo, String fecDesde, String fecHasta)
	{
		this.oVehiculo=oVehiculo;
		this.fecDesde=fecDesde;
		this.fecHasta=fecHasta;
	}
	
	public void setVehiculo(Entidades.Vehiculo oVehiculo)
	{
		this.oVehiculo=oVehiculo;
	}
	public Entidades.Vehiculo getVehiculo()
	{
		return this.oVehiculo;
	}
	
	public void setFecDesde(String fecDesde)
	{
		this.fecDesde=fecDesde;
	}
	public String getFecDesde()
	{
		return this.fecDesde;
	}
	
	public void setFecHasta(String fecHasta)
	{
		this.fecHasta=fecHasta;
	}
	public String getFecHasta()
	{
		return this.fecHasta;
	}
}
