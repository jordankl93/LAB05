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
 * @author 20112BSI0016
 */
@WebServlet(name = "GerarCookie", urlPatterns = {"/GerarCookie"})
public class GerarCookie extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        Cookie cookieURL = new Cookie("url", request.getParameter("txtnome")); //configura cookie
        cookieURL.setMaxAge(60); //1 minutos
        response.addCookie(cookieURL); //cria um cokie
        pw.println("Cookie criado.");
    }

}
