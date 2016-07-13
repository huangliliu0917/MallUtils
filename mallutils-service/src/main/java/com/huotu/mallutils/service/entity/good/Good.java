/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.entity.good;

import com.huotu.mallutils.service.entity.config.FreightTemplate;
import com.huotu.mallutils.service.model.DisRebateDesc;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by allan on 5/15/16.
 */
@Entity
@Table(name = "Mall_Goods")
@Setter
@Getter
@Cacheable(false)
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Goods_Id")
    private Integer goodId;
    @Column(name = "Bn")
    private String barcode;
    @ManyToOne
    @JoinColumn(name = "Cat_Id", referencedColumnName = "Cat_Id")
    private GoodCat goodCat;
    @Column(name = "Brand_Id")
    private int brandId;
    /**
     * 商品简介
     */
    @Column(name = "Brief")
    private String brief;
    @OneToMany(mappedBy = "good")
    private List<Product> products;
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
    /**
     * 市场价
     */
    @Column(name = "Mktprice")
    private double marketPrice;
    @Column(name = "Customer_Id")
    private Integer customerId;
    @Column(name = "Supplier_Id")
    private Integer supplierId;

    /**
     * 运费模板
     */
    @ManyToOne
    @JoinColumn(name = "Freight_Template_Id", referencedColumnName = "Id")
    private FreightTemplate freightTemplate;

    @Column(name = "Name")
    private String name;
    @Column(name = "Disabled")
    private boolean disabled;
    /**
     * 价格等级描述
     */
    @Column(name = "Price_LevelDesc")
    private String priceLevelDesc;

    /**
     * 上架场景
     */
    @Column(name = "Goods_Scenes")
    private int goodScenes;

    @Column(name = "DisRebate_Desc")
    private List<DisRebateDesc> disRebateDescList;

    /**
     * 返利配额
     */
    @Column(name = "RebateQuatoRatio")
    private double rebateQuatoRatio;
}
