/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.config.impl;

import com.hot.datacenter.entity.config.MallBaseConfig;
import com.hot.datacenter.repository.config.MallBaseConfigRepository;
import com.huotu.mallutils.service.service.config.MallBaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by allan on 6/22/16.
 */
@Service
public class MallBaseConfigServiceImpl implements MallBaseConfigService {
    @Autowired
    private MallBaseConfigRepository mallBaseConfigRepository;

    @Override
    public MallBaseConfig findByCustomerId(int customerId) {
        return mallBaseConfigRepository.findByCustomerId(customerId);
    }
}
