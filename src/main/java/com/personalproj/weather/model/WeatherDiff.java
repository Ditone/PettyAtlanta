package com.personalproj.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "difference_in_temps")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WeatherDiff{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer city_id;
    private String city;
    private Integer high_degf;
    private Integer low_degf;
    private Integer high_degc;
    private Integer low_degc;

    public WeatherDiff () {}


    public WeatherDiff (String city, Integer high_degf, Integer low_degf, Integer high_degc, Integer low_degc) {
        this.city = city;
        this.high_degf = high_degf;
        this.low_degf = low_degf;
        this.high_degc = high_degc;
        this.low_degc = low_degc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHigh_degf() {
        return high_degf;
    }

    public void setHigh_degf(Integer high_degf) {
        this.high_degf = high_degf;
    }

    public Integer getLow_degf() {
        return low_degf;
    }

    public void setLow_degf(Integer low_degf) {
        this.low_degf = low_degf;
    }

    public Integer getHigh_degc() {
        return high_degc;
    }

    public void setHigh_degc(Integer high_degc) {
        this.high_degc = high_degc;
    }

    public Integer getLow_degc() {
        return low_degc;
    }

    public void setLow_degc(Integer low_degc) {
        this.low_degc = low_degc;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }
}
