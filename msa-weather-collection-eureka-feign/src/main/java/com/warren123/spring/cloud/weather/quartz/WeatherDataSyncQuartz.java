package com.warren123.spring.cloud.weather.quartz;

import com.warren123.spring.cloud.weather.pojo.City;
import com.warren123.spring.cloud.weather.service.WeatherService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    WeatherService weatherService;


    private Logger log = LoggerFactory.getLogger(WeatherDataSyncQuartz.class);



    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//ToDo 调用城市列表服务接口
	    List<City> cityList = new ArrayList<>();
		City city = new City();
		city.setCityName("武汉");
		cityList.add(city);
       

        for (City c:
                cityList) {
            if (!StringUtils.isEmpty(c.getCityName())){
                weatherService.weatherDataSync(c.getCityName());
            }

        }

        log.info("天气数据缓存结束");

    }
}
