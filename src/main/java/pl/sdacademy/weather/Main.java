package pl.sdacademy.weather;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sdacademy.weather.model.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json", "a4f5affb73e04cddbf973133181808");

        try {
            if(!Files.isDirectory(Paths.get("images")))
                Files.createDirectory(Paths.get("images"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Weather cityWeather = weatherService.getCityWeather("Szpital");
        System.out.println(cityWeather);
        String url = "http://maps.googleapis.com/maps/api/staticmap?center="+cityWeather.getLat() + ","+cityWeather.getLon()+"&size=400x400&zoom=12";
        try (InputStream input = new URL(url).openStream()) {

            Files.deleteIfExists(Paths.get("images/"+cityWeather.getCity()+".jpg"));
            Files.copy(input, Paths.get("images/"+cityWeather.getCity()+".jpg"));
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}


        //String url = "http://api.apixu.com/v1/current.json?key=a4f5affb73e04cddbf973133181808&q=Torun&lang=pl";

            // System.out.println(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));

           /* System.out.println("Lokalizacja: " + json.getJSONObject("location").getString("name"));
            System.out.println("Temperatura: " + json.getJSONObject("current").get("temp_c"));
            System.out.println("Wiatr: " + json.getJSONObject("current").get("wind_kph"));
            System.out.println("Opis: " + json.getJSONObject("current").getJSONObject("condition").get("text"));*/

            /*Weather weather = new Weather();

            System.out.println(weather);

            //Iterator<String> keys = json.keys();
            Iterator<String> keys = json.getJSONObject("current").keys();
            for (Iterator<String> it = keys; it.hasNext(); ) {
                String k = it.next();
                System.out.println(k);
            }
        */


