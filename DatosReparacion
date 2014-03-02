package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Reparacion;
import General.ConexionBD;

public class DatosReparacion {

	public DatosReparacion(){}
	
	public int altaReparacion(Reparacion oReparacion) throws SQLException, Exception
	{
		String consulta="INSERT INTO reparaciones (patente, fec_desde, fec_hasta) VALUES"+
				"("+oReparacion.getVehiculo().getPatente()+", "+oReparacion.getFecDesde()+
				", "+oReparacion.getFecHasta()+");";
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
		
	public int bajaReparacion(Reparacion oReparacion) throws SQLException, Exception 
	{
		String consulta="DELETE FROM reparaciones WHERE patente="+oReparacion.getVehiculo().getPatente()+";";
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
		
	public int modificacionReparacion(Reparacion oReparacion) throws SQLException, Exception
	{
		String consulta="UPDATE reparaciones SET fec_hasta="+oReparacion.getFecHasta()+
				" WHERE patente="+oReparacion.getVehiculo().getPatente()+" AND fec_desde="+oReparacion.getFecDesde()+";";
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
	    
	public Reparacion getOne(String iPatente, String iFecDesde) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM reparaciones WHERE patente="+iPatente+" AND fec_desde="+iFecDesde+";";
		Reparacion oReparacion;
		Datos.DatosVehiculo oDatosVehiculo;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);
			
			oDatosVehiculo=new Datos.DatosVehiculo();
			
			if(resultado.next())
			{	
				oReparacion=new Reparacion(oDatosVehiculo.getOne(resultado.getString("patente")), 
						resultado.getString("fec_desde"), resultado.getString("fec_hasta"));
			}
			else
			{
				oReparacion=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oReparacion;
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
			oReparacion=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Reparacion>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM reparaciones;";
		Reparacion oReparacion;
		Datos.DatosVehiculo oDatosVehiculo;
		ArrayList<Reparacion>oListaReparaciones;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oDatosVehiculo=new Datos.DatosVehiculo();
			oListaReparaciones=new ArrayList<Reparacion>();
			
			while(resultado.next())
			{	
				oReparacion=new Reparacion(oDatosVehiculo.getOne(resultado.getString("patente")), 
						resultado.getString("fec_desde"), resultado.getString("fec_hasta"));
				oListaReparaciones.add(oReparacion);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaReparaciones;
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
			oReparacion=null;
			oListaReparaciones=null;
			stmt=null;
			resultado=null;
		}	
	}
}
