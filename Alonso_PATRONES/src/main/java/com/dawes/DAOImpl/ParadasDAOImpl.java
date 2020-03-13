package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.ParadasDAO;
import com.dawes.modelo.ParadasVO;

public class ParadasDAOImpl implements ParadasDAO {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexion;

	public ParadasDAOImpl(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(ParadasVO parada) {
		try {
			ps = conexion.prepareStatement("INSERT INTO paradas (denominacion, fecha) values ?,?");
			ps.setString(1, parada.getDenominacion());
			ps.setObject(2, parada.getFecha());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int modificar(ParadasVO parada) {
		try {
			ps = conexion.prepareStatement("UPDATE paradas SET denominacion = ?, fecha = ? where idparada = ?");
			ps.setString(1, parada.getDenominacion());
			ps.setObject(2, parada.getFecha());
			ps.setInt(3, parada.getIdParada());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(int idparada) {
		try {
			ps = conexion.prepareStatement("DELETE FROM paradas WHERE ideparad=?");
			ps.setInt(1, idparada);

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(ParadasVO parada) {
		// TODO Auto-generated method stub
		try {
			ps = conexion.prepareStatement("DELETE FROM paradas WHERE ideparad=?");
			ps.setInt(1, parada.getIdParada());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ParadasVO leerIgual(String denominacion) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM paradas WHERE denominacion =?");
			ps.setString(1, denominacion);

			rs = ps.executeQuery();

			ParadasVO parada = null;

			while (rs.next()) {
				parada = new ParadasVO(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate());
			}
			return parada;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ParadasVO leerIgual(int idparada) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM paradas WHERE idparada =?");
			ps.setInt(1, idparada);

			rs = ps.executeQuery();

			ParadasVO parada = null;
			while (rs.next()) {
				parada = new ParadasVO(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate());
			}
			return parada;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<ParadasVO> leerTodos() {
		try {
			ps = conexion.prepareStatement("SELECT * FROM paradas ");

			rs = ps.executeQuery();

			Set<ParadasVO>  parada = new HashSet<ParadasVO>();
			while (rs.next()) {
				parada.add(new ParadasVO(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate()));
			}
			return parada;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

}
