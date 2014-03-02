package Entidades;

public class Descuento {
	private int diaDesde;
	private int diaHasta;
	private int porcentaje;

	public Descuento(){}
	
	public Descuento(int diaDesde, int diaHasta, int porcentaje)
	{
		this.diaDesde=diaDesde;
		this.diaHasta=diaHasta;
		this.porcentaje=porcentaje;
	}
	
	public void setDiaDesde(int diaDesde)
	{
		this.diaDesde=diaDesde;
	}
	public int getDiaDesde()
	{
		return this.diaDesde;
	}
	
	public void setDiaHasta(int diaHasta)
	{
		this.diaHasta=diaHasta;
	}
	public int getDiaHasta()
	{
		return this.diaHasta;
	}
	
	public void setPorcentaje(int porcentaje)
	{
		this.porcentaje=porcentaje;
	}
	public int getPorcentaje()
	{
		return this.porcentaje;
	}
}
