package com.personalproj.weather.controller;

import com.personalproj.weather.model.WeatherAug;
import com.personalproj.weather.repository.WeatherAugRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/august_temp")
public class WeatherAugController {
    @Autowired
    private WeatherAugRepository weatherAugRepository;

    @GetMapping
    public Iterable<WeatherAug> list() {
        return weatherAugRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<WeatherAug> get(@PathVariable Long id){
        return weatherAugRepository.findById(id);
    }

    @PostMapping
    public WeatherAug create (@RequestBody final WeatherAug weatherAug){
        return weatherAugRepository.save(weatherAug);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        weatherAugRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public WeatherAug update(@PathVariable Long id, @RequestBody WeatherAug weatherAug) {
        WeatherAug existingWeatherAug = weatherAugRepository.findById(id).get();
        BeanUtils.copyProperties(weatherAug, existingWeatherAug, "city_id");
        return weatherAugRepository.save(existingWeatherAug);
    }

}
