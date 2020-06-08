<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Noticia" %>
    <%@ page import="service.NoticiaService" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Real News</title>
	<link rel="stylesheet" type="text/css" href="css/main.css" />
	<link href="https://fonts.googleapis.com/css2?family=Noto+Serif&display=swap" rel="stylesheet">
	</head>
<body>
	<div class="titulo__news">
		<img alt="" src="icons/newspaper.svg">
		<h1>Real News</h1>
	
	<div class="dropdown">
	  <button class="dropbtn"><img alt="" src="icons/menu.svg"></button>
	  <div class="dropdown-content">
		  <a href="inserir_Noticia.jsp">Inserir Notícia</a>
		  <a href="alterar_Noticia.jsp">Alterar Notícia</a>
		  <a href="excluir_Noticia.jsp">Excluir Notícia</a>
	  </div>
	</div>
	</div>
	
	<div>
		<h2>Notícias:</h2>
	</div>
	<div class="table">
		<table>
			<tr> 
				<th>ID: </th>
				<th>Título: </th>
				<th>Sobre: </th>
			</tr>
		
		<%
			NoticiaService noticiaService = new NoticiaService();
			ArrayList<Noticia> lista = noticiaService.listarNoticias();
			
			
			//Laço de repetição percorrendo a lista de professores:
				for (Noticia n : lista) {
		%>
			<tr>
				<td> <%= n.getId() %> </td>
				<td> <%= n.getTitulo() %></td>
				<td> <%= n.getDescricao() %> </td>			
			</tr>
		<%
				}
		%>
		</table>
	</div>
	
	<div class="titulo__reading">
		<img alt="" src="icons/reading.svg">
		<h2>Qual notícia deseja ler?</h2>
	</div>
	<form action="Controller.do">
		<input type="number"  name="id_noticia" > <br>
		<input type="hidden" name="command" value="ConsultarNoticia">
		<input type="submit" value="Enviar">
	</form>
	


</body>
</html>