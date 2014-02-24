package alquilervehiculos.cd;

import java.sql.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;

public class conector {

public void conectar(String servidor, String usuario, String contraseña){
	
	Connection conexion = DriverManager.getConnection(servidor, usuario, contraseña);
	
	Statement st = conexion.createStatement();
	
	System.out.println("Si he llegado hasta aquí es que se ha producido la conexión");

	System.out.println("Si no se hubiera producido, se habría disparado SQLException");

	ResultSet rs = st.executeQuery("'select * from estudiantes'");

	while (rs.next());
}

}
