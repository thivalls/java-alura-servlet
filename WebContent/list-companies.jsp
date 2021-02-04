<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listing Companies</title>
</head>
<body>
	<h1>List of Companies</h1>
	<hr>
	<ul>
	
		<c:forEach items="${companies}" var="company">
			<li>${ company.name }</li>
		</c:forEach>
		
	</ul>
</body>
</html>