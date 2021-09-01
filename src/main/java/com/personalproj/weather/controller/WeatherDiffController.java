package com.personalproj.weather.controller;

import com.personalproj.weather.model.WeatherDiff;
import com.personalproj.weather.repository.WeatherDiffRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/diff_temp")
public class WeatherDiffController {
    @Autowired
    private WeatherDiffRepository weatherDiffRepository;

    @GetMapping
    public Iterable<WeatherDiff> list (){
        return weatherDiffRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<WeatherDiff> get(@PathVariable Long id){
        return weatherDiffRepository.findById(id);
    }

    @PostMapping
    public WeatherDiff create (@RequestBody final WeatherDiff weatherDiff){
        return weatherDiffRepository.save(weatherDiff);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        weatherDiffRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public WeatherDiff update (@PathVariable Long id, @RequestBody WeatherDiff weatherDiff) {
        WeatherDiff existingWeatherDiff = weatherDiffRepository.findById(id).get();
        BeanUtils.copyProperties(weatherDiff, existingWeatherDiff, "city_id");
        return weatherDiffRepository.save(existingWeatherDiff);
    }

    //want this to use the url /api/v1/feb_temp/hotter to return a list of all cities with higher temps
    @GetMapping()
    @RequestMapping("/hotter")
    public List<WeatherDiff> findHotter(){
        return weatherDiffRepository.getHotter();
    }

    // usage in application: getRandomId = rand (findHotter.length) , call http://localhost:8080/api/v1/feb_temp/hotter/getRandomId
    @GetMapping
    @RequestMapping("/hotter/{id}")
    public WeatherDiff findRandomHotter(@PathVariable int id){
        return weatherDiffRepository.getHotter().get(id);
    }


}
