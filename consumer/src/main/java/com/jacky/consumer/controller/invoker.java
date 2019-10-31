package com.jacky.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@RestController
public class invoker {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/router", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        /**
         * 当provider-service启动多个实例的时候，就会进行轮询
         *{"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         *{"id":1,"name":"jacky","age":30,"message":"http://localhost:9002/person/1"}
         *{"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         *{"id":1,"name":"jacky","age":30,"message":"http://localhost:9002/person/1"}
         *{"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         *{"id":1,"name":"jacky","age":30,"message":"http://localhost:9002/person/1"}
         */
        String json = restTemplate.getForObject("http://provider-service/person/1", String.class);
        //如果RestTemplate去掉@@LoadBalanced修饰就不能直接调用http://provider-service/person/1，需要指定具体ip
//        String json = restTemplate.getForObject("http://localhost:9001/person/1", String.class);

        return json;
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service() {
        List<ServiceInstance> instances = getServiceInstances();
        for (ServiceInstance service : instances) {

            EurekaDiscoveryClient.EurekaServiceInstance esi = (EurekaDiscoveryClient.EurekaServiceInstance) service;
            InstanceInfo info = esi.getInstanceInfo();
            System.out.println(info.getAppName() + "---" + info.getInstanceId() + "---" + info.getStatus());
            //获取携带的元数据
            if (info.getAppName().equalsIgnoreCase("PROVIDER-SERVICE")) {
                System.out.println("name:" + info.getMetadata().get("name"));

            }
        }
        return "";
    }

    private List<ServiceInstance> getServiceInstances() {

        List<String> ids = discoveryClient.getServices();
        List<ServiceInstance> result = new ArrayList<>();

        for (String id : ids) {
            List<ServiceInstance> instances = discoveryClient.getInstances(id);
            result.addAll(instances);
        }
        return result;
    }


}
