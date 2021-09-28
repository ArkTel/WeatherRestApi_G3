package backend.json.AccuwetherDeserialize;

import backend.connect.AccuwetherGetData;
import backend.dto.AccuwetherDto.WetherDto.DailyForecasts;
import backend.model.Location;
import backend.model.WeatherData;
import backend.repository.LocationRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AccuwetherWetherDateDeserialize {
    public static WeatherData deserialize(LocationRepository locationRepository, String cityName, Location location) throws IOException {
        String myJson = AccuwetherGetData.getDate(locationRepository, cityName);
        myJson = myJson.substring(1, myJson.length() - 1);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DailyForecasts forecasts = objectMapper.readValue(myJson, DailyForecasts.class);
        System.out.println(forecasts);
        return new WeatherData(forecasts.getTemperature().getMetric().getValue(),
                forecasts.getRelativeHumidity(),
                forecasts.getWind().getSpeed().getMetric().getValue(),
                forecasts.getWind().getDirection().getLocalized(),
                forecasts.getPressure().getMetric().getValue(),
                location);
    }
}
