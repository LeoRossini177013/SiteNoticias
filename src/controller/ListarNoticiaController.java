package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String pTitulo = request.getParameter("titulo");
		int pId = request.getIntHeader("id");
		
		NoticiaService cs = new NoticiaService();
		int [] ids = cs.listId();
		PrintWriter out = response.getWriter();
		Noticia noticia = new Noticia();
		noticia.setId(pId);
		noticia.setTitulo(pTitulo);
		out.println("<html><head><title>Notícias</title></head><body>");
		
		for(int i = 0; i<ids.length; ++i) {
			cs.carregar(ids[i]);
			out.println("<h3>"+ noticia.getTitulo() + "<h3><br>");
		}
	    out.println("</body></html>");
		
	}

}