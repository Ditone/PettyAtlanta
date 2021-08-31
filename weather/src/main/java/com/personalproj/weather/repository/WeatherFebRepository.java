package com.personalproj.weather.repository;

import com.personalproj.weather.model.WeatherAug;
import com.personalproj.weather.model.WeatherFeb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WeatherFebRepository extends CrudRepository<WeatherFeb, Long>{
    @Query("select city " +
            "from febuary_temp " +
            "where high_degf > (select high_degf from febuary_temp where city_id = 1) " +
            "order by  high_degf DESC;")
    WeatherFeb getHotter();
}
