package com.jakcy.first.client.inter;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @Authror jacky
 * @create 2019-11-05
 */
public class myInter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("name", "jacky");

    }
}
