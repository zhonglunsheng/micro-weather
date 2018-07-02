package com.warren123.spring.cloud.weather.pojo;

import java.io.Serializable;

/**
 * Yeaterday class
 *
 * @author zhonglunsheng
 * @date 2018/7/1
 * @time 17:00
 */
public class Yeaterday implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 时间
     */
    private String date;
    /**
     * 高温
     */
    private String high;
    /**
     * 风向
     */
    private String fx;
    /**
     * 低温
     */
    private String low;

    /**
     * 风力
     */
    private String fl;
    /**
     * 类型
     */
    private String type;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getHigh() {
        return high;
    }
    public void setHigh(String high) {
        this.high = high;
    }
    public String getFx() {
        return fx;
    }
    public void setFx(String fx) {
        this.fx = fx;
    }
    public String getLow() {
        return low;
    }
    public void setLow(String low) {
        this.low = low;
    }
    public String getFl() {
        return fl;
    }
    public void setFl(String fl) {
        this.fl = fl;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
