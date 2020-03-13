package com.dawes.repositorioJDBC;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.DAOImpl.CuentaDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.serviciosImpl.ServicioCuentasImpl;
import com.dawes.util.MySqlDAOFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRepositorioCuentasJDBC {

	private static ServicioCuentasImpl repositorio;
	private static CuentaVO cuentaPrueba;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		repositorio = new ServicioCuentasImpl();
		cuentaPrueba = new CuentaVO("12345", 1233444, LocalDate.parse("2005-10-10"));
	}

	@Test
	public void test1RepositorioCuentasJDBC() {
		assertNotNull(repositorio);
	}

	@Test
	public void test2Insertar() {
		assertEquals(1, repositorio.crearCuenta(cuentaPrueba));
	}

	@Test
	public void test3LeerIgual() {
		assertNotNull(repositorio.buscarCuenta("12345"));
	}

	@Test
	public void test4LeerTodos() {
		assertNotNull(repositorio.mostrarCuentas());
	}

	@Test
	public void test5Modificar() {
		assertEquals(1, repositorio.actualizarCuenta(cuentaPrueba));
	}

	@Test
	public void test6Eliminar() {
		assertEquals(1, repositorio.borrarCuenta(cuentaPrueba));
	}

}
