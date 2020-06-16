package com.xiangxue.jack.controller;

import com.xiangxue.jack.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihuan
 * @create 2020-05-26 8:30
 */
@Slf4j
@RestController
public class UserControlller {

    @Autowired
    private UserService userService;

    @RequestMapping("/listUser")
    public String listUser() {
        log.info("==================micro-web == I am comming in listUser interface======================");
        return userService.listUser();
    }
}
