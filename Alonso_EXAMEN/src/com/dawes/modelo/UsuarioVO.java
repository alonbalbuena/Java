package com.dawes.modelo;

import java.util.List;

public class UsuarioVO {

	private String nombre;
	private String email;
	private String ciudad;
	private List<String> aficiones;
	private String sexo;
	
	public UsuarioVO(String nombre, String email, String ciudad, List<String> aficiones, String sexo) {
		this.nombre = nombre;
		this.email = email;
		this.ciudad = ciudad;
		this.aficiones = aficiones;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<String> getAficiones() {
		return aficiones;
	}

	public void setAficiones(List<String> aficiones) {
		this.aficiones = aficiones;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "UsuarioVO [nombre=" + nombre + ", email=" + email + ", ciudad=" + ciudad + ", aficiones=" + aficiones
				+ ", sexo=" + sexo + "]";
	}
	
}
