package com.dawes.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String userName;
	private String email;
	private String password;
	private LocalDate create_time;
	private String avatar_path;
	
	@OneToMany(mappedBy = "userId")
	private List<PostVO> posts;
	
	@ManyToOne
	@JoinColumn(name = "rol")
	private RolVO rol;
	
	public UsuarioVO() {
	}
	public UsuarioVO(String userName, String email, String password, LocalDate create_time, String avatar_path) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.create_time = create_time;
		this.avatar_path = avatar_path;
		posts = new ArrayList<PostVO>();
	}
	public UsuarioVO(int idUsuario, String userName, String email, String password, LocalDate create_time,
			String avatar_path) {
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.create_time = create_time;
		this.avatar_path = avatar_path;
		posts = new ArrayList<PostVO>();
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getCreate_time() {
		return create_time;
	}
	public void setCreate_time(LocalDate create_time) {
		this.create_time = create_time;
	}
	public String getAvatar_path() {
		return avatar_path;
	}
	public void setAvatar_path(String avatar_path) {
		this.avatar_path = avatar_path;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
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
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UsuarioVO [idUsuario=" + idUsuario + ", userName=" + userName + ", email=" + email + ", password="
				+ password + ", create_time=" + create_time + ", avatar_path=" + avatar_path + ",posts "
			+ posts+"]";
	}
	
}
