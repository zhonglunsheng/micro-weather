package com.warren123.spring.cloud.weather.quartz;

import com.warren123.spring.cloud.weather.pojo.City;
import com.warren123.spring.cloud.weather.service.CityDataService;
import com.warren123.spring.cloud.weather.service.WeatherService;
import com.warren123.spring.cloud.weather.vo.WeatherResponse;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * WeatherDataSyncQuartz class
 *
 * @author zhonglunsheng
 * @date 2018/7/2
 * @time 10:02
 */
public class WeatherDataSyncQuartz extends QuartzJobBean{


    @Autowired
    CityDataService cityDataService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private Logger log = LoggerFactory.getLogger(WeatherDataSyncQuartz.class);



    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<City> cityList = null;
        try {
           cityList  = cityDataService.getCityList();
        } catch (Exception e) {
            log.error("获取城市列表失败");
            e.printStackTrace();
        }

        for (City city:
                cityList) {
            if (!StringUtils.isEmpty(city.getCityName())){
                weatherService.weatherDataSync(city.getCityName());
            }

        }

        log.info("天气数据缓存结束");

    }
}
