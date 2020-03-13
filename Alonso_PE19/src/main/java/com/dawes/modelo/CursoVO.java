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
@Table(name="cursos")
public class CursoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcurso;
	
	@Column(unique = true)
	private String denominacion;
	
	@OneToMany(mappedBy = "curso")
	private List<AlumnoCursoVO> alumnos;

	public CursoVO(int idcurso, String denominacion, List<AlumnoCursoVO> alumnos) {
		this.idcurso = idcurso;
		this.denominacion = denominacion;
		this.alumnos = alumnos;
	}

	public CursoVO(String denominacion, List<AlumnoCursoVO> alumnos) {
		this.denominacion = denominacion;
		this.alumnos = alumnos;
	}

	public CursoVO() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnos == null) ? 0 : alumnos.hashCode());
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + idcurso;
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
		CursoVO other = (CursoVO) obj;
		if (alumnos == null) {
			if (other.alumnos != null)
				return false;
		} else if (!alumnos.equals(other.alumnos))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (idcurso != other.idcurso)
			return false;
		return true;
	}

	public int getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public List<AlumnoCursoVO> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoCursoVO> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "CursoVO [idcurso=" + idcurso + ", denominacion=" + denominacion + ", alumnos=" + alumnos + "]";
	}

	

}
