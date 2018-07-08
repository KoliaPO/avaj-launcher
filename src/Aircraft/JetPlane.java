package Aircraft;

import Tower.WeatherTower;

public class JetPlane extends Aircraft implements  Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates))
        {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                System.out.println("JetPlane#" + name + "(" + id + ")" + ": Very very WARMMMM!!!.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                System.out.println("JetPlane#" + name + "(" + id + ")" + ": It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println("JetPlane#" + name + "(" + id + ")" + ": Cant't see anything.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);

                System.out.println("JetPlane#" + name + "(" + id + ")" + ": OMG! Winter is coming!");
                break;
        }
        if (coordinates.getHeight() <= 0)
        {
            System.out.println("JetPlane#" + name + "(" + id + ")" + ": landing.");
            System.out.println("Tower says: JetPlane#"  + name + "(" + id + ")" + " unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        System.out.println("Tower says: JetPlane#"  + name + "(" + id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
