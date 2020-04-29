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


@WebServlet("/LerNoticia.do")
public class LerNoticiaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pTitulo = request.getParameter("titulo");
        String pConteudo = request.getParameter("conteudo");
        int pId = request.getIntHeader("id");

        //instanciar o javabean
        Noticia noticia = new Noticia();
        noticia.setId(pId);
        noticia.setTitulo(pTitulo);
        noticia.setConteudo(pConteudo);
        int id = pId;

        //instanciar o service
        NoticiaService cs = new NoticiaService();
        cs.carregar(id);

        PrintWriter out = response.getWriter();
        out.println("<html><head><title></title></head><body>");
        out.println("<h3>"+noticia.getTitulo()+"<h3>");
        out.println(noticia.getConteudo()+"<br>");
        out.println("</body></html>");

    }

}
