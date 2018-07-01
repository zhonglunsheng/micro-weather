package com.warren123.spring.cloud.weather.controller;

import com.warren123.spring.cloud.weather.service.WeatherService;
import com.warren123.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/cityId/{id}")
    public WeatherResponse getWeatherByCityId(@PathVariable String id){
        return weatherService.getDataByCityId(id);
    }

    @GetMapping("/cityName/{name}")
    public WeatherResponse getWeatherByCityName(@PathVariable String name){
        return weatherService.getDataByCityName(name);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!";
    }
}
