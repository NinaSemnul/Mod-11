package Service;

import Entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import lombok.Getter;
import Entity.Client;
import Entity.Planet;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(Planet.class)
            .addAnnotatedClass(Ticket.class)
            //.configure("hibernate.properties")
            .buildSessionFactory();

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
