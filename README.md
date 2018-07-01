> 将原有天气预报系统拆分成四个微服务，通过Spring Cloud服务治理 其中使用Eureka实现服务注册 Zuul实现API网关
Feign实现软负载均衡调用和服务通信 Hystrix实现服务熔断 Spring Cloud Config解决分布式系统配置管理

### 技术选型

技术 | 说明 | 官网
---|---|---
JDK | JDK8 | http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
IDE | Intellij IDEA | https://www.jetbrains.com/idea/
Gradle | 项目自动化构建 | https://gradle.org/
Redis  | 分布式缓存 | https://redis.io/
Quartz | 定时任务 | http://www.quartz-scheduler.org/
Thymeleaf  | 模板引擎 | https://www.thymeleaf.org/
HttpClient | Http客户端 | http://hc.apache.org/httpclient-3.x/
Bootstrap | 前端框架 | https://v3.bootcss.com/
Eureka | 服务注册和发现 |http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html#_service_discovery_eureka_clients
Zuul | API网关 |http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html#netflix-zuul-starter
Feign | 服务通信和负载均衡调用 |http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html#_spring_cloud_openfeign
Config | 分布式系统集中配置 | http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html#_spring_cloud_config_server
Hystrix | 熔断器 | http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html#_how_to_include_hystrix


### 数据流向图
![mark](http://upload.i20forever.cn/blog/180701/jEfaHcmAmm.png?imageslim)


### 微服务架构
![mark](http://upload.i20forever.cn/blog/180701/G7DhLb4FJi.png?imageslim)

### 项目结构包说明

#### 拆分前
服务名称 | 说明
---|---
micro-weather-report | 完整系统


#### 服务拆分

服务名称 | 说明
---|---
micro-weather-eureka-server| 服务注册中心
msa-weather-eureka-client-zuul| API网关
micro-weather-config-server| config服务端
msa-weather-city-eureka| 城市数据API微服务
msa-weather-data-eureka| 天气数据API微服务
msa-weather-collection-eureka-feign| 天气数据采集微服务
msa-weather-report-eureka-feign-gateway-hystrix|天气预报微服务

#### 各个组件说明


#### 启动



#### 界面
