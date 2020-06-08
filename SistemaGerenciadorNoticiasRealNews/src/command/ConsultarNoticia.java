package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Noticia;
import service.NoticiaService;

public class ConsultarNoticia implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		
		NoticiaService noticiaService = new NoticiaService();
		Noticia noticiaConsultada = noticiaService.consultar(id);
		
		//PrintWriter saida = response.getWriter();
		//saida.println(noticiaConsultada);		

		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("noticiaConsultada", noticiaConsultada);
		
		response.sendRedirect("noticia.jsp");
	}

}
