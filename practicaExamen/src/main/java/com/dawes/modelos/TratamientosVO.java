package com.dawes.modelos;

import java.util.HashSet;

public class TratamientosVO {
	private int idtratamientos;
	private String producto;
	private int dosis;
	private HashSet<RelacionVO> relacion;
	
	
	public TratamientosVO(int idtratamientos, String producto, int dosis) {
		this.idtratamientos = idtratamientos;
		this.producto = producto;
		this.dosis = dosis;
	}

	public TratamientosVO(  String producto, int dosis) {
		this.producto = producto;
		this.dosis = dosis;
	}

	public int getIdtratamientos() {
		return idtratamientos;
	}

	public void setIdtratamientos(int idtratamientos) {
		this.idtratamientos = idtratamientos;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idtratamientos;
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
		TratamientosVO other = (TratamientosVO) obj;
		if (idtratamientos != other.idtratamientos)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TratamientosVO [idtratamientos=" + idtratamientos + ", producto=" + producto + ", dosis=" + dosis + "]";
	}
	
	
	
	
}
