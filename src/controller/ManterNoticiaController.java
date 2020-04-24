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
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterNoticia.do")
public class ManterNoticiaController extends HttpServlet {
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
		String pConteudo = request.getParameter("conteudo");
		
		//instanciar o javabean
		Noticia noticia = new Noticia();
		noticia.setTitulo(pTitulo);
		noticia.setConteudo(pConteudo);
		
		//instanciar o service
		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		noticia = cs.carregar(noticia.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Noticia Cadastrada</title></head><body>");
		out.println(	"id: "+noticia.getId()+"<br>");
		out.println(	"titulo: "+noticia.getTitulo()+"<br>");
		out.println(	"conteudo: "+noticia.getConteudo()+"<br>");
	    out.println("</body></html>");
		
	}

}
