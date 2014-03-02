package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Servicio;
import General.ConexionBD;

public class DatosServicio {

	public DatosServicio(){}
	
	public int altaServicio(Servicio oServicio) throws SQLException, Exception
	{
		String consulta="INSERT INTO servicios (fec_servicio, fec_cancelacion, motivo_cancelacion, tpo_DNI, nro_DNI,"+
				" dia_desde, dia_hasta, patente) VALUES ("+oServicio.getFecServicio()+", "+oServicio.getFecCancelacion()+
				", "+oServicio.getMotivoCancelacion()+", "+oServicio.getPersona().getTpoDNI()+
				", "+oServicio.getPersona().getNroDNI()+", "+oServicio.getDescuento().getDiaDesde()+
				", "+oServicio.getDescuento().getDiaHasta()+", "+oServicio.getVehiculo().getPatente()+");";
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
		
	public int bajaServicio(Servicio oServicio) throws SQLException, Exception 
	{
		String consulta="DELETE FROM servicios WHERE nro_reserva="+oServicio.getNroReserva()+";";
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
		
	public int modificacionServicio(Servicio oServicio) throws SQLException, Exception
	{
		String consulta="UPDATE servicios SET fec_servicio="+oServicio.getFecServicio()+
				", fec_cancelacion="+oServicio.getFecCancelacion()+", motivo_cancelacion="+oServicio.getMotivoCancelacion()+
				", tpo_DNI="+oServicio.getPersona().getTpoDNI()+", nro_DNI="+oServicio.getPersona().getNroDNI()+
				", dia_desde="+oServicio.getDescuento().getDiaDesde()+", dia_hasta="+oServicio.getDescuento().getDiaHasta()+
				", patente="+oServicio.getVehiculo().getPatente()+" WHERE nro_reserva="+oServicio.getNroReserva()+";";
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
	    
	public Servicio getOne(int iNroReserva) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM servicios WHERE nro_reserva="+iNroReserva+";";
		Servicio oServicio;
		Datos.DatosPersona oDatosPersona;
		Datos.DatosDescuento oDatosDescuento;
		Datos.DatosVehiculo oDatosVehiculo;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);
			
			oDatosPersona=new Datos.DatosPersona();
			oDatosDescuento=new Datos.DatosDescuento();
			oDatosVehiculo=new Datos.DatosVehiculo();
			
			if(resultado.next())
			{	
				oServicio=new Servicio(resultado.getInt("nro_reserva"), resultado.getString("fec_servicio"), 
						resultado.getString("fec_cancelacion"), resultado.getString("motivo_cancelacion"), 
						oDatosPersona.getOne(resultado.getString("tpo_DNI"), resultado.getInt("nro_DNI")), 
						oDatosDescuento.getOne(resultado.getInt("dia_desde"), resultado.getInt("dia_hasta")), 
						oDatosVehiculo.getOne(resultado.getString("patente")));
			}
			else
			{
				oServicio=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oServicio;
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
			oServicio=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Servicio>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM servicios;";
		Servicio oServicio;
		Datos.DatosPersona oDatosPersona;
		Datos.DatosDescuento oDatosDescuento;
		Datos.DatosVehiculo oDatosVehiculo;
		ArrayList<Servicio>oListaServicios;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oDatosPersona=new Datos.DatosPersona();
			oDatosDescuento=new Datos.DatosDescuento();
			oDatosVehiculo=new Datos.DatosVehiculo();
			oListaServicios=new ArrayList<Servicio>();
			
			while(resultado.next())
			{	
				oServicio=new Servicio(resultado.getInt("nro_reserva"), resultado.getString("fec_servicio"), 
						resultado.getString("fec_cancelacion"), resultado.getString("motivo_cancelacion"), 
						oDatosPersona.getOne(resultado.getString("tpo_DNI"), resultado.getInt("nro_DNI")), 
						oDatosDescuento.getOne(resultado.getInt("dia_desde"), resultado.getInt("dia_hasta")), 
						oDatosVehiculo.getOne(resultado.getString("patente")));
				oListaServicios.add(oServicio);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaServicios;
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
			oServicio=null;
			oListaServicios=null;
			stmt=null;
			resultado=null;
		}	
	}
}
