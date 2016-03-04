package br.estacio.poo.historicoacademico.entidades;

/**
 * Projeto de Histórico Acadêmico
 * Atividade Estruturada - 2015.2
 * Programação Orientada a Objetos - Estácio|FIC
 * @author Matheus Braga
 */
public class Aluno {
    
    private String matricula;
    private String nome;
    private String curso;
    private String sexo;
    private int idade;
    private Disciplina historico[];

    public Aluno() {}
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws IllegalArgumentException {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) throws IllegalArgumentException {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws IllegalArgumentException {
        this.idade = idade;
    }
    
}
