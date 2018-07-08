package Aircraft;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        String newType = type.toLowerCase();
        Flyable flyable = null;
        Coordinates cor = new Coordinates(longitude, latitude, height);
        switch (newType)
        {
            case "baloon":
                flyable =  new Baloon(name, cor);
                break;
            case  "helicopter":
                flyable = new Helicopter(name, cor);
                break;
            case "jetplane":
                flyable = new JetPlane(name, cor);
                break;
        }
        if (flyable == null)
        {
            System.out.println("Wrong type !");
            System.exit(0);
        }
        return flyable;
    }
}
