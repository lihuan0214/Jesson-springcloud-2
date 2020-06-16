package com.xiangxue.jack.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiangxue.jack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lihuan 1000 000 000
 * @create 2020-05-26 9:04
 */
@Service
public class UserServiceImpl implements UserService {
    @HystrixCommand(fallbackMethod = "listUserSecond",
            commandKey = "listUser",
            groupKey = "querygroup-one",
            commandProperties = {
                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "10"),
//                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100000")
            }
//            ,threadPoolKey = "listUserHystrixJackPool", threadPoolProperties = {
//            @HystrixProperty(name = "coreSize", value = "10")
//            }
    )
    @Override
    public String listUser() {
        System.out.println("==========>>" + Thread.currentThread().getName() + "，调用listUser接口");
        String result = restTemplate.getForObject("http://" + SERVICE_NAME + "/listUser", String.class);
        return result;
    }


    public static String SERVICE_NAME = "micro-order";

    @Autowired
    private RestTemplate restTemplate;

    public String listUserSecond() {
        System.out.println("===================进入服务降级方法==================");
        return null;
    }
}
