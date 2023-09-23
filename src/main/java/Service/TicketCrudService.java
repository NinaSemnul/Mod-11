package Service;

import Entity.Client;
import Entity.Planet;
import Entity.Ticket;


import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class TicketCrudService {
    public void create(Client client, Planet fromPlanet, Planet toPlanet) {
        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Ticket getById(long ticketId) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, ticketId);
        }
    }

    public Ticket update(Ticket entity) {
        try (Session session = openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
            return entity;
        }
    }

    public void deleteById(long ticketId) {
        try (Session session = openSession()) {
            session.beginTransaction();
            Ticket entity = session.get(Ticket.class, ticketId);
            if (entity != null) {
                session.remove(entity);
            }
            session.getTransaction().commit();
        }
    }

    public List<Ticket> listAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    private Session openSession() {
        return HibernateUtil
                .getInstance()
                .getSessionFactory()
                .openSession();
    }

}
