<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tarefas</title>
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.mask.min.js"></script>
<script type="text/javascript" src="js/cadastrar.js"></script>
<script type="text/javascript" src="js/scriptGeral.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#idDataIni").mask("00/00/0000")
	$("#idHoraIni").mask("00:00")
	$("#idDataTerm").mask("00/00/0000")
	$("#idHoraTerm").mask("00:00")
})
</script>


</head>
<body>
	<div data-role="header" id="header">
		<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">


	</div>
	<main id="main">
		
		<div style="text-align: center; margin-left: 10%;">
			<img alt="" src="imagens/tarefaLogo.png" style="padding-left:30px; margin-top: 2%;">
			<form name="formPorjeto" id="formTarefa" method = "post">
			<fieldset style="display: block; width: 70%; margin-top: 2%; margin-left: 20%; background-color: #d3ffff; border-radius: 20pt;">
				<div style="text-align: center">
	<label>Identificação Tarefa: </label> <input name="idtTarefa"id="idIdtTarefa" placeholder="Identificação da Tarefa" type="text"size="27" maxlength="100" onblur="verificarNome()" /><br> <br>
				<label>Nome da Tarefa: </label>
				<input name="nomeTar"id="idNomeTar" placeholder="Nome da Tarefa" type="text" size = "30" maxlength="100" onblur="verificarNome()"/><br>	<br>
				<%out.println("<label >Responsavel: " + request.getAttribute("nome") + "</label>");%><br>
				<label >Data de Inicio: </label> <input name="dataIni"id="idDataIni" placeholder="Data de Inicio" type="text" size = "30" maxlength="11" onblur=""/><br>
				<label >Hora de Inicio: </label> <input name="horaIni"id="idHoraIni" placeholder="Hora de Inicio" type="text" size = "30" maxlength="5" onblur=""/><br>
				<label >Data de Termino: </label><input name="dataTerm"id="idDataTerm" placeholder="Data de Termino" type="text" size = "30" maxlength="11" onblur="verificarNome()"/><br>	
				<label >Hora de Termino: </label> <input name="horaTerm"id="idHoraTerm" placeholder="Hora de Termino" type="text" size = "30" maxlength="5" onblur=""/><br>	
				<br><textarea name="descricao"id="idDescricao" placeholder="Descrição"   rows="7" cols="50" onblur=""></textarea><br><br>
				
				</div>
			</fieldset>


			<table id="menuBtns" style="margin-left: 45%;">
				<tr>
					<td style="width: 300pt">
					<a href="index.html">Voltar</a>
					</td>
					<td style="width: 300pt"><a href="index.html">Sair</a></td>

				</tr>
			</table>
		</form>
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