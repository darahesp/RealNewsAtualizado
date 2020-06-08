package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

public class ExcluirNoticia implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		
		NoticiaService noticiaService = new NoticiaService();
		
		Noticia noticia = new Noticia();
		noticia.setId(id);		
		noticiaService.excluir(noticia);
		
		PrintWriter saida = response.getWriter();
		saida.println("A notícia de ID " + id + " foi excluída." );
	}

}
