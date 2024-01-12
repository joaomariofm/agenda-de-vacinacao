package DAOs;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import entities.Usuario;

public class UsuarioDAO {
    private EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    public Usuario read(int id) {
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class, id); 
        entityManager.getTransaction().commit();
        return usuario;
    }

    public ArrayList<Usuario> readAll() {
        entityManager.getTransaction().begin();
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) entityManager.createQuery("FROM Usuario").getResultList();
        entityManager.getTransaction().commit();
        return usuarios;
    }

    public void update(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }

    public void delete(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
    }
}
