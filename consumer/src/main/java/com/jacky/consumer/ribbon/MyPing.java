package com.jacky.consumer.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @auther
 */
public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("自定义ping类，服务器信息:" + server.getHostPort());
        return true;
    }
}
