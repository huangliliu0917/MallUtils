/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.config;

import com.hot.datacenter.config.DataCenterConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by allan on 5/15/16.
 */
@Configuration
@ComponentScan(basePackages = "com.huotu.mallutils.service")
@EnableJpaRepositories(
        basePackages = "com.huotu.mallutils.service.repository"
)
@Import(DataCenterConfig.class)
@ImportResource({"classpath:datasource_prod.xml", "classpath:datasource_test.xml"})
public class ServiceConfig {

}
