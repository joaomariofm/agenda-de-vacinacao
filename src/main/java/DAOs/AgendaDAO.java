package DAOs;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import entities.Agenda;

public class AgendaDAO {
    private EntityManager entityManager;    

    public AgendaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Agenda agenda) {
        entityManager.getTransaction().begin();
        entityManager.persist(agenda);
        entityManager.getTransaction().commit();
    }

    public void read(Agenda agenda) {
        entityManager.getTransaction().begin();
        entityManager.find(Agenda.class, agenda.getId());
        entityManager.getTransaction().commit();
    }

    public ArrayList<Agenda> readAll() {
        entityManager.getTransaction().begin();
        ArrayList<Agenda> agendas = (ArrayList<Agenda>) entityManager.createQuery("FROM Agenda").getResultList();
        entityManager.getTransaction().commit();
        return agendas;
    }

    public void update(Agenda agenda) {
        entityManager.getTransaction().begin();
        entityManager.merge(agenda);
        entityManager.getTransaction().commit();
    }

    public void delete(Agenda agenda) {
        entityManager.getTransaction().begin();
        entityManager.remove(agenda);
        entityManager.getTransaction().commit();
    }
}
