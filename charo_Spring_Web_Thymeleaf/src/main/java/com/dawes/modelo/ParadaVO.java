package com.dawes.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "paradas")
public class ParadaVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idparada;
	private String denominacion;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha;
	
	@OneToMany(mappedBy = "parada", cascade = CascadeType.PERSIST)
	private List<LineaParadaVO> lineas;

	public ParadaVO() {
		super();
		lineas = new ArrayList<LineaParadaVO>();
	}

	public ParadaVO(String denominacion, LocalDate fecha, List<LineaParadaVO> lineas) {
		super();
		this.denominacion = denominacion;
		this.fecha = fecha;
		this.lineas = lineas;
	}

	public ParadaVO(int idparada, String denominacion, LocalDate fecha, List<LineaParadaVO> lineas) {
		super();
		this.idparada = idparada;
		this.denominacion = denominacion;
		this.fecha = fecha;
		this.lineas = lineas;
	}
	
	
	public void addLineaParada(LineaParadaVO lp) {
		this.lineas.add(lp);
	}

	
	public int getIdparada() {
		return idparada;
	}
	public void setIdparada(int idParada) {
		this.idparada = idParada;
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
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idparada;
		result = prime * result + ((lineas == null) ? 0 : lineas.hashCode());
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
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idparada != other.idparada)
			return false;
		if (lineas == null) {
			if (other.lineas != null)
				return false;
		} else if (!lineas.equals(other.lineas))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "ParadaVO [idparada=" + idparada + ", denominacion=" + denominacion + ", fecha=" + fecha + ", lineas="
				+ lineas + "]";
	}	
	
}

