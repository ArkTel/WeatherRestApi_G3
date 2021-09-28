package backend.dto.AccuwetherDto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindSpeed {
    private WindMetric metric;

    @JsonGetter("Metric")
    public WindMetric getMetric() {
        return metric;
    }

    public void setMetric(WindMetric metric) {
        this.metric = metric;
    }

    @Override
    public String toString() {
        return "WindSpeed{" +
                "metric=" + metric +
                '}';
    }
}
