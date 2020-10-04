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
					<legend
						style="text-align:left;font: normal 20pt Courgette; background-color: #d3ffff; color: #15224b; padding: 5px 5px;">
							<%
							out.println("<label > Nome: " + request.getAttribute("nome") + "</label>");
						%>
					</legend>
			<fieldset style="text-align: center;margin-left:30% ;border-radius:40px; width:40%;">
					<% String diaIniS = request.getAttribute("prazoComeca").toString(); 
					int diaIni = Integer.parseInt(diaIniS);
					 String diaFimS = request.getAttribute("prazoTermina").toString(); 
					int diaFim = Integer.parseInt(diaFimS);
					%>
						<% //VERIFICA QUANTO TEMPO FALTA PARA *****COME�AR*******
							//VAI MUDANDO DE COR CONFORME O PRAZO PASSA
							
						if (diaIni>7){
							%>
							<label style="color: green"> <%out.println(diaIni);%> dias para come�ar.</label>	
						<%	
						}else if(diaIni>3){
							%>
							<label style="color: brown"><%out.println(diaIni);%> dias para come�ar.</label>	
							<%
						}else if(diaIni==2){
							%>
							<label style="color: orange;"><%out.println(diaIni);%> dias para come�ar.</label>	
							<%
						}else if(diaIni==1){
							if(diaIni<0){
								diaIni = diaIni *-1;	
								}
							%>
							<label style="color: red"><%out.println(diaIni);%> dia para come�ar. </label>	
							<%
						}else{
							
							diaIni = diaIni *-1;
							if(diaIni == 1){
							%>
							<label style="color: red">Come�ou a <%out.println(diaIni);%> dia</label>
							<%
							}else{
							%>
							<label style="color: red">Come�ou a <%out.println(diaIni);%> dias</label>	
							<%
							}
						}
						%>
						<br>
							<% //VERIFICA QUANTO TEMPO FALTA PARA *******TERMINAR*********
							//VAI MUDANDO DE COR CONFORME O PRAZO PASSA
						if (diaFim>7){
							%>
							
							<label style="color: green"> <%out.println(diaFim);%> dias para terminar.</label>	
						<%	
						}else if(diaFim<3){
							%>
							<label style="color: brown"><%out.println(diaFim);%> dias para terminar.</label>	
							<%
						}else if(diaFim==2){
							%>
							<label style="color: orange;"><%out.println(diaIni);%> dias para terminar.</label>	
							<%
						}else if(diaFim<=1){
							%>
							<label style="color: red"><%out.println(diaFim);%> dia para terminar. </label>	
							<%
						}else{
							if(diaFim<0){
							diaFim = diaFim *-1;	
							}
							if(diaFim == 1){
							%>
							<label style="color: red">Terminou a <%out.println(diaFim);%> dia</label>
							<%
							}else{
							%>
							<label style="color: red">Termina em <%out.println(diaFim);%> dias</label>	
							<%
							}
						
						}
						%>
					</fieldset>
					<br><br>
						<%
							out.println("<label > Id: " + request.getAttribute("idTarefa") + "</label>");
						%><br>
							<%
							out.println("<label > Identifica��o: " + request.getAttribute("identificacao") + "</label>");
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
						<%if(request.getAttribute("projeto")==null){ 
						 
						 out.println("<label > Descri��o: " + request.getAttribute("descricao") + "</label>");
						 
						}else{
							out.println("<label > Projeto: " + request.getAttribute("projeto") + "</label><br>");
							out.println("<label > Descri��o: " + request.getAttribute("descricao") + "</label>");
						}
						%><br>
						
						<div style="margin-left: 40%;">
						<form name="formTarefa" id="formTarefa" action="" method = "" >
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