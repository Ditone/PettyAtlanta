package com.personalproj.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    public Weather (){}

    @JsonProperty("date")
    public String date;

    @JsonProperty("maxtempC")
    public Integer maxTempC;

    @JsonProperty("maxtempF")
    public Integer maxTempF;

    @JsonProperty("mintempC")
    public Integer minTempC;

    @JsonProperty("mintempF")
    public Integer minTempF;

    @JsonProperty("avgtempC")
    public Integer avgTempC;

    @JsonProperty("avgtempF")
    public Integer avgTempF;

    public Weather(String date, Integer maxTempC, Integer maxTempF, Integer minTempC, Integer minTempF, Integer avgTempC, Integer avgTempF) {
        this.date = date;
        this.maxTempC = maxTempC;
        this.maxTempF = maxTempF;
        this.minTempC = minTempC;
        this.minTempF = minTempF;
        this.avgTempC = avgTempC;
        this.avgTempF = avgTempF;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(Integer maxTempC) {
        this.maxTempC = maxTempC;
    }

    public Integer getMaxTempF() {
        return maxTempF;
    }

    public void setMaxTempF(Integer maxTempF) {
        this.maxTempF = maxTempF;
    }

    public Integer getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(Integer minTempC) {
        this.minTempC = minTempC;
    }

    public Integer getMinTempF() {
        return minTempF;
    }

    public void setMinTempF(Integer minTempF) {
        this.minTempF = minTempF;
    }

    public Integer getAvgTempC() {
        return avgTempC;
    }

    public void setAvgTempC(Integer avgTempC) {
        this.avgTempC = avgTempC;
    }

    public Integer getAvgTempF() {
        return avgTempF;
    }

    public void setAvgTempF(Integer avgTempF) {
        this.avgTempF = avgTempF;
    }

    @Override
    public String toString(){
        return "ATL Weather {" +
                "\nHighF: " + maxTempF +
                "\nLowF: " + minTempF +
                "\nHighC: " + maxTempC +
                "\nLowC: " + minTempC +
                "\nAvgF: " + avgTempF +
                "\nAvgC: " + avgTempC +
                "\n}";
    }
}
