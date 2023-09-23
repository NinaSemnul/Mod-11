package Service;

import Entity.Client;
import org.hibernate.Session;

import java.util.List;

public class ClientCrudService {

    public long create(String name) {

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Client client = new Client();
            client.setName(name);
            session.persist(client);
            long clientId = client.getId();

//              long clientId =  session.persist(client);
            session.getTransaction().commit();
            return clientId;
        }
    }

    public Client getById(long clientId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, clientId);
        }
    }

    public void updateById(long clientId, String newName) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client != null) {
                client.setName(newName);
                session.getTransaction().commit();
            }
        }
    }

    public void deleteById(long clientId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client != null) {
                session.remove(client);
                session.getTransaction().commit();
            }
        }
    }

    public List<Client> listAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

}
