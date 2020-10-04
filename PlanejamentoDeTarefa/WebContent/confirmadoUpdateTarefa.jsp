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
					style="display: block; width: 90%; margin-top: 30px; margin-left: 10px; background-color: #d3ffff; border-radius: 20pt;text-align:justify;">
					<legend style="text-align:left;font: normal 20pt Courgette; background-color: #d3ffff; color: #15224b; padding: 5px 5px;">
					ATULIZADO COM SUCESSO!
					</legend>
						<%
							out.println("<label > Id: " + request.getAttribute("idTarefa") + "</label>");
						%><br>
							<%
							out.println("<label > Nome: " + request.getAttribute("nome") + "</label>");
						%><br>
							<%
							out.println("<label > Cpf Responsavel: " + request.getAttribute("cpf") + "</label>");
						%><br>
							<%
							out.println("<label > Identificação: " + request.getAttribute("idt") + "</label>");
						%><br>
							<%
							out.println("<label > Data Inicio: " + request.getAttribute("dIni") + "</label>");
						%><br>
							<%
							out.println("<label > Hora Inicio: " + request.getAttribute("hIni") + "</label>");
						%><br>
							<%
							out.println("<label > Data Fim: " + request.getAttribute("dFim") + "</label>");
						%><br>
							<%
							out.println("<label > Hora Fim: " + request.getAttribute("hFim") + "</label>");
						%><br>
							<%
							out.println("<label > Status: " + request.getAttribute("status") + "</label>");
						%><br>
						<%
							out.println("<label > Projeto: " + request.getAttribute("idProjeto") + "</label>");
						%><br>
						<%
							out.println("<label > Equipe: " + request.getAttribute("idEquipe") + "</label>");
						%><br>
							<%
							out.println("<label > Descrição: " + request.getAttribute("descricao") + "</label>");
						%><br>
						<div style="margin-left: 40%;">
						<form name="formProjeto" id="formProjeto" action="" method = "" >
					<input type="submit" value="Voltar " formaction="ServletPerfil" formmethod="post"/>
					</form>
						</div>
			



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