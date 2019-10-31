package com.jacky;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
public class TestChooseServer {
    public static void main(String[] args) {
        //创建负载均衡器
        BaseLoadBalancer lb=new BaseLoadBalancer();
        //添加服务器
        List<Server> servers=new ArrayList<>();
        servers.add(new Server("localhost",9001));
        servers.add(new Server("localhost",9002));
        lb.addServers(servers);
        for (int i = 0; i < 6; i++) {
            Server server = lb.chooseServer(null);
            System.out.println(server);

        }

    }
}
