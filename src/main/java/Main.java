import backend.model.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import presentation.Menu;

import javax.persistence.EntityManager;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Location.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();

        Menu.display(sessionFactory);
    }
}
