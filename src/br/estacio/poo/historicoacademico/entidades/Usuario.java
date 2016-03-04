package br.estacio.poo.historicoacademico.entidades;

/**
 * Projeto de Histórico Acadêmico
 * Atividade Estruturada - 2015.2
 * Programação Orientada a Objetos - Estácio|FIC
 * @author Matheus Braga
 */
public class Usuario {
    
    private int codigo;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    
    public Usuario() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws IllegalArgumentException {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws IllegalArgumentException {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws IllegalArgumentException {
        this.senha = senha;
    }
    
}
