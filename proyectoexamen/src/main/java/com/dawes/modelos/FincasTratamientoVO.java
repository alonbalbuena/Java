package com.dawes.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="fincastratamiento")

public class FincasTratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfincasTratamiento;
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "idfinca")
	private FincasVO finca;
	
	@ManyToOne
	@JoinColumn(name = "idtratamiento")
	private TratamientoVO tratamiento;
	
	public int getIdfincasTratamiento() {
		return idfincasTratamiento;
	}
	public void setIdfincasTratamiento(int idfincasTratamiento) {
		this.idfincasTratamiento = idfincasTratamiento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public FincasVO getFinca() {
		return finca;
	}
	public void setFinca(FincasVO finca) {
		this.finca = finca;
	}
	public TratamientoVO getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(TratamientoVO tratamiento) {
		this.tratamiento = tratamiento;
	}
	public FincasTratamientoVO(int idfincasTratamiento, LocalDate fecha, FincasVO finca, TratamientoVO tratamiento) {
		this.idfincasTratamiento = idfincasTratamiento;
		this.fecha = fecha;
		this.finca = finca;
		this.tratamiento = tratamiento;
	}
	public FincasTratamientoVO( LocalDate fecha, FincasVO finca, TratamientoVO tratamiento) {
		 
		this.fecha = fecha;
		this.finca = finca;
		this.tratamiento = tratamiento;
	}
	public FincasTratamientoVO() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((finca == null) ? 0 : finca.hashCode());
		result = prime * result + idfincasTratamiento;
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
		FincasTratamientoVO other = (FincasTratamientoVO) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (finca == null) {
			if (other.finca != null)
				return false;
		} else if (!finca.equals(other.finca))
			return false;
		if (idfincasTratamiento != other.idfincasTratamiento)
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
		return "FincasTratamientoVO [idfincasTratamiento=" + idfincasTratamiento + ", fecha=" + fecha + ", finca="
				+ finca + ", tratamiento=" + tratamiento + "]";
	}
	
	
	

}
