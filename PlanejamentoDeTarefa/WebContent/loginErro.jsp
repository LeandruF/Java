<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planning Task</title>
<link rel="stylesheet" href="css/estilo.css">
<script type="text/javascript" src="js/cadastrar.js"></script>
<script type="text/javascript"  defer="defer" src="js/scriptGeral.js" ></script>

<script>
$(document).ready(function(){ // senha errada exibe essa msg no loginErro.jsp
	
	window.alert(<%out.println("<label >Cpf: " + request.getAttribute("cpf") + "</label>");%>);
	
})
</script>
</head>
<body onload="erroLogin()">

	<div data-role="header" id="header">
	
	<img src="imagens/logo.png" id="logo" alt="" onclick="logo()">

	</div>
	<main id="main" style="width: 1150px; margin-left:0px">
		<div style="margin-top: 170px; text-align: center; margin-left: 200px;">
	
			<form id="form" class="btnMenu"action="ServletLogin" method="post">
				<fieldset style="display: block; width: 60%; margin-left: 0px; background-color: #d3ffff; border-radius: 20pt; position: absolute;">
					
					<legend style="font: normal 20pt Courgette;  padding: 5px 5px;">
					
					<img alt="" src="imagens/login.png" class="anuncieAqui" style="height: 50px;">
					
					</legend>

					<label for="idUser" style="float: left;">User: </label><br> 
					
					<br> <input id="idUser" name="email" placeholder="User" type="text" size="30"maxlength="100" /> <br> 
						<label for="idPassword"style="float: left; padding-top: 10pt; padding-bottom: 10pt;">Password:</label><br>
					<br> <input name="password" id="idPassword" placeholder="Password"type="password" size="30" maxlength="30" /> <br>
					<table style="width: 100%; margin-left: 10%;">
					<tr>
							<td>
							<input type="submit" id="btnLogin" style="width: 55%;" value="Login"/>
							</td>

							<td>
							<a href="cadastrar.jsp" style="width: 50%;">Cadastrar</a>
							</td>
						</tr>
					</table>
					
				</fieldset>
			</form>
			
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