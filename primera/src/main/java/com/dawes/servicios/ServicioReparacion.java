package com.dawes.servicios;

import com.dawes.modelo.ReparacionVO;

public interface ServicioReparacion {
	
	//De momento solo necesitamos el metodo de insertar reparaciones
	int insertar(ReparacionVO reparacion);
}
