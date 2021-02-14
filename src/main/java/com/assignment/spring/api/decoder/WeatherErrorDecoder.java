package com.assignment.spring.api.decoder;

import com.assignment.spring.exception.WeatherException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static com.assignment.spring.constants.Constants.*;
import static org.springframework.http.HttpStatus.*;

public class WeatherErrorDecoder implements ErrorDecoder {

    @Override
    public WeatherException decode(String method, Response response) {
        switch (response.status()) {
            case 401:
                return new WeatherException(UNAUTHORIZED, ERROR_API_AUTH_CODE, ERROR_API_AUTH_MESSAGE);
            case 404:
                return new WeatherException(NOT_FOUND, ERROR_API_NOT_FOUND_CODE, ERROR_API_NOT_FOUND_MESSAGE);
            default:
                return new WeatherException(INTERNAL_SERVER_ERROR, ERROR_API_DEFAULT_CODE, ERROR_API_DEFAULT_MESSAGE);
        }
    }

}
