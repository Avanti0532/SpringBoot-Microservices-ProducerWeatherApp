package com.avanti.Weather.model;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Weather {
    private String city;
    private String description;
    private double humidity;
    private double temperature;
    private double pressure;
    private Timestamp timestamp;
    private Wind wind;
}
