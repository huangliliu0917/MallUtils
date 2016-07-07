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
import com.huotu.mallutils.service.entity.config.DeliveryType;
import com.huotu.mallutils.service.entity.config.DesignatedAreaTemplate;
import com.huotu.mallutils.service.entity.config.FreightTemplate;
import com.huotu.mallutils.service.repository.config.DesignatedAreaTemplateRepository;
import com.huotu.mallutils.service.repository.config.FreightTemplateRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created by allan on 7/7/16.
 */
public class FreightTemplateServiceTest extends ServiceTestBase {
    @Autowired
    private FreightTemplateService freightTemplateService;
    @Autowired
    private FreightTemplateRepository freightTemplateRepository;
    @Autowired
    private DesignatedAreaTemplateRepository designatedAreaTemplateRepository;

    @Test
    @Rollback(false)
    public void testSave() throws Exception {
        FreightTemplate freightTemplate = new FreightTemplate();
        freightTemplate.setName(UUID.randomUUID().toString());


        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setFreightTemplate(freightTemplate);


        DesignatedAreaTemplate designatedAreaTemplate = new DesignatedAreaTemplate();
        designatedAreaTemplate.setDeliveryType(deliveryType);

        deliveryType.setDesignatedAreaTemplates(Arrays.asList(designatedAreaTemplate));

        freightTemplate.setDeliveryTypes(Arrays.asList(deliveryType));

        freightTemplate = freightTemplateRepository.saveAndFlush(freightTemplate);

        FreightTemplate freightTemplate1 = new FreightTemplate();
        freightTemplate1.setId(freightTemplate.getId());

        DeliveryType deliveryType1 = new DeliveryType();
        deliveryType1.setFreightTemplate(freightTemplate);
        deliveryType1.setId(deliveryType.getId());

        freightTemplate1.setDeliveryTypes(Arrays.asList(deliveryType1));

        freightTemplate1 = freightTemplateRepository.saveAndFlush(freightTemplate1);
    }

    @Test
    @Rollback(false)
    public void testFindByCustomerId() throws Exception {

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