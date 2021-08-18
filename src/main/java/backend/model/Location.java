package backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "location")
public class Location {
    private String name;
    private String latitude;
    private String longitude;
    private String region;
    private String country;
}
