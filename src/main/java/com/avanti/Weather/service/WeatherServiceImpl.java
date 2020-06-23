package com.avanti.Weather.service;

import com.avanti.Weather.awsMessaging.WeatherAlertsSns;
import com.avanti.Weather.model.Weather;
import com.avanti.Weather.model.WeatherAlert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherAlertsSns weatherAlertsSns;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<WeatherAlert> getWeatherSorted() {
        return restTemplate.getForObject("http://localhost:8083/getAlerts",List.class);
    }

    @Override
    public Boolean postWeather(Weather weather) throws JsonProcessingException {
        System.out.println(weather);
        if(weather.getTemperature() > 25){
            WeatherAlert weatherAlert = new WeatherAlert("Too Hot", weather);
            String message = objectMapper.writeValueAsString(weatherAlert);
            weatherAlertsSns.send("Temperature Alert", message);
        }

        if(weather.getWind().getSpeed() > 6){
            WeatherAlert weatherAlert = new WeatherAlert("Too Windy", weather);
            String message = objectMapper.writeValueAsString(weatherAlert);
            weatherAlertsSns.send("Wind Alert", message);
        }
        return true;
    }
}
