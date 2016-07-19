/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.user.impl;

import com.hot.datacenter.entity.client.UserLevel;
import com.hot.datacenter.repository.client.UserLevelRepository;
import com.huotu.mallutils.service.service.user.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by allan on 5/16/16.
 */
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private UserLevelRepository levelRepository;

    @Override
    public List<UserLevel> findByCustomerId(int customerId) {
        return levelRepository.findByCustomerId(customerId);
    }

    @Override
    public List<UserLevel> findByCustomerIdWithOrder(int customerId) {
        List<UserLevel> levels = findByCustomerId(customerId);

        List<UserLevel> results = new ArrayList<>();
        List<UserLevel> userLevelList = levels.stream().filter(level -> level.getType() == 0).collect(Collectors.toList());
        List<UserLevel> buddyLevelList = levels.stream().filter(level -> level.getType() == 1).collect(Collectors.toList());
        results.addAll(buddyLevelList);
        results.addAll(userLevelList);
        return results;
    }
}
