package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

@WebServlet("/Controller.do")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Enviando a requisição para o doExecute:
				doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Enviando a requisição para o doExecute:
				doExecute(request, response);
	}
	
	/**
	 * Método responsável pro tratar todas as requisições
	 * que chegarem dentro da aplicação:
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		try {
			Command comando = 
					/*Procurando a classe dentro do pacote command
					 *Classe que representa a ação que o usuário está executando*/
					(Command)Class.forName("command."+request.getParameter("command")).newInstance();
			comando.executar(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
