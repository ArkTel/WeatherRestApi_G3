package backend.dto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Pressure {
    private PressureMetric metric;

    @JsonGetter("Metric")
    public PressureMetric getMetric() {
        return metric;
    }

    public void setMetric(PressureMetric metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return "Pressure{" +
                "metric=" + metric +
                '}';
    }
}
