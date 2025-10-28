package demo;

import entities.*;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {
        // Criando professor
        Professor professor = new Professor();
        professor.setNome("Maria Silva");
        professor.setEmail("maria.silva@faculdade.edu");

        // Criando material do curso
        MaterialCurso material = new MaterialCurso();
        material.setUrl("https://material.com/java");

        // Criando aluno
        Aluno aluno = new Aluno();
        aluno.setNome("João Oliveira");
        aluno.setEmail("joao.oliveira@aluno.edu");

        // Criando curso
        Curso curso = new Curso();
        curso.setNome("Java com JPA");
        curso.setSigla("JPA101");
        curso.setProfessor(professor);
        curso.setMaterial(material);
        curso.setAlunos(List.of(aluno));

        // Exibindo informações
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Sigla: " + curso.getSigla());
        System.out.println("Professor: " + curso.getProfessor().getNome());
        System.out.println("Material: " + curso.getMaterial().getUrl());
        System.out.println("Aluno: " + curso.getAlunos().get(0).getNome());
    }
}
