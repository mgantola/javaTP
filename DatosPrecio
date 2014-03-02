package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;
// Probablemente haya que hacer tratamiento de fecha a string y viceversa, por eso los últimos 4 imports

import Entidades.Precio;
import General.ConexionBD;

public class DatosPrecio {

	public DatosPrecio(){}
	
	public int altaPrecio(Precio oPrecio) throws SQLException, Exception
	{
		String consulta="INSERT INTO precios (id_categoria, fec_desde_precio, importe) VALUES"+
				" ("+oPrecio.getCategoria().getIdCategoria()+", "+oPrecio.getFecDesdePrecio()+", "+oPrecio.getImporte()+");";
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
		
	public int bajaPrecio(Precio oPrecio) throws SQLException, Exception 
	{
		String consulta="DELETE FROM precios WHERE id_categoria="+oPrecio.getCategoria().getIdCategoria()+
				" AND fec_desde_precio="+oPrecio.getFecDesdePrecio()+";";
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
		
	public int modificacionPrecio(Precio oPrecio) throws SQLException, Exception
	{
		String consulta="UPDATE precios SET importe="+oPrecio.getImporte()+
				" WHERE id_categoria="+oPrecio.getCategoria().getIdCategoria()+
				" AND fec_desde_precio="+oPrecio.getFecDesdePrecio()+";";
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
	    
	public Precio getOne(int iIdCategoria, String iFecDesdePrecio) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM precios WHERE id_categoria="+iIdCategoria+
	   			" AND fec_desde_precio="+iFecDesdePrecio+";";
		Precio oPrecio;
		Datos.DatosCategoria oDatosCategoria;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);
			
			oDatosCategoria=new Datos.DatosCategoria();
			
			if(resultado.next())
			{	
				oPrecio=new Precio(oDatosCategoria.getOne(resultado.getInt("id_categoria")), 
						resultado.getString("fec_desde_precio"), resultado.getFloat("importe"));
			}
			else
			{
				oPrecio=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oPrecio;
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
			oPrecio=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Precio>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM precios;";
		Precio oPrecio;
		Datos.DatosCategoria oDatosCategoria;
		ArrayList<Precio>oListaPrecios;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oDatosCategoria=new Datos.DatosCategoria();
			oListaPrecios = new ArrayList<Precio>();
			
			while(resultado.next())
			{	
				oPrecio=new Precio(oDatosCategoria.getOne(resultado.getInt("id_categoria")), 
						resultado.getString("fec_desde_precio"), resultado.getFloat("importe"));
				oListaPrecios.add(oPrecio);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaPrecios;
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
			oPrecio=null;
			oListaPrecios=null;
			stmt=null;
			resultado=null;
		}	
	}
}
