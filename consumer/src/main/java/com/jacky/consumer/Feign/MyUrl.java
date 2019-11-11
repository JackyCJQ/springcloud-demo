package com.jacky.consumer.Feign;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Authror jacky
 * @create 2019-11-05
 */

@Target(METHOD)
@Retention(RUNTIME)
public @interface MyUrl {
    // 定义url与method属性
    String url();

    String method();
}
