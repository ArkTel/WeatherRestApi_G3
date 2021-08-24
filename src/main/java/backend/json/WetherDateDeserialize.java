package backend.json;

import backend.connect.AccuwetherGetData;
import backend.dto.WetherDto.DailyForecasts;
import backend.model.WeatherData;
import backend.repository.LocationRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class WetherDateDeserialize {
    public static WeatherData deserialize(LocationRepository locationRepository) throws IOException {
        String myJson = AccuwetherGetData.getDate(locationRepository);
        myJson = myJson.substring(1, myJson.length() - 1);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        DailyForecasts forecasts = objectMapper.readValue(myJson, DailyForecasts.class);
        System.out.println(forecasts);
        return new WeatherData(forecasts.getTemperature().getMetric().getValue(),
                forecasts.getRelativeHumidity(),
                forecasts.getWind().getSpeed().getMetric().getValue(),
                forecasts.getWind().getDirection().getLocalized(),
                forecasts.getPressure().getMetric().getValue());
    }
}
