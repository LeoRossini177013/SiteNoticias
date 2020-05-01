package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

public class ComentarioDAO {
	public String criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario(idNoticia, nome, comentario) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getIdNoticia());
			stm.setString(2, comentario.getNome());
			stm.setString(3, comentario.getComentario());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setIdComentario(String.valueOf(rs.getString(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getIdComentario();
	}

	public void atualizar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET nome=?, comentario=? WHERE idComentario=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getComentario());
			stm.setString(3, comentario.getIdComentario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Comentario comentario) {
		String sqlDelete = "DELETE FROM comentario WHERE idComentario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, comentario.getIdComentario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Comentario carregar(String id) {
		Comentario comentario= new Comentario();
		comentario.setIdComentario(id);
		String sqlSelect = "SELECT nome, comentario FROM comentario WHERE idComentario = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, comentario.getIdComentario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comentario.setNome(rs.getString("nome"));
					comentario.setComentario(rs.getString("comentario"));
				} else {
					comentario.setIdComentario(null);
					comentario.setNome(null);
					comentario.setComentario(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comentario;
	}
	
	public ArrayList<Comentario> listComentario(String id) {
		String sqlSelect = "SELECT * from comentario WHERE idNoticia = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				ArrayList<Comentario> listId = new ArrayList<Comentario>();
				while (rs.next()) {
					Comentario comentario = new Comentario();
					comentario.setIdComentario(rs.getString("idComentario"));
					comentario.setNome(rs.getString("nome"));
					comentario.setComentario(rs.getString("comentario"));
					comentario.setIdNoticia(rs.getString("idNoticia"));
					listId.add(comentario);
				} 
				
					return listId;
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}