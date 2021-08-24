package backend.dto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class TempMetric {
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
        return "TempMetric{" +
                "value=" + value +
                '}';
    }
}
