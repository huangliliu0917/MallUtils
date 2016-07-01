/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.entity.config;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by allan on 6/22/16.
 */
@Entity
@Table(name = "Mall_UserBaseConfig")
@Setter
@Getter
@Cacheable(false)
public class MallBaseConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConfigID")
    private Integer configId;
    @Column(name = "CustomerID")
    private int customerId;
    /**
     * 返利模式
     */
    @Column(name = "RebateCompatible")
    private Integer rebateCompatible;
}
