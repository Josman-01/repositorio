<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editor de registros</title>
</head>
<body>
	<h1>Editar informacion</h1>
	
	<form action="registro" method="post">
	<c:set var="registro" value="${registro}"></c:set>
	<input type="hidden" name="opcion" value="editar">
	<input type="hidden" name="id" value="${registro.id}">
		<table border="1">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50" value="${registro.nombre}"></td>
			</tr>
			
			<tr>
				<td>Correo:</td>
				<td><input type="email" name="correo" size="50" value="${registro.correo}"></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type="text" name="contraseña" size="50" value="${registro.contraseña}"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>