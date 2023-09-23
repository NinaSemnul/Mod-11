package Service;

import Entity.Planet;
import org.hibernate.Session;

import java.util.List;

public class PlanetCrudService {

    public void create(String id ,String name) {

        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Planet planet = new Planet();
            planet.setName(name);
            planet.setId(id);
            session.getTransaction().commit();
        }
    }

    public Planet getById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void updateById(String id, String newName) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Planet planet = session.get(Planet.class,id);
            if (planet != null) {
                planet.setName(newName);
                session.getTransaction().commit();
            }
        }
    }

    public void deleteById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
                session.getTransaction().commit();
            }
        }
    }

    public List<Planet> listAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

}
