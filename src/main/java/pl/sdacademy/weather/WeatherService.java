package pl.sdacademy.weather;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sdacademy.weather.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {
    private String finalUrl;

    public WeatherService(String url, String apiKey) {
        finalUrl = url +"?key=" + apiKey;
    }
    public Weather getCityWeather(String city){
        Weather weather = new Weather();
        String reqUrl = finalUrl + "&q=" + city + "&lang=pl";
        JSONObject json = null;
        try {
            json = new JSONObject(IOUtils.toString(new URL(reqUrl), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        weather.setCity(json.getJSONObject("location").getString("name"));
        weather.setIconUrl(json.getJSONObject("current").getJSONObject("condition").getString("icon"));
        weather.setConditionText(json.getJSONObject("current").getJSONObject("condition").getString("text"));
        weather.setTemp_c(json.getJSONObject("current").getDouble("temp_c"));
        weather.setFeelslike_c(json.getJSONObject("current").getDouble("feelslike_c"));
        weather.setLat(json.getJSONObject("location").getDouble("lat"));
        weather.setLon(json.getJSONObject("location").getDouble("lon"));
        return weather;
    }
}
