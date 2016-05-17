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

import javax.persistence.*;
import java.util.Map;

/**
 * Created by allan on 5/15/16.
 */
@Entity
@Table(name = "Mall_Products")
@Setter
@Getter
@Cacheable(false)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private Integer productId;
    @ManyToOne
    @JoinColumn(name = "Goods_Id")
    private Good good;

    /**
     * 规格
     */
    @Column(name = "Pdt_Desc")
    private String standard;

    /**
     * 成本价
     */
    @Column(name = "Cost")
    private double cost;
    /**
     * 销售价
     */
    @Column(name = "Price")
    private double price;
    @Column(name = "Mktprice")
    private double marketPrice;
    @Column(name = "Name")
    private String name;

    /**
     * 用户会员价信息
     */
    @Column(name = "UserPriceInfo")
    private String userPriceInfo;
    /**
     * 用户返利信息
     */
    @Column(name = "UserIntegralInfo")
    private String userIntegralInfo;

    @ElementCollection
    @CollectionTable(
            name = "Mall_Goods_Lv_Price",
            joinColumns = @JoinColumn(name = "Product_Id")
    )
    @MapKey(name = "levelId")
    private Map<Integer, GoodLvPrice> goodLvPriceMap;
}
