package com.dawes.serviciosImpl;

import java.util.Set;

import com.dawes.DAO.MovimientoDAO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.servicios.ServicioMovimientos;
import com.dawes.util.MySqlDAOFactory;

public class ServicioMovimientosImpl implements ServicioMovimientos {

	private MySqlDAOFactory f;
	private MovimientoDAO cd;
	
	public ServicioMovimientosImpl() {
		f = MySqlDAOFactory.getDAO();
		cd = f.getMovimientosRepositorioJDBC();
	}

	@Override
	public int crearMovimiento(MovimientoVO movimiento) {
		return cd.insertar(movimiento);
	}

	@Override
	public int borrarMovimiento(MovimientoVO movimiento) {
		return cd.eliminar(movimiento);
	}

	@Override
	public int borrarMovimiento(int idMovimiento) {
		return cd.eliminar(idMovimiento);
	}

	@Override
	public int actualizarMovimiento(MovimientoVO movimiento) {
		return cd.modificar(movimiento);
	}

	@Override
	public MovimientoVO buscarMovimientoPorId(int idMovimiento) {
		return cd.leerIgual(idMovimiento);
	}

	@Override
	public Set<MovimientoVO> mostrarMovimientos() {
		return cd.leerTodos();
	}
	
}
