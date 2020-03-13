<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Almacenaje</title>
</head>
<body>

	<table>
		<tr>
			<td>nombre</td>
			<td>email</td>
		<tr>
		<tr>
			<td>${ sessionScope.nombre}	</td>
			<td>${ sessionScope.mail}	</td>
		<tr>
	</table>

	<a href="datos.html">Introducir mas Usuarios</a>

</body>
</html>

















