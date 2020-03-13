package com.dawes.servicios;

import java.util.Set;
import com.dawes.modelo.LineasVO;

public interface ServicioLineas {

	int crearLinea(LineasVO linea);
	int borrarLinea(LineasVO linea);
	int borrarLinea(int idLinea);
	int actualizarLinea(LineasVO linea);
	LineasVO buscarLinea(int idLinea);
	LineasVO buscarLinea(String denCorta);
	Set<LineasVO> mostrarLineas();
	LineasVO buscarCompleja(String denCorta);
	 
}
