package com.data;

import java.sql.*;

public class Conector {
	
/* atributos */
private static Connection conexion;
private static Conector INSTANCE=null;

/* constructor */

/* datos de la conexion - PRUEBA !!! */
public static void conectar() {
	String host = "127.0.0.1";
	String user = "root";
	String pass = "root";
	String dtbs = "alquiler_de_vehiculos";
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs
				+ "?" + "user=" + user + "&password=" + pass;
				conexion = DriverManager.getConnection(newConnectionURL);
	}catch (Exception e) {
		System.out.println("Error en la apertura de la conexión");
	}	
}

/* crea una instancia de la conexion */
private synchronized static void crearInstancia() {
    if (INSTANCE == null) { 
        INSTANCE = new Conector();
        conectar();
    }
}

/* método para obtener una instancia, si ya existiese la devuelve, sino la crea */
public static Conector obtenerInstancia() {
    if (INSTANCE == null) crearInstancia();
    return INSTANCE;
}

/* cerrar conexion */
public void desconectar() {
	try {
		conexion.close();
	}catch (Exception e) {
		System.out.println("Error al intentar desconectar");
	}
}

/* agregar un cliente */
public int addCliente(String tpo_DNI, int nro_DNI,
		String apellido, String nombre, String direccion, String telefono,
		String mail, String usuario, String contrasena) throws Exception {

	int claveGenerada = 0;
	try {
		PreparedStatement ps = conexion.prepareStatement(
						"INSERT INTO clientes "
								+ "(tpo_DNI,nro_DNI,apellido,nombre,direccion,telefono,mail,usuario,contrasenia) "
								+ "VALUES (?,?,?,?,?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS);

		ps.setString(1, tpo_DNI);
		ps.setInt(2, nro_DNI);
		ps.setString(3, apellido);
		ps.setString(4, nombre);
		ps.setString(5, direccion);
		ps.setString(6, telefono);
		if (mail == "") {ps.setString(7, null);} else {ps.setString(7, mail);}
		ps.setString(8,usuario);
		ps.setString(9,contrasena);
		ps.executeUpdate();
		/* Se obtiene la clave generada */
		ResultSet rs = ps.getGeneratedKeys();
		while (rs.next()) {claveGenerada = rs.getInt(1);}} 
	catch (SQLException sqlEx) {
		// TODO: handle exception 
		if (esErrorDeClaveDuplicada(sqlEx.getErrorCode())) {
			throw new Exception("ERROR al dar de alta al cliente "  
					 + nombre + " " + apellido + " ,ya existe.");
		} else {
			throw new Exception("ERROR SQL al dar de alta al cliente " + apellido + " " + nombre
					+ ": " + "(" + sqlEx.getErrorCode() + ")"
					+ sqlEx.getMessage());
		}
	} catch (Exception e) {
		throw new Exception("ERROR DESCONOCIDO al dar de alta a "
				+ apellido + " " + nombre + "..." + e.getMessage());
	}

	return claveGenerada;
}


private boolean esErrorDeClaveDuplicada(int errorode) {
	return errorode == 1062;
}


}
