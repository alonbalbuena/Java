package com.dawes.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//implementamos la interfaz Comparable para ordenar las cuentas
public class CuentaVO implements Comparable<CuentaVO> {

	private int idCuenta;
	private String numCuenta;
	private double saldo;
	private LocalDate fecha;
	//usamos un Set porque no puede haber dos movimientos iguales
	private Set<MovimientoVO> movimientos; 
	
	public Set<MovimientoVO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<MovimientoVO> movimientos) {
		this.movimientos = movimientos;
	}

	//SIEMPRE SE HACE ASÍ, uno con el id y otro sin el
	
	//constructor sin id usamos el autoincrementado
	public CuentaVO(String numCuenta, double saldo, LocalDate fecha) {
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.fecha = fecha;
		this.movimientos = new HashSet<MovimientoVO>();
	}
	
	//constructor sin AI
	public CuentaVO(int idCuenta,String numCuenta, double saldo, LocalDate fecha) {
		this.idCuenta = idCuenta;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.fecha = fecha;
		this.movimientos = new HashSet<MovimientoVO>();
	}
	
	public void añadirMovimiento(MovimientoVO movimiento) {
		movimientos.add(movimiento);
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numCuenta == null) ? 0 : numCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaVO other = (CuentaVO) obj;
		if (numCuenta == null) {
			if (other.numCuenta != null)
				return false;
		} else if (!numCuenta.equals(other.numCuenta))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CuentasVO [idCuenta=" + idCuenta + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", fecha=" + fecha+ "]";
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	@Override
	public int compareTo(CuentaVO cuenta) {
		//comparamos por fecha
		return this.getFecha().compareTo(cuenta.getFecha());
	}
	
}
