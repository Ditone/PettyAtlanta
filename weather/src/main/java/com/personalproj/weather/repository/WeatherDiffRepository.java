package com.personalproj.weather.repository;

import com.personalproj.weather.model.WeatherAug;
import com.personalproj.weather.model.WeatherDiff;
import org.springframework.data.repository.CrudRepository;

public interface WeatherDiffRepository extends CrudRepository<WeatherDiff, Long> {
    WeatherDiff getOne(Long id);
}
