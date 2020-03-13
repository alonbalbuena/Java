package com.dawes.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gestion {

	private Connection conexion;
	private PreparedStatement ps;

	public Gestion() {
		conexion();
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public int addDepartamento(Departamentos departamento) {

		try {
			ps = conexion.prepareStatement("INSERT INTO departamentos(denominacion,localidad) VALUES (?,?)");

			ps.setString(1, departamento.getDenominacion());
			ps.setString(2, departamento.getLocalidad());

			ps.executeUpdate();
			
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void conexion() {

		try {
			// cambiamos la zona horario de mysql previamente "SET GLOBAL time_zone =
			// '+1:00';"
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/tema1", "root", "temporal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addEmpleado(Empleados empleado) {

		try {
			// cremos el formato en el que queremos la fecha
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
			// creamos la fecha con ese formato
			LocalDate fechaJava = LocalDate.parse(empleado.getFechaContrato(), formato);

			ps = conexion.prepareStatement("INSERT INTO empleados(dni,nombre,salario,fechaContrato,idDepartamento)"
					+ " VALUES (?,?,?,?,?)");
			// el primer valor es autoincrementado y no lo definimos, ya lo hace la BD
			ps.setString(1, empleado.getDni());
			ps.setString(2, empleado.getNombre());
			ps.setDouble(3, empleado.getSalario());
			ps.setObject(4, fechaJava);// para usar LocalDate es necesario setObject
			ps.setInt(5, empleado.getDepartamento().getIdDepartamento());

			ps.executeUpdate();
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
