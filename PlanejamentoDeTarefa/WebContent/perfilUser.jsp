<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planing Task</title>
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/scriptGeral.js"></script>
</head>
<body>
	<div data-role="header" id="header">
		<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">


	</div>
	<main id="main">

		<div style="text-align: center; margin-left: 10%;">

			<fieldset
				style="display: block; width: 70%; margin-top: 10%; margin-left: 20%; background-color: #d3ffff; border-radius: 20pt;">
				<legend
					style="font: normal 20pt Courgette; background-color: #d3ffff; color: #15224b; padding: 5px 5px;">
					<%
						out.println("<label >Olá: " + request.getAttribute("nome") + "</label>");
					%><br>
				</legend>
				<%
					out.println("<label >Cpf: " + request.getAttribute("cpf") + "</label>");
				%><br>
				<%
					out.println("<label >Cell: " + request.getAttribute("cell") + "</label>");
				%><br>
				
				<%
				if(request.getAttribute("equipes")!=null){
					out.println("<label >Equip: " + request.getAttribute("equipes") + "</label>");
					
				}
				%><br>
				<%
				if(request.getAttribute("nomeE")!= null){
					out.println("<label >Nome Equipe: " + request.getAttribute("equipe") + "</label>");
					
				}
				%><br>
				
				
			</fieldset>

			<table id="menuBtns"style="margin-left: 45%;">
					<tr>
						<td style="width: 300pt">
							<a href="index.html">Sair</a>
						</td>	
						<td style="width: 300pt">
							<a href="index.html">Sair</a>
						</td>
		
				</tr>
			</table>

		
</div>
	</main>
	<nav data-role="nav" id="nav">
		<a href="index.html" class="btnMenu"><img alt="" src="imagens/meuMenu.png" class="btnMenuImg"></a>
		<a href="index.html"class="btnMenu"><img alt="" src="imagens/projetosMenu.png" class="btnMenuImg"></a>
		<a href="index.html"class="btnMenu"><img alt="" src="imagens/tarefasMenu.png" class="btnMenuImg"></a>
		<a href="index.html"class="btnMenu"><img alt="" src="imagens/sairMenu.png" class="btnMenuImg"></a>
		<br>
	</nav>
	<aside id="aside"> 
		<img alt="" src="imagens/anuncieAqui.png" class="anuncieAqui">
	</aside>

	<div id="footer" class="ui-bar">
		<img alt="" src="imagens/contatoRodape.png" class="contatoRodape">
	</div>
</body>
</html>