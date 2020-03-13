package com.dawes.repositorioJDBC;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.DAOImpl.MovimientoDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.util.MySqlDAOFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRepositorioMovimientosJDBC {

	private static MySqlDAOFactory dao;
	private static MovimientoDAOImpl repositorio;
	private static CuentaVO cuentaPrueba;
	private static MovimientoVO movimientoPrueba;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//usamos el singleton para verificar que solo realizamos solo un objeto
		dao = MySqlDAOFactory.getDAO();
		repositorio = dao.getMovimientosRepositorioJDBC();
		cuentaPrueba = new CuentaVO("12345", 1233444, LocalDate.parse("2005-10-10"));
		movimientoPrueba = new MovimientoVO(1,LocalDate.parse("2009-10-10"), "s", 123, cuentaPrueba);
		
		//metodo para introducir en el array de la cuenta el movimiento creado
		cuentaPrueba.añadirMovimiento(movimientoPrueba);
	}

	@Test
	public void test1RepositorioMovimientosJDBC() {
		assertNotNull(repositorio);
	}

	@Test
	public void test2Insertar() {
		assertEquals(1, repositorio.insertar(movimientoPrueba));
	}

	@Test
	public void test3LeerIgual() {
		assertNotNull(repositorio.leerIgual(1));
	}

	@Test
	public void test4LeerTodos() {
		assertNotNull(repositorio.leerTodos());
	}

	@Test
	public void test5Modificar() {
		assertEquals(1, repositorio.modificar(movimientoPrueba));
	}
	
	// test
	//buscar la cuenta a modificar: 1234 (usar metodo buscar cuenta por numero de cuenta)
	//modificar la o las columnas de esa cuenta 1234 en el test
	// invocas al metodo modifica de la clase repositoriocuentasjdbc
	// update cuentas set numcuenta=?, fecha=?, titular=? where idcuenta=?

	@Test
	public void test6Eliminar() {
		assertEquals(1, repositorio.eliminar(movimientoPrueba));
	}
}
