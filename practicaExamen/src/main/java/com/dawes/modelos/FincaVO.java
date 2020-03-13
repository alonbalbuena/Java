package com.dawes.modelos;

import java.util.HashSet;

public class FincaVO {
	private int idfinca;
	private String nombre;
	private HashSet<RelacionVO> relacion;
	
	
	public FincaVO(int idfinca, String nombre) {
		this.idfinca = idfinca;
		this.nombre = nombre;
	}
	
	public FincaVO( String nombre) {
		this.nombre = nombre;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (idfinca != other.idfinca)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FincaVO [idfinca=" + idfinca + ", nombre=" + nombre + "]";
	}
	
	
	
}
