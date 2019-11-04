package com.jacky.consumer.ribbon;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther
 */
@RestController
@Configuration
public class InvokerController {

    /**
     * RestTemplate是spring-web项目中的一个Rest客户端，本身不具有负载均衡的功能。在springcloud中，使用@LoadBalanced修饰的RestTemplate,
     * 在Spring容器启动时，会为这些被修饰过的RestTemplate添加拦截器，在拦截器里里面使用了LoadBalancerClient来处理请求，LoadBalancerClient
     * 本来就是Sring封装的负载均衡客户端，通过这样的间接处理，使得RestTemplate拥有了负载均衡的能力
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 每次调用结果都只是调用同一个url,因为改变了rule
     *
     * @return
     */
    @RequestMapping(value = "/router1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        String json = getRestTemplate().getForObject("http://provider-service/person/1", String.class);
        return json;
    }

    //直接使用SpringCloud封装好的client
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @RequestMapping(value = "/uselb", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceInstance uselb() {

        ServiceInstance instance = loadBalancerClient.choose("provider-service");
        return instance;
    }

    //直接使用ribbon的API
    @Autowired
    private SpringClientFactory factory;

    @RequestMapping(value = "/defaultValue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private String defaultValue() {

        System.out.println("输出默认配置");
        ZoneAwareLoadBalancer loadBalancer = (ZoneAwareLoadBalancer) factory.getLoadBalancer("default");
        System.out.println("IClientConfig:" + factory.getLoadBalancer("default").getClass().getName());
        System.out.println("IRule:" + loadBalancer.getRule().getClass().getName());
        System.out.println("IPing:" + loadBalancer.getPing().getClass().getName());
        System.out.println("ServerList:" + loadBalancer.getServerListImpl().getClass().getName());
        System.out.println("ILoadBalancer:" + loadBalancer.getClass().getName());
        System.out.println("PingInterval:" + loadBalancer.getPingInterval());
        //获取provider-service的配置
        System.out.println("输出provider-service配置");
        ZoneAwareLoadBalancer loadBalancer1 = (ZoneAwareLoadBalancer) factory.getLoadBalancer("provider-service");
        System.out.println("IClientConfig:" + factory.getLoadBalancer("default").getClass().getName());
        System.out.println("IRule:" + loadBalancer1.getRule().getClass().getName());
        System.out.println("IPing:" + loadBalancer1.getPing().getClass().getName());
        System.out.println("ServerList:" + loadBalancer1.getServerListImpl().getClass().getName());
        System.out.println("ILoadBalancer:" + loadBalancer1.getClass().getName());
        System.out.println("PingInterval:" + loadBalancer1.getPingInterval());

        return "";

    }


}
