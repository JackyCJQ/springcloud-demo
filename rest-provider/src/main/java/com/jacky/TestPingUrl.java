package com.jacky;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authror jacky
 * @create 2019-11-03
 */
public class TestPingUrl {
    public static void main(String[] args) {


        BaseLoadBalancer lb = new BaseLoadBalancer();
        List<Server> servers = new ArrayList<>();

        servers.add(new Server("localhost", 8080));
        servers.add(new Server("localhost", 8088));

         lb.addServers(servers);



    }
}
