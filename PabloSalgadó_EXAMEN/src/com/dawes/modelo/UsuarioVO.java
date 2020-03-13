package com.dawes.modelo;

public class UsuarioVO {
	
	private String nombre;
	private String mail;
	private String ciudad;
	private String aficiones;
	private String sexo;
	
	
	public UsuarioVO(String nombre, String mail, String ciudad, String aficiones, String sexo) {
		this.nombre = nombre;
		this.mail = mail;
		this.ciudad = ciudad;
		this.aficiones = aficiones;
		this.sexo = sexo;
	}
	
	public UsuarioVO(String mail, String ciudad, String aficiones, String sexo) {
		
		this.mail = mail;
		this.ciudad = ciudad;
		this.aficiones = aficiones;
		this.sexo = sexo;
	}

	public UsuarioVO() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getAficiones() {
		return aficiones;
	}

	public void setAficiones(String aficiones) {
		this.aficiones = aficiones;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aficiones == null) ? 0 : aficiones.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		if (aficiones == null) {
			if (other.aficiones != null)
				return false;
		} else if (!aficiones.equals(other.aficiones))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioVO [nombre=" + nombre + ", mail=" + mail + ", ciudad=" + ciudad + ", aficiones=" + aficiones
				+ ", sexo=" + sexo + "]";
	}
	
	

}
