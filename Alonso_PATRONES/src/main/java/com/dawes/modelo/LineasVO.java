package com.dawes.modelo;

import java.time.LocalDate;
import java.util.TreeMap;

public class LineasVO {

	private int idLinea;
	private String denCorta;
	private String denLarga;
	private LocalDate fecha;
	//es treeMap porque cada parada en cada linea tiene un nombre,una clave(String)
	private TreeMap<String,LineaParadaVO> relaciones;
	
	public LineasVO(int idLinea, String denCorta, String denLarga, LocalDate fecha) {
		this.idLinea = idLinea;
		this.denCorta = denCorta;
		this.denLarga = denLarga;
		this.fecha = fecha;
		//inicializamos directamente la lista en el constructor
		relaciones = new TreeMap<String, LineaParadaVO>();
	}

	public LineasVO(String denCorta, String denLarga, LocalDate fecha) {
		this.denCorta = denCorta;
		this.denLarga = denLarga;
		this.fecha = fecha;
		//inicializamos directamente la lista en el constructor
		relaciones = new TreeMap<String, LineaParadaVO>();
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public String getDenCorta() {
		return denCorta;
	}

	public void setDenCorta(String denCorta) {
		this.denCorta = denCorta;
	}

	public String getDenLarga() {
		return denLarga;
	}

	public void setDenLarga(String denLarga) {
		this.denLarga = denLarga;
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

	//DOS LINEAS SON IGUALES SI TIENEN EL MISMO ID
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLinea;
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
		LineasVO other = (LineasVO) obj;
		if (idLinea != other.idLinea)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lineas [idLinea=" + idLinea + ", denCorta=" + denCorta + ", denLarga=" + denLarga + ", fecha=" + fecha
				+ ", relaciones=" + relaciones + "]";
	}

}
