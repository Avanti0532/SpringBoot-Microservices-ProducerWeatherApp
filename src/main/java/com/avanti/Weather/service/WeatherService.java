package com.avanti.Weather.service;

import com.avanti.Weather.model.Weather;
import com.avanti.Weather.model.WeatherAlert;

import java.util.List;

public interface WeatherService {

    List<WeatherAlert> getWeatherSorted();
    Boolean postWeather(Weather weather);
}
