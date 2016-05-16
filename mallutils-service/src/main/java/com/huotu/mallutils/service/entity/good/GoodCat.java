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

/**
 * Created by allan on 5/16/16.
 */
@Entity
@Table(name = "Mall_Goods_Cat")
@Setter
@Getter
@Cacheable(false)
public class GoodCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cat_Id")
    private Integer catId;
    @Column(name = "Parent_Id")
    private int parentId;
    @Column(name = "Supplier_Id")
    private int supplierId;
    @Column(name = "Supplier_Cat_Id")
    private int supplierCatId;
    @Column(name = "Cat_Path")
    private String catPath;
    @Column(name = "Is_Leaf")
    private int isLeaf;
    @Column(name = "Type_Id")
    private int typeId;
    @Column(name = "Cat_Name")
    private String catName;
    @Column(name = "Disabled")
    private int disabled;
    @Column(name = "P_Order")
    private int pOrder;
    @Column(name = "Goods_Count")
    private int goodsCount;
    @Column(name = "Tabs")
    private String tabs;
    @Column(name = "Finder")
    private String finder;
    @Column(name = "Addon")
    private String addon;
    @Column(name = "Child_Count")
    private int childCount;
    @Column(name = "Customer_Id")
    private int customerId;
    @Column(name = "Cat_Pic")
    private String catPic;

    public int getCatDepth() {
        return catPath.substring(1, catPath.length() - 1).split("\\|").length;
    }

    public String space() {
        int catDepth = getCatDepth();
        String space = "--";
        for (int i = 0; i < catDepth; i++) {
            space += space;
        }
        return space;
    }
}
