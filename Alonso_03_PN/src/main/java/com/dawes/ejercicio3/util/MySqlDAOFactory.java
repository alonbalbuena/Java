package com.dawes.ejercicio3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dawes.ejercicio3.repositorio.DepartamentoRepository;
import com.dawes.ejercicio3.repositorio.EmpleadoRepository;
import com.dawes.ejercicio3.repositorioJDBC.DepartamentoRepositoryJDBC;
import com.dawes.ejercicio3.repositorioJDBC.EmpleadoRepositoryJDBC;

public class MySqlDAOFactory {

	private Connection conexion;

	public MySqlDAOFactory() {
		try {
			// cambiamos la zona horaria en mysql "SET GLOBAL time_zone ='+1:00';"
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/tema1", "root", "temporal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DepartamentoRepository getDepartamentoRepositoryJDBC() {
		return new DepartamentoRepositoryJDBC(conexion);
	}
	
	public EmpleadoRepository getEmpleadoRepositoryJDBC() {
		return new EmpleadoRepositoryJDBC(conexion);
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
}
