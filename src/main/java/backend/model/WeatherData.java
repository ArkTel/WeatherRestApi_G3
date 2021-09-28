package backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private double temperature;
    private double pressure;
    private double humidity;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "wind_direction")
    private String windDirection;

//    @OneToMany
////    @JoinColumn(name = "weather_data_id")
//    private List<Location> locations = new ArrayList<>();
    @ManyToOne
    private Location location;

    public WeatherData(double temperature, double humidity, double windSpeed, String windDirection, double pressure, Location location ) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.location = location;
    }
}
