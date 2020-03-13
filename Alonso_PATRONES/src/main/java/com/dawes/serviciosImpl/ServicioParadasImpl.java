package com.dawes.serviciosImpl;

import java.util.Set;

import com.dawes.DAOImpl.ParadasDAOImpl;
import com.dawes.modelo.ParadasVO;
import com.dawes.servicios.ServicioParadas;
import com.dawes.util.MySqlDAOFactory;

public class ServicioParadasImpl implements ServicioParadas {

	private MySqlDAOFactory f;
	private ParadasDAOImpl gp;
	
	public ServicioParadasImpl() {
		f = MySqlDAOFactory.getDAO();
		gp = f.getParadas();
	}

	@Override
	public int crearParada(ParadasVO parada) {
		return gp.insertar(parada);
	}

	@Override
	public int borrarParada(ParadasVO parada) {
		return gp.borrar(parada);
	}

	@Override
	public int borrarParada(int idParada) {
		return gp.borrar(idParada);
	}

	@Override
	public int actualizarParada(ParadasVO parada) {
		return gp.modificar(parada);
	}

	@Override
	public ParadasVO buscarParada(String denominacion) {
		return gp.leerIgual(denominacion);
	}

	@Override
	public ParadasVO buscarParada(int idParada) {
		return gp.leerIgual(idParada);
	}

	@Override
	public Set<ParadasVO> mostrarParadas() {
		return gp.leerTodos();
	}
	
	

}
