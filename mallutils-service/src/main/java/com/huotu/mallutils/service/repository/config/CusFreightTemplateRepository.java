/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.repository.config;

import com.hot.datacenter.repository.config.FreightTemplateRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by allan on 7/7/16.
 */
@Repository
public interface CusFreightTemplateRepository extends FreightTemplateRepository {
    @Query("update FreightTemplate set isDefault=false where customerId=?1 and isDefault=true ")
    @Modifying
    void removeDefaultTemplate(int customerId);

    @Query("update FreightTemplate set isDefault=true where id=?1")
    @Modifying
    void setDefault(long id);

    @Query("select good.freightTemplate.id,count(good) from Good good " +
            "where good.freightTemplate is not null and good.customerId=?1 " +
            "group by good.freightTemplate")
    List<long[]> freightTemplateUsedInfo(int customerId);

    @Query("select count(good) from Good good where good.freightTemplate.id=?1")
    long isUsed(long id);
}
