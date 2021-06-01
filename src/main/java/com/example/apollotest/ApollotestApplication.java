package com.example.apollotest;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.apollotest.mapper")
@EnableApolloConfig
public class ApollotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApollotestApplication.class, args);
    }

}
