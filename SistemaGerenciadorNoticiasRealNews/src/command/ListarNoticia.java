package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

public class ListarNoticia implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
		
		NoticiaService noticiaService = new NoticiaService();
		
		ArrayList<Noticia> listaNoticias = noticiaService.listarNoticias();
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		saida.println("Lista de Not�cias:  " + "<br>");
		
		listaNoticias.forEach(n -> {
			
			saida.println("- ID:  " + n.getId() + "<br>");
			saida.println("- Descri��o:  " + n.getDescricao() + "<br>");
			saida.println("- Titulo:  " + n.getTitulo() + "<br>");
			saida.println("- Texto:  " + n.getTexto() + "<br>");
			saida.println("<br>");
			
		});
		
	}
	

}
