package com.dawes.servicios;

import java.util.Set;

import com.dawes.modelo.CuentaVO;

public interface ServicioCuentas {

	int crearCuenta(CuentaVO cuenta);
	
	int borrarCuenta(CuentaVO cuenta);
	
	int borrarCuenta(int idCuenta);
	
	int actualizarCuenta(CuentaVO cuenta);
	
	CuentaVO buscarCuenta(String numero);

	CuentaVO buscarCuenta(int idcuenta);

	Set<CuentaVO> mostrarCuentas();

}
