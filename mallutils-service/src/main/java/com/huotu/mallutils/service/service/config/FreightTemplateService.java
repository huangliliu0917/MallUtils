/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.config;

import com.huotu.mallutils.service.entity.config.FreightTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 运费模板实体对应的服务
 * Created by allan on 7/7/16.
 */
public interface FreightTemplateService {
    /**
     * 保存一个运费模板
     *
     * @param freightTemplate 运费模板实体
     * @return
     */
    @Transactional
    FreightTemplate save(FreightTemplate freightTemplate);

    /**
     * 得到对应商户下所有的运费模板
     *
     * @param customerId 商户id
     * @return
     */
    List<FreightTemplate> findByCustomerId(int customerId, int freightTemplateType);

    /**
     * 得到某个模板实体
     *
     * @param id 模板主键id
     * @return
     */
    FreightTemplate findById(long id);

    /**
     * 将商户下所有的运费模板设为非默认,总是在设置默认模板前调用
     *
     * @param customerId 商户id
     */
    @Transactional
    void removeDefaultTemplate(int customerId);

    /**
     * 将某个模板设置成为默认
     *
     * @param id         模板主键id
     * @param customerId 商户id
     */
    @Transactional
    void setDefault(long id, int customerId);

    /**
     * 删除一个模板,只有在此模板未被使用时可调用
     *
     * @param id 模板主键id
     */
    @Transactional
    void delete(long id);

    /**
     * 得到运费模板的使用情况
     * long[]中索引0为模板id,索引1为数量
     *
     * @param customerId
     * @return
     */
    List<long[]> freightTemplateUsedInfo(int customerId, int proType);
    /**
     * 运费是否使用
     *
     * @param id 运费模板主键id
     * @return
     */
    boolean isUsed(long id);
}
