/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan-PC
 */
@WebServlet(name = "ConfereIdade", urlPatterns = {"/ConfereIdade"})
public class ConfereIdade extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            // Recuperando o valor do campo nome
            int idade = Integer.parseInt(request.getParameter("idade"));
            // Recuperando/transformando para inteiro a idade
            if (idade >= 18) { // Caso seja maior de idade
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Seja bem-vindo</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Olá, " + nome
                        + ". Seja bem-vindo! Método utilizado: "+ request.getMethod() +" </h1>");
                out.println("</body>");
                out.println("</html>");
            } else { // Caso contrário, redirecionamos a página
                response.sendRedirect("http://www.disney.com");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
