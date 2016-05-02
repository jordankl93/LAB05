/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.lab5.exercicio08;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jordan-PC
 */
public class ArquivoTextoServlet extends HttpServlet {

    private void gravar(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
        //Gerando e gravando em arquivo texto
        PrintWriter pw = response.getWriter();
        String caminho = getServletContext().getRealPath("/") + "aquivo_teste_gravando.txt";
        System.out.println("Caminho: " + caminho);
        String texto = request.getParameter("nome") + " + " + request.getParameter("email") + " + " + request.getParameter("idade");
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(caminho)));
        out.writeBytes(texto);
        out.flush();
        out.close();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Gravado</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Gravado com sucesso!</h1>");
        pw.println("<h3>Caminho do arquivo texto: " + caminho + "</h3>");
        pw.println("<form action='ArquivoTextoServlet?cmd=ler' method='post'>");
        pw.println("<input type=\"submit\" value=\"Ler dados\" />"); // leitura dos dados do arquivo
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");
    }

    private void leitura(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
        //lendo arquivo texto
        FileReader file = new FileReader(getServletContext().getRealPath("/") + "aquivo_teste_gravando.txt");
        Scanner in = new Scanner(file);
        PrintWriter pw = response.getWriter();
        
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Gravado</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Leitura dos dados salvos!</h1>");
        while (in.hasNextLine()) {
            pw.println(in.nextLine()+"</br>");
        }
        pw.println("</body>");
        pw.println("</html>");
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String cmd = request.getParameter("cmd");
            if (cmd.equalsIgnoreCase("gravar")) {
                gravar(request, response);
            } else {
                leitura(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
