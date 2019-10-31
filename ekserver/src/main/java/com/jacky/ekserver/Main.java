package com.jacky.ekserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@SpringBootApplication
@EnableEurekaServer
public class Main {
    /**
     * 对于启动一个单点服务的启动方式
     *
     * @param args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).run(args);
    }
//    public static void main(String[] args) {
//        //读取从控制台输入的端口，避免端口冲突
//        Scanner scanner = new Scanner(System.in);
//        String profiles = scanner.nextLine();
//        new SpringApplicationBuilder(Main.class).profiles(profiles).run(args);
//    }


}
