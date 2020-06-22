package com.avanti.Weather.controller;

import com.avanti.Weather.model.Weather;
import com.avanti.Weather.model.WeatherAlert;
import com.avanti.Weather.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping(value = "getWeatherSorted")
    @ApiOperation(value="Get weather details sorted on timestamp")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<WeatherAlert> getWeatherSorted(){
       return service.getWeatherSorted();
    }

    @PostMapping(value = "addReading")
    @CrossOrigin(origins = "*")
    @ApiOperation(value="Post weather data into database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public boolean postWeather(@RequestBody Weather weather){
        return service.postWeather(weather);
    }

}
