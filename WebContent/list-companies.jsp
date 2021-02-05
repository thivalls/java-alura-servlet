<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing Companies</title>
</head>
<body>
	<h1>List of Companies</h1>
	<hr>
	
	
	<c:if test="${not empty companyName}">
		Company ${companyName} registered successfully!!!
	</c:if>
	
	<ul>
	
		<c:forEach items="${companies}" var="company" varStatus="loop">
			<li>
				${ company.name } - <fmt:formatDate value="${company.created_at}" pattern="dd/MM/yyy"/>
				<a href="/gerenciador/edit?id=${loop.index}">Editar</a> 
				<a href="/gerenciador/remove?id=${loop.index}">Remover</a> 
			</li>
		</c:forEach>
		
	</ul>
</body>
</html>