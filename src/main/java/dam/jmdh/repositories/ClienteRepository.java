package dam.jmdh.repositories;

import dam.jmdh.entities.Cliente;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.List;

import static dam.jmdh.HibernateUtil.print;

public class ClienteRepository implements Repository<Cliente> {
    private final Session session;

    public ClienteRepository(Session session) {
        this.session = session;
    }

    @Override
    public void save(Cliente cliente) {
        session.beginTransaction();
        session.persist(cliente);
        session.getTransaction().commit();
    }

    @Override
    public List<Cliente> findAll() {
        //Sentncia HQL
        return session.createQuery("FROM cliente", Cliente.class).getResultList();
    }

    @Override
    public Cliente findOneById(int id) {

        return null;
    }

    public Cliente findOneById(String id) {
        Cliente cliente = null;
        try {
            session.beginTransaction();
            // Dos formas de obtenerlo:
            // 1. Session.find()
            cliente = session.find(Cliente.class, id);

            // 2. Utilizando HQL
            cliente = session.createQuery("FROM cliente WHERE dni=:dni", Cliente.class)
                    .setParameter("dni", id).getSingleResult();
        } catch (NoResultException e) {
            print("El cliente con id " + id + " no se encuentra en la BBDD");
        } finally {

            // Fijaos donde pongo el commit. Por si falla que no se quede la transaccion abierta...
            session.getTransaction().commit();
        }
        return cliente;
    }

    @Override
    public void update(Cliente cliente) {
        session.beginTransaction();
        session.persist(cliente);
        session.getTransaction().commit();

    }

    @Override
    public void delete(Cliente cliente) {
        session.beginTransaction();
        session.remove(cliente);
        session.getTransaction().commit();

    }
}
