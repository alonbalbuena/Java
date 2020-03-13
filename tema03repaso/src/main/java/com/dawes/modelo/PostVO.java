package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;
	@Column(length = 200)
	private String nombre;
	@Column(length = 200)	
	private String contenido;
	private LocalDate fecha;
	public PostVO(int idPost, String nombre, String contenido, LocalDate fecha) {
		this.idPost = idPost;
		this.nombre = nombre;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	public PostVO(String nombre, String contenido, LocalDate fecha) {
		this.nombre = nombre;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	public PostVO() {
	}
	public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
