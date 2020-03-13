package com.dawes.tipos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesores {

	private String dni;
	private String nombre;
	private	LocalDate fechaFuncionario;
	private ArrayList<Imparten> ciclos;//como la relacion es N:M es necesario una lista
	
	public Profesores(String dni, String nombre, LocalDate fechaFuncionario) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaFuncionario = fechaFuncionario;
		this.setRelacion(new ArrayList<Imparten>());
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaFuncionario() {
		return fechaFuncionario;
	}

	public void setFechaFuncionario(LocalDate fechaFuncionario) {
		this.fechaFuncionario = fechaFuncionario;
	}

	public ArrayList<Imparten> getRelacion() {
		return ciclos;
	}

	public void setRelacion(ArrayList<Imparten> relacion) {
		this.ciclos = relacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechaFuncionario == null) ? 0 : fechaFuncionario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Profesores other = (Profesores) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechaFuncionario == null) {
			if (other.fechaFuncionario != null)
				return false;
		} else if (!fechaFuncionario.equals(other.fechaFuncionario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesores [dni=" + dni + ", nombre=" + nombre + ", fechaFuncionario=" + fechaFuncionario + "]";
	}
	
	
}
