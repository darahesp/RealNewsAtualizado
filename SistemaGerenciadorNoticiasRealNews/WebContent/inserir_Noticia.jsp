<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
	<h1>Inserção - Notícias:</h1>
	
	<form action="Controller.do" method ="post">
	  
		<h3>ID Notícia:</h3>
      	<input type = "number"  name = "id_noticia" > <br>
      
      	<h3>Título:</h3>
      	<input type = "text" name = "titulo_noticia"> <br>
      
      	<h3>Descrição:</h3>
      	<textarea name="descricao_noticia" cols="40" rows="3"></textarea><br>
      
      	<h3>Texto:</h3>
      	<textarea   name = "texto_noticia" cols="40" rows="5"></textarea><br><br>
      	
      	<input type="reset" value="Limpar" >
      	<input type="hidden" name="command" value="InserirNoticia" >
      	<input type = "submit" value="Inserir notícia">
      	
      
 	</form>
</body>
</html>