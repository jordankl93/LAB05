/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.persistence;

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
    
}
