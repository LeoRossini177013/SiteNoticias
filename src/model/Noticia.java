package model;

import java.io.Serializable;

public class Noticia implements Serializable {
	private static final long seriaVersionUID = 1L;
	private int id;
	private String titulo;
	private String conteudo;
	
	public Noticia() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return seriaVersionUID;
	}
	
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", conteudo=" + conteudo + "]";
	}
}
