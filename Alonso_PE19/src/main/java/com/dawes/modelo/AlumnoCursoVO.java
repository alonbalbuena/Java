package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="alumnocurso")
public class AlumnoCursoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumnocurso;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name="Idalumno")
	private AlumnoVO alumno;
	
	@ManyToOne
	@JoinColumn(name="Idcurso")
	private CursoVO curso;

	public AlumnoCursoVO(int idalumnocurso, LocalDate fecha, AlumnoVO alumno, CursoVO cursos) {
		this.idalumnocurso = idalumnocurso;
		this.fecha = fecha;
		this.alumno = alumno;
		this.curso = cursos;
	}

	public AlumnoCursoVO(LocalDate fecha, AlumnoVO alumno, CursoVO cursos) {
		this.fecha = fecha;
		this.alumno = alumno;
		this.curso = cursos;
	}

	public AlumnoCursoVO() {
	}

	public int getIdalumnocurso() {
		return idalumnocurso;
	}

	public void setIdalumnocurso(int idalumnocurso) {
		this.idalumnocurso = idalumnocurso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public AlumnoVO getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoVO alumno) {
		this.alumno = alumno;
	}

	public CursoVO getCursos() {
		return curso;
	}

	public void setCursos(CursoVO cursos) {
		this.curso = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idalumnocurso;
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
		AlumnoCursoVO other = (AlumnoCursoVO) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idalumnocurso != other.idalumnocurso)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlumnoCursoVO [idalumnocurso=" + idalumnocurso + ", fecha=" + fecha + ", alumno=" + alumno + ", cursos="
				+ curso + "]";
	}

	
	
}
