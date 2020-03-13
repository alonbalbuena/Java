package com.dawes.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuentas")
public class CuentaVO {
	//para determinar cual es la id la notacion va justo antes
	@Id
	//la siguiente linea determina que el id lo tiene que generar automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;
	private String numero;
	private float saldo;
	
	@ManyToOne
	@JoinColumn(name="idtitular")
	//clave agena
	private TitularVO titular;

	public CuentaVO(int idCuenta, String numero, float saldo, TitularVO titular) {
		this.idCuenta = idCuenta;
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}

	public CuentaVO(String numero, float saldo, TitularVO titular) {
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}

	public CuentaVO() {
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public TitularVO getTitular() {
		return titular;
	}

	public void setTitular(TitularVO titular) {
		this.titular = titular;
	}
	
	
}
