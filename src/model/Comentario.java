package model;

import java.io.Serializable;

public class Comentario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idComentario;
	private String nome;
	private String comentario;
	private String idNoticia;
	
	public Comentario() {
	}
	
	public String getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(String idComentario) {
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
	public String getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(String idNoticia) {
		this.idNoticia = idNoticia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", nome=" + nome + ", comentario=" + comentario + ", idNoticia=" + idNoticia +"]";
	}

}
