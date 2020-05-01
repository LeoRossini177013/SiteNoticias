package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.NoticiaService;
import service.ComentarioService;

/**
 * Servlet implementation class AtualizarNoticiaController
 */
@WebServlet("/LerNoticia.do")
public class LerNoticiaController extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		
		Noticia noticia = new Noticia();
		String pId = request.getParameter("id");
		noticia.setId(pId);
		
		//instanciar o service
		NoticiaService ns = new NoticiaService();
		ComentarioService cs = new ComentarioService();
		noticia = ns.carregar(noticia.getId());
		ArrayList<Comentario> ids = cs.listComentario(pId);
		
		out.println("<html><head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Notícia</title>");
		out.println("</head>");
		out.println("<body><h2>Real news</h2>");
		out.println("<hr/>");
		out.println("<form action=index.html method=post>");
		out.println("<input type=submit value='Voltar ao Menu'>");
		out.println("</form>");
		out.println("<div align='center'><h3>"+noticia.getTitulo()+"</h3><br/>");
		out.println("</div>");
		out.println(""+noticia.getConteudo()+"<br>");
		out.println("<hr/>");
		out.println("<div align=\"left\">");
		out.println("<form action='ManterComentario.do' method='post'>");
		out.println("Nome: <input type='text' name='nome'><br/>");
		out.println("Comentario: <input type='text' name='comentario'><br/>");
		out.println("<p>");
		out.println("<input type='hidden' name='idNoticia' value='"+noticia.getId()+"'><br/>");
		out.println("<input type='submit' value='Enviar'>");
		out.println("<p>");
		out.println("</form>");
		out.println("</div>");
		out.println("<div align='center'><h3>Comentários</h3><br/>");
		out.println("</div>");
		
		for (Comentario id : ids) {
			out.println("<p><strong>"+id.getNome()+"</strong><p>");
			out.println(""+id.getComentario()+"<br/>");
			out.println("<hr/>");
		}
		out.println("</div>");
		out.println("</body></html>");
		
	}

}