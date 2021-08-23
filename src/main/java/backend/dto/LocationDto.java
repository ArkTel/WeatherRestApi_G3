package backend.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class LocationDto {
    private String key;
    private String localizedName;
    private Region region;
    private Country country;
    private GeoPosition geoPosition;

    @JsonGetter("Key")
    public String getKey() {
        return key;
    }

    @JsonSetter("Key")
    public void setKey(String key) {
        this.key = key;
    }
    @JsonGetter("LocalizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    @JsonGetter("Region")
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @JsonGetter("Country")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonGetter("GeoPosition")
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @Override
    public String toString(){
        return"LocationDto{"+
                "key='"+key+'\''+
                ", localizedName='" + localizedName + '\'' +
                ", region=" + region +
                ", country=" + country +
                ", geoPosition=" + geoPosition +
                '}';
    }
}
