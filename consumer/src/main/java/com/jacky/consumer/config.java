package com.jacky.consumer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@Configuration
public class config {

    /**
     * restTemplate主要用来调用rest服务，本身不具备调用分布式服务的能力，但是RestTemplate的bean
     * 被@LoadBalanced注解修饰后，这个RestTemplate实例就具有访问分布式服务的能力。
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
