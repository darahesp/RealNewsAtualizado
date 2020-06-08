package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

public class InserirNoticia implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		String descricao = request.getParameter("descricao_noticia");
		String titulo = request.getParameter("titulo_noticia");
		String texto = request.getParameter("texto_noticia");
		
		response.setContentType("text/jsp; charset=UTF-8");
		
		Noticia noticia = new Noticia();
		
		noticia.setId(id);
		noticia.setDescricao(descricao);
		noticia.setTitulo(titulo);
		noticia.setTexto(texto);
		
		NoticiaService noticiaService = new NoticiaService();
		
		noticiaService.cadastrar(noticia);
		
		PrintWriter saida = response.getWriter();
		saida.println("Notícia com ID " + id + " adicionada.");
	}

}
