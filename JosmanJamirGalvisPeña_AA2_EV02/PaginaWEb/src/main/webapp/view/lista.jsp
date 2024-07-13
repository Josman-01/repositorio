<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de registros</title>
</head>
<body>
	<h1>Lista de usuarios registrados</h1>
	
	<table border="1">
	<tr>
		<td>Id</td>
		<td>Nombre</td>
		<td>Correo</td>
		<td>Contraseña</td>
		<td>Acción</td>
	</tr>
	<c:forEach var="registro" items="${lista}">
	<tr>
		<td><c:out value="${registro.id}"></c:out></td>
		<td><c:out value="${registro.nombre}"></c:out></td>
		<td><c:out value="${registro.correo}"></c:out></td>
		<td><c:out value="${registro.contraseña}"></c:out></td>
		<td><a href="registro?opcion=editar&id=<c:out value="${registro.id}"></c:out>">Editar</a></td>
		<td><a href="registro?opcion=eliminar&id=<c:out value="${registro.id}"></c:out>"> Eliminar</a></td>
	</c:forEach>
	</table>
</body>
</html>