<%
	String companyName = (String)request.getAttribute("companyName");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador - Nova Empresa Criada</title>
</head>
<body>

	Empresa <%= companyName %> registrada com sucesso!!!

</body>
</html>