package com.xiangxue.jack.health;

import com.xiangxue.jack.controller.UserControlller;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

/**
 * @author lihuan
 * @create 2020-05-26 21:34
 */
@Configuration
public class MicroOrderHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (UserControlller.canVisitDb)
            return new Health.Builder(Status.UP).build();
        else
            return new Health.Builder(Status.DOWN).build();
    }
}
