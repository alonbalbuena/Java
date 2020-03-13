package com.dawes.modelos;

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
	private int idtratamiento;
	private String producto;
	private String dosis;
	@OneToMany(mappedBy = "finca")
	private List <FincasTratamientoVO> fincas;
	
	
	
	public int getIdtratamiento() {
		return idtratamiento;
	}
	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public List<FincasTratamientoVO> getFincas() {
		return fincas;
	}
	public void setFincas(List<FincasTratamientoVO> fincas) {
		this.fincas = fincas;
	}
	public TratamientoVO(int idtratamiento, String producto, String dosis, List<FincasTratamientoVO> fincas) {
		this.idtratamiento = idtratamiento;
		this.producto = producto;
		this.dosis = dosis;
		this.fincas = fincas;
	}
	public TratamientoVO( String producto, String dosis, List<FincasTratamientoVO> fincas) {
		 
		this.producto = producto;
		this.dosis = dosis;
		this.fincas = fincas;
	}
	public TratamientoVO() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dosis == null) ? 0 : dosis.hashCode());
		result = prime * result + ((fincas == null) ? 0 : fincas.hashCode());
		result = prime * result + idtratamiento;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		if (dosis == null) {
			if (other.dosis != null)
				return false;
		} else if (!dosis.equals(other.dosis))
			return false;
		if (fincas == null) {
			if (other.fincas != null)
				return false;
		} else if (!fincas.equals(other.fincas))
			return false;
		if (idtratamiento != other.idtratamiento)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TratamientoVO [idtratamiento=" + idtratamiento + ", producto=" + producto + ", dosis=" + dosis
				+ ", fincas=" + fincas + "]";
	}
	
	
	
}
