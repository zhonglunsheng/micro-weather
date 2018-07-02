package com.warren123.spring.cloud.weather.controller;

import com.warren123.spring.cloud.weather.pojo.City;
import com.warren123.spring.cloud.weather.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CityController class
 *
 * @author zhonglunsheng
 * @date 2018/7/2
 * @time 15:31
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityDataService cityDataService;

    @GetMapping("/list")
    public List<City> list() throws Exception {
        return cityDataService.getCityList();
    }
}
