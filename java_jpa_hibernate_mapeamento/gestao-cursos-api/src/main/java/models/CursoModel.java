package models;

import entities.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");

    public void salvar(Curso curso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }

    // outros métodos...
}
