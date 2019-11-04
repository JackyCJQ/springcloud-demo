package com.jacky;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.util.List;

/**
 * @auther
 */
public class TestPingUrlConfig {
    public static void main(String[] args) throws Exception {
        //设置请求的服务器
        ConfigurationManager.getConfigInstance().setProperty("provider-service.ribbon.listOfServers", "localhost:9001,localhost:9002");
        //配置ping处理类
//        ConfigurationManager.getConfigInstance().setProperty("provider-service.ribbon.NFLoadBalancerPingClassName", PingUrl.class.getName());
        //这是自定义的ping实现类
        ConfigurationManager.getConfigInstance().setProperty("provider-service.ribbon.NFLoadBalancerPingClassName", MyPing.class.getName());
        //配置ping的时间间隔
        ConfigurationManager.getConfigInstance().setProperty("provider-service.ribbon.NFLoadBalancerPingInterval", 2);
        //获取rest请求客户端
        RestClient client = (RestClient) ClientFactory.getNamedClient("provider-service");
        Thread.sleep(6000);

        List<Server> servers = client.getLoadBalancer().getAllServers();
        System.out.println(servers.size());

        //输出状态
        for (Server server : servers) {
            System.out.println(server.getHostPort() + ",状态:" + server.isAlive());
        }
    }
}
