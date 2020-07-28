<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planning Task</title>
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/cadastrar.js"></script>
<script type="text/javascript" src="js/scriptGeral.js" ></script>

</head>
<body>
<div data-role="header" id="header">
		
		<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">
	
	</div>
	<main id="main">
		<img alt="" src="imagens/error.png" style="padding-left: 200px;">

		<div style="text-align: center; margin-left: 10%;">

			
			<label >Erro: </label><%=request.getAttribute("erro")%><br> 		

		<a href="index.html" style="margin-left: 40%">Sair</a>
		</div>
	</main>


	<aside id="aside">
	<img alt="" src="imagens/anuncieAqui.png" class="anuncieAqui">
	</aside>

	<div id="footer" class="ui-bar">
		<img alt="" src="imagens/contatoRodape.png" class="contatoRodape">
	</div>
</body>
</html>