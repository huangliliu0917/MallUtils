/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good.impl;

import com.hot.datacenter.entity.good.Product;
import com.hot.datacenter.service.AbstractCrudService;
import com.huotu.mallutils.service.service.good.ProductService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


/**
 * Created by allan on 5/16/16.
 */
@Service
public class ProductServiceImpl extends AbstractCrudService<Product, Long, Void> implements ProductService {
    @Override
    public Specification<Product> specification(Void aVoid) {
        return null;
    }
}
