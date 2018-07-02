package com.warren123.spring.cloud.weather.service;


public interface WeatherService {

    /**
     * 同步天气数据
     * @param cityName
     */
    void weatherDataSync(String cityName);
}
