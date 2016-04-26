/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

/**
 *
 * @author Jordan-PC
 */
@WebServlet(name = "Parametros",
        urlPatterns = {"/Parametros"},
        initParams = {
            @WebInitParam(name = "nome", value = "administrador"),
            @WebInitParam(name = "email", value = "adm@empresa.com.br"),
            @WebInitParam(name = "senha", value = "1234")
        })
public class Parametros extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ServletConfig config = getServletConfig();
        String nome = "";
        nome = config.getInitParameter("nome");

        PrintWriter out = null;
        out = response.getWriter();
        out.println("Usuário com acesso total: " + nome);
    }

}
