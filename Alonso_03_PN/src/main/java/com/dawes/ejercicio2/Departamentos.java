package com.dawes.ejercicio2;

import java.util.TreeMap;

public class Departamentos {

	private int idDepartamento;
	private String denominacion;
	private String localidad;
	private TreeMap<String,Empleados> empleados;
	
	public Departamentos(String denominacion, String localidad) {
		this.denominacion = denominacion;
		this.localidad = localidad;
		this.setEmpleados(new TreeMap<String, Empleados>());
	}
	
	public Departamentos(int idDepartamento,String denominacion,String localidad) {
		this.setIdDepartamento(idDepartamento);
		this.denominacion = denominacion;
		this.localidad = localidad;
	}
	
	
	public String getDenominacion() {
		return denominacion;
	}
	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public TreeMap<String,Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(TreeMap<String,Empleados> empleados) {
		this.empleados = empleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
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
		Departamentos other = (Departamentos) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamentos [denominacion=" + denominacion + ", localidad=" + localidad + "]";
	}
}
