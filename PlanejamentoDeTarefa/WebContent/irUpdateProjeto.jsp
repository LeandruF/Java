
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

				<fieldset style="display: block; width: 90%; margin-top: 30px; margin-left: 10px; background-color: #d3ffff; border-radius: 20pt;text-align:center;">
					<legend style="text-align:left;font: normal 20pt Courgette; background-color: #d3ffff; color: #15224b; padding: 5px 5px;">
							<label>Update Projeto</label>
					</legend>
					
			<form action="" method="">
			<!-- 
			PEGAR CPF DE TODOS AS PESSOAS E COLOCAR NO CPF_TITULAR CASO QUEIRA TROCAR O TITULAR
			 -->
						<label>Id:</label>
						<br>
						<input name="id"id="id"  type="text" size = "30" maxlength="100" readonly="readonly" value="<%=request.getAttribute("idProjeto")%>"/><br>
						<label > Nome:</label> 
						<br>
						<input name="nome"id="idNome"  type="text" size = "30" maxlength="100" value="<%=request.getAttribute("nome")%>"/>
						<br>		
						<label > Identificação:</label> 
						<br>
						<input name="identificacao"id="idIdentificacao"  type="text" size = "30" maxlength="100" value="<%=request.getAttribute("identificacao")%>"/><br>	
						<label > Data Inicio:</label> 
						<br>
						<input name="dIni"id="dIni"  type="text" size = "30" maxlength="100" value="<%=request.getAttribute("dIni")%>"/><br>	
						<label > Hora Inicio:</label> 
						<br>
						<input name="hIni"id="hIni"  type="text" size = "30" maxlength="100" value="<%=request.getAttribute("hIni")%>"/><br>	
						<label > Data Fim:</label> 
						<br>
						<input name="dFim"id="dFim"  type="text" size = "30" maxlength="100" value="<%=request.getAttribute("dFim")%>"/><br>	
						<label > Hora Fim:</label> 
						<br>
						<input name="hFim"id="hFim"  type="text" size = "30" maxlength="100" value="<%=request.getAttribute("hFim")%>"/><br>	
						 <br>
						<label > Cpf Responsavel:</label> <label><%out.println(session.getAttribute("cpf")); %></label>
						<br>
						<label>Cpfs:</label><select id="cpf" name="cpf" style="
						margin-top:10px; 
						width: 25%;
						border-radius: 20px;
						line-height: 40px;
						margin: 10px;
						background-color: white;
						color: black;
						border-radius: 5px;
						text-decoration: none;
						font: normal 20pt Courgette;

						
						">
						<!-- PEGAR TODOS DA LISTA AQUI -->
						<%@ page import="controller.Pessoa , java.util.List, java.util.ArrayList"%>
						<% List<Pessoa> lista = new ArrayList<Pessoa>();
						Pessoa p = new Pessoa();
						lista = p.listarPessoa();
						for(int i = 0;i<lista.size();i++){
							%>
							<option value = "<%=lista.get(i).getCpf()%>"><%=lista.get(i).getCpf()%> </option>
							<%
						}
						
						%>
				
						</select>
						<br>
						<br>
						<label > Status: </label>	<label name="stat"><%=request.getAttribute("status")%></label>
						 <br>
				  <input type="radio" id="ativo" name="status" value="ativo" checked><label for="ativo">Ativo</label>
				  <input type="radio" id="inativo" name="status" value="inativo"><label for="inativo">Inativo</label>
				  <input type="radio" id="concluido" name="status" value="concluido"><label for="concluido">Concluido</label>
				  <input type="radio" id="cancelado" name="status" value="cancelado"><label for="cancelado">Cancelado</label>
				  	<br>					
					<br>	
						<!--ATIVO  | INATIVO | PAUSADO | CONCLUIDO | CANCELADO  -->

						<label > Descrição:</label> 
						<br>	
						<textarea name="descricao" id="idDescricao"
							placeholder="Descrição" rows="7" cols="50" onblur=""><%=request.getAttribute("descricao")%></textarea>	
						
						
								<table style="width:80%;margin-left:10%;">
							<td style="width:250px;">
						<input style="width:200px;" type="submit" value="Confirmar " formaction="servletConfirmaUpdateProjeto" formmethod="post"/>
							</td>
							<td style="width:250px">
					<input style="width:200px;" type="submit" value="Voltar " formaction="ServletPerfil" formmethod="post"/>
							</td>
							</table>
						
						
						
		
	
						
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