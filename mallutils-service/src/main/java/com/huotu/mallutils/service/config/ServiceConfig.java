package com.huotu.mallutils.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by allan on 5/15/16.
 */
@Configuration
@ComponentScan(basePackages = "com.huotu.mallutils.service")
@EnableJpaRepositories(
        basePackages = "com.huotu.mallutils.service.repository"
)
@EnableTransactionManagement
@ImportResource({"classpath:datasource_prod.xml", "classpath:datasource_test.xml"})
public class ServiceConfig {

}
