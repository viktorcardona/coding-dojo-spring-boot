package com.assignment.spring.service;

import com.assignment.spring.api.client.WeatherClient;
import com.assignment.spring.api.model.WeatherResponse;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.mapper.WeatherEntityMapper;
import com.assignment.spring.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient client;
    private final WeatherRepository repository;
    private final WeatherEntityMapper mapper;

    public WeatherEntity getWeather(String city) {
        log.debug("Get weather service was invoked...");
        WeatherResponse response = client.getWeather(city);
        WeatherEntity entity = mapper.map(response);
        repository.save(entity);
        return entity;
    }

}
