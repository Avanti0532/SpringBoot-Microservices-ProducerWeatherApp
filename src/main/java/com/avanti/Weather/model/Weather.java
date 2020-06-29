package com.avanti.Weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private String city;
    private String description;
    private double humidity;
    private double temperature;
    private double pressure;
    private Timestamp timestamp;
    private Wind wind;
}
