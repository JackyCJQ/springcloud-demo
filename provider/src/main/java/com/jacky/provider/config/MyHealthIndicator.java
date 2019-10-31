package com.jacky.provider.config;

import com.jacky.provider.controller.HealthController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * 自定义健康指示器
 *
 * @Authror jacky
 * @create 2019-10-31
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (HealthController.canVisitDb) {
            return new Health.Builder(Status.UP).build();
        } else {
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
