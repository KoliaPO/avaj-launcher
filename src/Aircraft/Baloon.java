package Aircraft;
import Tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates))
        {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                System.out.println("Baloon#" + name + "(" + id + ")" + ": Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                System.out.println("Baloon#" + name + "(" + id + ")" + ": Damn you rain! You messed up my baloon.");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                System.out.println("Baloon#" + name + "(" + id + ")" + ": can't see landing.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                System.out.println("Baloon#" + name + "(" + id + ")" + ": It's snowing. We're gonna crash.");
                break;
        }
        if (coordinates.getHeight() <= 0)
        {
            System.out.println("Baloon#" + name + "(" + id + ")" + ": landing.");
            System.out.println("Tower says: Baloon#"  + name + "(" + id + ")" + " unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: Baloon#"  + name + "(" + id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);

    }
}
