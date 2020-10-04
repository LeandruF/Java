<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projetos</title>
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.mask.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<!-- NAO UTILIZO -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/cadastrar.js"></script>
<script type="text/javascript" src="js/scriptGeral.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

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
		<form action="" method="">
<input type="submit" id="logout "value="" style=" margin-top:10px;float: right; background: url('imagens/logo2.png') 80px 20px  no-repeat; height: 120px;border: 0px; box-shadow: unset;" formaction="ServletLogout" formmethod="post"/>
</form>
	</div>
	<main id="main">

		<div style="text-align: center; margin-left: 30px;">
			<img alt="" src="imagens/projetoLogo.png"
				style="padding-left: 30px; margin-top: 2%;">
			<form name="formProjeto" id="formProjeto" action="" method="">
				<fieldset
					style="display: block; width: 90%; margin-top: 30px; margin-left: 10px; background-color: #d3ffff; border-radius: 20pt;">
					<div style="text-align: center; ">
						<label>Identificação Projeto: </label> 
						<br>
						<input name="idtProjeto"
							id="idIdtProjeto" placeholder="Identificação do Projeto"
							type="text" size="30" maxlength="100" onblur="verificarNome()" /><br>
						 
						<label>Nome do Projeto: </label> 
						<br>
						<input name="nomeProjeto" id="idNomeProjeto"
							placeholder="Nome do Projeto" type="text" size="30"
							maxlength="100" onblur="verificarNome()" /><br>  
							<label>Responsavel:</label><br>
						<input type="text" value="<%=session.getAttribute("nomeUser")%>"
							readonly="readonly" size="30"
							maxlength="100"/> <br>
						 <label>Cpf Responsavel: </label><br>
						<input type="text"
							value="<%=session.getAttribute("cpf")%>" readonly="readonly" size="30"
							maxlength="100"/>
						<br>
						  <label>Data de Inicio: </label><br>
						 <input
							name="dataIni" id="idDataIni" placeholder="Data de Inicio"
							type="text" size="30" maxlength="11" onblur="" /> <br>
						<label>Hora de Inicio: </label><br>
						 <input name="horaIni"
							id="idHoraIni" placeholder="Hora de Inicio" type="text" size="30"
							maxlength="5" onblur="" /><br>
						<label>Data de Termino: </label><br>
						<input name="dataTerm"
							id="idDataTerm" placeholder="Data de Termino" type="text"
							size="30" maxlength="11" onblur="verificarNome()" /><br>
						<label>Hora de Termino: </label> <br>
						<input name="horaTerm"
							id="idHoraTerm" placeholder="Hora de Termino" type="text"
							size="30" maxlength="5" onblur="" /><br> 
							<label>Status:</label> 
							<input type="radio" id="ativo" name="status" value="ativo"checked>
							<label for="ativo">Ativo</label>
							 <input type="radio" id="inativo" name="status" value="inativo">
							<label for="inativo">Inativo</label>

						<!--ATIVO  | INATIVO | PAUSADO | CONCLUIDO | CANCELADO  -->
						<br>
						<textarea name="descricao" id="idDescricao"
							placeholder="Descrição" rows="7" cols="50" onblur=""></textarea>
						<br> <br>

					</div>
				</fieldset>
				<table id="menuBtns" style="margin-left: 20%; width: 80%;">
					<tr>
						<td style="width: 37%"><input type="submit" id="btnCadastrar"
							style="width: 200px;" value="Cadastrar"
							formaction="ServletCadastrarProjeto" formmethod="post" /></td>
						<td style="width: 100%">
							<form name="formTarefa" id="formTarefa" action="" method="">
								<input type="submit" value="Voltar " formaction="ServletPerfil"
									formmethod="post" />
							</form>
						</td>

					</tr>
				</table>
			</form>





		</div>

	</main>
	<nav data-role="nav" id="nav">

		<a href="menuProjetos.jsp" class="btnMenu"><img alt=""
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
</body>
</html>