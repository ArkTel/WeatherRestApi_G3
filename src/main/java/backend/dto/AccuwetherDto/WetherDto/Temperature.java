package backend.dto.AccuwetherDto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Temperature {
    TempMetric metric;

    @JsonGetter("Metric")
    public TempMetric getMetric() {
        return metric;
    }

    public void setMetric(TempMetric metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "metric=" + metric +
                '}';
    }
}
