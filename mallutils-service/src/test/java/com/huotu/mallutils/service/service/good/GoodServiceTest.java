/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good;

import com.huotu.mallutils.service.ServiceTestBase;
import com.huotu.mallutils.service.entity.good.Good;
import com.huotu.mallutils.service.repository.config.FreightTemplateRepository;
import com.huotu.mallutils.service.repository.good.GoodRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by allan on 7/4/16.
 */
public class GoodServiceTest extends ServiceTestBase {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    private FreightTemplateRepository freightTemplateRepository;
    @Autowired
    private GoodBrandService goodBrandService;
    @Autowired
    private GoodCatService goodCatService;

    private int mockCustomer = 296;

    @Test
    public void testFindByBrandIdExceptAct() throws Exception {
//        List<GoodBrand> goodBrands = goodBrandService.findByCustomerId(mockCustomer);
//        goodBrands.forEach(goodBrand -> {
//            List<Good> goods = goodService.findByBrandIdExceptAct(goodBrand.getBrandId(), 0);
//            long disabledCount = goods.stream().filter(Good::isDisabled).count();
//            Assert.assertEquals(0, disabledCount);
//        });
//
//        List<GoodCat> goodCatList = goodCatService.findByCustomerId(mockCustomer);
//        goodCatList.forEach(goodCat -> {
//            List<Good> goods = goodService.findByCatIdExceptAct(String.valueOf(goodCat.getCatId()), 0);
//            long disabledCount = goods.stream().filter(Good::isDisabled).count();
//            Assert.assertEquals(0, disabledCount);
//        });

        Page<Good> goods = goodRepository.findAll(new PageRequest(0, 20));

//        List<long[]> objects = freightTemplateRepository.freightTemplateUsedInfo(296);

        System.out.println(111);
    }
}