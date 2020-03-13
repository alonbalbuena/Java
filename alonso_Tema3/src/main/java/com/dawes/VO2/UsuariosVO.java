package com.dawes.VO2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuariosVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombre;
	private String NIF;
	public UsuariosVO(int idUsuario, String nombre, String nIF) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		NIF = nIF;
	}
	public UsuariosVO(String nombre, String nIF) {
		this.nombre = nombre;
		NIF = nIF;
	}
	
	
	
	public UsuariosVO() {
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
		
	
}
