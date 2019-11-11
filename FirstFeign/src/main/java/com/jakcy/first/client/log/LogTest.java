package com.jakcy.first.client.log;

import com.jakcy.first.client.HelloClient;
import feign.Feign;
import feign.Logger;

/**
 * @Authror jacky
 * @create 2019-11-05
 */
public class LogTest {
    public static void main(String[] args) {
        //默认实现类java.net.HttpURLConnection
        HelloClient client = Feign.builder()
                .logLevel(Logger.Level.FULL)
                .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                .target(HelloClient.class, "http://localhost:8080/");
        System.out.println(client.SayHello());

    }
}
