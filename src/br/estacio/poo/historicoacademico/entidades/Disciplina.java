package br.estacio.poo.historicoacademico.entidades;

/**
 * Projeto de Histórico Acadêmico
 * Atividade Estruturada - 2015.2
 * Programação Orientada a Objetos - Estácio|FIC
 * @author Matheus Braga
 */
public class Disciplina {
    
    private int codigo;
    private String nome;
    private String professor;
    private int semestre;
    private float av1;
    private float av2;
    private float av3;
    
    public Disciplina() {}

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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) throws IllegalArgumentException {
        this.professor = professor;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) throws IllegalArgumentException {
        this.semestre = semestre;
    }

    public float getAv1() {
        return av1;
    }

    public void setAv1(float av1) throws IllegalArgumentException {
            this.av1 = av1;
    }

    public float getAv2() {
        return av2;
    }

    public void setAv2(float av2) throws IllegalArgumentException {
        this.av2 = av2;
    }

    public float getAv3() {
        return av3;
    }

    public void setAv3(float av3) throws IllegalArgumentException {   
        this.av3 = av3;
    }
 
}
