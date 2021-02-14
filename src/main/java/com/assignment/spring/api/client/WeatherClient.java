package com.assignment.spring.api.client;

import com.assignment.spring.api.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "WeatherClient", url = "${weather.api.baseUrl}")
public interface WeatherClient {

    @GetMapping(value = "${weather.api.path}", produces = "application/json")
    WeatherResponse getWeather(@RequestParam(value = "q") String city);

}
