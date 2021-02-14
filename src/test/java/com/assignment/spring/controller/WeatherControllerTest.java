package com.assignment.spring.controller;

import com.assignment.spring.exception.handler.WeatherErrorHandler;
import com.assignment.spring.mapper.WeatherErrorMapper;
import com.assignment.spring.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WeatherController.class)
@ContextConfiguration(classes = WeatherErrorMapper.class)
class WeatherControllerTest {

    @MockBean
    private WeatherService weatherService;

    @Autowired
    private WeatherErrorMapper errorMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setMockMvc() {
        this.mockMvc = standaloneSetup(new WeatherController(weatherService))
                .setControllerAdvice(new WeatherErrorHandler(errorMapper))
                .build();
    }

    @Test
    void getWeather_givenValidParameter_status200ByCallingService() throws Exception {
        mockMvc.perform(get("/weather")
                .param("city", "London"))
                .andExpect(status().isOk());
        verify(weatherService).getWeather("London");
    }

}