package backend.dto.WetherDto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Wind {
    private WindDirection direction;
    private WindSpeed speed;

    @JsonGetter("Direction")
    public WindDirection getDirection() {
        return direction;
    }

    public void setDirection(WindDirection direction) {
        this.direction = direction;
    }

    @JsonGetter("Speed")
    public WindSpeed getSpeed() {
        return speed;
    }

    public void setSpeed(WindSpeed speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "direction=" + direction +
                ", speed=" + speed +
                '}';
    }
}
