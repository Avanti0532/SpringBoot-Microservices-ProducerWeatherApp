package com.avanti.Weather.service;

import com.avanti.Weather.awsMessaging.WeatherAlertsSns;
import com.avanti.Weather.model.WeatherAlert;
import com.avanti.Weather.util.GetWeatherObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {

    private WeatherServiceImpl weatherServiceimpl;

    @Mock
    private WeatherAlertsSns weatherAlertsSns;

    @Mock
    private ObjectMapper objectMapper;

    @Before
    public void setup(){
        weatherServiceimpl = new WeatherServiceImpl(weatherAlertsSns, objectMapper);
    }

    @Test
    public void postWeatherTemperature() throws JsonProcessingException {
        boolean b = weatherServiceimpl.postWeather(GetWeatherObject.getWeatherObjectTemp());
        Mockito.lenient().when(objectMapper.writeValueAsString(Matchers.any(WeatherAlert.class))).thenReturn("Hello World");
        Assert.assertEquals(b, true);
    }

    @Test
    public void postWeatherWind() throws JsonProcessingException {
        boolean b = weatherServiceimpl.postWeather(GetWeatherObject.getWeatherObjectWind());
        lenient().when(objectMapper.writeValueAsString(Matchers.any(WeatherAlert.class))).thenReturn("Hello World");
        Assert.assertEquals(b, true);
    }

    @Test
    public void postWeatherNormal() throws JsonProcessingException {
        boolean b = weatherServiceimpl.postWeather(GetWeatherObject.getWeatherObject());
        Assert.assertEquals(b, false);
    }
}