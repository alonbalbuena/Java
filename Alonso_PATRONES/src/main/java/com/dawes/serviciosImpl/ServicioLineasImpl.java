package com.dawes.serviciosImpl;

import java.util.Set;

import com.dawes.DAO.LineasDAO;
import com.dawes.modelo.LineasVO;
import com.dawes.servicios.ServicioLineas;
import com.dawes.util.MySqlDAOFactory;

public class ServicioLineasImpl implements ServicioLineas {

	private MySqlDAOFactory f;
	private LineasDAO cd;

	public ServicioLineasImpl() {
		//en el constructor de servicios obtengo la conexion
		f = MySqlDAOFactory.getDAO();
		//y conecto con la tabla correspondiente
		cd = f.getLineas();
	}
	
	@Override
	public int crearLinea(LineasVO linea) {
		return cd.insertar(linea);
	}

	@Override
	public int borrarLinea(LineasVO linea) {
		return cd.borrar(linea);
	}

	@Override
	public int borrarLinea(int idLinea) {
		return cd.borrar(idLinea);
	}

	@Override
	public int actualizarLinea(LineasVO linea) {
		return cd.modificar(linea);
	}

	@Override
	public LineasVO buscarLinea(int idLinea) {
		return cd.leerIgual(idLinea);
	}

	@Override
	public LineasVO buscarLinea(String denCorta) {
		return cd.leerIgual(denCorta);
	}
	@Override
	public LineasVO buscarCompleja(String denCorta) {
		return cd.leerComplejo(denCorta);
	}

	@Override
	public Set<LineasVO> mostrarLineas() {
		return cd.leerTodos();
	}

}
