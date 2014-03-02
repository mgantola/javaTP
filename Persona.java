package Entidades;

public class Persona {
	private String tpoDNI;
	private int nroDNI;
	private String apellido;
	private String nombre;
	private String direccion;
	private String telefono;
	private String mail;
	private String usuario;
	private String contrasenia;
	private Entidades.TipoPersona oTipoPersona;
	
	public Persona(){}
	
	public Persona(String tpoDNI, int nroDNI, String apellido, String nombre, String direccion, String telefono, String mail, 
			String usuario, String contrasenia, Entidades.TipoPersona oTipoPersona)
	{
		this.tpoDNI=tpoDNI;
		this.nroDNI=nroDNI;
		this.apellido=apellido;
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono=telefono;
		this.mail=mail;
		this.usuario=usuario;
		this.contrasenia=contrasenia;
		this.oTipoPersona=oTipoPersona;
	}
	
	public void setTpoDNI(String tpoDNI)
	{
		this.tpoDNI=tpoDNI;	
	}
	public String getTpoDNI()
	{
		return this.tpoDNI;
	}
	
	public void setNroDNI(int nroDNI)
	{
		this.nroDNI=nroDNI;	
	}
	public int getNroDNI()
	{
		return this.nroDNI;
	}
	
	public void setApellido(String apellido)
	{
		this.apellido=apellido;	
	}
	public String getApellido()
	{
		return this.apellido;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre=nombre;	
	}
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion=direccion;	
	}
	public String getDireccion()
	{
		return this.direccion;
	}
	
	public void setTelefono(String telfono)
	{
		this.telefono=telfono;	
	}
	public String getTelefono()
	{
		return this.telefono;
	}
	
	public void setMail(String mail)
	{
		this.mail=mail;	
	}
	public String getMail()
	{
		return this.mail;
	}
	
	public void setUsuario(String usuario)
	{
		this.usuario=usuario;	
	}
	public String getUsuario()
	{
		return this.usuario;
	}
	
	public void setContrasenia(String contrasenia)
	{
		this.contrasenia=contrasenia;	
	}
	public String getContrasenia()
	{
		return this.contrasenia;
	}
	
	public void setTipoPersona(Entidades.TipoPersona oTipoPersona)
	{
		this.oTipoPersona=oTipoPersona;	
	}
	public Entidades.TipoPersona getTipoPersona()
	{
		return this.oTipoPersona;
	}
}
