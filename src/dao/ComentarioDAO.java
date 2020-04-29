package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Comentario;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario(nome, comentario, idNoticia) VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getComentario());
			stm.setInt(3, comentario.getIdNoticia());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setIdComentario(rs.getInt(1));
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
		String sqlUpdate = "UPDATE noticia SET titulo=?, conteudo=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getComentario());
			stm.setInt(4, comentario.getIdComentario());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM noticia WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Comentario carregar(int id) {
		Comentario noticia= new Comentario();
		noticia.setIdComentario(id);
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, noticia.getIdComentario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					noticia.setNome(rs.getString("nome"));
					noticia.setComentario(rs.getString("comentario"));
				} else {
					noticia.setIdComentario(-1);
					noticia.setNome(null);
					noticia.setComentario(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}

}