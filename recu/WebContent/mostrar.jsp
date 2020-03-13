<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Alonso:${requestScope.votosAlonso}</p>
	<p>Oscar:${requestScope.votosOscar}</p>
	<p>Pablo:${requestScope.votosPablo}</p>
	<a href="encuesta.html">enviar nuevo voto</a>
</body>
</html>