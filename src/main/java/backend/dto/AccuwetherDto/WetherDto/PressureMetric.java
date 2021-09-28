package backend.dto.AccuwetherDto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class PressureMetric {
    private double value;

    @JsonGetter("Value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PressureMetric{" +
                "value=" + value +
                '}';
    }
}
