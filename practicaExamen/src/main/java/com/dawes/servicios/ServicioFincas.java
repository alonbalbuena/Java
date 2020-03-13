package com.dawes.servicios;

import java.util.HashSet;

import com.dawes.modelos.FincaVO;

public interface ServicioFincas {
	int insertarFinca(FincaVO finca);
	int actualizarFinca (FincaVO finca);
	int borrarFinca(FincaVO finca);
	int borrarFincaID(int idfinca);
	FincaVO BuscarFinca (int idfinca);
	HashSet<FincaVO> mostrarFincas();

}
