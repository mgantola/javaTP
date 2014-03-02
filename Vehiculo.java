package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Vehiculo;
import General.ConexionBD;

public class DatosVehiculo {

	public DatosVehiculo(){}
	
	public int altaVehiculo(Vehiculo oVehiculo) throws SQLException, Exception
	{
		String consulta="INSERT INTO vehiculos (patente, desc_vehiculo, id_categoria) VALUES"+
					"("+oVehiculo.getPatente()+", "+oVehiculo.getDescVehiculo()+
					", "+oVehiculo.getCategoria().getIdCategoria()+");";
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
		
	public int bajaVehiculo(Vehiculo oVehiculo) throws SQLException, Exception 
	{
		String consulta="DELETE FROM vehiculos WHERE patente="+oVehiculo.getPatente()+";";
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
		
	public int modificacionVehiculo(Vehiculo oVehiculo) throws SQLException, Exception
	{
		String consulta="UPDATE vehiculos SET patente="+oVehiculo.getPatente()+
				", desc_vehiculo="+oVehiculo.getDescVehiculo()+
				", telefono="+oVehiculo.getCategoria().getIdCategoria()+";";
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
	    
	public Vehiculo getOne(String iPatente) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM vehiculos WHERE patente="+iPatente+";";
		Vehiculo oVehiculo;
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
				oVehiculo=new Vehiculo(resultado.getString("patente"), resultado.getString("fec_desde"),  
						oDatosCategoria.getOne(resultado.getInt("id_categoria")));
			}
			else
			{
				oVehiculo=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oVehiculo;
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
			oVehiculo=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Vehiculo>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM personas;";
		Vehiculo oVehiculo;
		Datos.DatosCategoria oDatosCategoria;
		ArrayList<Vehiculo>oListaVehiculos;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oDatosCategoria=new Datos.DatosCategoria();
			oListaVehiculos=new ArrayList<Vehiculo>();
			
			while(resultado.next())
			{	
				oVehiculo=new Vehiculo(resultado.getString("patente"), resultado.getString("fec_desde"),  
						oDatosCategoria.getOne(resultado.getInt("id_categoria")));
				oListaVehiculos.add(oVehiculo);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaVehiculos;
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
			oVehiculo=null;
			oListaVehiculos=null;
			stmt=null;
			resultado=null;
		}	
	}
}
