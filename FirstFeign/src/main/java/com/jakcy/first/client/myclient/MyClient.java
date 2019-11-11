package com.jakcy.first.client.myclient;

import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

/**
 * @Authror jacky
 * @create 2019-11-05
 */
public class MyClient implements Client {
    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        System.out.println("这是自定义的feign客户端");
        try {
            //创建一个默认的http客户端
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //获取调用的http方法
            final String method = request.method();
            HttpRequestBase httpRequest = new HttpRequestBase() {
                @Override
                public String getMethod() {
                    return method;
                }
            };
            //设置请求的地址
            httpRequest.setURI(new URI(request.url()));
            CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
            Response response = Response.builder().body(body)
                    .headers(new HashMap<String, Collection<String>>())
                    .status(httpResponse.getStatusLine().getStatusCode())
                    .build();
            return response;

        } catch (Exception e) {
            throw new IOException(e);

        }
    }
}
