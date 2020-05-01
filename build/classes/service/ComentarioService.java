package service;

import model.Comentario;

import java.util.ArrayList;

import dao.ComentarioDAO;


public class ComentarioService {
	ComentarioDAO dao = new ComentarioDAO();
	
	public String criar(Comentario comentario) {
		return dao.criar(comentario);
	}
	
	public void atualizar(Comentario comentario){
		dao.atualizar(comentario);
	}
	
	public void excluir(Comentario comentario){
		dao.excluir(comentario);
	}
	
	public Comentario carregar(String id){
		return dao.carregar(id);
	}
	
	public ArrayList<Comentario> listComentario(String id) {
		return dao.listComentario(id);
	}

}
