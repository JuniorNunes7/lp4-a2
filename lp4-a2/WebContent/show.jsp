<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% java.util.ArrayList<models.Geladeira> geladeiras = (java.util.ArrayList<models.Geladeira>) request.getAttribute("geladeiras"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Geladeiras</title>
</head>
<body>
	<h1>Geladeiras</h1>	
	
	<div>
		<% for (models.Geladeira geladeira : geladeiras) { %>
			<ul>
				<li>Modelo: <%= geladeira.getModelo() %></li>
				<li>Volume: <%= geladeira.getVolume() %></li>
				<li>Quantidade de portas: <%= geladeira.getNumero_portas() %></li>
				<li>Faz gelo?: <%= geladeira.getFaz_gelo() ? "Sim" : "Não" %></li>
			</ul>
			<hr>
		<% } %>
	</div>
	
	<a href="/lp4-a2">Voltar para o cadastro</a>
</body>
</html>