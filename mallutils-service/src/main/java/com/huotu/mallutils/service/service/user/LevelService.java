/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.user;

import com.hot.datacenter.entity.client.UserLevel;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
public interface LevelService {
    List<UserLevel> findByCustomerId(int customerId);

    /**
     * 得到等级列表,先普通会员,在小伙伴的排序
     *
     * @param customerId
     * @return
     */
    List<UserLevel> findByCustomerIdWithOrder(int customerId);
}
