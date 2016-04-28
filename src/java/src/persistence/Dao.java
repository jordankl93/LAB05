/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jordan-PC
 */
public class Dao {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    String url = "jdbc:postgresql://localhost:5432/exercicio6";
    String usuario = "postgres";
    String senha = "jokl93";

    protected void open() throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, usuario, senha);
    }

    protected void close() throws Exception {
        con.close();
    }
}
