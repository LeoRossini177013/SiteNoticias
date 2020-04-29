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
@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticiaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pId = request.getIntHeader("id");

        //instanciar o javabean
        int id = pId;

        //instanciar o service
        NoticiaService cs = new NoticiaService();
        cs.excluir(id);

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Noticia Excluida</title></head><body>");
        out.println("</body></html>");

    }

}