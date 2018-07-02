package com.warren123.spring.cloud.weather.service.impl;

import com.warren123.spring.cloud.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService{

    /**
     * 外部API接口
     */
    private static final String WATHER_API = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 接口状态
     */
    private  static final Integer API_STATUS = 200;

    /**
     * 缓存时间
     */
    private static final Long  TIME_OUT = 1800L;

    private Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();


    @Override
    public void weatherDataSync(String cityName) {
        String url = WATHER_API+"city="+cityName;
        saveWeatherData(url);
    }

    /**
     * 把天气数据缓存
     * @param url
     */
    private void saveWeatherData(String url) {
        ResponseEntity<String> repString = restTemplate.getForEntity(url, String.class);
        if (repString.getStatusCodeValue() == API_STATUS){
           ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

           ops.set(url, repString.getBody(), TIME_OUT, TimeUnit.SECONDS);
           log.info("{}:{} 缓存更新结束",url,repString.getBody());
        }
    }

}
