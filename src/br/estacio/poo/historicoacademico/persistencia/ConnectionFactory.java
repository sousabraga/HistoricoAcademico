package br.estacio.poo.historicoacademico.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Projeto de Histórico Acadêmico
 * Atividade Estruturada - 2015.2
 * Programação Orientada a Objetos - Estácio|FIC
 * @author Matheus Braga
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        
        try {
            return DriverManager.getConnection("jdbc:mysql://107.0.0.1:3306/historico_academico", "root", "123456");
        } catch(SQLException e) {
            throw new RuntimeException("Problema ao se conectar com o banco de dados. " + e.getMessage());
        }
    }
}
