<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ 
	page import="java.util.List, br.com.alura.gerenciador.models.Empresa"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listagem de Empresas</h1>
	<hr>
	<ul>
		<%
			List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
			for (Empresa empresa : empresas) {
		%>
		
			<li><%= empresa.getName() %></li>
		
		<% } %>
		
		</ul>

</body>
</html>