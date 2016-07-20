/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good;

import com.hot.datacenter.entity.good.GoodType;

import java.util.List;

/**
 * Created by allan on 7/20/16.
 */
public interface GoodTypeService {
    /**
     * 根据父类目id得到子类目列表
     *
     * @param parentStandardTypeId
     * @return
     */
    List<GoodType> findByParentStandardType(String parentStandardTypeId);

    /**
     * 得到根类目
     *
     * @return
     */
    List<GoodType> findRootStandardTypes();

    /**
     * 得到某个商户的商品类型列表
     *
     * @param customerId
     * @return
     */
    List<GoodType> findByCustomerId(Integer customerId);
}
