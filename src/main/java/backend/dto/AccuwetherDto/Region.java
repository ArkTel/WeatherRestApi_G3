package backend.dto.AccuwetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Region {
    private String localizedName;

    @JsonGetter("LocalizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    //    @JsonSetter("LocalizedName")
    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "localizedName='" + localizedName + '\'' +
                '}';
    }
}
