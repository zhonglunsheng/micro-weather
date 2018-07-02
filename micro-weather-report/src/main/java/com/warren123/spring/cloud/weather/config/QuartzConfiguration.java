package com.warren123.spring.cloud.weather.config;

import com.warren123.spring.cloud.weather.quartz.WeatherDataSyncQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QuartzConfiguration class
 *
 * @author zhonglunsheng
 * @date 2018/7/2
 * @time 10:24
 */
@Configuration
public class QuartzConfiguration {

    /**
     * 更新频率
     */
    private static final int TIME = 1800;

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncQuartz.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }


    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}

