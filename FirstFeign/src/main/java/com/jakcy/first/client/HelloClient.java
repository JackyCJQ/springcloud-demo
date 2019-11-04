package com.jakcy.first.client;

import feign.RequestLine;

/**
 * @Authror jacky
 * @create 2019-11-04
 */
public interface HelloClient {
    @RequestLine("GET /hello")
    String SayHello();
}
