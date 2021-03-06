package presentation;

import backend.json.AccuwetherDeserialize.AccuwetherLocationDeserialize;
import backend.json.AccuwetherDeserialize.AccuwetherWetherDateDeserialize;
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
                System.out.println("Wprowadź nazwę lokalizacji, którą chcesz dodać:");
                String cityName = sc.next();
                if (!locationRepository.isContainLocationList(cityName)) {
                    Location location = AccuwetherLocationDeserialize.deserialize(cityName);

//                System.out.println(location);
                    locationRepository.save(location);
                }else {
                    System.err.println("Lokalizacja znajduje się już w bazie danych");
                }
                break;
            }
            case "2": {
                locationRepository.allLocation().forEach(System.out::println);
                break;
            }
            case "3": {
                System.out.println("Wprowadź nazwę lokalizacji");
                String cityName = sc.next();
//                int id = locationRepository.getLocationId(cityName);
                //
                if (!locationRepository.isContainLocationList(cityName)) {
                    Location location = AccuwetherLocationDeserialize.deserialize(cityName);
                    locationRepository.save(location);

                    WeatherData weatherData = AccuwetherWetherDateDeserialize.deserialize(locationRepository, cityName, location);
                    weatherDateRepository.save(weatherData);
                }else {
                    Location location = locationRepository.getLocationByName(cityName);
                    WeatherData weatherData = AccuwetherWetherDateDeserialize.deserialize(locationRepository, cityName, location);
                    weatherDateRepository.save(weatherData);
                }

                break;
            }
            case "0": {
                System.out.println("Dziękujemy za skorzystanie z programu WRA-G3");
                break;
            }
            default:{
                System.err.println("ERROR");
            }
        }
    }
}
