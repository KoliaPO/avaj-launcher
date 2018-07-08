package Aircraft;

import Tower.WeatherTower;

public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
