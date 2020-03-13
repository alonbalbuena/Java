package com.dawes.serviciosImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.dawes.DAO.CuentaDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.servicios.ServicioCuentas;
import com.dawes.util.MySqlDAOFactory;

public class ServicioCuentasImpl implements ServicioCuentas {

	private MySqlDAOFactory f;
	private CuentaDAO cd;

	public ServicioCuentasImpl() {
		f = MySqlDAOFactory.getDAO();
		cd = f.getCuentasRepositorioJDBC();
	}

	@Override
	public int crearCuenta(CuentaVO cuenta) {
		return cd.insertar(cuenta);
	}

	@Override
	public int borrarCuenta(CuentaVO cuenta) {
		return cd.eliminar(cuenta);
	}

	@Override
	public int borrarCuenta(int idCuenta) {
		return cd.eliminar(idCuenta);
	}

	@Override
	public int actualizarCuenta(CuentaVO cuenta) {
		return cd.modificar(cuenta);
	}

	@Override
	public CuentaVO buscarCuenta(String numero) {
		return cd.leerIgual(numero);
	}

	@Override
	public CuentaVO buscarCuenta(int idcuenta) {
		return cd.leerIgual(idcuenta);
	}

	@Override
	public Set<CuentaVO> mostrarCuentas() {
		return cd.leerTodos();
	}

	@Override
	public Set<CuentaVO> mostrarSaldos3000() {
		Set<CuentaVO> cuentas = new HashSet<CuentaVO>();
		// 1-obtenemos todas las cuentas
		// 2-obtenemos los movimientos de estas cuentas
		// 3-guardamos la cuenta que cumpla con las condiciones
		// 4-devolvemos la lista de las cuentas que cumplen dichas condiciones
		cd.leerTodos().forEach(cuenta -> {
			CuentaVO nuevaCuenta = new CuentaVO(cuenta.getIdCuenta(), cuenta.getNumCuenta(), cuenta.getSaldo(),
					cuenta.getFecha());
			cuenta.getMovimientos().forEach(movimiento -> {
				if (movimiento.getImporte() > 3000 && movimiento.getTipo().equals("d")) {
					nuevaCuenta.getMovimientos().add(movimiento);
					cuentas.add(nuevaCuenta);
				}
			});
		});
		return cuentas;
	}
}
