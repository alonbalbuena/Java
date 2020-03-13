package com.dawes.DAO;

import com.dawes.modelos.TratamientoVO;

public interface TratamientoDAO {
	int insertar(TratamientoVO tratamiento);
	int borrar(TratamientoVO tratamiento);
	int modificar(TratamientoVO tratamiento);


}
