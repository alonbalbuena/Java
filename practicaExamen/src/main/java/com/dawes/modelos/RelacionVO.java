package com.dawes.modelos;

import java.time.LocalDate;

public class RelacionVO {
	private int idrelacion;
	private LocalDate fecha;
	private FincaVO idfinca;
	private TratamientosVO idtratamientos;
	
	public RelacionVO(int idrelacion, LocalDate fecha, FincaVO idfinca, TratamientosVO idtratamientos) {
		this.idrelacion = idrelacion;
		this.fecha = fecha;
		this.idfinca = idfinca;
		this.idtratamientos = idtratamientos;
	}
	
	public RelacionVO(LocalDate fecha, FincaVO idfinca, TratamientosVO idtratamientos) {
		this.fecha = fecha;
		this.idfinca = idfinca;
		this.idtratamientos = idtratamientos;
	}

	public int getIdrelacion() {
		return idrelacion;
	}

	public void setIdrelacion(int idrelacion) {
		this.idrelacion = idrelacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public FincaVO getIdfinca() {
		return idfinca;
	}

	public void setIdfinca(FincaVO idfinca) {
		this.idfinca = idfinca;
	}

	public TratamientosVO getIdtratamientos() {
		return idtratamientos;
	}

	public void setIdtratamientos(TratamientosVO idtratamientos) {
		this.idtratamientos = idtratamientos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idrelacion;
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
		RelacionVO other = (RelacionVO) obj;
		if (idrelacion != other.idrelacion)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RelacionVO [idrelacion=" + idrelacion + ", fecha=" + fecha + ", idfinca=" + idfinca
				+ ", idtratamientos=" + idtratamientos + "]";
	}
	
	
}
