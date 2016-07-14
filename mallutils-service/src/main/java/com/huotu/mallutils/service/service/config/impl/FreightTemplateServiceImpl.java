/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.config.impl;

import com.huotu.mallutils.service.entity.config.FreightTemplate;
import com.huotu.mallutils.service.repository.config.FreightTemplateRepository;
import com.huotu.mallutils.service.service.config.FreightTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allan on 7/7/16.
 */
@Service
public class FreightTemplateServiceImpl implements FreightTemplateService {
    @Autowired
    private FreightTemplateRepository freightTemplateRepository;

    @Override
    @Transactional
    public FreightTemplate save(FreightTemplate freightTemplate) {
        return freightTemplateRepository.save(freightTemplate);
    }

    @Override
    public List<FreightTemplate> findByCustomerId(int customerId, int freightTemplateType) {
        return freightTemplateRepository.findByCustomerIdAndFreightTemplateType(customerId, freightTemplateType);
    }

    @Override
    public FreightTemplate findById(long id) {
        return freightTemplateRepository.findOne(id);
    }

    @Override
    @Transactional
    public void removeDefaultTemplate(int customerId) {
        freightTemplateRepository.removeDefaultTemplate(customerId);
    }

    @Override
    @Transactional
    public void setDefault(long id, int customerId) {
        //全部设置成非默认
        freightTemplateRepository.removeDefaultTemplate(customerId);
        //设置默认
        freightTemplateRepository.setDefault(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        freightTemplateRepository.delete(id);
    }

    public List<long[]> freightTemplateUsedInfo(int customerId) {
        return freightTemplateRepository.freightTemplateUsedInfo(customerId);
    }

    public boolean isUsed(long id) {
        return freightTemplateRepository.isUsed(id) > 0;
    }
}
