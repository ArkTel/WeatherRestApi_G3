package backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "weather_date")
public class WeatherDate {
    private double temperature;
    private double pressure;
    private double humidity;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "wind_direction")
    private String windDirection;
}
