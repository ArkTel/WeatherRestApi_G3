import backend.model.Location;
import backend.model.WeatherData;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import presentation.Menu;

import java.io.IOException;

//@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Location.class)
                .addAnnotatedClass(WeatherData.class)
                .buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        EntityManager em = session.getEntityManagerFactory().createEntityManager();

        Menu.display(sessionFactory);
    }
}
