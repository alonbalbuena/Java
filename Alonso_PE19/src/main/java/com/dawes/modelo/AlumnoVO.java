package com.dawes.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class AlumnoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumno;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "alumno")
	private List<AlumnoCursoVO> cursos;

	public AlumnoVO(int idalumno, String nombre, List<AlumnoCursoVO> cursos) {
		this.idalumno = idalumno;
		this.nombre = nombre;
		this.cursos = cursos;
	}

	public AlumnoVO(String nombre, List<AlumnoCursoVO> cursos) {
		this.nombre = nombre;
		this.cursos = cursos;
	}

	public AlumnoVO() {
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AlumnoCursoVO> getCursos() {
		return cursos;
	}

	public void setCursos(List<AlumnoCursoVO> cursos) {
		this.cursos = cursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + idalumno;
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
		AlumnoVO other = (AlumnoVO) obj;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (idalumno != other.idalumno)
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
		return "AlumnoVO [idalumno=" + idalumno + ", nombre=" + nombre + ", cursos=" + cursos + "]";
	}
	
	

}
