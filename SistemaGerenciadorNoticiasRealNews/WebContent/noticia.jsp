<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Noticia" %>
<%@page import="model.Comentario" %>
<%@page import="service.ComentarioService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notícia</title>
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

	<%
		HttpSession sessao = request.getSession();
		
		Noticia noticiaConsultada = (Noticia) sessao.getAttribute("noticiaConsultada");
	%>
	
	<h2><%= noticiaConsultada.getTitulo() %></h2>
	<p><%= noticiaConsultada.getTexto() %></p>
	
	<%
		ComentarioService comentariaService = new ComentarioService();
		ArrayList<Comentario> listaComentarios = comentariaService.listarComentario();
	%>
	
	<h3>Comentário:</h3>
	
	<%
		for (Comentario c : listaComentarios) {
				
		int id_noticia_fk = noticiaConsultada.getId();
		int id_comentario_fk = c.getFk_noticia_id(); 
			
		if(id_comentario_fk == id_noticia_fk) {
	%>
		<h4><%=c.getNome() %></h4>
		<p><%= c.getTexto() %></p>
		<hr>
	
	<%
		}}
	%>
	
	<div class="form__comentario">
		<form action="Controller.do" method="post">
			<label>ID:</label>
			<br>
			<input type="number" name="id_comentario">
			<br>
			<br>
			
			<label>Nome:</label>
			<br>
			<input type="text" name="nome_comentario">
			<br>
			<br>
			
			<label>Comentario:</label>
			<br>
			<textarea name="texto_comentario" cols="40" rows="4"></textarea>
			<br><br>
			<input type="hidden" name="command" value="InserirComentario">
			<input type="submit" value="Enviar">
		</form>
	</div>

</body>
</html>