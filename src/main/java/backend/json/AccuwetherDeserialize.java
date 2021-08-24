package backend.json;

import backend.connect.AccuwetherConnection;
import backend.dto.LocationDto;
import backend.model.Location;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AccuwetherDeserialize {
    public static Location deserialize(String cityName) throws IOException {
        String myJson = AccuwetherConnection.connect(cityName);
        myJson = myJson.substring(1, myJson.length() - 1);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LocationDto mylocalization = objectMapper.readValue(myJson, LocationDto.class);
//        System.out.println(mylocalization);
        return new Location(mylocalization.getKey(),
                mylocalization.getLocalizedName(),
                mylocalization.getRegion().getLocalizedName(),
                mylocalization.getCountry().getLocalizedName(),
                mylocalization.getGeoPosition().getLatitude(),
                mylocalization.getGeoPosition().getLongitude());
    }
}
