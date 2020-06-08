package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;
import model.Noticia;

public class ComentarioDAO {
	
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void inserir(Comentario comentario) {
		String inserir = "INSERT INTO comentario " 
				+ " (id, nome, texto, fk_noticia_id) "
				+ "VALUES (?, ?, ?, ?)";
		
		try ( PreparedStatement pst = conexao.prepareStatement(inserir) ){
			
			pst.setInt(1, comentario.getId());
			pst.setString(2, comentario.getNome());
			pst.setString(3, comentario.getTexto());
			pst.setInt(4, comentario.getFk_noticia_id());
			
			pst.execute();
			
		} catch (SQLException ex) {
			System.err.println("Não foi possível manipular " 
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
		
	}
	 public ArrayList<Comentario> listaComentario() {
		 
		 String consultar = "SELECT * FROM comentario";
		 
		 try (PreparedStatement pst = conexao.prepareStatement(consultar) ) {
			 
			 ResultSet resultado = pst.executeQuery();
			 
			 ArrayList<Comentario> lista = new ArrayList<>();
			 while (resultado.next()) {
				 Comentario c = new Comentario();
				 
				 c.setId(resultado.getInt("id"));
				 c.setNome(resultado.getString("nome"));
				 c.setTexto(resultado.getString("texto"));
				 c.setFk_noticia_id(resultado.getInt("fk_noticia_id"));

				 
				 lista.add(c);
				 
			 }return lista;
			 
		 } catch (SQLException ex) {
				
				System.err.println("Não foi possível manipular "
						+ "a tabela Comentario.");
				ex.printStackTrace();
				
				return null;
				
			}
		 
	 }

}
