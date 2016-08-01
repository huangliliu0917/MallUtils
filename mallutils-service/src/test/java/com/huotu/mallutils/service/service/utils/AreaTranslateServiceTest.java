/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.utils;

import com.huotu.mallutils.service.ServiceTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * Created by allan on 8/1/16.
 */
public class AreaTranslateServiceTest extends ServiceTestBase {
    @Autowired
    private AreaTranslateService areaTranslateService;

    @Test
    @Rollback(false)
    public void testTaobaoAreas() throws Exception {
        System.out.println("start");
        areaTranslateService.translateArea();
//        areaTranslateService.translateRegionNode();
//        areaTranslateService.translateAreaToDatabase();
        System.out.println("end");
    }
}