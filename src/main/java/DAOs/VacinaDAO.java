package DAOs;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import entities.Vacina;

public class VacinaDAO {
    private EntityManager entityManager;

    public VacinaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Vacina vacina) {
        entityManager.getTransaction().begin();
        entityManager.persist(vacina);
        entityManager.getTransaction().commit();
    }

    public Vacina read(int id) {
        entityManager.getTransaction().begin();
        Vacina vacina = entityManager.find(Vacina.class, id); 
        entityManager.getTransaction().commit();
        return vacina;
    }

    public ArrayList<Vacina> readAll() {
        entityManager.getTransaction().begin();
        ArrayList<Vacina> vacinas = (ArrayList<Vacina>) entityManager.createQuery("FROM Vacina").getResultList();
        entityManager.getTransaction().commit();
        return vacinas;
    }

    public void update(Vacina vacina) {
        entityManager.getTransaction().begin();
        entityManager.merge(vacina);
    }

    public void delete(Vacina vacina) {
        entityManager.getTransaction().begin();
        entityManager.remove(vacina);
        entityManager.getTransaction().commit();
    }
}
