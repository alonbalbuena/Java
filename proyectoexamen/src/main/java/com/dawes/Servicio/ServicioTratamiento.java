package com.dawes.Servicio;

import com.dawes.modelos.TratamientoVO;

public interface ServicioTratamiento {
	int insertar(TratamientoVO tratamiento);
	int borrar(TratamientoVO tratamiento);
	int modificar(TratamientoVO tratamiento);


}
