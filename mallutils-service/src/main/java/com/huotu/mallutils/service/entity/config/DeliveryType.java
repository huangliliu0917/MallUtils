/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.entity.config;

import com.huotu.mallutils.service.ienum.DeliveryTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * 运送方式,关联运费模板
 * <p>
 * Created by allan on 7/7/16.
 */
@Entity
@Table(name = "Mall_Delivery_Type")
@Setter
@Getter
public class DeliveryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Freight_Template_Id", referencedColumnName = "Id")
    private FreightTemplate freightTemplate;
    /**
     * 运送方式
     */
    @Column(name = "Delivery_Type")
    private DeliveryTypeEnum deliveryType;
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

    @OneToMany(mappedBy = "deliveryType", orphanRemoval = true, cascade = {CascadeType.PERSIST})
    private List<DesignatedAreaTemplate> designatedAreaTemplates;
}
