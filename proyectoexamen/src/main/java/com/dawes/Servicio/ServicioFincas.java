package com.dawes.Servicio;

import com.dawes.modelos.FincasTratamientoVO;
import com.dawes.modelos.FincasVO;

public interface ServicioFincas {
	int insertar(FincasVO fincas);
	int borrar(FincasVO finca);
	int modificar(FincasVO finca);

	
}
