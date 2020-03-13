package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.LineasDAO;
import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineasVO;
import com.dawes.serviciosImpl.ServicioLineasImpl;
import com.dawes.serviciosImpl.ServicioParadasImpl;

public class LineaDAOImpl implements LineasDAO {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;

	public LineaDAOImpl(Connection conexion) {
		this.setConexion(conexion);
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public int insertar(LineasVO linea) {

		try {
			ps = conexion.prepareStatement("INSERT INTO lineas (dencorta,denlarga,fecha) VALUES ?,?,?");

			ps.setString(1, linea.getDenCorta());
			ps.setString(2, linea.getDenLarga());
			ps.setObject(3, linea.getFecha());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int modificar(LineasVO linea) {

		try {
			ps = conexion.prepareStatement("UPDATE lineas SET dencorta = ?,denlarga = ?,fecha = ? WHERE idlinea = ?");

			ps.setString(1, linea.getDenCorta());
			ps.setString(2, linea.getDenLarga());
			ps.setObject(3, linea.getFecha());
			ps.setInt(4, linea.getIdLinea());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int borrar(int idLinea) {
		try {
			ps = conexion.prepareStatement("DELETE FROM lineas WHERE idlinea = ?");

			ps.setInt(1, idLinea);

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(LineasVO linea) {
		try {
			ps = conexion.prepareStatement("DELETE FROM lineas WHERE idlinea = ?");

			ps.setInt(1, linea.getIdLinea());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public LineasVO leerIgual(int idLinea) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM lineas WHERE idlinea = ?");
			ps.setInt(1, idLinea);

			rs = ps.executeQuery();

			LineasVO linea = null;
			while (rs.next()) {
				linea = new LineasVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate());
			}
			return linea;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<LineasVO> leerTodos() {
		try {
			ps = conexion.prepareStatement("SELECT * FROM lineas");

			rs = ps.executeQuery();

			Set<LineasVO> lineas = new HashSet<LineasVO>();
			while (rs.next()) {
				lineas.add(new LineasVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate()));
			}
			return lineas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LineasVO leerIgual(String denCorta) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM lineas WHERE dencorta = ?");
			ps.setString(1, denCorta);

			rs = ps.executeQuery();

			LineasVO linea = null;
			while (rs.next()) {
				linea = new LineasVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate());
			}
			return linea;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public LineasVO leerComplejo(String denCorta) {
		try {
			ps= conexion.prepareStatement("SELECT * FROM lineaparada a,lineas b , paradas c"
					+ "where a.idlinea = b.idlinea and a.idparada = c.idparada and b.dencorta = ? ");
			ps.setString(1, denCorta);
			
			rs = ps.executeQuery();
			
			//creamos una conexion con las otras tablas para hacer la busqueda compleja
			ServicioLineasImpl servicioLinea = new ServicioLineasImpl();
			ServicioParadasImpl servicioParada = new ServicioParadasImpl();
			
			LineasVO linea = null;

			
			if(rs.next())
				linea = new  LineasVO(rs.getInt("a.idlinea"),rs.getString("dencorta"),
						rs.getString("denlarga"),rs.getDate("b.fecha").toLocalDate());
			//añadimos a linea las relaciones que señalen a la tabla parada
			linea.getRelaciones().put(
					rs.getString("a.idlineaparada"),
					new LineaParadaVO(rs.getInt("a.idlineaparada"), 
							servicioLinea.buscarLinea(rs.getInt("b.idlinea")),
							servicioParada.buscarParada(rs.getInt("c.idparada")),
							rs.getInt("marquesina")) );
			
			//devolvemos
			return linea;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
