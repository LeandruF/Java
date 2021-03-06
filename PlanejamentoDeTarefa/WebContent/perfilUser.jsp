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
					style="display: block; width: 90%; margin-top: 30px; margin-left: 10px; background-color: #d3ffff; border-radius: 20pt;">
					<legend
						style="text-align:left;font: normal 20pt Courgette; background-color: #d3ffff; color: #15224b; padding: 5px 5px;">
						<%
							out.println("<label > " + session.getAttribute("nomeUser") + "</label>");
						%><br>
					</legend>
					<%
						out.println("<label >Cpf: " + session.getAttribute("cpf") + "</label>");
					%><br>
					<%
						out.println("<label >Cell: " + session.getAttribute("cell") + "</label>");
					%><br>

					<%
						out.println("<label >Nome Equipe: " + session.getAttribute("nomeEquipe") + "</label>");
					%>
					<br>
					<%
						out.println("<label >Equip: " + session.getAttribute("idEquipe") + "</label>");
					%><br>
					
					<div id="tarefas" name="tarefas" style="margin-left:0px;width:90%;">
					<%@ page import="controller.Tarefa , java.util.List"%>
					<% 
					List<Tarefa> listaTarefas = (List<Tarefa>) request.getAttribute("listaTarefas");
					for (int i = 0; i<listaTarefas.size() ; i++){ 
						if(i==0){
							%>
						
							<img src="imagens/tarefasPerfil.png" id="tarefasPerfil" alt="" style="float:left;" >
						
							<%
						}
					%>
					<!-- 
					 <input type="submit" id="btnCadastrar" style="width: 50%;"value="Cadastrar" formaction="ServletCadastrarTarefa" formmethod="post"/>
					 -->
					<span id="spanTarefas" class="listaTarefasSpan" >
			<form action="" method="">
			<!-- 
			style = " visibility:hidden;" 
					<label id="idTarefa" name = "idTarefa" ><%= listaTarefas.get(i).getId() %></label>
			
			-->
					<input type="hidden"  id="idTarefa" name = "idTarefa"  value="<%=listaTarefas.get(i).getId()%> ">
					
						Nome:<%= listaTarefas.get(i).getNome() %>
						DataIni:<%= listaTarefas.get(i).getDataIni()%>
						DataFim:<%= listaTarefas.get(i).getDataFim()%>
						Status:<%= listaTarefas.get(i).getStatus()%>
			
				
					
					<input type = "submit" style="margin-left:5%; width:89%;"  class="listaTarefasBtn" 
					id = "<%= listaTarefas.get(i).getId() %>" name="tarefa"value="Go"
					formaction="ServletIrTarefa" formmethod="post"/>
					 </form>
						</span>
						<%
						if(i%2 ==1){
							%>
							<br>
							<%
						}
					}
						%>
				
					<br>					
					</div>
						
					<div id="projetos" name="projetos">
					<%@ page import="controller.Projeto , java.util.List"%>
					<% 
					List<Projeto> listaProjetos = (List<Projeto>) request.getAttribute("listaProjetos");
					for (int i = 0; i<listaProjetos.size() ; i++){ 
						if(i==0){
							%>
							
							<img src="imagens/projetosPerfil.png" id="projetosPerfil" alt="" >
						
							<%
						}
					%>
					<span id="spanProjetos" class="listaProjetosSpan" >
					<form action="" method="">
					<!-- style = " visibility:hidden;" -->
					<input type="hidden"  id="idProjeto" name = "idProjeto"  value="<%=listaProjetos.get(i).getId()%> ">
						Nome:<%= listaProjetos.get(i).getNome() %>
						DataIni:<%= listaProjetos.get(i).getDataIni()%>
						DataFim:<%= listaProjetos.get(i).getDataFim()%>
						Status:<%= listaProjetos.get(i).getStatus()%>
			
				
					
					<input type = "submit" style="margin-left:5%; width:89%;"  class="listaProjetosBtn" 
					id = "<%= listaProjetos.get(i).getId() %>" name="projeto"value="Go"
					formaction="ServletIrProjeto" formmethod="post"/>
					 </form>
						</span>
						<%
						if(i%2 ==1){
							%>
							<br>
							<%
						}
					}
						%>
					
					
					</div>
					
				</fieldset>

			</div>
		</main>
		<nav data-role="nav" id="nav">
			 <a
				href="menuProjetos.jsp" class="btnMenu"><img alt=""
				src="imagens/projetosMenu.png" class="btnMenuImg"></a> 
				<a href="menuTarefas.jsp" class="btnMenu"><img alt=""src="imagens/tarefasMenu.png" class="btnMenuImg"></a>
			<a href="index.html" class="btnMenu"><img alt=""
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