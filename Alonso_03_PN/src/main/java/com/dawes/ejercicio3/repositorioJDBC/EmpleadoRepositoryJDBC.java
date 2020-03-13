package com.dawes.ejercicio3.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.dawes.ejercicio2.Departamentos;
import com.dawes.ejercicio2.Empleados;
import com.dawes.ejercicio3.repositorio.EmpleadoRepository;

public class EmpleadoRepositoryJDBC implements EmpleadoRepository {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexion;

	public EmpleadoRepositoryJDBC(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(Empleados empleado) {

		try {
			// cremos el formato en el que queremos la fecha
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
			// creamos la fecha con ese formato
			LocalDate fechaJava = LocalDate.parse(empleado.getFechaContrato(), formato);

			ps = conexion.prepareStatement(
					"INSERT INTO empleados(dni,nombre,salario,fecha,departamento)" + " VALUES (?,?,?,?,?)");
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
			return 0;
		}

	}

	public int eliminar(Empleados empleado) {
		try {
			ps = conexion.prepareStatement("DELETE FROM empleados WHERE 'dni'=?");
			ps.setString(1, empleado.getDni());
			ps.executeUpdate();

			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int modificar(Empleados empleado) {
		try {
			ps = conexion.prepareStatement("UPDATE empleados SET nombre=? WHERE idEmpleado=?");
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Empleados leerIgual(String dni) {

		try {
			ps = conexion.prepareStatement("SELECT * FROM empleados WHERE 'dni'=?");
			ps.setString(1, dni);
			rs = ps.executeQuery();

			return new Empleados(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
					(Departamentos) rs.getObject(5));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Empleados> leerTodos() {
		ArrayList<Empleados> array = new ArrayList<Empleados>();
		try {
			ps = conexion.prepareStatement("SELECT * FROM empleados");
			rs = ps.executeQuery();

			while (rs.next()) {
				array.add(new Empleados(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
						(Departamentos) rs.getObject(5)));
			}
			return array;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
