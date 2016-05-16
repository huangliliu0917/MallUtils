/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by allan on 5/16/16.
 */
@Entity
@Table(name = "Mall_UserLevel")
@Setter
@Getter
@Cacheable(false)
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UL_ID")
    private Integer id;
    @Column(name = "UL_Level")
    private int level;
    @Column(name = "UL_LevelName")
    private String levelName;
    @Column(name = "UL_CustomerID")
    private int customerId;
    @Column(name = "UL_Type")
    private int type;
}
