package com.dawes.VO2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//indicamos a hibernate que esto va a ser una entidad en el modelo
@Entity

//indicamos el nombre de la tabla cuando lo creemos
@Table(name = "pedidos" )
public class PedidosVO {

	//indicamos que el valor a continuacion es un id
	@Id
	//indicamos que tambien sera autogenerado
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
}
