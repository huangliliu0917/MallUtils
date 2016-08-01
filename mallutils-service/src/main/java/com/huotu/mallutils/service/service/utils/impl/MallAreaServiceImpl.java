/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.utils.impl;

import com.hot.datacenter.entity.MallAreaData;
import com.hot.datacenter.service.AbstractCrudService;
import com.huotu.mallutils.service.service.utils.MallAreaService;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by allan on 8/1/16.
 */
public class MallAreaServiceImpl extends AbstractCrudService<MallAreaData, String, Void> implements MallAreaService {

    @Override
    public Specification<MallAreaData> specification(Void aVoid) {
        return null;
    }
}
