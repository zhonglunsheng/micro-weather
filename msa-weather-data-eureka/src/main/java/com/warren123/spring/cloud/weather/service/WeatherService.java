package com.warren123.spring.cloud.weather.service;

import com.warren123.spring.cloud.weather.vo.WeatherResponse;

public interface WeatherService {

    /**
     * 通过城市Id获取数据
     * @param id
     * @return
     */
    WeatherResponse getDataByCityId(String id);

    /**
     * 通过城市名称获取数据
     * @param name
     * @return
     */
    WeatherResponse getDataByCityName(String name);

}
