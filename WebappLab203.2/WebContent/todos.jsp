<%@page import="com.example.model.Todo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos</title>
</head>
<body>

<% Todo[] todos = (Todo[]) request.getAttribute("todos"); %>

<form method="post" action="todos">
	<ul>
	<% for (Todo todo : todos) { %>
		<li>
			<span>
				<input type="checkbox" name="check:<%= todo.getId() %>" <%= todo.getChecked() ? "checked" : "" %> >
			</span>
			<span><%= todo.getId() %></span>
			<span><%= todo.getTitle() %></span>
			<span><%= todo.getCreated() %></span>
		</li>
	<% } %>
	</ul>
	<input type="submit" value="Update">
</form>

<form method="post" action="saveTodos">
	<input type="submit" value="Save">
</form>

<form method="post" action="loadTodos">
	<input type="submit" value="Load">
</form>

</body>
</html>