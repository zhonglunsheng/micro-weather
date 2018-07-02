package com.warren123.spring.cloud.weather.controller;

import com.warren123.spring.cloud.weather.pojo.City;
import com.warren123.spring.cloud.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * WeatherReportController class
 *
 * @author zhonglunsheng
 * @date 2018/7/2
 * @time 10:46
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {


    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) throws Exception {
        model.addAttribute("title", "在线天气预报");
        model.addAttribute("cityId", cityId);
        //ToDO 获取远程服务城市列表
        model.addAttribute("cityList", new ArrayList<City>().add(new City()));
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
