package com.dawes.servicios;

import java.util.Set;

import com.dawes.modelo.MovimientoVO;

public interface ServicioMovimientos {

	int crearMovimiento(MovimientoVO movimiento);
	
	int borrarMovimiento(MovimientoVO movimiento);
	
	int borrarMovimiento(int idMovimiento);
	
	int actualizarMovimiento(MovimientoVO movimiento);

	MovimientoVO buscarMovimientoPorId(int idMovimiento);

	Set<MovimientoVO> mostrarMovimientos();

}
