package com.dawes.recetas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tiene")
public class TieneVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTiene;
	
	//decimos que se borre en cascada
	@ManyToOne(cascade = CascadeType.ALL)
	//si en la otra clase pusimos @OneToMany(mappedBy = "idingrediente")
	@JoinColumn(name = "idingrediente")
	private int idIngrediente;
	
	//decimos que se borre en cascada
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idreceta")//el nombre de la foreign key
	private int idReceta;
	
	private int cantidad;

	
	
	public TieneVO() {
	}

	public TieneVO(int idIngrediente, int idReceta, int cantidad) {
		this.idIngrediente = idIngrediente;
		this.idReceta = idReceta;
		this.cantidad = cantidad;
	}

	public TieneVO(int idTiene, int idIngrediente, int idReceta, int cantidad) {
		this.idTiene = idTiene;
		this.idIngrediente = idIngrediente;
		this.idReceta = idReceta;
		this.cantidad = cantidad;
	}

	public int getIdTiene() {
		return idTiene;
	}

	public void setIdTiene(int idTiene) {
		this.idTiene = idTiene;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
