<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.NumeroVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${requestScope.comparacion}</p>
	<p>el numero generado es: ${sessionScope.numeroAleatorio.getNumero()}</p>
	<p>Numero de intentos es: ${sessionScope.intentos}</p>
	<p>Esta peticion del Servlet es la numero ${requestScope.peticiones}</p>

	<a href="./index.html">Volver a intentar</a>
</body>
</html>