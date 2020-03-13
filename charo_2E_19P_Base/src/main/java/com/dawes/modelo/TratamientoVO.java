package com.dawes.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tratamientos")
public class TratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idtratamiento;
	String pa;
	@OneToMany(mappedBy="tratamiento")
	List<FincaTratamientoVO> fincas;
	public TratamientoVO(int idtratamiento, String pa, List<FincaTratamientoVO> fincas) {
		super();
		this.idtratamiento = idtratamiento;
		this.pa = pa;
		this.fincas = fincas;
	}
	public TratamientoVO(String pa, List<FincaTratamientoVO> fincas) {
		super();
		this.pa = pa;
		this.fincas = fincas;
	}
	public TratamientoVO() {
		super();
	}
	public int getIdtratamiento() {
		return idtratamiento;
	}
	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}
	public String getPa() {
		return pa;
	}
	public void setPa(String pa) {
		this.pa = pa;
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
		result = prime * result + ((fincas == null) ? 0 : fincas.hashCode());
		result = prime * result + idtratamiento;
		result = prime * result + ((pa == null) ? 0 : pa.hashCode());
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
		TratamientoVO other = (TratamientoVO) obj;
		if (fincas == null) {
			if (other.fincas != null)
				return false;
		} else if (!fincas.equals(other.fincas))
			return false;
		if (idtratamiento != other.idtratamiento)
			return false;
		if (pa == null) {
			if (other.pa != null)
				return false;
		} else if (!pa.equals(other.pa))
			return false;
		return true;
	}
	

}
