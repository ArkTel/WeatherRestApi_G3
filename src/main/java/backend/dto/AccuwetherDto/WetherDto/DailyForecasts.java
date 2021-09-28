package backend.dto.AccuwetherDto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class DailyForecasts {
    private Temperature temperature;
    private double relativeHumidity;
    private Wind wind;
    private Pressure pressure;


    @JsonGetter("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonGetter("RelativeHumidity")
    public double getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @JsonGetter("Wind")
    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonGetter("Pressure")
    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "temperature=" + temperature +
                ", relativeHumidity=" + relativeHumidity +
                ", wind=" + wind +
                ", pressure=" + pressure +
                '}';
    }
}
