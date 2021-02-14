package com.assignment.spring.mapper;

import com.assignment.spring.api.model.WeatherResponse;
import com.assignment.spring.entity.WeatherEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class WeatherEntityMapperTest {

    private WeatherEntityMapper subject = new WeatherEntityMapper();

    @Test
    void map_givenWeatherResponse_buildWeatherEntity() throws JsonProcessingException {
        WeatherEntity result = subject.map(response());
        assertThat(result, is(equalToObject(WeatherEntity.builder().city("Tokyo").country("JP").temperature(Double.valueOf(285.81)).build())));
    }

    private WeatherResponse response() throws JsonProcessingException {
        return new ObjectMapper().readValue("{\"coord\":{\"lon\":139.6917,\"lat\":35.6895},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":285.81,\"pressure\":1025,\"humidity\":66,\"temp_min\":284.82,\"temp_max\":286.48,\"feels_like\":281.75},\"visibility\":10000,\"wind\":{\"speed\":4.63,\"deg\":180},\"clouds\":{\"all\":40},\"dt\":1613211662,\"sys\":{\"type\":1,\"id\":8074,\"country\":\"JP\",\"sunrise\":1613165445,\"sunset\":1613204421},\"id\":1850147,\"name\":\"Tokyo\",\"cod\":200,\"timezone\":32400}", WeatherResponse.class);
    }

}
