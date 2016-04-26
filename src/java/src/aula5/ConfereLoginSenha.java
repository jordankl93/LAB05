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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan-PC
 */
@WebServlet(name = "ConfereLoginSenha", urlPatterns = {"/ConfereLoginSenha"})
public class ConfereLoginSenha extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String nome = request.getParameter("txtnome");
        String senha = request.getParameter("txtsenha");
        if (nome == null && senha == null) {
            MontaFormNull(response);
        } else {
            if ((senha.equals("123"))) {
                /*crie a funo*/
                MontaValido(request, response);
            } else {
                /*crie a fuo*/
                MontaFormInvalidos(response);
            }
        }
        // Montando o formulrio
        MontaForm(request, response);        
    }

    private void MontaForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String nome = "";
        //obtém todos os cookies armazenado no computador cliente
//        Cookie[] cookie = request.getCookies();
//        for (Cookie obj : cookie) {
//            if (obj.getName().equals("url")) {
//                nome = obj.getValue();
//            }
//        }

        pw.println(" <!DOCTYPE html>");
        pw.println(" <html>");
        pw.println(" <head>");
        pw.println(" <meta charset='ISO-8859-1'>");
        pw.println(" <title>Webmail</title>");
        pw.println(" </head>");
        pw.println(" <body>");
        pw.println(" <center>");
        pw.println("<h1>Seja bem-vindo ao nosso Webmail</h1>");
        pw.println("<form action=\"GerarCookie\" method='post'>");
        pw.println("<div class='frm'>");
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<td>Nome:</td>");
        pw.println("<td><input type= 'text' name='txtnome'>"+ nome +"</td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Senha:</td>");
        pw.println("<td><input type='text' name='txtsenha'></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td></td>");
        pw.println("<td><input type='submit' value='Enviar' /></td>");
        pw.println("</tr>");
        pw.println("</table>");
        pw.println("</div>");
        pw.println("</form>");
        pw.println("</center>");
        pw.println("</body>");
        pw.println("</html>");
    }

    private void MontaFormNull(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset='ISO-8859-1'>");
        pw.println("<title>Webmail</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Preencha os dados!</h1>");
        pw.println("</body>");
        pw.println("</html>");
    }

    private void MontaFormInvalidos(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset='ISO-8859-1'>");
        pw.println("<title>Webmail</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Nome ou senha incorretos! </h1>");
        pw.println("</body>");
        pw.println("</html>");
    }

    private void MontaValido(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String nome = request.getParameter("txtnome");
        PrintWriter pw = response.getWriter();

        pw.println(" <!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset='ISO-8859-1'>");
        pw.println("<title>Seja bem-vindo</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Olá, " + nome + ". Seja bem-vindo ao nosso Webmail! </h1>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
