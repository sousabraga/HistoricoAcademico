package br.estacio.poo.historicoacademico.persistencia;

import br.estacio.poo.historicoacademico.entidades.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Projeto de Histórico Acadêmico
 * Atividade Estruturada - 2015.2
 * Programação Orientada a Objetos - Estácio|FIC
 * @author Matheus Braga
 */
public class AlunoDao {
    
    Connection connection;
    
    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insert(Aluno aluno) {
        
        String sql = "INSERT INTO alunos (matricula, nome, curso, sexo, idade) VALUES (?, ?, ?, ?, ?)";
        
        try{ 
            PreparedStatement pstm = connection.prepareStatement(sql);
            
            pstm.setString(1, aluno.getMatricula());
            pstm.setString(2, aluno.getNome());
            pstm.setString(3, aluno.getCurso());
            pstm.setString(4, aluno.getSexo());
            pstm.setInt(5, aluno.getIdade());
            
            pstm.execute();
            pstm.close();
            connection.close();

        } catch(SQLException e) {
            throw new RuntimeException("Problema ao inserir aluno. " + e.getMessage());
        }
    }
}
