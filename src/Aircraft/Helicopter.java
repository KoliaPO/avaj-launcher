package Aircraft;

import Tower.WeatherTower;

public class Helicopter extends  Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates))
        {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                System.out.println("Helicopter#" + name + "(" + id + ")" + ": This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println("Helicopter#" + name + "(" + id + ")" + ": Shit rain.");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println("Helicopter#" + name + "(" + id + ")" + ": Cant't see landing.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                System.out.println("Helicopter#" + name + "(" + id + ")" + ": My rotor is going to freeze!");
                break;
        }
        if (coordinates.getHeight() <= 0)
        {
            System.out.println("Helicopter#" + name + "(" + id + ")" + ": landing.");
            System.out.println("Tower says: Helicopter#"  + name + "(" + id + ")" + " unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: Helicopter#"  + name + "(" + id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
