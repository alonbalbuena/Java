package com.dawes.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="fincas")
public class FincaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfinca;
	private String denominacion;
	@OneToMany(mappedBy="finca")
	List<ArbolVO> arboles;
	@OneToMany(mappedBy="finca")
	List<FincaTratamientoVO> fincas;
	public FincaVO(int idfinca, String denominacion, List<ArbolVO> arboles, List<FincaTratamientoVO> fincas) {
		super();
		this.idfinca = idfinca;
		this.denominacion = denominacion;
		this.arboles = arboles;
		this.fincas = fincas;
	}
	public FincaVO(String denominacion, List<ArbolVO> arboles, List<FincaTratamientoVO> fincas) {
		super();
		this.denominacion = denominacion;
		this.arboles = arboles;
		this.fincas = fincas;
	}
	public FincaVO() {
		super();
	}
	public int getIdfinca() {
		return idfinca;
	}
	public void setIdfinca(int idfinca) {
		this.idfinca = idfinca;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public List<ArbolVO> getArboles() {
		return arboles;
	}
	public void setArboles(List<ArbolVO> arboles) {
		this.arboles = arboles;
	}
	public List<FincaTratamientoVO> getFincas() {
		return fincas;
	}
	public void setFincas(List<FincaTratamientoVO> fincas) {
		this.fincas = fincas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arboles == null) ? 0 : arboles.hashCode());
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + ((fincas == null) ? 0 : fincas.hashCode());
		result = prime * result + idfinca;
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
		FincaVO other = (FincaVO) obj;
		if (arboles == null) {
			if (other.arboles != null)
				return false;
		} else if (!arboles.equals(other.arboles))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (fincas == null) {
			if (other.fincas != null)
				return false;
		} else if (!fincas.equals(other.fincas))
			return false;
		if (idfinca != other.idfinca)
			return false;
		return true;
	}

}
