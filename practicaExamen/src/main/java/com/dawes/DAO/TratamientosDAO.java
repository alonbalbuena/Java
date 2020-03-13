package com.dawes.DAO;

import java.util.HashSet;

import com.dawes.modelos.TratamientosVO;

public interface TratamientosDAO {
	
	int insertarTratamientos(TratamientosVO tratamientos);
	int actualizarTratamientos (TratamientosVO tratamientos);
	int borrarTratamientos(TratamientosVO tratamientos);
	int borrarTratamientosID(int idtratamientos);
	TratamientosVO BuscarTratamientos(int idtratamientos);
	HashSet<TratamientosVO> mostrarTratamientos();

}
