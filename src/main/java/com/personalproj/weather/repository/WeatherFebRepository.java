package com.personalproj.weather.repository;

import com.personalproj.weather.model.WeatherFeb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherFebRepository extends CrudRepository<WeatherFeb, Long>{
//    @Query(value = "SELECT city FROM febuary_temp WHERE high_degf > (SELECT high_degf FROM febuary_temp WHERE city_id = 1)", nativeQuery = true)
//    WeatherFeb getHotter();

    @Query(value = "select *\n" +
            "from february_temp \n" +
            "where high_degf > (select high_degf from february_temp where city = 'Atlanta, Georgia' ) \n" +
            "order by  high_degf DESC;;"
            , nativeQuery = true)
    List<WeatherFeb> getHotter ();
}
