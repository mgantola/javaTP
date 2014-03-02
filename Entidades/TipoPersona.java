package Entidades;

public class TipoPersona {
	private int idTipoPersona;
	private String descTipoPersona;
	
	public TipoPersona(){}
	
	public TipoPersona(int idTipoPersona, String descTipoPersona)
	{
		this.idTipoPersona=idTipoPersona;
		this.descTipoPersona=descTipoPersona;
	}
	
	public void setIdTipoPersona(int idTipoPersona)
	{
		this.idTipoPersona=idTipoPersona;
	}
	public int getIdTipoPersona()
	{
		return this.idTipoPersona;
	}
	
	public void setDescTipoPersona(String descTipoPersona)
	{
		this.descTipoPersona=descTipoPersona;
	}
	public String getDescTipoPersona()
	{
		return this.descTipoPersona;
	}
}
