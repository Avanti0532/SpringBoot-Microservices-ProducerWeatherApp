package com.avanti.Weather.service;

import com.avanti.Weather.model.Weather;
import com.avanti.Weather.model.WeatherAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<WeatherAlert> getWeatherSorted() {
        return restTemplate.getForObject("http://localhost:8083/getAlerts",List.class);
    }

    @Override
    public Boolean postWeather(Weather weather) {
        if(weather.getTemperature() > 25){
            WeatherAlert weatherAlert = new WeatherAlert("Too Hot", weather);
            return restTemplate.postForObject("http://localhost:8083/addReading",weatherAlert,boolean.class);
        }

        if(weather.getWind().getSpeed() > 6){
            WeatherAlert weatherAlert = new WeatherAlert("Too Windy", weather);
            return restTemplate.postForObject("http://localhost:8083/addReading",weatherAlert,boolean.class);
        }
        return true;
    }
}
