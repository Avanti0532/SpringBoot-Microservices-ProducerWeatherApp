package com.avanti.Weather.util;

import com.avanti.Weather.model.Weather;
import com.avanti.Weather.model.Wind;

public class GetWeatherObject {

    public static Weather getWeatherObject(){
        return new Weather("Chicago","sunny", 90.0, 22, 1009.0,null, new Wind());
    }

    public static Weather getWeatherObjectTemp(){
        return new Weather("Chicago","sunny", 90.0, 27, 1009.0,null, new Wind());
    }
    public static Weather getWeatherObjectWind(){
        return new Weather("Chicago","sunny", 90.0, 23, 1009.0,null, new Wind(7,34));
    }
}
