package com.personalproj.weather.controller;

import com.personalproj.weather.model.AtlWeatherData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/atl_weather_data")
public class AtlWeatherDataController {

    @GetMapping (value = "/get_all_atl_data")
    public AtlWeatherData getWeatherData(){
        String url = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=f7c9db6a492049b6aee131935213108&q=30301&format=json&date=2021-06-01&enddate=2021-08-31";
        RestTemplate restTemplate = new RestTemplate();
        AtlWeatherData result = restTemplate.getForObject(url, AtlWeatherData.class);
        return result;
    }

    //json property annotations
    // probably object mapper

}
