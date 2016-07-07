/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.repository.config;

import com.huotu.mallutils.service.entity.config.FreightTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by allan on 7/7/16.
 */
@Repository
public interface FreightTemplateRepository extends JpaRepository<FreightTemplate, Long> {
    List<FreightTemplate> findByCustomerId(int customerId);

    @Query("select templ from FreightTemplate templ where templ.customerId=?1 and templ.isDefault=true ")
    FreightTemplate findDefaultTemplate(int customerId);

    @Query("update FreightTemplate set isDefault=false where customerId=?1 and isDefault=true ")
    @Modifying
    void removeDefaultTemplate(int customerId);

    @Query("update FreightTemplate set isDefault=true where id=?1")
    @Modifying
    void setDefault(long id);
}
