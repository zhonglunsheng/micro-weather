package com.warren123.spring.cloud.weather.service;

import com.warren123.spring.cloud.weather.pojo.City;

import java.util.List;

public interface CityDataService {

    /**
     *获取城市列表
     * @return
     * @throws Exception xml解析错误
     */
    List<City> getCityList() throws Exception;
}
