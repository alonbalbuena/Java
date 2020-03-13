package com.dawes.modelo;

public class LineaParadaVO {

	private int idLineaParada;
	private LineasVO idLinea;
	private ParadasVO idParada;
	private int marquesina;
	
	//CON ID
	public LineaParadaVO(int idLineaParada, LineasVO idLinea, ParadasVO idParada, int marquesina) {
		this.idLineaParada = idLineaParada;
		this.idLinea = idLinea;
		this.idParada = idParada;
		this.marquesina = marquesina;
	}

	//SIN ID
	public LineaParadaVO(LineasVO idLinea, ParadasVO idParada, int marquesina) {
		this.idLinea = idLinea;
		this.idParada = idParada;
		this.marquesina = marquesina;
	}

	public int getIdLineaParada() {
		return idLineaParada;
	}

	public void setIdLineaParada(int idLineaParada) {
		this.idLineaParada = idLineaParada;
	}

	public LineasVO getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(LineasVO idLinea) {
		this.idLinea = idLinea;
	}

	public ParadasVO getIdParada() {
		return idParada;
	}

	public void setIdParada(ParadasVO idParada) {
		this.idParada = idParada;
	}

	public int getMarquesina() {
		return marquesina;
	}

	public void setMarquesina(int marquesina) {
		this.marquesina = marquesina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLineaParada;
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
		LineaParadaVO other = (LineaParadaVO) obj;
		if (idLineaParada != other.idLineaParada)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineaParada [idLineaParada=" + idLineaParada + ", idLinea=" + idLinea + ", idParada=" + idParada
				+ ", marquesina=" + marquesina + "]";
	}	
}
