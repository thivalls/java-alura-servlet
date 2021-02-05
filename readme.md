JSP

O JSP é uma solução onde visa tornar o desenvolvimento mais organizado e deixar páginas dinâmicas. Ele faz
o trabalho de uma template engine onde podemos trabalhar com dados dinâmicos que vêm do servidor e podemos
renderizar no frontend da aplicação.

O JSP foi um salto no desenvolvimento de aplicações web com JAVA.

Quando trabalhamos com um cadastro de uma nova entidade devemos enviar a requisição para o Servlet, que por sua vez
 faz toda lógica necessária, mas não é mais responsável por renderizar nada no front. Agora o Servlet deve chamar
um JSP para que faça a renderização de uma resposta ao usuário.

Este processo é muito importante porque se trata de separar as responsabilidades entre as camadas do fluxo da
aplicação.

Quando temos alguns itens simples para passarmos, como parâmetro, para o JSP não é tão complicado, mas quando precisamos
fazer um loop de repetição para listar dados do banco, precisamos fazer imports também no JSP, caso contrário 
não teremos os recursos necessários. No exemplo no curso foi necessário importar List e o modelo Company.

Como fazer os imports?

<%@ 
	page import="java.util.List, br.com.alura.gerenciador.models.Empresa"
%>

Como fazer um loop for com os scriplets para listagem de dados?

<%
	List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
	for (Empresa empresa : empresas) {
%>
		
		<li><%= empresa.getName() %></li>
		
<% 
	} 
%>

Apesar dos scriptlets melhorar o desenvolvimento e deixar as responsabilidades bem definidas, ainda não apresenta
o melhor dos mundos quando trabalhamos com HTML.

Para melhorar ainda mais a experiência de programação, vamos instalar o pacote JSTL (JAVA STANDARD TAGLIB) que faz
os processos mais verbosos se tornarem mais amigáveis quando trabalhamos com o HTML.

link para download da lib: https://caelum-online-public.s3.amazonaws.com/986-servlets-parte1/05/jstl-1.2.jar

Veja um exemplo de um for utilizando o taglib:

<c:forEach items="${empresas}" var="empresa">
	<li>${ empresa.name }</li>
</c:forEach>

Para trabalhar com internacionalização podemos utilizar o recurso FMT.

Para pegar a URL dinamicamente podemos utilizar uma tag chamada url. Veja exemplo:

<c:url value="/link_para_servlet" var="variable_name">

Existe também a possibilidade de fazer uma iteração com o forEach utilizando incrementos diferentes.

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <body>
     <c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
     </c:forEach>
  </body>
</html>

Expression Language (EL) é uma linguagem simples e limitada para imprimir o resultado de uma expressão
EL usa a sintaxe de ${ .. }
JSTL é a biblioteca padrão de tags
JSTL não vem com Tomcat e precisamos copiar um JAR
JSTL define 4 taglibs, as mais importantes são core e fmt
a taglib core serve para controle de fluxo, fmt para formatação
é preciso importar as taglib, core e fmt separadamente
JSTL e EL devem ser usados em conjunto
vimos várias tags do core como c:if, c:forEach e c:url
da fmt vimos a tag fmt:formatDate
JARs ficam na pasta WEB-INF/lib do projeto

### Como resolver requisições repetidas no código

Utilizando o método sendRedirect através do objeto response que foi injetado no método de criação.

O status enviado para o servidor é 302 e também é enviado um location, que seria a nova url para onde o navegador
enviar uma nova requisição do tipo get. Desta forma conseguimos mitigar o evento de atualização do browser
conseguir ficar cadastrando diversos dados e inflando o banco de dados em uma aplicação real.

*o problema de reenviar uma requisição
*a diferença entre redirecionamento pelo cliente e servidor
*para redirecionar pelo navegador usamos o método response.sendRedirect("endereço")
*o código de resposta para redirecionamento HTTP é 30X (301 ou 302)