<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planning Task Cadastrado</title>
<link rel="stylesheet" href="css/estilo.css">

<script type="text/javascript" src="js/cadastrar.js"></script>
<script type="text/javascript" src="js/scriptGeral.js" ></script>

</head>
<body>
	<div data-role="header" id="header">
		<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">
		<form action="" method="">
<input type="submit" id="logout "value="" style=" margin-top:10px;float: right; background: url('imagens/logo2.png') 80px 20px  no-repeat; height: 120px;border: 0px; box-shadow: unset;" formaction="ServletLogout" formmethod="post"/>
</form>
	
	</div>
	<main id="main" >
		<fieldset style="margin-top:50px;display: block; padding-top:20px;width: 50%; margin-left: 25%; background-color: #d3ffff; border-radius: 20pt;">
		<legend style="font: normal 20pt Courgette; background-color: #d3ffff; color:#15224b;padding: 5px 5px;">Cadastrado Com Sucesso!</legend>
		

			
			<label >Nome: </label><%out.println("<label > "+request.getParameter("nome")+"</label>");%><br> 
			<label >Cpf: </label><%out.println("<label > "+request.getParameter("cpf")+"</label>");%><br> 
			<label >Cell: </label><%out.println("<label > "+request.getParameter("cell")+"</label>");%><br> 
			<label >Email: </label><%out.println("<label > "+request.getParameter("email")+"</label>");%><br> 
			
			<%
			String nomeEquipe = request.getParameter("nomeEquipe");
				if(nomeEquipe==null || nomeEquipe==""){
				}
				else{
				out.println("<label >Nome da Equipe: "+nomeEquipe+"</label>");
				
				}
			%>
		
			<a href="index.html"style="margin-left: 40%">Voltar</a>

		</fieldset>

	</main>
<nav data-role="nav" id="nav">
		
	</nav>
	<aside id="aside">
	<img alt="" src="imagens/anuncieAqui.png" class="anuncieAqui">
	</aside>

	<div id="footer" class="ui-bar">
	<img alt="" src="imagens/contatoRodape.png" class="contatoRodape">
	</div>
</body>
</html>