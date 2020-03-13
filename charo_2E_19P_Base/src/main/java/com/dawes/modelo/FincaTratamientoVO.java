package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="fincatratamientos")
public class FincaTratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfincatratamiento;
	private LocalDate fecha;
	@ManyToOne
	@JoinColumn(name="idfinca")
	private FincaVO finca;
	@ManyToOne
	@JoinColumn(name="idtratamiento")
	private TratamientoVO tratamiento;
	public FincaTratamientoVO(int idfincatratamiento, LocalDate fecha, FincaVO finca, TratamientoVO tratamiento) {
		super();
		this.idfincatratamiento = idfincatratamiento;
		this.fecha = fecha;
		this.finca = finca;
		this.tratamiento = tratamiento;
	}
	public FincaTratamientoVO(LocalDate fecha, FincaVO finca, TratamientoVO tratamiento) {
		super();
		this.fecha = fecha;
		this.finca = finca;
		this.tratamiento = tratamiento;
	}
	public FincaTratamientoVO() {
		super();
	}
	public int getIdfincatratamiento() {
		return idfincatratamiento;
	}
	public void setIdfincatratamiento(int idfincatratamiento) {
		this.idfincatratamiento = idfincatratamiento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public FincaVO getFinca() {
		return finca;
	}
	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}
	public TratamientoVO getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(TratamientoVO tratamiento) {
		this.tratamiento = tratamiento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((finca == null) ? 0 : finca.hashCode());
		result = prime * result + idfincatratamiento;
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
		FincaTratamientoVO other = (FincaTratamientoVO) obj;
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
		if (idfincatratamiento != other.idfincatratamiento)
			return false;
		if (tratamiento == null) {
			if (other.tratamiento != null)
				return false;
		} else if (!tratamiento.equals(other.tratamiento))
			return false;
		return true;
	}
	

}
