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
	<div>
		<div data-role="header" id="header">
			<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">


			<form action="" method="">
<input type="submit" id="logout "value="" style=" margin-top:10px;float: right; background: url('imagens/logo2.png') 80px 20px  no-repeat; height: 120px;border: 0px; box-shadow: unset;" formaction="ServletLogout" formmethod="post"/>
</form>

		</div>
		<main id="main">
			<div style="text-align: center; margin-left: 30px;">

				<fieldset
					style="display: block; width: 90%; margin-top: 30px; margin-left: 1px; background-color: #d3ffff; border-radius: 20pt;">
					<legend
						style="font: normal 20pt Courgette; background-color: #d3ffff; color: #15224b; padding: 5px 5px;">
						MENU TAREFA </legend>
						<form name="formTarefa" id="formTarefa" action="" method = "" >
						
						<input type="submit" value="Cadastrar Tarefa " formaction="tarefas.jsp" formmethod="post"style="width: 95%;"/>
						<input type="submit" value="Alterar Tarefa " formaction="ServletListarUpdateTarefa" formmethod="post"style="width: 95%;"/>
						<input type="submit" value="Localizar Tarefa " formaction="ServletLocalizarTarefa" formmethod="post"style="width: 95%;"/>
						<input type="submit" value="Deletar Tarefa " formaction="ServletListarDeletarTarefa" formmethod="post"style="width: 95%;"/>
						</form>


				</fieldset>




			</div>
		</main>
		<nav data-role="nav" id="nav">
			 <a
				href="menuProjetos.jsp" class="btnMenu"><img alt=""
				src="imagens/projetosMenu.png" class="btnMenuImg"></a> <a
				href="menuTarefas.jsp" class="btnMenu"><img alt=""
				src="imagens/tarefasMenu.png" class="btnMenuImg"></a> <a
				href="index.html" class="btnMenu"><img alt=""
				src="imagens/sairMenu.png" class="btnMenuImg"></a> <br>
		</nav>
		<aside id="aside">
			<img alt="" src="imagens/anuncieAqui.png" class="anuncieAqui">
		</aside>

		<div id="footer" class="ui-bar">
			<img alt="" src="imagens/contatoRodape.png" class="contatoRodape">
		</div>
	</div>
</body>
</html>