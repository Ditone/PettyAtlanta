package com.personalproj.weather.repository;

import com.personalproj.weather.model.WeatherDiff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherDiffRepository extends CrudRepository<WeatherDiff, Long> {
    @Query(value = "select *\n" +
            "from difference_in_temps \n" +
            "where high_degf > (select high_degf from difference_in_temps where city = 'Atlanta, Georgia' ) \n" +
            "order by  high_degf DESC;;"
            , nativeQuery = true)
    List<WeatherDiff> getHotter ();
}
