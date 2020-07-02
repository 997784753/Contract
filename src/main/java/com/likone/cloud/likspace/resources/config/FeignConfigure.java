package com.likone.cloud.likspace.resources.config;


import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @project: likSpace
 * @Auther: 颜涛
 * @Date: 2019/4/20 23:36
 * @Description: Feign超时时间设置,开启重试机制，默认为5次（包含首次请求）
 */
@Configuration
public class FeignConfigure {
    public static int connectTimeOutMillis = 2000;// 连接超时
    public static int readTimeOutMillis = 30000; //响应超时 这里的响应时间与配置文件中的超时时间谁的值小已哪个为准!!
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }
    //自定义重试次数 关闭不需要重复调用
    @Bean
    @Primary
    public Retryer feignRetryer() {
        //自定义
//        Retryer retryer = new Retryer.Default(100, 1000, 4);
//        return new Retryer.Default();
        return Retryer.NEVER_RETRY;
    }

    //日志
//    @Bean
//    Logger.Level.feignLoggerLevel(){
//        return Logger.Level.FULL;
//    }
}
