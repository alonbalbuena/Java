package com.dawes.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.dawes.DAO.LineaParadaDAO;
import com.dawes.modelo.LineaParadaVO;
import com.dawes.modelo.LineasVO;
import com.dawes.serviciosImpl.ServicioLineasImpl;
import com.dawes.serviciosImpl.ServicioParadasImpl;

public class LineaParadaDAOImpl implements LineaParadaDAO {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;

	public LineaParadaDAOImpl(Connection conexion) {
		this.setConexion(conexion);
	}

	
	public Connection getConexion() {
		return conexion;
	}


	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}


	public int insertar(LineaParadaVO lineaparada) {
		try {
			ps = conexion.prepareStatement("INSERT INTO lineaparada (idlinea,idparada,marquesina) VALUES ?,?,?");

			ps.setInt(1,lineaparada.getIdLinea().getIdLinea());
			ps.setInt(2, lineaparada.getIdParada().getIdParada());
			ps.setInt(3, lineaparada.getMarquesina());

			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int modificar(LineaParadaVO lineaParada) {
		try {
			ps = conexion.prepareStatement("UPDATE lineaparada SET idlinea = ?,idparada = ?,marquesina = ? WHERE idlineaparada = ?");

			ps.setInt(1, lineaParada.getIdLinea().getIdLinea());
			ps.setInt(2, lineaParada.getIdParada().getIdParada());
			ps.setInt(3, lineaParada.getMarquesina());
			
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int borrar(LineaParadaVO lineaParada) {
		try {
			ps = conexion.prepareStatement("DELETE FROM lineaparada WHERE idlineaparada = ?");

			ps.setInt(3, lineaParada.getIdLineaParada());
			
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public LineaParadaVO leerIgual(int idLineaParada) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM lineaparada WHERE idlineaparada = ?");
			ps.setInt(1, idLineaParada);

			rs = ps.executeQuery();

			//conectamos con los servicios de cada tabla
			ServicioLineasImpl servicioLineas = new ServicioLineasImpl();
			ServicioParadasImpl servicioParadas = new ServicioParadasImpl();
			
			//devolvemos cada lineaparada con la linea y parada que señala
			LineaParadaVO lineaParada = null;
			while (rs.next()) {
				lineaParada = new LineaParadaVO(rs.getInt(1),servicioLineas.buscarLinea(rs.getInt(2)),servicioParadas.buscarParada(rs.getInt(2)), rs.getInt(4));
			}
			return lineaParada;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Set<LineaParadaVO> leerTodos() {
		try {
			ps = conexion.prepareStatement("SELECT * FROM lineaparada");

			rs = ps.executeQuery();

			Set<LineaParadaVO> lineasParadas = new HashSet<LineaParadaVO>();
			//conectamos con los servicios de cada tabla
			ServicioLineasImpl servicioLineas = new ServicioLineasImpl();
			ServicioParadasImpl servicioParadas = new ServicioParadasImpl();
			
			//devolvemos cada lineaparada con la linea y parada que señala
			while (rs.next()) {
				lineasParadas.add(new LineaParadaVO(rs.getInt(1),servicioLineas.buscarLinea(rs.getInt(2)),servicioParadas.buscarParada(rs.getInt(2)), rs.getInt(4)));
			}
			return lineasParadas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int borrar(int idLineaParada) {
		try {
			ps = conexion.prepareStatement("DELETE FROM lineaparada WHERE idlineaparada = ?");

			ps.setInt(3, idLineaParada);
			
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public LineaParadaVO leerIgualMarquesina(int marquesina) {
		try {
			ps = conexion.prepareStatement("SELECT * FROM lineaparada WHERE marquesina = ?");
			ps.setInt(1, marquesina);

			rs = ps.executeQuery();
			
			//conectamos con los servicios de cada tabla
			ServicioLineasImpl servicioLineas = new ServicioLineasImpl();
			ServicioParadasImpl servicioParadas = new ServicioParadasImpl();
			
			//devolvemos lineaparada con la linea y parada que señala
			LineaParadaVO lineaParada = null;
			while (rs.next()) {
				lineaParada = new LineaParadaVO(rs.getInt(1),servicioLineas.buscarLinea(rs.getInt(2)),servicioParadas.buscarParada(rs.getInt(2)), rs.getInt(4));
			}
			return lineaParada;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
