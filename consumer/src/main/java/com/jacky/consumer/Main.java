package com.jacky.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@SpringBootApplication
@EnableEurekaClient  //@EnableEurekaClient注解已经包含了@EnableDiscoveryClient的功能，就是本身就具有服务发现的功能
public class Main {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).run(args);
    }
}
