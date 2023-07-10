<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello JSP</title>
</head>
<body>

	<h1>JavaServer Pages (JSP)</h1>
	
	<jsp:useBean id="productos" class="com.example.beans.ProductosService" scope="application"></jsp:useBean>
	
	<% int a = 123; %>
	<% String nombre = "Ana Ming"; %>
	<% out.print(a); %>
	
	<h2><%= a %></h2>
	<h3><%= nombre %></h3>
	
	<ul>
	<% for (int i = 1; i <= 10; i++) { %>
		<li>Hola <%= i %></li>
	<% } %>
	</ul>
	
	<h1>Lista de productos:</h1>
	<ul>
	<% for (String producto : productos.getProductos()) { %>
		<li><%= producto %></li>
	<% } %>
	</ul>

</body>
</html>