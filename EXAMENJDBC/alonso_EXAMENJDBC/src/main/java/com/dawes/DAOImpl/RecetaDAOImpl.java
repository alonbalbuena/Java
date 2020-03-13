package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.RecetaDAO;
import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaVO;

public class RecetaDAOImpl implements RecetaDAO {

	private ResultSet rs;
	private PreparedStatement ps;

	// cada vez que hagamos una conexion/administracion de esta tabla llamaremos a
	// este constructor
	private Connection conexion;

	public RecetaDAOImpl(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(RecetaVO recetaSinId) {
		try {
			ps = conexion.prepareStatement("INSERT INTO receta (nombre,descripcion,fecha,tipo) VALUES (?,?,?,?)");
			ps.setString(1, recetaSinId.getNombre());
			ps.setString(2, recetaSinId.getDescripcion());
			ps.setObject(3, recetaSinId.getFecha());
			ps.setString(4, recetaSinId.getTipo());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(int idReceta) {
		try {
			ps = conexion.prepareStatement("DELETE FROM receta WHERE idreceta= ?");
			ps.setInt(1, idReceta);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(String nombreReceta) {
		try {
			ps = conexion.prepareStatement("DELETE FROM receta WHERE nombre = ?");
			ps.setString(1, nombreReceta);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int modificar(RecetaVO recetaConId) {
		try {
			ps = conexion.prepareStatement(
					"UPDATE receta SET nombre = ?, descripcion= ?, fecha =?, tipo =? WHERE idreceta= ?");
			ps.setString(1, recetaConId.getNombre());
			ps.setString(2, recetaConId.getDescripcion());
			ps.setObject(3, recetaConId.getFecha());
			ps.setString(4, recetaConId.getTipo());
			ps.setInt(5, recetaConId.getIdReceta());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public RecetaVO leerIgual(int idReceta) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM receta WHERE idrecetas= ?");
			ps.setInt(1, idReceta);
			rs = ps.executeQuery();

			RecetaVO receta = null;
			if (rs.next()) {
				receta = new RecetaVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5));
			}
			return receta;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public RecetaVO leerIgual(String nombreReceta) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM receta WHERE nombre= ?");
			ps.setString(1, nombreReceta);
			rs = ps.executeQuery();

			RecetaVO receta = null;
			if (rs.next()) {
				receta = new RecetaVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5));
			}
			return receta;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<RecetaVO> leerTodo() {
		try {
			ps = conexion.prepareStatement("SELECT * FROM receta");
			rs = ps.executeQuery();

			HashSet<RecetaVO> recetas = new HashSet<RecetaVO>();
			while (rs.next()) {
				recetas.add(new RecetaVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5)));
			}
			return recetas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public HashSet<RecetaVO> mostrarRecetasPorIngrediente(IngredientesVO ingrediente) {
		try {
			ps = conexion.prepareStatement("SELECT r.idreceta,r.nombre,descripcion,fecha,r.tipo \r\n"
					+ "FROM receta as r,ingredientes as i,recetaingredientes as u\r\n"
					+ "WHERE r.idreceta = u.idreceta\r\n"
					+ "AND u.idingrediente = i.idingredientes\r\n"
					+ "AND i.idingredientes =?"
					+ "ORDER BY r.tipo ");

			ps.setInt(1, ingrediente.getIdingredientes());

			rs = ps.executeQuery();
			
			HashSet<RecetaVO> recetas = new HashSet<RecetaVO>();
			while (rs.next()) {
				recetas.add(new RecetaVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate(),
						rs.getString(5)));
			}
			return recetas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
