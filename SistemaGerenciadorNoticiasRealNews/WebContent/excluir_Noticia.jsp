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
	<h1>Excluir - Notícias:</h1>
	
	<form action= "Controller.do" method ="post">
	  
		<h3>ID Notícia:</h3>
      	<input type = "number"  name = "id_noticia" > <br><br>
      	
      	<input type="reset" value="Limpar" >
      	<input type="hidden" name="command" value="ExcluirNoticia">
        <input type = "submit" value="Excluir notícia">
      	
 	</form>
</body>
</html>