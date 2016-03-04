/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.poo.historicoacademico.persistencia;

import br.estacio.poo.historicoacademico.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author matheus
 */
public class UsuarioDao {
    
    Connection connection;
    
    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insert(Usuario usuario) {
        
        String sql = "INSERT INTO alunos (codigo, nome, cpf, login, senha) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            
            pstm.setInt(1, usuario.getCodigo());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, usuario.getCpf());
            pstm.setString(4, usuario.getLogin());
            pstm.setString(5, usuario.getSenha());
            
            pstm.execute();
            pstm.close();
            connection.close();
            
        } catch (SQLException e) {
            throw new RuntimeException("Problema ao inserir usuário. " + e.getMessage());
        }
    }
}
