package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Descuento;
import General.ConexionBD;

public class DatosDescuento {
	
	public DatosDescuento(){}
	
	public int altaDescuento(Descuento oDescuento) throws SQLException, Exception
	{
		String consulta="INSERT INTO descuentos (dia_desde, dia_hasta, porcentaje) VALUES"+
				" ("+oDescuento.getDiaDesde()+", "+oDescuento.getDiaHasta()+", "+oDescuento.getPorcentaje()+");";
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
		
	public int bajaDescuento(Descuento oDescuento) throws SQLException, Exception 
	{
		String consulta="DELETE FROM descuentos WHERE dia_hasta="+oDescuento.getDiaHasta()+
				" AND dia_desde="+oDescuento.getDiaDesde()+";";
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
		
	public int modificacionDescuento(Descuento oDescuento) throws SQLException, Exception
	{
		String consulta="UPDATE descuentos SET porcentaje="+oDescuento.getPorcentaje()+
				" WHERE dia_desde="+oDescuento.getDiaDesde()+" AND dia_hasta="+oDescuento.getDiaHasta()+";";
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
	    
	public Descuento getOne(int iDiaDesde, int iDiaHasta) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM categorias WHERE dia_desde="+iDiaDesde+" AND dia_hasta="+iDiaHasta+";";
		Descuento oDescuento;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);		
			
			if(resultado.next())
			{	
				oDescuento=new Descuento(resultado.getInt("dia_desde"), resultado.getInt("dia_hasta"), 
						resultado.getInt("procentaje"));
			}
			else
			{
				oDescuento=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oDescuento;
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
			oDescuento=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Descuento>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM categorias;";
		Descuento oDescuento;
		ArrayList<Descuento>oListaDescuentos;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oListaDescuentos=new ArrayList<Descuento>();
			
			while(resultado.next())
			{	
				oDescuento=new Descuento(resultado.getInt("dia_desde"), resultado.getInt("dia_hasta"), 
						resultado.getInt("porcentaje"));
				oListaDescuentos.add(oDescuento);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaDescuentos;
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
			oDescuento=null;
			oListaDescuentos=null;
			stmt=null;
			resultado=null;
		}	
	}
}
