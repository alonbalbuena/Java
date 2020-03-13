package com.dawes.servicios;

import java.util.HashSet;

import com.dawes.modelos.TratamientosVO;

public interface ServicioTratamientos {
	int insertarTratamientos(TratamientosVO tratamientos);
	int actualizarTratamientos (TratamientosVO tratamientos);
	int borrarTratamientos(TratamientosVO tratamientos);
	int borrarTratamientosID(int idtratamientos);
	TratamientosVO BuscarTratamientos(int idtratamientos);
	HashSet<TratamientosVO> mostrarTratamientos();


}
