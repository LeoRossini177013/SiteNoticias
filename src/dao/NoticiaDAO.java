package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Noticia;

public class NoticiaDAO {
	public String criar(Noticia noticia) {
		String sqlInsert = "INSERT INTO noticia(titulo, conteudo) VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, noticia.getTitulo());
			stm.setString(2, noticia.getConteudo());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					noticia.setId(String.valueOf(rs.getInt(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticia.getId();
	}

	public void atualizar(Noticia noticia) {
		String sqlUpdate = "UPDATE noticia SET titulo=?, conteudo=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, noticia.getTitulo());
			stm.setString(2, noticia.getConteudo());
			stm.setString(3, noticia.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Noticia noticia) {
		String sqlDelete = "DELETE FROM noticia WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, noticia.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Noticia carregar(String id) {
		Noticia noticia= new Noticia();
		String sqlSelect = "SELECT titulo , conteudo FROM noticia WHERE noticia.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, noticia.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					noticia.setTitulo(rs.getString("titulo"));
					noticia.setConteudo(rs.getString("conteudo"));
				} else {
					noticia.setId(null);
					noticia.setTitulo(null);
					noticia.setConteudo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}
	
	public ArrayList<String> listId() {
		Noticia noticia = new Noticia();
		String sqlSelect = "SELECT * from noticia";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				ArrayList<String> listId = new ArrayList<String>();
				for (int i = 1; rs.next(); ++i) {
					listId.add(rs.getString(i));
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