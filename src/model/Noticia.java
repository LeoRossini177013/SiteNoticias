package model;

import java.io.Serializable;

public class Noticia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String conteudo;
	private String idNoticia;
	
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

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(String idNoticia) {
		this.idNoticia = idNoticia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
