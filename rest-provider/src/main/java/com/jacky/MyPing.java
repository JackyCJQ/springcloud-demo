package com.jacky;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @auther
 */
public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("这是自定义的Ping实现类：" + server.getHostPort());
        return true;
    }
}
