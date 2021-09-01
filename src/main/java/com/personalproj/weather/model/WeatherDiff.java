package com.personalproj.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "difference_in_temps")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WeatherDiff{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city")
    private String city;

    @Column(name = "high_degf")
    private Integer highDegF;

    @Column(name = "low_degf")
    private Integer lowDegF;

    @Column(name = "high_degc")
    private Integer highDegC;

    @Column(name = "low_degc")
    private Integer lowDegC;

    public WeatherDiff () {}

    public WeatherDiff(Integer cityId, String city, Integer highDegF, Integer lowDegF, Integer highDegC, Integer lowDegC) {
        this.city = city;
        this.highDegF = highDegF;
        this.lowDegF = lowDegF;
        this.highDegC = highDegC;
        this.lowDegC = lowDegC;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHighDegF() {
        return highDegF;
    }

    public void setHighDegF(Integer highDegF) {
        this.highDegF = highDegF;
    }

    public Integer getLowDegF() {
        return lowDegF;
    }

    public void setLowDegF(Integer lowDegF) {
        this.lowDegF = lowDegF;
    }

    public Integer getHighDegC() {
        return highDegC;
    }

    public void setHighDegC(Integer highDegC) {
        this.highDegC = highDegC;
    }

    public Integer getLowDegC() {
        return lowDegC;
    }

    public void setLowDegC(Integer lowDegC) {
        this.lowDegC = lowDegC;
    }

    @Override
    public String toString() {
        return "WeatherDiff{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", highDegF=" + highDegF +
                ", lowDegF=" + lowDegF +
                ", highDegC=" + highDegC +
                ", lowDegC=" + lowDegC +
                '}';
    }
}
