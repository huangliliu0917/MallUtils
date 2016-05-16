/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.entity.good;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by allan on 5/15/16.
 */
@Embeddable
@Setter
@Getter
@Cacheable(false)
public class GoodLvPrice {
    @Column(name = "Level_Id")
    private int levelId;
    @Column(name = "Goods_Id")
    private int goodsId;
    @Column(name = "Customer_Id")
    private int customerId;
    @Column(name = "Price")
    private double price;
    @Column(name = "MaxIntegral")
    private int maxIntegral;
}
