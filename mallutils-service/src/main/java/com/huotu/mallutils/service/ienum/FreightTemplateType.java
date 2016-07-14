/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.ienum;

import com.huotu.mallutils.common.ienum.ICommonEnum;

/**
 * Created by allan on 7/14/16.
 */
public enum FreightTemplateType implements ICommonEnum {
    HUOBAN_MALL(0, "伙伴商城"),
    SUPPLIER(1, "供应商"),
    AGENT(2, "代理商");

    private Integer code;
    private String value;

    FreightTemplateType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
