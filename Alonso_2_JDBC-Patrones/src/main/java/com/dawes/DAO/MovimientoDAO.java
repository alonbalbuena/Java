package com.dawes.DAO;

import java.util.Set;

import com.dawes.modelo.MovimientoVO;

public interface MovimientoDAO {
	
	int insertar (MovimientoVO movimiento);
	int eliminar (MovimientoVO movimiento);
	int eliminar(int idMovimiento);
	int modificar (MovimientoVO movimiento);
	MovimientoVO leerIgual(int idMovimiento);
	Set<MovimientoVO> leerTodos();

}
