package Entidades;

public class Categoria {
	private int idCategoria;
	private String descCategoria;
	
	public Categoria(){} // Constructor para instanciar la clase
	
	public Categoria(int idCategoria, String descCategoria)
	{
		this.idCategoria=idCategoria;
		this.descCategoria=descCategoria;
	} // Para asignar los parámetros del constructor
	
	public void setIdCategoria(int idCategoria)
	{
		this.idCategoria=idCategoria;
	} // Asignar
	public int getIdCategoria()
	{
		return this.idCategoria;
	} // Recuperar
	
	public void setDescCategoria(String descCategoria)
	{
		this.descCategoria=descCategoria;
	}
	public String getDescCategoria()
	{
		return this.descCategoria;
	}
}
