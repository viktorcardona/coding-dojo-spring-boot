package com.assignment.spring.mapper;

import com.assignment.spring.api.model.WeatherResponse;
import com.assignment.spring.entity.WeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherEntityMapper {

    public WeatherEntity map(WeatherResponse response) {
        return WeatherEntity.builder()
                .city(response.getName())
                .country(response.getSys().getCountry())
                .temperature(response.getMain().getTemp())
                .build();
    }

}
