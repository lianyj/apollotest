package com.example.apollotest.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName ApplicationConfig
 * Description
 * Create by yanjie14
 * Date 2021/5/31 11:28 上午
 */
@Data
@Component
public class ApplicationConfig {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;
}
