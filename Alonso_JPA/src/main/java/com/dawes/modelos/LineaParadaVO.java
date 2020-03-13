package com.dawes.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lineaparadas")
public class LineaParadaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLineaParada;
	
	private int marquesina;
	
	@ManyToOne
	@JoinColumn(name = "idlinea")
	//indicamos el nombre de la columna en el que relacionamos las tablas
	private LineaVO idLinea;
	
	@ManyToOne
	@JoinColumn(name="idparada")
	//indicamos el nombre de la columna en el que relacionamos las tablas
	private ParadaVO idParada;

	public LineaParadaVO(int idLineaParada,int marquesina, LineaVO idLinea, ParadaVO idParada) {
		this.idLineaParada = idLineaParada;
		this.idLinea = idLinea;
		this.idParada = idParada;
		this.marquesina = marquesina;
	}

	public LineaParadaVO(int marquesina,LineaVO idLinea, ParadaVO idParada) {
		this.idLinea = idLinea;
		this.idParada = idParada;
		this.marquesina = marquesina;

	}

	public LineaParadaVO() {
	}

	public int getIdLineaParada() {
		return idLineaParada;
	}

	public void setIdLineaParada(int idLineaParada) {
		this.idLineaParada = idLineaParada;
	}

	public LineaVO getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(LineaVO idLinea) {
		this.idLinea = idLinea;
	}

	public ParadaVO getIdParada() {
		return idParada;
	}

	public void setIdParada(ParadaVO idParada) {
		this.idParada = idParada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLineaParada;
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
		LineaParadaVO other = (LineaParadaVO) obj;
		if (idLineaParada != other.idLineaParada)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineaParadaVO [idLineaParada=" + idLineaParada + ", idLinea=" + idLinea + ", idParada=" + idParada
				+ "]";
	}

	public int getMarquesina() {
		return marquesina;
	}

	public void setMarquesina(int marquesina) {
		this.marquesina = marquesina;
	}
	
	
}
