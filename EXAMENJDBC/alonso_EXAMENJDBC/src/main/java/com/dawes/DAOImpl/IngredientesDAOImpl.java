package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.IngredientesDAO;
import com.dawes.modelo.IngredientesVO;

public class IngredientesDAOImpl implements IngredientesDAO {

	private ResultSet rs;
	private PreparedStatement ps;

	// cada vez que hagamos una conexion/administracion de esta tabla llamaremos a
	// este constructor
	private Connection conexion;

	public IngredientesDAOImpl(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(IngredientesVO ingredienteSinId) {
		try {
			ps = conexion.prepareStatement("INSERT INTO ingredientes(nombre,tipo) VALUES(?,?); ");

			ps.setString(1, ingredienteSinId.getNombre());
			ps.setString(2, ingredienteSinId.getTipo());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(int idIngredientes) {
		try {
			ps = conexion.prepareStatement("DELETE FROM ingredientes WHERE idingredientes = ? ");

			ps.setInt(1, idIngredientes);

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(String nombre) {
		try {
			ps = conexion.prepareStatement("DELETE FROM ingredientes WHERE nombre = ? ");

			ps.setString(1, nombre);

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int modificar(IngredientesVO ingredienteConId) {
		try {
			ps= conexion.prepareStatement("UPDATE ingredientes SET nombre = ?, tipo = ?, WHERE idingredientes=?");
			ps.setString(1, ingredienteConId.getNombre());
			ps.setString(2, ingredienteConId.getTipo());
			ps.setInt(3, ingredienteConId.getIdingredientes());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 
	}

	public IngredientesVO leerIgual(int idIngredientes) {
		IngredientesVO ingrediente = null;
		try {
			ps = conexion.prepareStatement("DELETE FROM ingredientes WHERE idingredientes = ?");
			ps.setInt(1, idIngredientes);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ingrediente = new IngredientesVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
			return ingrediente;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public IngredientesVO leerIgual(String nombreIngrediente) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM ingredientes WHERE nombre = ?");
			ps.setString(1, nombreIngrediente);
			
			rs = ps.executeQuery();
			
			IngredientesVO ingrediente = null;
			if(rs.next())
				ingrediente= new IngredientesVO(rs.getInt(1), rs.getString(2),rs.getString(3));
			return ingrediente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<IngredientesVO> leerTodo() {
		try {
			ps = conexion.prepareStatement("SELECT * FROM ingredientes");
			
			rs = ps.executeQuery();
			
			HashSet<IngredientesVO> ingredientes = new HashSet<IngredientesVO>();
			while(rs.next()) {
				ingredientes.add(new IngredientesVO(rs.getInt(1), rs.getString(2),rs.getString(3)));				
			}
			return ingredientes;			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
