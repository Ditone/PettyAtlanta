package com.personalproj.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties("data")
public class DataResponseModel {

    @JsonProperty ("weather")
    public AtlWeatherData atlWeatherData;

    public DataResponseModel() {}


}
