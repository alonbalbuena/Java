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
@Table(name="recetas")
public class RecetaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceta;
	
	@Column(length = 200)
	private String nombre;
	
	//clave ajena
	@OneToMany(mappedBy = "idingrediente")
	private List<TieneVO> ingredientes;

	public RecetaVO(int idReceta, String nombre, List<TieneVO> ingredientes) {
		this.idReceta = idReceta;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
	}

	public RecetaVO(String nombre, List<TieneVO> ingredientes) {
		this.nombre = nombre;
		this.ingredientes = ingredientes;
	}
	
	public RecetaVO() {
		
	}

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

	public List<TieneVO> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<TieneVO> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
