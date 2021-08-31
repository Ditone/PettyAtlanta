package com.personalproj.weather.repository;

import com.personalproj.weather.model.WeatherAug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WeatherAugRepository extends CrudRepository<WeatherAug, Long> {
}
