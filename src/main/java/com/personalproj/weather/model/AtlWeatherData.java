package com.personalproj.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//json ignore unknown
public class AtlWeatherData {

    @JsonProperty("data")
    private List<Weather> weatherList;

    public AtlWeatherData() {}

}
