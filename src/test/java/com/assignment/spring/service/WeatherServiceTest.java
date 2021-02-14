package com.assignment.spring.service;

import com.assignment.spring.api.client.WeatherClient;
import com.assignment.spring.api.model.WeatherResponse;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.mapper.WeatherEntityMapper;
import com.assignment.spring.repository.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @InjectMocks
    private WeatherService subject;

    @Mock
    private WeatherClient client;

    @Mock
    private WeatherRepository repository;

    @Mock
    private WeatherEntityMapper mapper;

    @Test
    void getWeather_givenCity_callAPIAndSaveEntity() {
        WeatherResponse response = new WeatherResponse();

        when(client.getWeather("some_city")).thenReturn(response);
        when(mapper.map(response)).thenReturn(WeatherEntity.builder().id(1).city("some_city").city("come_country").temperature(2d).build());

        WeatherEntity result = subject.getWeather("some_city");
        WeatherEntity expected = WeatherEntity.builder().id(1).city("some_city").city("come_country").temperature(2d).build();

        assertThat(result, is(equalToObject(expected)));
        verify(client).getWeather("some_city");
        verify(repository).save(WeatherEntity.builder().id(1).city("some_city").city("come_country").temperature(2d).build());
        verify(mapper).map(response);
    }

}