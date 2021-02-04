<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/storeCompanies" var="linkStoreNewCompany" />

<html>


<body>
	<h1>
		Criando nova empresa
	</h1>
	
	<form action="${linkStoreNewCompany}" method="post">
		<input name="name" placeholder="Type the company name..." />
		<button type="submit">Cadastrar</button>
	</form>
</body>


</html>