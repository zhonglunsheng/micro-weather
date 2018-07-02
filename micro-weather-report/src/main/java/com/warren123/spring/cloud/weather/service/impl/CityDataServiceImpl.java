package com.warren123.spring.cloud.weather.service.impl;

import com.warren123.spring.cloud.weather.pojo.City;
import com.warren123.spring.cloud.weather.service.CityDataService;
import com.warren123.spring.cloud.weather.util.XmlBuilder;
import com.warren123.spring.cloud.weather.vo.CityListVo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * CityDataServiceImpl class
 *
 * @author zhonglunsheng
 * @date 2018/7/2
 * @time 9:38
 */
@Service("cityDataService")
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> getCityList() throws Exception{
        Resource resource = new ClassPathResource("citylist.xml");
        StringBuffer sb = new StringBuffer();
        String line;
        BufferedReader buf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        while((line = buf.readLine()) !=  null ){
            sb.append(line);
        }
        buf.close();

        CityListVo cityListVo = (CityListVo) XmlBuilder.xmlStrToObject(CityListVo.class, sb.toString());
        return cityListVo.getCityList();
    }
}
