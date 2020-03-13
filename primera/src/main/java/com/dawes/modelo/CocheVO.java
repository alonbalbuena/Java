package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "coches")
public class CocheVO {

	@Id//indicamos que idCoche va a ser la clave primaria de coches
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCoche;
	private String matricula;
	private String propietario;

	// extendemos la clave de ReparacionVO
	@OneToMany(mappedBy = "coche",cascade= {CascadeType.REMOVE,CascadeType.PERSIST} ) 
	// para que borre en cascada al borrar un coche
	//y para que inserte en cascada todas las reparaciones de un coche
	private List<ReparacionVO> reparaciones;
	// UN Coche solo puede tener VARIAS reparaciones

	// CONSTRUCTORES
	public CocheVO(int idCoche, String matricula, String propietario) {
		this.idCoche = idCoche;
		this.matricula = matricula;
		this.propietario = propietario;
		this.reparaciones = new ArrayList<ReparacionVO>();
	}

	public CocheVO(String matricula, String propietario) {
		this.matricula = matricula;
		this.propietario = propietario;
		this.reparaciones = new ArrayList<ReparacionVO>();
	}

	public CocheVO() {
	}

	// GETTER Y SETTER
	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public List<ReparacionVO> getReparacion() {
		return reparaciones;
	}

	public void setReparacion(List<ReparacionVO> reparacion) {
		this.reparaciones = reparacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCoche;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((propietario == null) ? 0 : propietario.hashCode());
		result = prime * result + ((reparaciones == null) ? 0 : reparaciones.hashCode());
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
		CocheVO other = (CocheVO) obj;
		if (idCoche != other.idCoche)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (propietario == null) {
			if (other.propietario != null)
				return false;
		} else if (!propietario.equals(other.propietario))
			return false;
		if (reparaciones == null) {
			if (other.reparaciones != null)
				return false;
		} else if (!reparaciones.equals(other.reparaciones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "cocheVO [idCoche=" + idCoche + ", matricula=" + matricula + ", propietario=" + propietario
				+ ", reparacion=" + reparaciones + "]";
	}

}
