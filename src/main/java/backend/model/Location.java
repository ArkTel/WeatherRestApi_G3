package backend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "location")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private int id;

    private String key;
    private String name;
    private double latitude;
    private double longitude;
    private String region;
    private String country;

    public Location(String key, String name, String region, String country, double latitude, double longitude) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.region = region;
        this.country = country;
    }
}
