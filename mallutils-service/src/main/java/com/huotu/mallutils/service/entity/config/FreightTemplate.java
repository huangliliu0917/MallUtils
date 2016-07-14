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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 运费模板实体
 * Created by allan on 7/7/16.
 */
@Entity
@Table(name = "Mall_Freight_Template")
@Setter
@Getter
public class FreightTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    /**
     * 模板名称
     */
    @Column(name = "Name")
    private String name;
    /**
     * 是否包邮
     * 0:买家承担运费
     * 1:卖家承担运费
     */
    @Column(name = "Is_ShippingFree")
    private int isShippingFree;
    /**
     * 计价方式
     * 0:按件计价
     * 1:按重计价
     */
    @Column(name = "Valuation_Way")
    private int valuationWay;
    /**
     * 商户ID
     */
    @Column(name = "Customer_Id", updatable = false)
    private int customerId;

    /**
     * 商户类型
     * 0:伙伴商城
     * 1:供应商
     * 2:代理商
     */
    @Column(name = "Template_Type", updatable = false)
    private int freightTemplateType;

    @Column(name = "Is_Default", updatable = false)
    private boolean isDefault;
    /**
     * 模板说明
     */
    @Column(name = "Template_Desc")
    private String description;

    @OneToMany(mappedBy = "freightTemplate", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<FreightTemplateDetail> freightTemplateDetails = new ArrayList<>();


    /**
     * 得到指定运送方式的默认运费设置
     *
     * @return
     */
    public List<FreightTemplateDetail> defaultDetails() {
//        if (freightTemplateDetails == null) {
//            return new ArrayList<>();
//        }
        return freightTemplateDetails.stream()
                .filter(p -> p.getIsDefault() == 1)
                .collect(Collectors.toList());
    }

    public List<FreightTemplateDetail> designatedDetails(DeliveryTypeEnum deliveryType) {
//        if (freightTemplateDetails == null) {
//            return new ArrayList<>();
//        }
        return freightTemplateDetails.stream()
                .filter(p -> p.getIsDefault() == 0 && p.getDeliveryType() == deliveryType)
                .collect(Collectors.toList());
    }
}
