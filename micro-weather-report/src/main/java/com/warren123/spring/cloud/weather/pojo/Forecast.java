package com.warren123.spring.cloud.weather.pojo;

import java.io.Serializable;

/**
 * Forecast class
 *
 * @author zhonglunsheng
 * @date 2018/7/1
 * @time 17:00
 */
public class Forecast implements Serializable{

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
     * 风力
     */
    private String fengli;
    /**
     * 低温
     */
    private String low;

    /**
     * 风向
     */
    private String fengxiang;
    /**
     * 类型
     */
    private String type;
    /**
     * 时间
     */

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

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
