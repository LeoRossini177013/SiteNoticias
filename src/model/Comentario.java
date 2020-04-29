package model;

import java.io.Serializable;

public class Comentario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idComentario;
	private String nome;
	private String comentario;
	private int idNoticia;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
