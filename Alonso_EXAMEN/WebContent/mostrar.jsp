<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dawes.modelo.UsuarioVO,java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	font-family: Arial;
}

table {
	border-collapse: collapse;
}

table, tr {
	border: 1px solid black;
}

tr{
	text-align:center;
}

tr:nth-child(1){
	background-color:grey;
}
</style>
<body>
	<table>
		<tr>
			<td>nombre</td>
			<td>email</td>
			<td>ciudad</td>
			<td>aficiones</td>
			<td>sexo</td>
		</tr>
		<c:forEach var="usuario" items="${sessionScope.usuarios}">
			<tr>
				<td>${usuario.nombre}</td>
				<td>${usuario.email}</td>
				<td>${usuario.ciudad}</td>
				<td>${usuario.aficiones}</td>
				<td>${usuario.sexo}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Contador de accesos : ${requestScope.contadorAccesos}</td>
		</tr>
	</table>
	<a href="./datos.html">Introducir Otro Usuario</a>
</body>
</html>