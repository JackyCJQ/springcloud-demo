package com.jacky.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@RestController
public class HealthController {

    public static boolean canVisitDb = false;

    @RequestMapping(value = "/db/{canVisitDb}")
    public String setConnectState(@PathVariable("canVisitDb") Boolean canVisitDb) {
        HealthController.canVisitDb = canVisitDb;
        return "当前数据库的状态为：" + HealthController.canVisitDb;
    }

}
