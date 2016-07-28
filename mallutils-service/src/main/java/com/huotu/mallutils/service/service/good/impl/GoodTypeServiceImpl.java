/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good.impl;

import com.hot.datacenter.entity.good.GoodType;
import com.hot.datacenter.repository.good.GoodTypeRepository;
import com.huotu.mallutils.service.service.good.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by allan on 7/20/16.
 */
@Service
public class GoodTypeServiceImpl implements GoodTypeService {
    @Autowired
    private GoodTypeRepository goodTypeRepository;

    @Override
    public List<GoodType> findByParentStandardType(String parentStandardTypeId) {
        return goodTypeRepository.findByParentStandardTypeIdAndDisabledFalseAndCustomerIdOrderByTOrderAsc(parentStandardTypeId, -1);
    }

    @Override
    public List<GoodType> findRootStandardTypes() {
        return goodTypeRepository.findByParentStandardTypeIdAndDisabledFalseAndCustomerIdOrderByTOrderAsc("0", -1);
    }

    @Override
    public List<GoodType> findByCustomerId(Integer customerId) {
        return goodTypeRepository.findByCustomerIdOrderByTOrderAsc(customerId);
    }
}
