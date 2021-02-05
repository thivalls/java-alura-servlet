<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/update" var="linkUpdateCompany" />

<html>


<body>
	<h1>
		Editando empresa ${company.name}
	</h1>
	
	<form action="${linkUpdateCompany}" method="post">
		<input name="name" placeholder="Type the company name..." value="${company.name}" />
		<input type="hidden" name="id" value="${company.id}" />
		<input name="created_at" value="<fmt:formatDate value='${company.created_at}' pattern='dd/MM/yyyy'/>"/>
		<button type="submit">Atualizar</button>
	</form>
</body>


</html>