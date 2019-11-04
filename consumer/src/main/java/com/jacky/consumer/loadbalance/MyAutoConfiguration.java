package com.jacky.consumer.loadbalance;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther
 */
@Configuration
public class MyAutoConfiguration {


    @Autowired(required = false)
    @MyLoadBalance
    private List<RestTemplate> myTemplates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton init() {
        System.out.println("这个bean将在容器初始化时创建");
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for (RestTemplate template : myTemplates) {
                    //创建一个自定义的拦截器实例
                    MyInterceptor interceptor = new MyInterceptor();
                    //获取restTemplate原来的拦截器
                    List list = new ArrayList(template.getInterceptors());
                    //添加到拦截器集合
                    list.add(interceptor);
                    //将新的拦截器集合设置到restTemplate
                    template.setInterceptors(list);


                }

            }
        }
    }


}
