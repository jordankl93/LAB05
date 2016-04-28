/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.model.Pessoa;
import src.persistence.PessoaDao;

/**
 *
 * @author Jordan-PC
 */
@WebServlet(name = "Enviardados", urlPatterns = {"/Enviardados"})
public class Enviardados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String cmd = request.getParameter("cmd");
            Pessoa p;
            PessoaDao pd;

            if (cmd.equalsIgnoreCase("cadastrar")) {
                p = new Pessoa(request.getParameter("nome"),
                        request.getParameter("email"),
                        new Integer(request.getParameter("idade")));

                pd = new PessoaDao();
                pd.create(p);

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Gravado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Gravado com sucesso!</h1>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gravado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: " + e.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
