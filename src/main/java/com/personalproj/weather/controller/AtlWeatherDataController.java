package com.personalproj.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalproj.weather.model.AtlWeatherData;
import com.personalproj.weather.model.DataResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

// TODO: DOESNT WORK

@RestController
@RequestMapping("/api/v1/atl_weather_data")
public class AtlWeatherDataController {

   // Uses resttemplate in order to use the call
    @GetMapping (value = "/get_data")
    public AtlWeatherData getWeatherData(){
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=f7c9db6a492049b6aee131935213108&q=Atlanta&format=json&date=2021/07/01&enddate=2021/08/31";
//
//        AtlWeatherData result = restTemplate.getForObject(url, AtlWeatherData.class);
//        return result;

        //test - map the json result to an object
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AtlWeatherData data = objectMapper.readValue(new URL("file:src/main/java/com/personalproj/weather/additional_files/response.json"), AtlWeatherData.class);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //json property annotations
    // probably object mapper

}
