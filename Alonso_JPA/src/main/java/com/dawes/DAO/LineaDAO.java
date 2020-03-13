package com.dawes.DAO;

import com.dawes.modelos.LineaVO;

public interface LineaDAO {

	int buscarPorNombre(String denCorta);

	int buscarNombreLargoPorNombre(String denCorta);

	int insertarLinea(LineaVO linea);

}