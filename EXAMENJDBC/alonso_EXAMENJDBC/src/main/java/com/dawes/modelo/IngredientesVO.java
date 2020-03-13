package com.dawes.modelo;

import java.util.HashSet;
import java.util.Set;

public class IngredientesVO {

	private int idIngredientes;
	private String nombre;
	private String tipo;
	/*no existen dos relaciones de cantidad iguales, por eso el Set*/
	private Set<RecetaIngredientesVO> relacion;
	
	//CONSTRUCTORES
	public IngredientesVO(int idingredientes, String nombre, String tipo) {
		this.idIngredientes = idingredientes;
		this.nombre = nombre;
		this.tipo = tipo;
		/*inicializo la lista directamente en el cosntructor*/
		this.relacion = new  HashSet<RecetaIngredientesVO>();
	}
	public IngredientesVO(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;

		/*inicializo la lista directamente en el cosntructor*/
		this.relacion = new  HashSet<RecetaIngredientesVO>();
	}
	public int getIdingredientes() {
		return idIngredientes;
	}
	public void setIdingredientes(int idingredientes) {
		this.idIngredientes = idingredientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	//Dos ingredientes son iguales si tienen el mismo id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idIngredientes;
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
		IngredientesVO other = (IngredientesVO) obj;
		if (idIngredientes != other.idIngredientes)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ingredientesVO [idingredientes=" + idIngredientes + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", relacion=" + relacion + "]";
	}
	
}
