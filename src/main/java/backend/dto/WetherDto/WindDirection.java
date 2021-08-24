package backend.dto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindDirection {
    private String localized;

    @JsonGetter("Localized")
    public String getLocalized() {
        return localized;
    }

    public void setLocalized(String localized) {
        this.localized = localized;
    }

    @Override
    public String toString() {
        return "WindDirection{" +
                "localized='" + localized + '\'' +
                '}';
    }
}
