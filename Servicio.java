package Entidades;

public class Servicio {
	private int nroReserva;
	private String fecServicio;
	private String fecCancelacion;
	private String motivoCancelacion;
	private Entidades.Persona oPersona;
	private Entidades.Descuento oDescuento;
	private Entidades.Vehiculo oVehiculo;
	
	public Servicio(){}
	
	public Servicio (int nroReserva, String fecServicio, String fecCancelacion, String motivoCancelacion, 
			Entidades.Persona oPersona, Entidades.Descuento oDescuento, Entidades.Vehiculo oVehiculo)
	{
		this.nroReserva=nroReserva;
		this.fecServicio=fecServicio;
		this.fecCancelacion=fecCancelacion;
		this.motivoCancelacion=motivoCancelacion;
		this.oPersona=oPersona;
		this.oDescuento=oDescuento;
		this.oVehiculo=oVehiculo;
	}
	
	public void setNroReserva(int nroReserva)
	{
		this.nroReserva=nroReserva;
	}
	public int getNroReserva()
	{
		return this.nroReserva;
	}
	
	public void setFecServicio(String fecServicio)
	{
		this.fecServicio=fecServicio;	
	}
	public String getFecServicio()
	{
		return this.fecServicio;
	}
	
	public void setFecCancelacion(String fecCancelacion)
	{
		this.fecCancelacion=fecCancelacion;	
	}
	public String getFecCancelacion()
	{
		return this.fecCancelacion;
	}
	
	public void setMotivoCancelacion(String motivoCancelacion)
	{
		this.motivoCancelacion=motivoCancelacion;	
	}
	public String getMotivoCancelacion()
	{
		return this.motivoCancelacion;
	}
	
	public void setPersona(Entidades.Persona oPersona)
	{
		this.oPersona=oPersona;	
	}
	public Entidades.Persona getPersona()
	{
		return this.oPersona;
	}
	
	public void setDescuento(Entidades.Descuento oDescuento)
	{
		this.oDescuento=oDescuento;
	}
	public Entidades.Descuento getDescuento()
	{
		return this.oDescuento;
	}
	
	public void setVehiculo(Entidades.Vehiculo oVehiculo)
	{
		this.oVehiculo=oVehiculo;	
	}
	public Entidades.Vehiculo getVehiculo()
	{
		return this.oVehiculo;
	}
}
