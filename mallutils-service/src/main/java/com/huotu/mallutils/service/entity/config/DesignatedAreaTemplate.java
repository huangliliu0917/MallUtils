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
 * 指定地区运费模板
 * Created by allan on 7/7/16.
 */
@Entity
@Table(name = "Mall_DesignatedArea_Template")
@Setter
@Getter
public class DesignatedAreaTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Freight_Template_Id", referencedColumnName = "Id")
    private FreightTemplate freightTemplate;
    /**
     * 配送至
     */
    @Lob
    @Column(name = "Area_Desc")
    private String areaDesc;
    /**
     * 配送地区代码集合
     * |100000|100001|
     */
    @Lob
    @Column(name = "AreaId_Group")
    private String areaIdGroup;
    /**
     * 几件内或者多少重内,根据计价方式
     */
    @Column(name = "First_Item")
    private int firstItem;
    /**
     * 对应firstItem的运费
     */
    @Column(name = "First_Freight")
    private double firstFreight;
    /**
     * 每增加几件或者多少重,根据计价方式
     */
    @Column(name = "Next_Item")
    private int nextItem;
    /**
     * 对应nextItem的运费
     */
    @Column(name = "Next_Freight")
    private int nextFreight;
}
