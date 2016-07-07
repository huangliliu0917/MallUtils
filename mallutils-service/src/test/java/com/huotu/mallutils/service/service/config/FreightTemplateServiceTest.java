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
import com.huotu.mallutils.service.entity.config.DesignatedAreaTemplate;
import com.huotu.mallutils.service.entity.config.FreightTemplate;
import com.huotu.mallutils.service.repository.config.DesignatedAreaTemplateRepository;
import com.huotu.mallutils.service.repository.config.FreightTemplateRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void testSave() throws Exception {
        //一个模板
        FreightTemplate freightTemplate = new FreightTemplate();
        freightTemplate.setCustomerId(296);
        freightTemplate.setName(UUID.randomUUID().toString());

        DesignatedAreaTemplate designatedAreaTemplate = new DesignatedAreaTemplate();
        designatedAreaTemplate.setFreightTemplate(freightTemplate);
        DesignatedAreaTemplate designatedAreaTemplate1 = new DesignatedAreaTemplate();
        designatedAreaTemplate1.setFreightTemplate(freightTemplate);
        freightTemplate.setDesignatedAreaTemplates(Arrays.asList(designatedAreaTemplate, designatedAreaTemplate1));

//        freightTemplate = freightTemplateRepository.saveAndFlush(freightTemplate);

        freightTemplate = freightTemplateRepository.findOne((long) 3);
        freightTemplate.getDesignatedAreaTemplates().remove(0);
        freightTemplateRepository.saveAndFlush(freightTemplate);
        System.out.println("end");
    }

    @Test
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