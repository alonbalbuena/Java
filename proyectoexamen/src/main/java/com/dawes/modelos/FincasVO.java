package com.dawes.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fincas")

public class FincasVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfinca;
	private String nombre;
	@OneToMany (mappedBy = "tratamiento", cascade = CascadeType.REMOVE)
	private List<FincasTratamientoVO> tratamiento;
	
	public int getIdfinca() {
		return idfinca;
	}
	public void setIdfinca(int idfinca) {
		this.idfinca = idfinca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<FincasTratamientoVO> getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(List<FincasTratamientoVO> tratamiento) {
		this.tratamiento = tratamiento;
	}
	public FincasVO(int idfinca, String nombre, List<FincasTratamientoVO> tratamiento) {
		this.idfinca = idfinca;
		this.nombre = nombre;
		this.tratamiento = tratamiento;
	}
	
	public FincasVO(String nombre, List<FincasTratamientoVO> tratamiento) {
		 
		this.nombre = nombre;
		this.tratamiento = tratamiento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idfinca;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tratamiento == null) ? 0 : tratamiento.hashCode());
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
		FincasVO other = (FincasVO) obj;
		if (idfinca != other.idfinca)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tratamiento == null) {
			if (other.tratamiento != null)
				return false;
		} else if (!tratamiento.equals(other.tratamiento))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FincasVO [idfinca=" + idfinca + ", nombre=" + nombre + ", tratamiento=" + tratamiento + "]";
	}
	
	
	
	

}
