package com.dawes.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class RecetaVO {
	
	private int idReceta;
	private String nombre;
	private String descripcion;
	private LocalDate fecha;
	private String tipo;
	/*no existen dos relaciones de cantidad iguales, por eso el Set*/
	private Set<RecetaIngredientesVO> relacion;
	
	//CONSTRUCTORES
	public RecetaVO(int idReceta, String nombre, String descripcion, LocalDate fecha, String tipo) {
		this.idReceta = idReceta;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.tipo = tipo;

		/*inicializo la lista directamente en el cosntructor*/
		relacion = new HashSet<RecetaIngredientesVO>();
	}
	public RecetaVO(String nombre, String descripcion, LocalDate fecha, String tipo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.tipo = tipo;

		/*inicializo la lista directamente en el cosntructor*/
		relacion = new HashSet<RecetaIngredientesVO>();
	}
	//GETTER Y SETTER
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Set<RecetaIngredientesVO> getRelacion() {
		return relacion;
	}
	public void setRelacion(Set<RecetaIngredientesVO> relacion) {
		this.relacion = relacion;
	}
	
	//DOS RECETAS SON IGUALES SI TIENEN EL MISMO ID
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idReceta;
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
		RecetaVO other = (RecetaVO) obj;
		if (idReceta != other.idReceta)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "recetaVO [idReceta=" + idReceta + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha="
				+ fecha + ", tipo=" + tipo + "]";
	}
}
