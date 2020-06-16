package com.xiangxue.jack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lihuan
 * @create 2020-05-26 8:11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationDemo.class, args);
    }
}
