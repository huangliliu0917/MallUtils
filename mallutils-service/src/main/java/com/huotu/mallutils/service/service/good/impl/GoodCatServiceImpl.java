/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good.impl;

import com.huotu.mallutils.service.entity.good.GoodCat;
import com.huotu.mallutils.service.repository.good.GoodCatRepository;
import com.huotu.mallutils.service.service.good.GoodCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by allan on 5/16/16.
 */
@Service
public class GoodCatServiceImpl implements GoodCatService {
    @Autowired
    private GoodCatRepository goodCatRepository;

    @Override
    public List<GoodCat> findByCustomerId(int customerId) {
        List<GoodCat> result = new ArrayList<>();
        List<GoodCat> allCate = goodCatRepository.findByCustomerId(customerId);
        List<GoodCat> roots = allCate.stream().filter(p -> p.getParentId() == 0).collect(Collectors.toList());
        for (GoodCat root : roots) {
            //找孩子
            result.add(root);
            findChild(result, root.getCatId(), allCate);
        }
        return result;
    }

    private void findChild(List<GoodCat> result, int parentId, List<GoodCat> allCate) {
        List<GoodCat> children = allCate.stream().filter(p -> p.getParentId() == parentId).collect(Collectors.toList());
        for (GoodCat child : children) {
            result.add(child);
            findChild(result, child.getCatId(), allCate);
        }
    }
}
