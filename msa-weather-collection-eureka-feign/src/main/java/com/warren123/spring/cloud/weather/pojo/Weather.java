package com.warren123.spring.cloud.weather.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Weather class
 *
 * @author zhonglunsheng
 * @date 2018/7/1
 * @time 16:58
 */
public class Weather implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 城市名称
     */
    private String city;
    /**
     * 空气质量
     */
    private String aqi;
    /**
     * 感冒建议
     */
    private String ganmao;
    /**
     * 温度
     */
    private String wendu;
    /**
     * 昨天天气
     */
    private Yeaterday yesterday;
    /**
     * 未来几天预报
     */
    private List<Forecast> forecast;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAqi() {
        return aqi;
    }
    public void setAqi(String aqi) {
        this.aqi = aqi;
    }
    public String getGanmao() {
        return ganmao;
    }
    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }
    public String getWendu() {
        return wendu;
    }
    public void setWendu(String wendu) {
        this.wendu = wendu;
    }
    public Yeaterday getYesterday() {
        return yesterday;
    }
    public void setYesterday(Yeaterday yesterday) {
        this.yesterday = yesterday;
    }
    public List<Forecast> getForecast() {
        return forecast;
    }
    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
