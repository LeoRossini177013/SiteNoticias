package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class ListarNoticiaController
 */
@WebServlet("/ListarNoticia.do")
public class ListarNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noticia noticia = new Noticia();
		NoticiaService cs = new NoticiaService();
		ArrayList<String> ids = cs.listId();
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Notícias</title></head><body>");
		out.println("<h2>Lista de Noticias<h2>");
		
		for (String id : ids) {
			noticia = cs.carregar(id);
			out.println("<h3><a href=/LerNoticias.do?id="+noticia.getId()+">" + noticia.getTitulo() + "</a><h3><br>");
		}
		
	    out.println("</body></html>");
		
	}

}