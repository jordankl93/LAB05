/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.model.Pessoa;

/**
 *
 * @author Jordan-PC
 */
public class PessoaDao extends Dao {

    public void create(Pessoa p) throws Exception {
        open();

        stmt = con.prepareStatement("INSERT INTO pessoa(nome, email, idade) VALUES( ?,  ?,  ?) ");

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.setInt(3, p.getIdade());

        stmt.execute();
        close();
    }

    public List<Pessoa> buscarTodos() throws Exception {
        List<Pessoa> resultados = new ArrayList<>();
        
        open();
        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Pessoa temp = new Pessoa(rs.getString("nome"), rs.getString("email"), rs.getInt("idade"));
                resultados.add(temp);
            }
            close();
            return resultados;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pessoa: \n" + e.getMessage());
            close();
            return null;
        }

    }
}
