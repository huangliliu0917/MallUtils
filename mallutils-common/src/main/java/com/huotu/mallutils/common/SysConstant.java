/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * Created by allan on 5/16/16.
 */
@Configuration
public class SysConstant {
    public static final int DEFAULT_PAGE_INDEX = 20;
    public static String HUOBANMALL_LOGIN;
    public static String SUPPLIER_LOGIN;
    public static String Agent_SHOP_LOGIN;

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        HUOBANMALL_LOGIN = environment.getProperty("huobanmall_login", "http://login.huobanplus.com");
        SUPPLIER_LOGIN = environment.getProperty("supplier_login", "http://gys.huobanplus.com");
        Agent_SHOP_LOGIN = environment.getProperty("agent_shop_login", "http://localhost:8080");
    }
}
