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

    public Agenda read(int id) {
			entityManager.getTransaction().begin();
			Agenda agenda = entityManager.find(Agenda.class, id);
			entityManager.getTransaction().commit();
			return agenda;
    }

    public ArrayList<Agenda> readAll() {
        entityManager.getTransaction().begin();
        ArrayList<Agenda> agendas = (ArrayList<Agenda>) entityManager.createQuery("FROM Agenda").getResultList();
        entityManager.getTransaction().commit();
        return agendas;
    }

		public ArrayList<Agenda> readAllByDate(String date) {
			entityManager.getTransaction().begin();
			ArrayList<Agenda> agendas = (ArrayList<Agenda>) entityManager.createQuery("FROM Agenda WHERE date = :date").setParameter("date", date).getResultList();
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
