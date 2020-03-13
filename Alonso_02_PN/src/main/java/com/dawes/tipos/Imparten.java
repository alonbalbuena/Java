package com.dawes.tipos;

import java.time.LocalDate;

public class Imparten {

	private LocalDate fechaCiclo;
	private Profesores profesor;
	private Ciclos ciclo;
	
	public Imparten(LocalDate fechaCiclo, Profesores profesor, Ciclos ciclo) {
		this.fechaCiclo = fechaCiclo;
		this.profesor = profesor;
		this.ciclo = ciclo;
	}

	public LocalDate getFechaCiclo() {
		return fechaCiclo;
	}

	public void setFechaCiclo(LocalDate fechaCiclo) {
		this.fechaCiclo = fechaCiclo;
	}

	public Profesores getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}

	public Ciclos getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclos ciclo) {
		this.ciclo = ciclo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((fechaCiclo == null) ? 0 : fechaCiclo.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		Imparten other = (Imparten) obj;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (fechaCiclo == null) {
			if (other.fechaCiclo != null)
				return false;
		} else if (!fechaCiclo.equals(other.fechaCiclo))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Imparten [fechaCiclo=" + fechaCiclo + ", profesor=" + profesor + ", ciclo=" + ciclo + "]";
	}
	
	
	
}
