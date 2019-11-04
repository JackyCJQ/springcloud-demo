package com.jacky.demo.loadbalance;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;

/**
 * @auther
 */
public class MyHttpRequest implements HttpRequest {

    private HttpRequest sourceHttpRequest;

    public MyHttpRequest(HttpRequest sourceHttpRequest) {
        this.sourceHttpRequest = sourceHttpRequest;
    }

    @Override
    public HttpMethod getMethod() {
        return sourceHttpRequest.getMethod();
    }

    @Override
    public URI getURI() {
        try {
            String oldUri = sourceHttpRequest.getURI().toString();
            URI newUri = new URI("http://localhost:8080/hello");
            return newUri;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceHttpRequest.getURI();
    }

    @Override
    public HttpHeaders getHeaders() {
        return sourceHttpRequest.getHeaders();
    }
}
