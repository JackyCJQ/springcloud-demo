package com.jacky;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Authror jacky
 * @create 2019-10-31
 */
public class rest {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i = 0; i < 6; i++) {
            //调用get方法请求服务
            HttpGet httpGet = new HttpGet("http://localhost:10001/router");
            //获取相应
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
