package com.assignment.spring.exception.handler;

import com.assignment.spring.exception.WeatherException;
import com.assignment.spring.mapper.WeatherErrorMapper;
import com.assignment.spring.model.WeatherError;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.assignment.spring.constants.Constants.*;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class WeatherErrorHandler {

    private final WeatherErrorMapper errorMapper;

    @ExceptionHandler(value = {WeatherException.class})
    public ResponseEntity<WeatherError> handleWeatherException(WeatherException ex) {
        log.error("Weather Exception Occurred...", ex);
        return new ResponseEntity<>(errorMapper.map(ex.getCode(), ex.getMessage()), ex.getStatusCode());
    }

    @ExceptionHandler(value = {FeignException.class})
    public ResponseEntity<WeatherError> handleFeignException(FeignException ex) {
        log.error("Feign Exception Occurred...", ex);
        return new ResponseEntity<>(errorMapper.map(ERROR_API_CLIENT_CODE, ERROR_API_CLIENT_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<WeatherError> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("Missing Servlet Request Parameter Exception Occurred...", ex);
        return new ResponseEntity<>(errorMapper.map(ERROR_API_BAD_REQUEST_CODE, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<WeatherError> handleException(Exception ex) {
        log.error("Exception Occurred...", ex);
        return new ResponseEntity<>(errorMapper.map(ERROR_CODE_UNHANDLED, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
