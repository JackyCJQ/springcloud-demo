package com.jacky.consumer.Feign;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.core.type.MethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import feign.MethodMetadata;

/**
 * @Authror jacky
 * @create 2019-11-05
 */
public class MyContract extends SpringMvcContract {
    protected void processAnnotationOnMethod(MethodMetadata data, Annotation annotation, Method method) {
        super.processAnnotationOnMethod(data, annotation, method);
// 是MyUrl注解才进行处理
        if (MyUrl.class.isInstance(annotation)) {
            // 获取注解的实例
            MyUrl myUrlAnn = method.getAnnotation(MyUrl.class);
            // 获取配置的HTTP方法
            String httpMethod = myUrlAnn.method();
            // 获取服务的url
            String url = myUrlAnn.url();
            // 将值设置到模板中
            data.template().method(httpMethod);
            data.template().append(url);
        }

    }
}
