/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good.impl;

import com.hot.datacenter.entity.good.GoodBrand;
import com.hot.datacenter.repository.good.GoodBrandRepository;
import com.huotu.mallutils.service.service.good.GoodBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by allan on 6/21/16.
 */
@Service
public class GoodBrandServiceImpl implements GoodBrandService {
    @Autowired
    private GoodBrandRepository goodBrandRepository;

    @Override
    public List<GoodBrand> findByCustomerId(int customerId) {
        return goodBrandRepository.findByCustomerId(customerId);
    }
}
