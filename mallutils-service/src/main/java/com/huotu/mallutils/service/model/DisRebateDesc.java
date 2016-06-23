/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allan on 6/22/16.
 */
@Data
public class DisRebateDesc {
    @JSONField(name = "proid")
    private int proId;
    private double amount;
    @JSONField(name = "iscustom")
    private int isCustom;
    @JSONField(name = "customcfg", deserialize = false)
    private List<String> customCfg = new ArrayList<>();
}
