package com.personalproj.weather.repository;

import com.personalproj.weather.model.WeatherAug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherAugRepository extends CrudRepository<WeatherAug, Long> {
    @Query(value = "select *\n" +
            "from august_temp \n" +
            "where high_degf > (select high_degf from august_temp where city = 'Atlanta, Georgia' ) \n" +
            "order by  high_degf DESC;;"
            , nativeQuery = true)
    List<WeatherAug> getHotter();
}
