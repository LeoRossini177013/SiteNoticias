package service;

import model.Noticia;

import java.util.ArrayList;

import dao.NoticiaDAO;


public class NoticiaService {
	NoticiaDAO dao = new NoticiaDAO();
	
	public String criar(Noticia noticia) {
		return dao.criar(noticia);
	}
	
	public void atualizar(Noticia noticia){
		dao.atualizar(noticia);
	}
	
	public void excluir(Noticia noticia){
		dao.excluir(noticia);
	}
	
	public Noticia carregar(String id){
		return dao.carregar(id);
	}
	
	public ArrayList<Noticia> listId() {
		return dao.listId();
	}

}
