package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class ExcluirNoticiaController
 */
@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		
		//instanciar o javabean
		Noticia noticia = new Noticia();
		noticia.setId(pId);
		
		//instanciar o service
		NoticiaService cs = new NoticiaService();
		cs.excluir(noticia);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><h3>Noticia Excluida</h3></head><body>");
	    out.println("</body></html>");
		
	}

}