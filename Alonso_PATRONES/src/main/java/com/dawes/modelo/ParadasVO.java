package com.dawes.modelo;

import java.time.LocalDate;
import java.util.TreeMap;

public class ParadasVO {

	private int idParada;
	private String denominacion;
	private LocalDate fecha;
	//es treeMap porque cada parada en cada linea tiene un nombre,una clave(String)
	private TreeMap<String,LineaParadaVO> relaciones;
	
	public ParadasVO(int idParada, String denominacion, LocalDate fecha) {
		this.idParada = idParada;
		this.denominacion = denominacion;
		this.fecha = fecha;
		//inicializamos directamente la lista en el constructor
		this.relaciones = new TreeMap<String, LineaParadaVO>();
	}

	public ParadasVO(String denominacion, LocalDate fecha) {
		this.denominacion = denominacion;
		this.fecha = fecha;
		//inicializamos directamente la lista en el constructor
		this.relaciones = new TreeMap<String, LineaParadaVO>();
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

	public TreeMap<String, LineaParadaVO> getRelaciones() {
		return relaciones;
	}

	public void setRelaciones(TreeMap<String, LineaParadaVO> relaciones) {
		this.relaciones = relaciones;
	}

	//DOS PARADAS SON IGUALES SI TIENEN EL MISMO ID
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
		ParadasVO other = (ParadasVO) obj;
		if (idParada != other.idParada)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paradas [idParada=" + idParada + ", denominacion=" + denominacion + ", fecha=" + fecha + ", relaciones="
				+ relaciones + "]";
	}
	
}
