/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.entity.support;

import com.alibaba.fastjson.JSON;
import com.huotu.mallutils.service.model.DisRebateDesc;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

/**
 * Created by allan on 6/22/16.
 */
@Converter(autoApply = true)
public class DisRebateDescConverter implements AttributeConverter<List<DisRebateDesc>, String> {
    @Override
    public String convertToDatabaseColumn(List<DisRebateDesc> attribute) {
        return JSON.toJSONString(attribute);
    }

    @Override
    public List<DisRebateDesc> convertToEntityAttribute(String dbData) {
        if (StringUtils.isEmpty(dbData)) {
            return null;
        }
        return JSON.parseArray(dbData, DisRebateDesc.class);
    }
}
