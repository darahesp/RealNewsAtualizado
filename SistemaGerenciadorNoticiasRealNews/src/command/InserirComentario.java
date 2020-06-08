package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;

public class InserirComentario implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession sessao = request.getSession();
		
		Noticia noticiaConsultada = (Noticia) sessao.getAttribute("noticiaConsultada");
		
		int id = Integer.parseInt(request.getParameter("id_comentario"));
		String nome = request.getParameter("nome_comentario");
		String texto = request.getParameter("texto_comentario");
		
		
		int id_noticia = noticiaConsultada.getId();
		
		Comentario comentario = new Comentario();
		comentario.setId(id);
		comentario.setNome(nome);
		comentario.setTexto(texto);
		comentario.setFk_noticia_id(id_noticia);
		
		ComentarioService comentarioServie = new ComentarioService();
		
		comentarioServie.inserir(comentario);
		
		//PrintWriter saida = response.getWriter();
		//saida.println("Not�cia com ID " + id + " adicionada.");
		
		response.sendRedirect("noticia.jsp");
		
	}

}
