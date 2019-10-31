package com.jacky.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
@SpringBootApplication
@EnableEurekaClient
public class Main {
    //单点启动
//    public static void main(String[] args) {
//        new SpringApplicationBuilder(Main.class).run(args);
//    }
    //多个启动
    public static void main(String[] args) {
        //读取从控制台输入的端口，避免端口冲突
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        new SpringApplicationBuilder(Main.class).profiles(file).run(args);
    }

}
