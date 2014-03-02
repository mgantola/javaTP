package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Persona;
import General.ConexionBD;

public class DatosPersona {

	public DatosPersona(){}
	
	public int altaPersona(Persona oPersona) throws SQLException, Exception
	{
		String consulta="INSERT INTO personas (tpo_DNI, nro_DNI, apellido, nombre, direccion, telefono, mail, usuario,"+
				" contrasenia, id_tipo_persona) VALUES ("+oPersona.getTpoDNI()+", "+oPersona.getNroDNI()+
				", "+oPersona.getApellido()+", "+oPersona.getNombre()+", "+oPersona.getDireccion()+
				", "+oPersona.getTelefono()+", "+oPersona.getMail()+", "+oPersona.getUsuario()+
				", "+oPersona.getContrasenia()+", "+oPersona.getTipoPersona().getIdTipoPersona()+");";
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
		
	public int bajaPersona(Persona oPersona) throws SQLException, Exception 
	{
		String consulta="DELETE FROM personas WHERE tpo_DNI="+oPersona.getTpoDNI()+" AND nro_DNI= "
				+oPersona.getNroDNI()+";";
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
		
	public int modificacionPersona(Persona oPersona) throws SQLException, Exception
	{
		String consulta="UPDATE personas SET apellido="+oPersona.getApellido()+", nombre="+oPersona.getNombre()+
				", telefono="+oPersona.getTelefono()+", mail="+oPersona.getMail()+", usuario"+oPersona.getUsuario()+
				", contrasenia="+oPersona.getContrasenia()+", id_tipo_persona"+oPersona.getTipoPersona().getIdTipoPersona()+
				" WHERE tpo_DNI="+oPersona.getTpoDNI()+" AND nro_dni="+oPersona.getNroDNI()+";";
		// Puse el usuario y la contraseña pero tal vez haya que hacerlo separado o no permitir cambiar el usuario
		// Si cambia el usuario debería haber una excepción que chequee que el usuario ya existe y no puede cambiarlo
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
	    
	public Persona getOne(String iTpoDNI, int iNroDNI) throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM personas WHERE tpo_DNI="+iTpoDNI+", nro_DNI="+iNroDNI+";";
		Persona oPersona;
		Datos.DatosTipoPersona oDatosTipoPersona;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);
			
			oDatosTipoPersona=new Datos.DatosTipoPersona();
			
			if(resultado.next())
			{	
				oPersona=new Persona(resultado.getString("tpo_DNI"), resultado.getInt("nro_DNI"), 
						resultado.getString("apellido"), resultado.getString("nombre"), resultado.getString("direccion"), 
						resultado.getString("telefono"), resultado.getString("mail"), resultado.getString("usuario"), 
						resultado.getString("contrasenia"), oDatosTipoPersona.getOne(resultado.getInt("id_tipo_persona")));
			}
			else
			{
				oPersona=null;
			}
			
			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oPersona;
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
			oPersona=null;
			stmt=null;
			resultado=null;
		}			
	}
	   
	public ArrayList<Persona>getAll() throws SQLException, Exception
	{
	   	String consulta="SELECT * FROM personas;";
		Persona oPersona;
		Datos.DatosTipoPersona oDatosTipoPersona;
		ArrayList<Persona>oListaPersonas;
		Statement stmt;
		ResultSet resultado;
		
		try
		{
			ConexionBD.conexion();
			stmt=ConexionBD.conexion().createStatement();
		
			resultado=stmt.executeQuery(consulta);	
			
			oDatosTipoPersona=new Datos.DatosTipoPersona();
			oListaPersonas=new ArrayList<Persona>();
			
			while(resultado.next())
			{	
				oPersona=new Persona(resultado.getString("tpo_DNI"), resultado.getInt("nro_DNI"), resultado.getString("apellido"), 
						resultado.getString("nombre"), resultado.getString("direccion"), resultado.getString("telefono"), 
						resultado.getString("mail"), resultado.getString("usuario"), resultado.getString("contrasenia"), 
						oDatosTipoPersona.getOne(resultado.getInt("id_tipo_persona")));
				oListaPersonas.add(oPersona);
			}	

			resultado.close();
			stmt.close();
			ConexionBD.conexion().close();
			
			return oListaPersonas;
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
			oPersona=null;
			oListaPersonas=null;
			stmt=null;
			resultado=null;
		}	
	}
}
