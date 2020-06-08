package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Interface responsável por definir a estrutura
 * dos comandos existentes na aplicação
 */
public interface Command {
	
	/**
	 * Método responsável por executar a ação de cada comando.
	 * @param request Objeto do tipo HttpServletRequest para armazenar os dados da requisição
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void executar(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException;
	
}