package com.dawes.ejercicio2;
public class Empleados {

	private String dni;
	private String nombre;
	private double salario;
	private String fechaContrato;
	private Departamentos departamento;
	
	
	public Empleados(String nombre, String dni, double salario, String fechaContrato, Departamentos departamento) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
		this.fechaContrato = fechaContrato;
		this.departamento = departamento;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public Departamentos getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Empleados other = (Empleados) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Empleados [nombre=" + nombre + ", dni=" + dni + ", salario=" + salario + ", fechaContrato="
				+ fechaContrato + ", departamento=" + departamento + "]";
	}
	
	
}
