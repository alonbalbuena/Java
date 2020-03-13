package com.dawes.DAO;

import java.util.Set;
import com.dawes.modelo.LineasVO;

public interface LineasDAO {
	
	int insertar(LineasVO linea);
	int borrar(LineasVO linea);
	int borrar(int idLinea);
	int modificar(LineasVO linea);
	LineasVO leerIgual(int idLinea);
	LineasVO leerIgual(String denCorta);
	Set<LineasVO> leerTodos();
	LineasVO leerComplejo(String denCorta);

}
