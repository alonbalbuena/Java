package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="arboles")
public class ArbolVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idarbol;
	String variedad;
	String patron;
	int fila;
	int columna;
	@ManyToOne
	@JoinColumn(name="idfinca")
	FincaVO finca;
	public ArbolVO(int idarbol, String variedad, String patron, int fila, int columna, FincaVO finca) {
		super();
		this.idarbol = idarbol;
		this.variedad = variedad;
		this.patron = patron;
		this.fila = fila;
		this.columna = columna;
		this.finca = finca;
	}
	public ArbolVO(String variedad, String patron, int fila, int columna, FincaVO finca) {
		super();
		this.variedad = variedad;
		this.patron = patron;
		this.fila = fila;
		this.columna = columna;
		this.finca = finca;
	}
	public ArbolVO() {
		super();
	}
	public int getIdarbol() {
		return idarbol;
	}
	public void setIdarbol(int idarbol) {
		this.idarbol = idarbol;
	}
	public String getVariedad() {
		return variedad;
	}
	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}
	public String getPatron() {
		return patron;
	}
	public void setPatron(String patron) {
		this.patron = patron;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public FincaVO getFinca() {
		return finca;
	}
	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		result = prime * result + ((finca == null) ? 0 : finca.hashCode());
		result = prime * result + idarbol;
		result = prime * result + ((patron == null) ? 0 : patron.hashCode());
		result = prime * result + ((variedad == null) ? 0 : variedad.hashCode());
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
		ArbolVO other = (ArbolVO) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		if (finca == null) {
			if (other.finca != null)
				return false;
		} else if (!finca.equals(other.finca))
			return false;
		if (idarbol != other.idarbol)
			return false;
		if (patron == null) {
			if (other.patron != null)
				return false;
		} else if (!patron.equals(other.patron))
			return false;
		if (variedad == null) {
			if (other.variedad != null)
				return false;
		} else if (!variedad.equals(other.variedad))
			return false;
		return true;
	}

}
