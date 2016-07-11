/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.config;

import com.huotu.mallutils.service.ServiceTestBase;
import com.huotu.mallutils.service.entity.config.FreightTemplate;
import com.huotu.mallutils.service.entity.config.FreightTemplateDetail;
import com.huotu.mallutils.service.ienum.DeliveryTypeEnum;
import com.huotu.mallutils.service.repository.config.FreightTemplateRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

/**
 * Created by allan on 7/7/16.
 */
public class FreightTemplateServiceTest extends ServiceTestBase {
    @Autowired
    private FreightTemplateRepository freightTemplateRepository;

    @Test
    @Rollback(false)
    public void testSave() throws Exception {
        FreightTemplate freightTemplate = new FreightTemplate();
        freightTemplate.setName(UUID.randomUUID().toString());


        FreightTemplateDetail freightTemplateDetail = new FreightTemplateDetail();
        freightTemplateDetail.setFreightTemplate(freightTemplate);
        freightTemplateDetail.setDeliveryType(DeliveryTypeEnum.EXPRESS);
        freightTemplateDetail.setIsDefault(1);

        FreightTemplateDetail freightTemplateDetail1 = new FreightTemplateDetail();
        freightTemplateDetail.setFreightTemplate(freightTemplate);
        freightTemplateDetail1.setDeliveryType(DeliveryTypeEnum.EXPRESS);
        freightTemplateDetail.setIsDefault(0);

//        freightTemplate.setFreightTemplateDetails(Arrays.asList(freightTemplateDetail, freightTemplateDetail1));

        freightTemplate = freightTemplateRepository.saveAndFlush(freightTemplate);
    }

    @Test
    @Rollback(false)
    public void testFindByCustomerId() throws Exception {
        List<FreightTemplate> freightTemplates = freightTemplateRepository.findAll();
    }

    @Test
    public void testRemoveDefaultTemplate() throws Exception {

    }

    @Test
    public void testSetDefault() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}