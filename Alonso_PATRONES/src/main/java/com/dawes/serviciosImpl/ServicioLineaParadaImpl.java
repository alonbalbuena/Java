package com.dawes.serviciosImpl;

import java.util.Set;

import com.dawes.DAOImpl.LineaParadaDAOImpl;
import com.dawes.modelo.LineaParadaVO;
import com.dawes.servicios.ServicioLineaParada;
import com.dawes.util.MySqlDAOFactory;

public class ServicioLineaParadaImpl implements ServicioLineaParada {

	private MySqlDAOFactory f;
	private LineaParadaDAOImpl cd;

	public ServicioLineaParadaImpl() {
		//en el constructor de servicios obtengo la conexion
		f = MySqlDAOFactory.getDAO();
		//y conecto con la tabla correspondiente
		cd = f.getLineaParada();
	}
	
	@Override
	public int crearLineaParada(LineaParadaVO lineaParada) {
		return cd.insertar(lineaParada);
	}

	@Override
	public int borrarLineaParada(LineaParadaVO lineaParada) {
		return cd.borrar(lineaParada);
	}

	@Override
	public int borrarLineaParada(int idLineaParada) {
		return cd.borrar(idLineaParada);
	}

	@Override
	public int actualizarLineaParada(LineaParadaVO lineaParada) {
		return cd.modificar(lineaParada);
	}

	@Override
	public LineaParadaVO buscarLineaParada(int idLineaParada) {
		return cd.leerIgual(idLineaParada);
	}

	@Override
	public LineaParadaVO buscarLineaParadaPorMarquesina(int marquesina) {
		return cd.leerIgual(marquesina);
	}

	@Override
	public Set<LineaParadaVO> mostrarLineasParadas() {
		return cd.leerTodos();
	}

}
