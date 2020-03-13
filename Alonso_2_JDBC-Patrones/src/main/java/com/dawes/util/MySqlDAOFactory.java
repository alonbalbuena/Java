package com.dawes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dawes.DAOImpl.CuentaDAOImpl;
import com.dawes.DAOImpl.MovimientoDAOImpl;

public class MySqlDAOFactory {

	private Connection conexion;
	
	//para evitar que se instancie mas de un DAO usamos el metodo singleton
	//declaramos un objeto privado y estatico de la clase que implementa el patron singleton
	private static MySqlDAOFactory dao;
	
	//declaramos constructor privado
	private MySqlDAOFactory() {
		try {
			// cambiamos la zona horaria en mysql "SET GLOBAL time_zone ='+1:00';"
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/alonso_2_jdbc-patrones", "root", "Hacendado15*");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//declaramos un método estatico, que devuelve la instancia unica de esta clase
	public static MySqlDAOFactory getDAO() {
		//usamos el singleton para verificar que solo realizamos solo un objeto
		if(dao == null) {
			dao = new MySqlDAOFactory();
		}
		return dao;
	}
	
	public CuentaDAOImpl getCuentasRepositorioJDBC() {
		return new CuentaDAOImpl(conexion);
	}
	
	public MovimientoDAOImpl getMovimientosRepositorioJDBC() {
		return new MovimientoDAOImpl(conexion);
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}
