package com.dawes.ejercicio3.repositorioJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dawes.ejercicio2.Departamentos;
import com.dawes.ejercicio3.repositorio.DepartamentoRepository;

public class DepartamentoRepositoryJDBC implements DepartamentoRepository {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;

	public DepartamentoRepositoryJDBC(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(Departamentos departamento) {
		try {
			ps = conexion.prepareStatement("INSERT INTO departamentos(denominacion,localidad) VALUES (?,?);");
			ps.setString(1, departamento.getDenominacion());
			ps.setString(2, departamento.getLocalidad());

			ps.executeUpdate();

			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int eliminar(Departamentos departamento) {

		try {
			ps = conexion.prepareStatement("DELETE FROM departamentos WHERE denominacion=?");
			ps.setString(1, departamento.getDenominacion());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int modificar(Departamentos departamento) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Departamentos leerIgual(String denominacion) {
		Departamentos departamento = null;
		try {
			ps = conexion.prepareStatement("SELECT * FROM departamentos WHERE denominacion = ?");
			ps.setString(1, denominacion);
			
			rs = ps.executeQuery();
			while(rs.next()) {				
				departamento = new Departamentos(rs.getString(2),rs.getString(3));
			}
			return departamento;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Departamentos> leerTodos() {
		ArrayList<Departamentos> listaDepartamentos = new ArrayList<Departamentos>();
		try {
			ps = conexion.prepareStatement("SELECT * FROM departamentos");
			rs = ps.executeQuery();
			while(rs.next()) {
				listaDepartamentos.add(new Departamentos(rs.getString(1),rs.getString(2)));
			}
			return listaDepartamentos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
