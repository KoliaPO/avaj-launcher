package Tower;

import Aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int changeWeather = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        changeWeather = changeWeather < 0 ? changeWeather * -1 : changeWeather;
        return weather[changeWeather % 4];
    }
}
