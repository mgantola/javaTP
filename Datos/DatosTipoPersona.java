package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.TipoPersona;
import General.ConexionBD;

public class DatosTipoPersona {

	public DatosTipoPersona(){}
	
	public int altaTipoPersona(TipoPersona oTipoPersona) throws SQLException, Exception
	{
		String consulta="INSERT INTO tipos_persona (desc_tipo_persona) VALUES ("+oTipoPersona.getDescTipoPersona()+");";
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
		
	public int bajaTipoPersona(TipoPersona oTipoPersona) throws SQLException, Exception 
	{
		String consulta="DELETE FROM tipos_persona WHERE id_tipo_persona="+oTipoPersona.getIdTipoPersona()+";";
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
		
	public int modificacionTipoPersona(TipoPersona oTipoPersona) throws SQLException, Exception
	{
		String consulta="UPDATE tipos_persona SET desc_tipo_persona"+oTipoPersona.getDescTipoPersona()+
				" WHERE id_tipo_persona="+oTipoPersona.getIdTipoPersona()+";";
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
	    
	public TipoPersona getOne(int iIdTipoPersona) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM tipos_persona WHERE id_tipo_persona="+iIdTipoPersona+";";
		TipoPersona oTipoPersona;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);		
			
			if(resultado.next())
			{	
				oTipoPersona=new TipoPersona(resultado.getInt("id_tipo_persona"), 
						resultado.getString("desc_tipo_persona"));
			}
			else
			{
				oTipoPersona=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oTipoPersona;
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
			oTipoPersona=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<TipoPersona>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM tipos_persona;";
		TipoPersona oTipoPersona;
		ArrayList<TipoPersona>oListaTiposPersona;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oListaTiposPersona=new ArrayList<TipoPersona>();
			
			while(resultado.next())
			{	
				oTipoPersona=new TipoPersona(resultado.getInt("id_tipo_persona"), 
						resultado.getString("desc_tipo_persona"));
				oListaTiposPersona.add(oTipoPersona);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaTiposPersona;
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
			oTipoPersona=null;
			oListaTiposPersona=null;
			stmt=null;
			resultado=null;
		}	
	}
}
