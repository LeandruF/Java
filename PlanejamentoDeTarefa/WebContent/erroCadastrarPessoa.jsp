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
		<form action="" method="">
<input type="submit" id="logout "value="" style=" margin-top:10px;float: right; background: url('imagens/logo2.png') 80px 20px  no-repeat; height: 120px;border: 0px; box-shadow: unset;" formaction="ServletLogout" formmethod="post"/>
</form>
	</div>
	<main id="main" style="width: 1150px; margin-left:0px">
		<img alt="" src="imagens/error.png" style="padding-left: 200px;">

		<div style="text-align: center; margin-left: 10%;">

			
			<label >Erro: </label><%=request.getAttribute("erro")%><br> 		

		<form name="formTarefa" id="formTarefa" action="" method = "" style="margin-left: 45%" >
					<input type="submit" value="Voltar " formaction="cadastrar.jsp" formmethod="post"/>
					</form>
		</div>
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