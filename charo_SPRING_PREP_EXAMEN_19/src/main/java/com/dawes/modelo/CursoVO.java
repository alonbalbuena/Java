package com.dawes.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="curso")
public class CursoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcurso;
	
	@Column(unique = true)
	private String denominacion;
	
	
	
	

}
