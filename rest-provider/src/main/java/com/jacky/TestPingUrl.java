package com.jacky;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authror jacky
 * @create 2019-11-03
 */
public class TestPingUrl {
    public static void main(String[] args) throws Exception {

        //创建负载均衡器
        BaseLoadBalancer lb = new BaseLoadBalancer();
        //添加服务器
        List<Server> servers = new ArrayList<>();
        //8080端口正常
        servers.add(new Server("localhost", 8761));
        //一个不存在的端口
        servers.add(new Server("localhost", 8088));
        lb.addServers(servers);
        //设置IPing实现类
        lb.setPing(new PingUrl());
        //设置ping的时间间隔为2秒
        lb.setPingInterval(2);
        Thread.sleep(6000);
        for (Server server : lb.getAllServers()) {
            System.out.println(server.getHostPort() + ",状态：" + server.isAlive());
        }
        /**
         * 打印的结果
         * localhost:8761,状态：true
         * localhost:8088,状态：false
         */

    }
}
