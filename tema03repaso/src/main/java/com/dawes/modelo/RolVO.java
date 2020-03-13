package com.dawes.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class RolVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	private String nombre;
	
	//cuando es una relacion N:M usamos tabla auxiliar
	//decimos a que clave de la otra tabla relaciona
	@OneToMany(mappedBy = "idusuario")
	private List<UsuarioRolVO> usuarios;

	public RolVO(int idRol, String nombre, List<UsuarioRolVO> usuarios) {
		this.idRol = idRol;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public RolVO(String nombre, List<UsuarioRolVO> usuarios) {
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public RolVO() {
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioRolVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioRolVO> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
