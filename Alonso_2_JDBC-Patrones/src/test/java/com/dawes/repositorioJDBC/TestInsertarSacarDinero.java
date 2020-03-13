package com.dawes.repositorioJDBC;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.util.MySqlDAOFactory;

public class TestInsertarSacarDinero {

	private static MySqlDAOFactory dao;
	private static CuentaVO cuentaPrueba;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		//creamos la conexion
		//usamos el singleton para verificar que solo realizamos solo un objeto
		dao = MySqlDAOFactory.getDAO();
		
		//introducimos la cuenta sin usar el autoincrementado para facilitar el uso
		//(el metodo de insertar tal y como lo he programado facilita la labor)
		cuentaPrueba = new CuentaVO(1,"16", 123456, LocalDate.parse("2001-01-01"));
		dao.getCuentasRepositorioJDBC().insertar(cuentaPrueba);
	}

	
	@Test
	public void testInsertarDinero() {
		MovimientoVO insertar = new MovimientoVO(1,LocalDate.parse("2001-01-01"), "d", 123, cuentaPrueba);
		dao.getMovimientosRepositorioJDBC().insertar(insertar);
	}
	
	@Test
	public void testQuitarDinero() {
		MovimientoVO quitar = new MovimientoVO(2,LocalDate.parse("2001-01-01"), "p", 15, cuentaPrueba);
		dao.getMovimientosRepositorioJDBC().insertar(quitar);
	}

}
