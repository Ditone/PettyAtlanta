package com.personalproj.weather.controller;

import com.personalproj.weather.model.WeatherFeb;
import com.personalproj.weather.repository.WeatherFebRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/feb_temp")
public class WeatherFebController {
    @Autowired
    private WeatherFebRepository weatherFebRepository;

    @GetMapping
    public Iterable<WeatherFeb> list(){
        return weatherFebRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<WeatherFeb> get(@PathVariable Long id){
        return weatherFebRepository.findById(id);
    }

    @PostMapping
    public WeatherFeb create (@RequestBody final WeatherFeb weatherFeb){
        return weatherFebRepository.save(weatherFeb);
    }

    @RequestMapping (value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        weatherFebRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public WeatherFeb update(@PathVariable Long id, @RequestBody WeatherFeb weatherFeb){
        WeatherFeb existingWeatherFeb = weatherFebRepository.findById(id).get();
        BeanUtils.copyProperties(weatherFeb, existingWeatherFeb, "city_id");
        return weatherFebRepository.save(existingWeatherFeb);
    }

    //want this to use the url /api/v1/feb_temp/hotter to return a list of all cities with higher temps
    @GetMapping("hotter")
    public WeatherFeb findHotter(){
        return weatherFebRepository.getHotter();
    }
}
