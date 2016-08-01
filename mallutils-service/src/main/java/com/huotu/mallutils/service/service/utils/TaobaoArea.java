/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.utils;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by allan on 8/1/16.
 */
@Data
public class TaobaoArea {
    private String id;
    private String name;
    @JSONField(name = "parent_id")
    private String parentId;
    private int type;
    private String zip;
}
