package com.dawes.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dawes.modelo.UsuarioVO;

@WebServlet("/Proceso")
public class Proceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// variable propia de la aplicacio_n independiente del usuario
	private int contadorAccesos = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtenemos la sesion y le introducimos el nuevo usuario
		HttpSession sesion = request.getSession();

		// comprobamos si ya tiene usuarios introducidos
		ArrayList<UsuarioVO> listaUsuarios = (ArrayList<UsuarioVO>) sesion.getAttribute("usuarios");
		if (listaUsuarios == null) {
			// creamos la lista si no esta creada
			listaUsuarios = new ArrayList<UsuarioVO>();
		}

		//obtenemos los valores del fomulario
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String ciudad = request.getParameter("ciudad");
		String sexo = request.getParameter("Sexo");
		
		//introducimos las aficiones
		ArrayList<String> aficiones = new ArrayList<String>();
		aficiones.add(request.getParameter("Deportes"));
		aficiones.add(request.getParameter("Coches"));
		aficiones.add(request.getParameter("Musica"));
		
		
		// introducimos valores
		listaUsuarios.add(new UsuarioVO(nombre, email, ciudad, aficiones, sexo));

		// enviamos y guardamos en la SESION
		sesion.setAttribute("usuarios", listaUsuarios);

		// Sumo el contador y lo guardo EN LA PETICION
		contadorAccesos++;
		request.setAttribute("contadorAccesos",contadorAccesos);

		// REDIRECCIONAMOS la informacion obtenida del formulario
		RequestDispatcher rd = request.getRequestDispatcher("/mostrar.jsp");
		rd.forward(request, response);
	}

}
