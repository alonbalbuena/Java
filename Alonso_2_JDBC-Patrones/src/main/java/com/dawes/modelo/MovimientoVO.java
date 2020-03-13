package com.dawes.modelo;

import java.time.LocalDate;

public class MovimientoVO {

	private int idMovimiento;
	private LocalDate fecha;
	private String tipo;
	private double importe;
	private CuentaVO cuenta;
	
	public MovimientoVO(LocalDate fecha, String tipo, double importe,CuentaVO cuenta) {
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.setCuenta(cuenta);
	}

	public MovimientoVO(int idMovimiento, LocalDate fecha, String tipo, double importe, CuentaVO cuenta) {
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.tipo = tipo;
		this.importe = importe;
		this.setCuenta(cuenta);
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}
	
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		long temp;
		temp = Double.doubleToLongBits(importe);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		MovimientoVO other = (MovimientoVO) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (Double.doubleToLongBits(importe) != Double.doubleToLongBits(other.importe))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "MovimientosVO [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", tipo=" + tipo + ", importe="
				+ importe + ", cuenta=" + cuenta.getIdCuenta() + "]";
	}

	public CuentaVO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaVO cuenta) {
		this.cuenta = cuenta;
	}

	
}
