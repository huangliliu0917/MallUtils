/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.repository.good;

import com.huotu.mallutils.service.entity.good.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Repository
public interface GoodRepository extends JpaRepository<Good, Integer>, JpaSpecificationExecutor<Good> {
    List<Good> findByGoodCat_CatId(int catId);

    @Query("select good from Good good where good.goodId in ?1")
    List<Good> findByGoodIdIn(List<Integer> goodIdList);
}
