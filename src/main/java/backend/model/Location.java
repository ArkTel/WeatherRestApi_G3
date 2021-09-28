package backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "location")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "location_key")
    private String key;

    private String name;
    private double latitude;
    private double longitude;
    private String region;
    private String country;

//    @ManyToOne
//    private WeatherData weatherData;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private List<WeatherData> weatherDataList = new ArrayList<>();

    public Location(String key, String name, String region, String country, double latitude, double longitude) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.region = region;
        this.country = country;
    }
}
