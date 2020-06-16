package com.xiangxue.jack.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author lihuan
 * @create 2020-05-26 8:30
 */
@Slf4j
@RestController
public class UserControlller {

    public static volatile boolean canVisitDb = true;

    @RequestMapping("/listUser")
    public String listUser() {
        log.info("==================I am comming in listUser interface======================");
        return "I am comming in listUser interface";
    }

    @RequestMapping("/db/{can}")
    public boolean setCanVisitDb(@PathVariable boolean can) {
        canVisitDb = can;
        return canVisitDb;
    }
}
