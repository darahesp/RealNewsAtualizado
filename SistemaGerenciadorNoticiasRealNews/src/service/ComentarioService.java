package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
	
	private ComentarioDAO comentarioDAO;
	
	public ComentarioService() {
		this.comentarioDAO = new ComentarioDAO();
	}
	
	public void inserir(Comentario comentario) {
		comentarioDAO.inserir(comentario);
	}
	
	public ArrayList<Comentario> listarComentario(){
		return comentarioDAO.listaComentario();
	}

}
