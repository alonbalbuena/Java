package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.RecetaIngredientesDAO;
import com.dawes.modelo.IngredientesVO;
import com.dawes.modelo.RecetaIngredientesVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.serviciosImpl.ServicioIngredientesImpl;
import com.dawes.serviciosImpl.ServicioRecetaImpl;

public class RecetaIngredientesDAOImpl implements RecetaIngredientesDAO {

	private ResultSet rs;
	private PreparedStatement ps;

	// cada vez que hagamos una conexion/administracion de esta tabla llamaremos a
	// este constructor
	private Connection conexion;

	public RecetaIngredientesDAOImpl(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(RecetaIngredientesVO relacionSinId,IngredientesVO ingredienteConID,RecetaVO recetaConID) {
		try {
			ps = conexion.prepareStatement(
					"INSERT INTO recetaingredientes(cantidad,idreceta,idingrediente)" + " VALUES (?,?,?) ");

			ps.setInt(1, relacionSinId.getCantidad());
			
			// para introducir los id, debemos de pasarlos por parametros
			ps.setInt(2,ingredienteConID.getIdingredientes() );
			ps.setInt(3,recetaConID.getIdReceta());
			
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(int idRecetaIngredientes) {
		try {
			ps = conexion.prepareStatement("DELETE FROM recetaingredientes WHERE idrecetaingredientes = ?");
			ps.setInt(1, idRecetaIngredientes);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	public int modificar(RecetaIngredientesVO relacionConId) {
		try {
			ps = conexion.prepareStatement("UPDATE SET cantidad = ?, idreceta = ?,idingrediente = ? WHERE idrecetaingredientes = ?");
			ps.setInt(1,relacionConId.getCantidad());
			ps.setInt(2, relacionConId.getIdreceta().getIdReceta());
			ps.setInt(3, relacionConId.getIdingrediente().getIdingredientes());
			ps.setInt(4, relacionConId.getIdrecetaingredientes());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public RecetaIngredientesVO leerIgual(int idRecetaIngrediente) {
		try {
			ps= conexion.prepareStatement("SELECT * FROM relacion WHERE idrelacion = ?");
			ps.setInt(1, idRecetaIngrediente);
			
			rs = ps.executeQuery();
			
			//debemos de buscar las recetas para encontrar su id
			ServicioRecetaImpl servicioReceta = new ServicioRecetaImpl();
			ServicioIngredientesImpl servicioIngredientes = new ServicioIngredientesImpl();
			
			if(rs.next())
				return new RecetaIngredientesVO(rs.getInt(1),
						rs.getInt(2),
						servicioReceta.mostrarReceta(rs.getInt(3)),
						servicioIngredientes.mostrarIngrediente(rs.getInt(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	}

	public Set<RecetaIngredientesVO> leerTodo() {
		try {
			ps= conexion.prepareStatement("SELECT * FROM relacion");
			
			rs = ps.executeQuery();
			
			//debemos de buscar las recetas para encontrar su id
			ServicioRecetaImpl servicioReceta = new ServicioRecetaImpl();
			ServicioIngredientesImpl servicioIngredientes = new ServicioIngredientesImpl();
			
			HashSet<RecetaIngredientesVO> listaRecetaIngredientes = new HashSet<RecetaIngredientesVO>();
			while(rs.next()) {
				listaRecetaIngredientes.add(
						new RecetaIngredientesVO(rs.getInt(1),
						rs.getInt(2),
						servicioReceta.mostrarReceta(rs.getInt(3)),
						servicioIngredientes.mostrarIngrediente(rs.getInt(4)))
						);
			}
			return listaRecetaIngredientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	}

}
