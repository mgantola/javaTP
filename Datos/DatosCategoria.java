package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Categoria;
import General.ConexionBD;

public class DatosCategoria {

	public DatosCategoria(){}
	
	public int altaCategoria(Categoria oCategoria) throws SQLException, Exception
	{
		String consulta="INSERT INTO categorias (desc_categoria) VALUES ("+oCategoria.getDescCategoria()+");";
		Statement stmt;
		int resultado=0;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
			
			resultado=stmt.executeUpdate(consulta);
			
			stmt.close();
			ConexionBD.conexion().close();
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex) 
		{
			throw ex;
		}
		finally
		{
			consulta=null;
			stmt=null;
		}	
		return resultado;
	}
		
	public int bajaCategoria(Categoria oCategoria) throws SQLException, Exception 
	{
		String consulta="DELETE FROM categorias WHERE id_categoria="+oCategoria.getIdCategoria()+";";
		Statement stmt;
		int resultado=0;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
			
			resultado=stmt.executeUpdate(consulta);
			
			stmt.close();
			ConexionBD.conexion().close();
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex) 
		{
			throw ex;
		}
		finally
		{
			consulta=null;
			stmt=null;
		}	
		return resultado;
	} // COMPLETAR CON EL BORRADO DE LAS FORÁNEAS
		
	public int modificacionCategoria(Categoria oCategoria) throws SQLException, Exception
	{
		String consulta="UPDATE categorias SET desc_categoria="+oCategoria.getDescCategoria()+
				" WHERE id_categoria="+oCategoria.getIdCategoria()+";";
		Statement stmt;
		int resultado=0;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
			
			resultado=stmt.executeUpdate(consulta);
			
			stmt.close();
			ConexionBD.conexion().close();
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex) 
		{
			throw ex;
		}
		finally
		{
			consulta=null;
			stmt=null;
		}	
		return resultado;
	}
	    
	public Categoria getOne(int iIdCategoria) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM categorias WHERE id_categoria="+iIdCategoria+";";
		Categoria oCategoria;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);		
			
			if(resultado.next())
			{	
				oCategoria=new Categoria(resultado.getInt("id_categoria"), resultado.getString("desc_categoria"));
			}
			else
			{
				oCategoria=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oCategoria;
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw ex;
		}
		finally
		{
			consulta=null;
			oCategoria=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Categoria>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM categorias;";
		Categoria oCategoria;
		ArrayList<Categoria>oListaCategorias;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oListaCategorias=new ArrayList<Categoria>();
			
			while(resultado.next())
			{	
				oCategoria=new Categoria(resultado.getInt("id_categoria"), resultado.getString("desc_categoria"));
				oListaCategorias.add(oCategoria);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaCategorias;
		}
		catch (SQLException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			throw ex;
		}
		finally
		{
			consulta=null;
			oCategoria=null;
			oListaCategorias=null;
			stmt=null;
			resultado=null;
		}	
	}
}
