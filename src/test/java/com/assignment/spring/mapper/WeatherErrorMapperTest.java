package com.assignment.spring.mapper;

import com.assignment.spring.model.WeatherError;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class WeatherErrorMapperTest {

    private WeatherErrorMapper subject = new WeatherErrorMapper();

    @Test
    void map_givenInput_createWeatherError() {
        WeatherError result = subject.map("some_code", "some_message");
        WeatherError expected = WeatherError.builder().code("some_code").message("some_message").build();
        assertThat(result, is(equalToObject(expected)));
    }

}