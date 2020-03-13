package com.dawes.tipos;

import java.util.ArrayList;

public class Ciclos {
	
	private String dCorta;
	private String dLarga;
	private ArrayList<Imparten> profesores;//como la relacion es N:M es necesario una lista
	
	public Ciclos(String dCorta, String dLarga) {
		this.dCorta = dCorta;
		this.dLarga = dLarga;
		this.setRelacion(new ArrayList<Imparten>());
	}
	
	

	public String getdCorta() {
		return dCorta;
	}



	public void setdCorta(String dCorta) {
		this.dCorta = dCorta;
	}



	public String getdLarga() {
		return dLarga;
	}



	public void setdLarga(String dLarga) {
		this.dLarga = dLarga;
	}



	public ArrayList<Imparten> getRelacion() {
		return profesores;
	}



	public void setRelacion(ArrayList<Imparten> relacion) {
		this.profesores = relacion;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dCorta == null) ? 0 : dCorta.hashCode());
		result = prime * result + ((dLarga == null) ? 0 : dLarga.hashCode());
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
		Ciclos other = (Ciclos) obj;
		if (dCorta == null) {
			if (other.dCorta != null)
				return false;
		} else if (!dCorta.equals(other.dCorta))
			return false;
		if (dLarga == null) {
			if (other.dLarga != null)
				return false;
		} else if (!dLarga.equals(other.dLarga))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Ciclos [dCorta=" + dCorta + ", dLarga=" + dLarga + ", profesores=" + profesores + "]";
	}
	
	
}
