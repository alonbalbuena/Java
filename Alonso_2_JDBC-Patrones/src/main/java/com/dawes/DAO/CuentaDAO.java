package com.dawes.DAO;

import java.util.Set;

import com.dawes.modelo.CuentaVO;

public interface CuentaDAO {

	int insertar(CuentaVO cuenta);
	int eliminar(CuentaVO cuenta);
	int eliminar(int idCuenta);
	int modificar(CuentaVO cuenta);
	CuentaVO leerIgual(String numCuenta);
	CuentaVO leerIgual(int idCuenta);
	Set<CuentaVO> leerTodos();
}
