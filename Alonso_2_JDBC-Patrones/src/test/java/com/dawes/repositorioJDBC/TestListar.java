package com.dawes.repositorioJDBC;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.serviciosImpl.ServicioCuentasImpl;
import com.dawes.serviciosImpl.ServicioMovimientosImpl;

public class TestListar {

	private static MovimientoVO movimiento;
	private static CuentaVO cuentaPrueba;
	private static ServicioCuentasImpl servicioCuentas;
	private static ServicioMovimientosImpl servicioMovimientos;

	@BeforeClass
	public static void creamosMovimiento() {
		// usamos el singleton para verificar que solo realizamos solo un objeto
		servicioCuentas = new ServicioCuentasImpl();
		servicioMovimientos = new ServicioMovimientosImpl();

		// creamos cuenta de prueba en la que introduciremos movimientos
		cuentaPrueba = new CuentaVO(100, "123456789", 361237821, LocalDate.parse("2000-01-01"));
		servicioCuentas.crearCuenta(cuentaPrueba);

		// creamos el movimiento para que cumpla el ejercicio y aparezca
		movimiento = new MovimientoVO(100, LocalDate.parse("2000-01-01"), "d", 5000, cuentaPrueba);
		//lo introducimos en la cuenta
		cuentaPrueba.añadirMovimiento(movimiento);
		
		servicioMovimientos.crearMovimiento(movimiento);

	}

	@Test
	public void listarCuentasMovimientos() {
		System.out.println("####cuentas####");
		servicioCuentas.mostrarCuentas().forEach(cuenta -> System.out.println(cuenta));
		System.out.println("####movimientos####");
		servicioMovimientos.mostrarMovimientos().forEach(movimiento -> System.out.println(movimiento));
	}

	@Test
	public void listarCuentas3000() {
		System.out.println("---Listar cuentas 3000---");
		// usamos la condicion que nos pone la tarea mandada
		servicioCuentas.mostrarSaldos3000().forEach(cuenta -> System.out.println(cuenta));
		
		servicioCuentas.mostrarCuentas().forEach(cuenta -> System.out.println(cuenta));
	}

	@AfterClass
	public static void borramosMovimiento() {
		// eliminamos el movimiento despues de usarlo
		servicioMovimientos.borrarMovimiento(movimiento);

		// tambien borramos la cuenta de prueba
		servicioCuentas.borrarCuenta(cuentaPrueba);
	}

}
