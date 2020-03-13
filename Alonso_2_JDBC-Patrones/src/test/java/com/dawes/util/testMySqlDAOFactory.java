package com.dawes.util;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class testMySqlDAOFactory {

	static MySqlDAOFactory dao;

	@BeforeClass
	public static void setUpBeforeClass() {
		//usamos el singleton para verificar que solo realizamos solo un objeto
		dao = MySqlDAOFactory.getDAO();
	}

	@Test
	public void testMySqlDAOFactory() {
		assertNotNull(dao);
	}

	@Test
	public void testGetCuentaRepositorioJDBC() {
		assertNotNull(dao.getCuentasRepositorioJDBC());
	}

	@Test
	public void testGetMovimientoRepositoryJDBC() {
		assertNotNull(dao.getMovimientosRepositorioJDBC());
	}

}
