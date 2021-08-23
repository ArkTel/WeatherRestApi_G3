package backend.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Country {
    private String localizedName;

    @JsonGetter("LocalizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "localizedName='" + localizedName + '\'' +
                '}';
    }
}
