package backend.dto.AccuwetherDto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindMetric {
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
        return "WindMetric{" +
                "value=" + value +
                '}';
    }
}
