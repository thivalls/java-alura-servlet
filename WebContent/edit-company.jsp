<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/update" var="linkUpdateCompany" />

<html>


<body>
	<h1>
		Criando nova empresa
	</h1>
	
	<form action="${linkUpdateCompany}?id=${id}" method="post">
		<input name="name" placeholder="Type the company name..." value="${company.name}" />
		<input type="hidden" name="_method" value="PUT" />
		<input name="created_at" value="${company.created_at}"/>
		<button type="submit">Atualizar</button>
	</form>
</body>


</html>