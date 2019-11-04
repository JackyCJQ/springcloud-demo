package com.jacky.consumer.loadbalance;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @auther
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("自定义拦截器");
        System.out.println("原来的url:" + httpRequest.getURI());
        //换成新的请求对象
        MyHttpRequest myHttpRequest = new MyHttpRequest(httpRequest);
        System.out.println("拦截后新的URI:" + httpRequest.getURI());
        return clientHttpRequestExecution.execute(myHttpRequest, bytes);
    }
}
