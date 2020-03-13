package com.dawes.recetas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredientes")
public class IngredienteVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIngrediente;
	
	@Column(length=200)
	private String nombre;
	
	//señalamos la clave ajena
	@OneToMany(mappedBy = "idreceta")
	private List<TieneVO> recetas;

	public IngredienteVO(int idIngrediente, String nombre, List<TieneVO> recetas) {
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.recetas = recetas;
	}

	public IngredienteVO(String nombre, List<TieneVO> recetas) {
		this.nombre = nombre;
		this.recetas = recetas;
	}

	public IngredienteVO() {
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TieneVO> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<TieneVO> recetas) {
		this.recetas = recetas;
	}
	
	
	
}
