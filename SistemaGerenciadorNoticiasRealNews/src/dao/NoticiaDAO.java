package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

public class NoticiaDAO {
	
	private Connection conexao;
	
	public NoticiaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void inserir(Noticia noticia) {
		String inserir = "INSERT INTO noticia "
				+ " (id, descricao, titulo, texto) "
				+ "VALUES (?, ?, ?, ?)";
		
		try ( PreparedStatement pst = conexao.prepareStatement(inserir) ){
			
			pst.setInt(1, noticia.getId());
			pst.setString(2, noticia.getDescricao());
			pst.setString(3, noticia.getTitulo());
			pst.setString(4, noticia.getTexto());
			
			pst.execute();
			
		} catch (SQLException ex) {
			System.err.println("Não foi possivel manipular" 
					+ "a tabela Noticia.");
			ex.printStackTrace();
		}
	}
	
	public void alterar(Noticia noticia) {
		
		String inserir = "UPDATE noticia "
				+ "SET descricao = ?, titulo = ?, texto = ? "
				+ "WHERE id = ? ";
		
		try ( PreparedStatement pst = conexao.prepareStatement(inserir) ){
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			pst.setInt(4, noticia.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
		}
		
	}
	
	public void excluir(Noticia noticia) {
		
		String excluir = "DELETE FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = conexao.prepareStatement(excluir) ){
			
			pst.setInt(1, noticia.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular"
					+ "a tabela Noticia. ");
			ex.printStackTrace();
		}
		
	}
	
	public Noticia consultar(int id) {
		
		String consultar = "SELECT * FROM noticia"
				+ " WHERE id = ? ";
		
		try (PreparedStatement pst = conexao.prepareStatement(consultar) ){
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Noticia n = new Noticia();
			if (resultado.next()) {
				n.setId(id);
				n.setDescricao(resultado.getString("descricao"));
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));
				
			} return n;
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public ArrayList<Noticia> listarNoticias() {
		
		String consultar = "SELECT * FROM noticia";
		
		try (PreparedStatement pst = conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia n = new Noticia();
				
				n.setId(resultado.getInt("id"));
				n.setDescricao(resultado.getString("descricao"));
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));
				lista.add(n);
				
			} return lista;
		
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
			
		}
		
	}

}
