package com.dawes.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<body>");
		 out.println("<h1>Se ha guardado satisfactoriamente</h1>");
		 
		 //CREAMOS EL USUARIO
		 UsuarioVO usuario = new UsuarioVO(request.getParameter("nombre"),
				 request.getParameter("contra")
				 );
		 //Y LO GUARDAMOS EN LA BASE DE DATOS
		 ServicioUsuarioImpl servicio = new ServicioUsuarioImpl();
		 servicio.insertarUsuario(usuario);
		 
		 //mostramos los usuarios que van introducidos
		 List<UsuarioVO> lista = servicio.mostrarUsuarios();
		 for (UsuarioVO usuarioEnBase : lista) {
			 out.println("<br>");
			 out.println("nombre: "+usuarioEnBase.getNombre() +"/ contraseña: "+ usuarioEnBase.getContraseña());
		}
		 
		 out.println("</body>");
		 out.println("</html>");

	}

}
