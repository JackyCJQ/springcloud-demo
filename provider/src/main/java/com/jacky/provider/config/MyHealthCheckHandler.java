package com.jacky.provider.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Eureka中会启动一个定时器，定时刷新本地实例的信息，并且执行处理器中的getStatus方法，再将服务实例的状态更新到服务器中。
 * 默认30秒执行一次。
 *
 * @Authror jacky
 * @create 2019-10-31
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    private MyHealthIndicator indicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = indicator.health().getStatus();
        if (status.equals(Status.UP)) {
            System.out.println("数据库连接正常");
            return InstanceInfo.InstanceStatus.UP;
        } else {
            System.out.println("数据库无法连接");
            return InstanceInfo.InstanceStatus.DOWN;

        }
    }
}
