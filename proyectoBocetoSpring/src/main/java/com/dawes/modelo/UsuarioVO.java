package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String usuarioId;
	
	private String usuarioNombre;
	private String email;
	private String contraseña;
	private LocalDate horaCreacion;
	private String tipo;
	private String rutaFoto;
	
	public UsuarioVO() {
	}

	public UsuarioVO(String usuarioNombre, String email, String contraseña, LocalDate horaCreacion, String tipo,
			String rutaFoto) {
		this.usuarioNombre = usuarioNombre;
		this.email = email;
		this.contraseña = contraseña;
		this.horaCreacion = horaCreacion;
		this.tipo = tipo;
		this.rutaFoto = rutaFoto;
	}

	public UsuarioVO(String usuarioId, String usuarioNombre, String email, String contraseña, LocalDate horaCreacion,
			String tipo, String rutaFoto) {
		this.usuarioId = usuarioId;
		this.usuarioNombre = usuarioNombre;
		this.email = email;
		this.contraseña = contraseña;
		this.horaCreacion = horaCreacion;
		this.tipo = tipo;
		this.rutaFoto = rutaFoto;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public LocalDate getHoraCreacion() {
		return horaCreacion;
	}

	public void setHoraCreacion(LocalDate horaCreacion) {
		this.horaCreacion = horaCreacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
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
		UsuarioVO other = (UsuarioVO) obj;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioVO [usuarioId=" + usuarioId + ", usuarioNombre=" + usuarioNombre + ", email=" + email
				+ ", contraseña=" + contraseña + ", horaCreacion=" + horaCreacion + ", tipo=" + tipo + ", rutaFoto="
				+ rutaFoto + "]";
	}

}
