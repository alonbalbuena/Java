package com.dawes.modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table (name = "lineas")
public class LineaVO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlinea;
	private String dencorta;
	private String denlarga;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha;	
	@OneToMany(mappedBy = "linea",  fetch = FetchType.LAZY)
	private List<LineaParadaVO> paradas=new ArrayList();

	public LineaVO() {
		super();
		paradas = new ArrayList<LineaParadaVO>();
	}

	public LineaVO(String denCorta, String denLarga, LocalDate fecha, List<LineaParadaVO> paradas) {
		super();
		this.dencorta = denCorta;
		this.denlarga = denLarga;
		this.fecha = fecha;
		this.paradas = paradas;
	}

	public LineaVO(int idLinea, String denCorta, String denLarga, LocalDate fecha, List<LineaParadaVO> paradas) {
		super();
		this.idlinea = idLinea;
		this.dencorta = denCorta;
		this.denlarga = denLarga;
		this.fecha = fecha;
		this.paradas = paradas;
	}
	
	
	public void addLineaParada(LineaParadaVO lp) {
		this.paradas.add(lp);
	}
	

	public int getIdlinea() {
		return idlinea;
	}
	public void setIdlinea(int idLinea) {
		this.idlinea = idLinea;
	}

	public String getDencorta() {
		return dencorta;
	}
	public void setDencorta(String denCorta) {
		this.dencorta = denCorta;
	}

	public String getDenlarga() {
		return denlarga;
	}
	public void setDenlarga(String denLarga) {
		this.denlarga = denLarga;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<LineaParadaVO> getParadas() {
		return paradas;
	}
	public void setParadas(List<LineaParadaVO> paradas) {
		this.paradas = paradas;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dencorta == null) ? 0 : dencorta.hashCode());
		result = prime * result + ((denlarga == null) ? 0 : denlarga.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idlinea;
		result = prime * result + ((paradas == null) ? 0 : paradas.hashCode());
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
		LineaVO other = (LineaVO) obj;
		if (dencorta == null) {
			if (other.dencorta != null)
				return false;
		} else if (!dencorta.equals(other.dencorta))
			return false;
		if (denlarga == null) {
			if (other.denlarga != null)
				return false;
		} else if (!denlarga.equals(other.denlarga))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idlinea != other.idlinea)
			return false;
		if (paradas == null) {
			if (other.paradas != null)
				return false;
		} else if (!paradas.equals(other.paradas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineasVO [idlinea=" + idlinea + ", dencorta=" + dencorta + ", denlarga=" + denlarga + ", fecha="
				+ fecha + "]";
	}
	
	
	
}
