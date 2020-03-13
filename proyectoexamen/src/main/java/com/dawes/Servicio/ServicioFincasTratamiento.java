package com.dawes.Servicio;

import com.dawes.modelos.FincasTratamientoVO;

public interface ServicioFincasTratamiento {
	int insertar(FincasTratamientoVO fincastratamiento);
	int borrar(FincasTratamientoVO fincastratamiento);
	int modificar(FincasTratamientoVO fincastratamiento);


}
