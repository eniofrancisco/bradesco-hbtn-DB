package models;

import entities.Aluno;
import jakarta.persistence.*;

import java.util.List;

public class AlunoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");

    public void create(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public Aluno findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Aluno> alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        em.close();
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        if (aluno != null) {
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
        }
        em.close();
    }
}
