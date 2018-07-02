package com.warren123.spring.cloud.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warren123.spring.cloud.weather.service.WeatherService;
import com.warren123.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
    public WeatherResponse getDataByCityId(String id) {
        if (StringUtils.isEmpty(id)){
            return null;
        }
        String url = WATHER_API+"citykey="+id;
        return this.doGetWeather(url);
    }


    @Override
    public WeatherResponse getDataByCityName(String name) {
        if (StringUtils.isEmpty(name)){
            return null;
        }
        String url = WATHER_API+"city="+name;
        return this.doGetWeather(url);
    }


    private WeatherResponse doGetWeather(String url) {
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse response = null;
        String strBody = null;
        String key = url;

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        //判断缓存是否有数据
        if (stringRedisTemplate.hasKey(key)) {
            log.info("redis has data");
            strBody = ops.get(key);
        } else {
            ResponseEntity<String> repString = restTemplate.getForEntity(url, String.class);

            if (repString.getStatusCodeValue() == API_STATUS) {
                strBody = repString.getBody();
            }
            log.info("redis has no data");
            //缓存数据
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            // Json数据转Object对象
            response = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("Json turn error");
            e.printStackTrace();
        }
        return response;
    }

}
