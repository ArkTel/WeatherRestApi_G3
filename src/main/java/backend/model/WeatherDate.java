package backend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "weather_date")
public class WeatherDate {
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
}
