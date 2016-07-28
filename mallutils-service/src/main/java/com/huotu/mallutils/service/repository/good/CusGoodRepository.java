/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.repository.good;

import com.hot.datacenter.entity.good.Good;
import com.hot.datacenter.repository.good.GoodRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by allan on 5/16/16.
 */
@Repository
public interface CusGoodRepository extends GoodRepository {

    @Query("select good from Good good where good.disabled=false and good.goodScenes=?2 and good.goodCat.catPath like %?1%")
    List<Good> findByGoodCatAndGoodScenes(String catId, int goodScenes);

    @Query("select good from Good good where good.disabled=false and good.goodBrand.brandId=?1 and good.goodScenes=?2")
    List<Good> findByBrandIdAndGoodScenes(long brandId, int goodScenes);
}
