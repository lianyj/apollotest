package com.example.apollotest.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * 动态数据库
 * Description
 * Create by yanjie14
 * Date 2021/5/31 10:20 上午
 */
@Configuration
@Slf4j
public class DataSourceConfiguration {

    private final static String DATASOURCE_TAG = "db";
    @Autowired
    ApplicationContext context;
    @ApolloConfig(value ="spring.datasource" )
    Config config;
    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource source = new DynamicDataSource();
        source.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, dataSource()));
        return source;
    }
    @ApolloConfigChangeListener(interestedKeyPrefixes = {"spring.datasource","spring.rabbitmq","jedis.pool"})
    public void onChange(ConfigChangeEvent changeEvent) {
        changeEvent.changedKeys().forEach(s -> {
            DynamicDataSource source = context.getBean(DynamicDataSource.class);
            source.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, dataSource()));
            source.afterPropertiesSet();
            log.info("动态切换数据源为：{}", config.getProperty("spring.datasource.url", ""));
        });
    }
    public DataSource dataSource() {
        DataSourceProperties dataSource = new DataSourceProperties();
        dataSource.setUrl(config.getProperty("spring.datasource.url", ""));
        dataSource.setUsername(config.getProperty("spring.datasource.username", ""));
        dataSource.setPassword(config.getProperty("spring.datasource.password", ""));
        dataSource.setDriverClassName(config.getProperty("spring.datasource.driver-class-name", ""));
        return dataSource.initializeDataSourceBuilder().build();
    }
    class DynamicDataSource extends AbstractRoutingDataSource {
        @Override
        protected Object determineCurrentLookupKey() {
            return DATASOURCE_TAG;
        }
    }
}
