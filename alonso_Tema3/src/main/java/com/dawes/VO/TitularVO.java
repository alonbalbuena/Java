package com.dawes.VO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="titulares")

public class TitularVO {

	
	//indicamos al orm que la siguiente propiedad es una PK
	@Id
	//esta PK es un autonumerico
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtitular;
	private String nombre;
	private String dni;
	
	//esta es la clave ajena
	@OneToMany(mappedBy = "titular")
	private List<CuentaVO> cuentas;

	public TitularVO(int idtitular, String nombre, String dni, List<CuentaVO> cuentas) {
		this.idtitular = idtitular;
		this.nombre = nombre;
		this.dni = dni;
		this.cuentas = cuentas;
	}

	public TitularVO(String nombre, String dni, List<CuentaVO> cuentas) {
		this.nombre = nombre;
		this.dni = dni;
		this.cuentas = cuentas;
	}
	
	

	public TitularVO() {
	}

	public int getIdtitular() {
		return idtitular;
	}

	public void setIdtitular(int idtitular) {
		this.idtitular = idtitular;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<CuentaVO> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaVO> cuentas) {
		this.cuentas = cuentas;
	}
	
	
}
