package com.dawes.modelos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paradas")
public class ParadaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParada;
	private String denominacion;
	private LocalDate fecha;

	// relacion con lineas
	@OneToMany(mappedBy = "idParada")
	// pongo el nombre del campo de la otra tabla (nombre del atributo java) que relaciona
	private List<LineaParadaVO> lineas;

	public ParadaVO(int idParada, String denominacion, LocalDate fecha, List<LineaParadaVO> lineas) {
		this.idParada = idParada;
		this.denominacion = denominacion;
		this.fecha = fecha;
		this.lineas = lineas;
	}

	public ParadaVO(String denominacion, LocalDate fecha, List<LineaParadaVO> lineas) {
		this.denominacion = denominacion;
		this.fecha = fecha;
		this.lineas = lineas;
	}

	public ParadaVO() {
	}

	public int getIdParada() {
		return idParada;
	}

	public void setIdParada(int idParada) {
		this.idParada = idParada;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<LineaParadaVO> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaParadaVO> lineas) {
		this.lineas = lineas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idParada;
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
		ParadaVO other = (ParadaVO) obj;
		if (idParada != other.idParada)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParadaVO [idParada=" + idParada + ", denominacion=" + denominacion + ", fecha=" + fecha + ", lineas="
				+ lineas + "]";
	}
	
	
}
