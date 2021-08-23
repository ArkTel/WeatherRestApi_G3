package presentation;

import backend.connect.AccuwetherConnection;
import backend.json.AccuwetherDeserialize;
import backend.model.Location;
import backend.repository.LocationRepository;
import org.hibernate.SessionFactory;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void display(SessionFactory sessionFactory) throws InterruptedException, IOException {

        LocationRepository locationRepository = new LocationRepository(sessionFactory.createEntityManager());
        System.out.println("=====================================================");
        System.out.println("         Witaj w aplikacji pogodowej WRA-G3          ");
        System.out.println("=====================================================");
        sleep(3000);

        System.out.println("Wybierz co chcesz zrobić wciskając odpowiedni \nnumer i zatwierdzając klawiszem enter");

        boolean flag = true;
        while (flag) {
            System.out.println("1. DODAJ LOKALIZACJĘ;   0.Zakończ program");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
//                AccuwetherConnection.connect();

                    Location location = AccuwetherDeserialize.deserialize();
                    locationRepository.save(location);
                    break;
                }
                case 0: {
                    flag = false;
                    System.out.println("Dziękujemy za skorzystanie z programu WRA-G3");
                }
            }
        }

    }
}
