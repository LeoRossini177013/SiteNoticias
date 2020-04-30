package model;

import java.io.Serializable;

public class Noticia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String titulo;
	private String conteudo;
	
	public Noticia() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteúdo) {
		conteudo = conteúdo;
	}

	public static long getSeriaversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", conteudo=" + conteudo + "]";
	}
}
