package com.dawes.Aplicacion;
import java.util.TreeMap;
import com.dawes.tipos.*;
import java.time.LocalDate;
public class Curso {

	private TreeMap<String,Ciclos> ciclos;
	private TreeMap<String,Profesores> profesores;
	
	public static void main(String [] args) {
		Curso aplicacion =new Curso();
		aplicacion.addCiclo("mates", "matematicas para las ciencias sociales");
		aplicacion.addCiclo("lengua", "Lengua y Literatura");
		aplicacion.addCiclo("cono", "Conocimmiento del medio");
		
		aplicacion.addProfesor("53646496P", "Alonso Garcia Balbuena", LocalDate.parse("1997-10-18"));
		aplicacion.addProfesor("35591934D", "Alicia Asenjo Ferrera",LocalDate.parse("1997-01-16"));
		
		aplicacion.relacionar(LocalDate.parse("2019-01-01"), "lengua", "35591934D");
		aplicacion.relacionar(LocalDate.parse("2019-02-02"), "cono", "35591934D");
		
		aplicacion.relacionar(LocalDate.parse("2019-10-08"), "mates", "53646496P");
		
		aplicacion.consultarCiclos("35591934D");
		aplicacion.consultarProfesores("lengua");
		aplicacion.consultarTodo();
		
		aplicacion.consultaAñosProfesor(3);
		
	}
	
	public void consultaAñosProfesor(int años) {
		System.out.println("Profesores que lleven mas de "+años+ " dando clase:");
		profesores.forEach( (dni,profe) -> {
			//si la fecha de año del funcionario - el año actual <= 3
			if(LocalDate.now().getYear() - profe.getFechaFuncionario().getYear() >= años ) {
				System.out.println(profe.getNombre());
			}
				
		});
	}

	public void consultarCiclos(String dni) {
		
		profesores.get(dni).getRelacion().forEach(ciclo -> System.out.println(ciclo.getCiclo().getdCorta()));
	}
	
	public void consultarProfesores(String dCortaCiclo) {
		ciclos.get(dCortaCiclo).getRelacion().forEach(profe -> System.out.println(profe.getProfesor().getNombre()));
	}
	
	public void consultarTodo() {
		profesores.forEach((dCorta,profe) -> {
			System.out.println(profe);
			profe.getRelacion().forEach(ciclo -> System.out.println(ciclo.getCiclo().getdLarga()));
			});
	}

	public Curso(){
		ciclos = new TreeMap<>();
		profesores = new TreeMap<>();
	}
	
	public TreeMap<String, Ciclos> getCiclos() {
		return ciclos;
	}

	public void setCiclos(TreeMap<String, Ciclos> ciclos) {
		this.ciclos = ciclos;
	}

	public TreeMap<String, Profesores> getProfesores() {
		return profesores;
	}

	public void setProfesores(TreeMap<String, Profesores> profesores) {
		this.profesores = profesores;
	}

	public void addCiclo(String dCorta,String dLarga) {
		Ciclos ciclo = new Ciclos(dCorta, dLarga);
		ciclos.put(dCorta, ciclo);
	}
	
	public void addProfesor(String dni,String nombre, LocalDate localDate) {
		Profesores profe = new Profesores(dni,nombre,localDate);
		profesores.put(dni,profe);
	}
	
	public void relacionar(LocalDate localDate,String dCorta, String dni) {
		//obtengo los campos de profesores y ciclos
		Profesores profe = profesores.get(dni);
		Ciclos ciclo = ciclos.get(dCorta);
		//Creo la relacion
		Imparten relacion = new Imparten(localDate, profe, ciclo);
		//actualizamos campos
		ciclo.getRelacion().add(relacion);
		profe.getRelacion().add(relacion);
	}
}
