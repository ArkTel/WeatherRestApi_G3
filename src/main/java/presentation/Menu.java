package presentation;

import backend.json.AccuwetherDeserialize;
import backend.json.WetherDateDeserialize;
import backend.model.Location;
import backend.model.WeatherData;
import backend.repository.LocationRepository;
import backend.repository.WeatherDataRepository;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void display(SessionFactory sessionFactory) throws InterruptedException, IOException {


        System.out.println("=====================================================");
        System.out.println("         Witaj w aplikacji pogodowej WRA-G3          ");
        System.out.println("=====================================================");
        sleep(1000);

        System.out.println("Wybierz co chcesz zrobić wciskając odpowiedni \nnumer i zatwierdzając klawiszem enter");

        boolean flag = true;
        while (flag) {
            System.out.println("1. DODAJ LOKALIZACJĘ;  2.LISTA LOKALIZACJI;  3.POBIERZ DANE POGODOWE  0.Zakończ program");
            String n = sc.next();
            switchMenu(n, sessionFactory);
            if (n.equals("0")){
                flag = false;
            }

        }

    }
    public static void switchMenu(String n, SessionFactory sessionFactory) throws IOException {
        LocationRepository locationRepository = new LocationRepository(sessionFactory.createEntityManager());
        WeatherDataRepository weatherDateRepository = new WeatherDataRepository(sessionFactory.createEntityManager());
        switch (n) {
            case "1": {
//                AccuwetherConnection.connect();
                Location location = AccuwetherDeserialize.deserialize();

//                System.out.println(location);
                locationRepository.save(location);
                break;
            }
            case "2": {
                locationRepository.allLocation().forEach(System.out::println);
                break;
            }
            case "3": {
                WeatherData weatherData = WetherDateDeserialize.deserialize(locationRepository);
                weatherDateRepository.save(weatherData);
                break;
            }
            case "0": {
                System.out.println("Dziękujemy za skorzystanie z programu WRA-G3");
                break;
            }
            default:{
                System.out.println("ERROR");
            }
        }
    }
}
