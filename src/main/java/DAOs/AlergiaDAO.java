package DAOs;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import entities.Alergia;

public class AlergiaDAO {
    private EntityManager entityManager;

    public AlergiaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Alergia alergia) {
        entityManager.getTransaction().begin();
        entityManager.persist(alergia);
        entityManager.getTransaction().commit();
    }

    public Alergia read(int id) {
        entityManager.getTransaction().begin();
        Alergia alergia = entityManager.find(Alergia.class, id);
        System.out.println(alergia);
        entityManager.getTransaction().commit();
        return alergia;
    }

    public ArrayList<Alergia> readAll() {
        entityManager.getTransaction().begin();
        ArrayList<Alergia> alergias = (ArrayList<Alergia>) entityManager.createQuery("FROM Alergia").getResultList();
        entityManager.getTransaction().commit();
        return alergias;
    }

    public void update(Alergia alergia) {
        entityManager.getTransaction().begin();
        entityManager.merge(alergia);
        entityManager.getTransaction().commit();
    }

    public void delete(Alergia alergia) {
        entityManager.getTransaction().begin();
        entityManager.remove(alergia);
        entityManager.getTransaction().commit();
    }
}
