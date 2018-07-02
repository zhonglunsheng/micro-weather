package com.warren123.spring.cloud.weather.service;

import com.warren123.spring.cloud.weather.pojo.Weather;


public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);
}
