import Aircraft.AircraftFactory;
import Aircraft.Flyable;
import Tower.WeatherTower;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    private static WeatherTower weatherTower = new WeatherTower();
    public static void main(String[] args)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null)
            {
                int sim = Integer.parseInt(line);
                System.out.println(sim);
                if (sim <= 0)
                {
                    System.out.println("Wrong number simulations !");
//                    System.exit(0);
                }
                else
                {
                    while ((line = reader.readLine()) != null)
                    {
                        Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                                Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                                Integer.parseInt(line.split(" ")[4]));
                        if (flyable != null)
                            flyable.registerTower(weatherTower);
                    }
                    for (int i = 1; i <= sim; i++)
                        weatherTower.changeWeather();
                }
            }

        } catch (Exception e) {
            System.out.println("Error EXCEPTION !");
        }
    }
}
