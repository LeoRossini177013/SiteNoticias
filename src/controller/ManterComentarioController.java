package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;

/**
 * Servlet implementation class ManterNoticiaController
 */
@WebServlet("/ManterComentario.do")
public class ManterComentarioController extends HttpServlet {
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
		String pNome = request.getParameter("nome");
		String pComentario = request.getParameter("comentario");
		String pIdNoticia = request.getParameter("idNoticia");
		
		//instanciar o javabean
		Comentario comentario = new Comentario();
		comentario.setNome(pNome);
		comentario.setComentario(pComentario);
		comentario.setIdNoticia(pIdNoticia);
		
		//instanciar o service
		ComentarioService cs = new ComentarioService();
		cs.criar(comentario);
		comentario = cs.carregar(comentario.getIdComentario());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Comentario Cadastrado</title></head><body>");
		out.println(	"nome: "+comentario.getNome()+"<br>");
		out.println(	"comentario: "+comentario.getComentario()+"<br>");
		out.println("<form action=index.html method=post>");
		out.println("<input type=submit value='Voltar ao Menu'>");
	    out.println("</body></html>");
		
	}

}
