package com.jacky;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
public class TestRibbon {

    public static void main(String[] args) throws Exception {

        ConfigurationManager.getConfigInstance().setProperty("provider-service.ribbon.listOfServers", "localhost:9001,localhost:9002");
        ConfigurationManager.getConfigInstance().setProperty("provider-service.ribbon.NFLoadBalancerRuleClassName", MyRule.class.getName());
        RestClient client = (RestClient) ClientFactory.getNamedClient("provider-service");
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
        for (int i = 0; i < 6; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            String result = response.getEntity(String.class);
            System.out.println(result);
        }
        /**
         * 打印的结果
         *
         * {"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         * {"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         * {"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         * {"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         * {"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         * {"id":1,"name":"jacky","age":30,"message":"http://localhost:9001/person/1"}
         */
    }
}
