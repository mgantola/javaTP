package General;

import java.sql.*;
import com.mysql.jdbc.exceptions.MySQLDataException;

public class ConexionBD {
	
	@SuppressWarnings("finally")
	public static Connection conexion()
	{
		Connection conexion=null;
		String servidor="jdbc:mysql://localhost/alquiler_de_vehiculos";
		String usuario="root";
		String contrasenia="root";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(servidor, usuario, contrasenia);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(MySQLDataException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			return conexion;
		}
	}
}
