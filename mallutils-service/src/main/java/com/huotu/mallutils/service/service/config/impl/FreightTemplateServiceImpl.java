/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.config.impl;

import com.hot.datacenter.entity.config.FreightTemplate;
import com.hot.datacenter.ienum.ProType;
import com.hot.datacenter.service.AbstractCusCrudService;
import com.huotu.mallutils.service.repository.config.CusFreightTemplateRepository;
import com.huotu.mallutils.service.service.config.FreightTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by allan on 7/7/16.
 */
@Service
public class FreightTemplateServiceImpl extends AbstractCusCrudService<FreightTemplate, Long, Void> implements FreightTemplateService {
    @Autowired
    private CusFreightTemplateRepository freightTemplateRepository;

    @PostConstruct
    private void init() {
        initRepository(FreightTemplate.class);
    }

    @Override
    public Specification<FreightTemplate> specification(Void aVoid) {
        return null;
    }

    @Override
    public List<FreightTemplate> findByCustomerId(int customerId, int freightTemplateType) {
        return freightTemplateRepository.findByCustomerIdAndFreightTemplateType(customerId, freightTemplateType);
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

    public List<long[]> freightTemplateUsedInfo(int customerId, int proType) {
        if (proType == ProType.HUOBAN_MALL.getCode()) {
            return freightTemplateRepository.freightTemplateUsedInfoForCustomer(customerId);
        } else {
            return freightTemplateRepository.freightTempolateUseInfoForSupplier(customerId);
        }
    }

    public boolean isUsed(long id) {
        return freightTemplateRepository.isUsed(id) > 0;
    }
}
