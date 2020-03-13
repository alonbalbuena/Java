package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reparaciones")
public class ReparacionVO {

	//indicamos que idReparacion va a ser la clave primaria de coches
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	// autoincrementado
	private int idReparacion;
	
	private int importe;
	private LocalDate fecha;

	@ManyToOne() // a que columna de la tabla esta señalando la FK
	@JoinColumn(name = "coche")
	private CocheVO coche; // UNA reparacion se puede hacer a UN solo coche

	// CONSTRUCTORES
	public ReparacionVO(int idReparacion,int importe, LocalDate fecha, CocheVO coche) {
		this.idReparacion = idReparacion;
		this.importe = importe;
		this.fecha = fecha;
		this.coche = coche;
	}

	public ReparacionVO(int importe,LocalDate fecha, CocheVO coche) {
		this.fecha = fecha;
		this.importe = importe;
		this.coche = coche;
	}

	public ReparacionVO() {
	}

	
	// GETTER Y SETTER
	public int getIdReparacion() {
		return idReparacion;
	}

	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public CocheVO getCoche() {
		return coche;
	}

	public void setCoche(CocheVO coche) {
		this.coche = coche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coche == null) ? 0 : coche.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idReparacion;
		result = prime * result + importe;
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
		ReparacionVO other = (ReparacionVO) obj;
		if (coche == null) {
			if (other.coche != null)
				return false;
		} else if (!coche.equals(other.coche))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idReparacion != other.idReparacion)
			return false;
		if (importe != other.importe)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReparacionVO [idReparacion=" + idReparacion + ", importe=" + importe + ", fecha=" + fecha + ", coche="
				+ coche + "]";
	}

}
