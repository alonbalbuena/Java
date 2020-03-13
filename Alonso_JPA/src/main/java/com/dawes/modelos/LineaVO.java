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
@Table(name = "lineas")
public class LineaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLinea;
	
	private String denCorta;
	
	private String denLarga;
	
	private LocalDate fecha;
	
	//relacion con paradas
	@OneToMany(mappedBy = "idLinea",cascade = CascadeType.REMOVE)
	// pongo el nombre del campo de la otra tabla (nombre del atributo java) que relaciona
	//si pongo borrar en cascada:
	//si BORRRA linea se borran todas sus paradas
	private List<LineaParadaVO> paradas;

	public LineaVO(int idLineas, String denCorta, String denLarga, LocalDate fecha, List<LineaParadaVO> paradas) {
		this.idLinea = idLineas;
		this.denCorta = denCorta;
		this.denLarga = denLarga;
		this.fecha = fecha;
		this.paradas = paradas;
	}

	public LineaVO(String denCorta, String denLarga, LocalDate fecha, List<LineaParadaVO> paradas) {
		this.denCorta = denCorta;
		this.denLarga = denLarga;
		this.fecha = fecha;
		this.paradas = paradas;
	}

	public LineaVO() {
	}

	public int getIdLineas() {
		return idLinea;
	}

	public void setIdLineas(int idLineas) {
		this.idLinea = idLineas;
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
		LineaVO other = (LineaVO) obj;
		if (idLinea != other.idLinea)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineaVO [idLinea=" + idLinea + ", denCorta=" + denCorta + ", denLarga=" + denLarga + ", fecha=" + fecha
				+ ", paradas=" + paradas + "]";
	}
	
	
}
