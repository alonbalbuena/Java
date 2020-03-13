package com.dawes.controlador;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controlador")
public class controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		// Creamos lista
		Set<String> listaVotos = (Set<String>) sesion.getAttribute("listaVotos");
		if (listaVotos == null)
			listaVotos = new HashSet<String>();

		// rellenamos la lista
		listaVotos.add(request.getParameter("candidato"));
		//y la vovlemos a sobreescribir para futuras sesiones
		sesion.setAttribute("listaVotos", listaVotos);

		// contamos los votos 
		int votosAlonso, votosOscar, votosPablo;
		votosAlonso = (int) listaVotos.stream().filter(voto -> voto.equals("Alonso")).count();
		votosOscar = (int) listaVotos.stream().filter(voto -> voto.equals("Oscar")).count();
		votosPablo = (int) listaVotos.stream().filter(voto -> voto.equals("Pablo")).count();
		
		//enviamos por la sesion
		request.setAttribute("votosAlonso", votosAlonso);
		request.setAttribute("votosOscar", votosOscar);
		request.setAttribute("votosPablo", votosPablo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
	}

}
