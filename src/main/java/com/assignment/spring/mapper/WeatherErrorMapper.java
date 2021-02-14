package com.assignment.spring.mapper;

import com.assignment.spring.model.WeatherError;
import org.springframework.stereotype.Component;

@Component
public class WeatherErrorMapper {

    public WeatherError map(String code, String message) {
        return WeatherError.builder()
                .code(code)
                .message(message)
                .build();
    }
}
