package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuariorol")
public class UsuarioRolVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuarioRol;
	
	@ManyToOne
	//señalamos quien es la clave ajena igual que @Id para PK
	@JoinColumn(name = "idrol")
	private RolVO idRol;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioVO idUsuario;
	
	public UsuarioRolVO() {
	}

	public UsuarioRolVO(RolVO idRol, UsuarioVO idUsuario) {
		this.idRol = idRol;
		this.idUsuario = idUsuario;
	}

	public UsuarioRolVO(int idUsuarioRol, RolVO idRol, UsuarioVO idUsuario) {
		this.idUsuarioRol = idUsuarioRol;
		this.idRol = idRol;
		this.idUsuario = idUsuario;
	}

	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}

	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public RolVO getIdRol() {
		return idRol;
	}

	public void setIdRol(RolVO idRol) {
		this.idRol = idRol;
	}

	public UsuarioVO getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UsuarioVO idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
