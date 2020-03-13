package com.dawes.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;
	@Column(length = 45)
	private String nombre;
	private LocalDate fecha;
	//Roles del usuario la relacion es N:M(usamos tabla auxiliar)
	//decimos a que clave de la otra tabla relaciona
	@OneToMany(mappedBy = "idrol")
	private List<UsuarioRolVO> roles;
	
	public UsuarioVO(int idusuario, String nombre, LocalDate fecha,List<UsuarioRolVO> roles) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.fecha = fecha;
		this.roles = roles;
	}
	
	
	public UsuarioVO(String nombre, LocalDate fecha,List<UsuarioRolVO> roles) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.roles = roles;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public List<UsuarioRolVO> getRoles() {
		return roles;
	}


	public void setRoles(List<UsuarioRolVO> roles) {
		this.roles = roles;
	}
	
}
