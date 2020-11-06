<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
   <a href="acessoliberado.jsp"><img alt="Inicio" title="Inicio" src="resources/img/home.png" width="50px" height="50px"></a>
	<a href="index.jsp"><img alt="Sair" title="Sair" src="resources/img/sair.png" width="50px" height="50px"></a>

   <center style="padding-top: 10%;">
	<h1>Bem vindo ao sistema!</h1>
	
	<table>
	 <tr>
	  <td><a href="salvarUsuario?acao=listartodos"><img src="resources/img/login.png" width="100px" height="100px" /></a></td>
	  <td><a href="salvarProduto?acao=listartodos"><img src="resources/img/produto.png" width="80px" height="80px"/></a></td>
	 </tr>
	 <tr>
	  <td>Cad. Usuário</td>
	  <td>Cad. Produto</td>
	 </tr>
	</table>
	
	</center>
</body>
</html>