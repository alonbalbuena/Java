package com.dawes.modelo;

public class RecetaIngredientesVO {
	
	private int idRecetaIngredientes;
	private int cantidad;
	private RecetaVO idReceta;
	private IngredientesVO idIngrediente;
	
	//CONSTRUCTORES
	public RecetaIngredientesVO(int idrecetaingredientes, int cantidad, RecetaVO idreceta,
			IngredientesVO idingrediente) {
		this.idRecetaIngredientes = idrecetaingredientes;
		this.cantidad = cantidad;
		this.idReceta = idreceta;
		this.idIngrediente = idingrediente;
	}
	public RecetaIngredientesVO(int cantidad, RecetaVO idreceta, IngredientesVO idingrediente) {
		this.cantidad = cantidad;
		this.idReceta = idreceta;
		this.idIngrediente = idingrediente;
	}

	public int getIdrecetaingredientes() {
		return idRecetaIngredientes;
	}

	public void setIdrecetaingredientes(int idrecetaingredientes) {
		this.idRecetaIngredientes = idrecetaingredientes;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public RecetaVO getIdreceta() {
		return idReceta;
	}

	public void setIdreceta(RecetaVO idreceta) {
		this.idReceta = idreceta;
	}

	public IngredientesVO getIdingrediente() {
		return idIngrediente;
	}

	public void setIdingrediente(IngredientesVO idingrediente) {
		this.idIngrediente = idingrediente;
	}
	
	//DOS SON IGUALES SI TIENEN EL MISMO ID
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRecetaIngredientes;
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
		RecetaIngredientesVO other = (RecetaIngredientesVO) obj;
		if (idRecetaIngredientes != other.idRecetaIngredientes)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "recetaIngredientesVO [idrecetaingredientes=" + idRecetaIngredientes + ", cantidad=" + cantidad
				+ ", idreceta=" + idReceta + ", idingrediente=" + idIngrediente + "]";
	}
}
