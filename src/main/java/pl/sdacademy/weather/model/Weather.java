package pl.sdacademy.weather.model;

public class Weather {
    private String city;
    private String iconUrl;
    private double temp_c;
    private double feelslike_c;
    private String conditionText;

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", temp_c=" + temp_c +
                ", feelslike_c=" + feelslike_c +
                ", conditionText='" + conditionText + '\'' +
                '}';
    }
}
