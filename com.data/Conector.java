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


}
