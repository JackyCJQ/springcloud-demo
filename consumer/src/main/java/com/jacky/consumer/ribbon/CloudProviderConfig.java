package com.jacky.consumer.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @auther
 */
@RibbonClient(name = "provider-service",configuration = MyConfig.class)
public class CloudProviderConfig {
}
