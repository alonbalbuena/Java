package com.dawes.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1 {

	private Connection conexion;

	public static void main(String[] args) {

		Ejercicio1 ej1 = new Ejercicio1();

		ej1.conectar();
		
		ej1.verUsuarios();

	}

	public void conectar() {
		try {
			// cambiamos la zona horario de mysql previamente "SET GLOBAL time_zone =
			// '-3:00';"
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/tema1", "root", "temporal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertarUsuario(String dni, String nombre, int edad) {

		PreparedStatement query;
		try {
			query = conexion.prepareStatement("INSERT INTO usuarios VALUES (?,?,?);");
			query.setString(1, dni);
			query.setString(2, nombre);
			query.setInt(3, edad);

			query.executeUpdate();// devuelve el numero de filas afectado, solo para DML

			query.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void verUsuarios() {
		PreparedStatement query;

		try {
			query = conexion.prepareStatement("SELECT * FROM usuarios");

			ResultSet cursor = query.executeQuery();// devuelve un cursor, util para consultas(SELECT)
			
			while(cursor.next()) {
				System.out.println(cursor.getString(1)+","+cursor.getString(2)+","+cursor.getInt(3));				
			}
			
			query.close();

		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}
}
