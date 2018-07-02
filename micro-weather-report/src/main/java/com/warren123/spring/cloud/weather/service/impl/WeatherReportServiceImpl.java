package com.warren123.spring.cloud.weather.service.impl;

import com.warren123.spring.cloud.weather.pojo.Weather;
import com.warren123.spring.cloud.weather.service.WeatherReportService;
import com.warren123.spring.cloud.weather.service.WeatherService;
import com.warren123.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("weatherReportService")
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private WeatherService weatherService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = weatherService.getDataByCityId(cityId);
		return resp.getData();
	}

}
