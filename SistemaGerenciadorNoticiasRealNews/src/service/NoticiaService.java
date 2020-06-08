package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	
	private NoticiaDAO noticiaDAO;
	
	public NoticiaService() {
		this.noticiaDAO = new NoticiaDAO();
	}
	
	public void cadastrar(Noticia noticia) {
		noticiaDAO.inserir(noticia);
	}
	
	public void alterar(Noticia noticia) {
		noticiaDAO.alterar(noticia);
	}
	
	public void excluir(Noticia noticia) {
		noticiaDAO.excluir(noticia);
	}
	
	public Noticia consultar(int id) {
		return noticiaDAO.consultar(id);
	}
	
	public ArrayList<Noticia> listarNoticias(){
		return noticiaDAO.listarNoticias();
	}
	
	
	

}
