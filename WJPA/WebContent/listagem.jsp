<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.bv.model.Visitante, br.com.bv.model.VisitanteDao" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Visitantes armazenados</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<div>
		<h3>Visitantes que enviaram mensagens</h3>
		<table>
			<tr>
				<th>Nome</th>
				<th>Telefone</th>
			</tr>
			<%
			for (Visitante visitante : new VisitanteDao().listar())
			{
			%>
				<tr>
					<td><%=visitante.getNome()%></td>
					<td><%=visitante.getTelefone()%></td>
				</tr>
			<%
			}
			%>
			<tr>
				<th>Nome</th>
				<th>Telefone</th>
			</tr>
			<jsp:useBean id="dao" class="br.com.bv.model.VisitanteDao" />
			<c:forEach var="visitante" items="${dao.listar()}">
				<tr>
					<td>${visitante.nome}</td>
					<td>${visitante.telefone}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<c:import url="rodape.jsp" />
</body>
</html>