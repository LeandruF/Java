<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planning Task Cadastrar</title>
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.mask.min.js"></script>
<script type="text/javascript" src="js/cadastrar.js"></script>
<script type="text/javascript" src="js/scriptGeral.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#idCpf").mask("000.000.000-00")
	$("#idCell").mask("(00)00000-0000")
})
</script>
<style>
	label{
		float: left;
	}
</style>
</head>	
<body>
	
	<div data-role="header" id="header">
		<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">
		
	
	</div>
	
	<nav data-role="nav" id="nav">
		
		<h2>Planing Task</h2>
		<br>
	</nav>
	
	<main id="main">
	<img alt="" src="imagens/newUser.png" style="padding-left:30px;">
	
	<div style="text-align: center; margin-left: 260px;">
	<table>
	
	<tr>	
	<td id="conteudo">
	<form id="form" action="ServletCadastrarPessoa" method = "post">
	
	<fieldset style = " display: block; width: 70%; margin-left: 30px; background-color: #d3ffff; border-radius: 20pt;">
	
																													<!-- onblur="javascript: controleContato(document.getElementById('idContato').value)" -->
		<label for="idNome">Nome: </label> <label id="nomeMsg" style="color:red;padding-left:5px;"></label>
		<input name="nome"id="idNome" placeholder="Nome" type="text" size = "30" maxlength="100" onblur="verificarNome()"/><br>	
		<label for="idCpf">Cpf: </label> <label id="cpfMsg" style="color:red;padding-left:5px;"></label>
		<input name="cpf" id="idCpf" placeholder="Cpf" type="text" size = "30" maxlength="14" placeholder="Ex.: 000.000.000-00" onblur="verificarCpf()"onblur="existCpf()" /><br>
		<label for="idCell">Celular: </label> <label id="cellMsg" style="color:red;padding-left:5px;"></label>
		<input name ="cell" id="idCell" placeholder="(xx)xxxx-xxxxx" type="text"maxlength="14" size = "30" maxlength="14" onblur="verificarCell()" /><br>
		<label for="idNomeEquipe">Nome Equipe: </label> <label id="nomeEquipeMsg" style="color:red;padding-left:5px;"></label>
		<input name="nomeEquipe"id="idNomeEquipe" placeholder="Nome da Equipe" type="text" size = "30" maxlength="100" /><br>
		<label for="idEmail">Email: </label> <label id="emailMsg" style="color:red;padding-left:5px;"></label>
		<input name="email"id="idEmail" placeholder="User" type="text" size = "30" maxlength="100" onblur="verificarEmail()	"/><br>
		<label for="idPassword">Password: </label><label id="passwordMsg" style="color:red;padding-left:5px;"></label>
		<input name="password" id="idPassword" placeholder="Password" type="password" size="30" maxlength="30" onblur="verificarPassword()"/><br>
		<label for="idRepetirPassword">Repetir Password: </label><label id="repetirPasswordMsg" style="color:red;padding-left:5px;"></label>
		<input name="repetirPassword"id="idRepetirPassword" placeholder="Repetir Password" type="password" size="30" maxlength="30" onblur="repetirPassword()"><br>
		<table style="width: 100%;">
		<tr>
		
			<td style="width: auto;">
				<input type="submit" id="btnCadastrar" style="width: 55%;"value="Cadastrar"/>

			</td>
			<td>
				<a href="index.html" style="width: 60%;">Voltar</a>

			</td>
		</tr>
		</table>
		
		
	</fieldset>
	</form>
	</td>

	<td id="resp" style="width: 450px; height: 550px; color:red; display: block; width: 50%; float:right; margin-top: 20px; margin-right: 200px">
	
	<div id="msg" style="float:left;width: 450px; height: 550px;">
	</div>
	
	</td>
	<tr>
	</table>
</div>
	
	</main>

<aside id="aside">
<img alt="" src="imagens/anuncieAqui.png" class="anuncieAqui">
</aside>

<div 	id="footer" class="ui-bar">
<img alt="" src="imagens/contatoRodape.png" class="contatoRodape">
</div>
</body>
</html>