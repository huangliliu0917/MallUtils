/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good;

import com.huotu.mallutils.service.entity.good.Good;
import org.springframework.transaction.annotation.Transactional;

import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

/**
 * Created by allan on 5/16/16.
 */
public interface GoodService {
    @Transactional
    Good save(Good good);

    /**
     * 设置用户会员价
     *
     * @param levelsToSet 要设置的等级及对应的公式列表
     * @param goods       要应用设置的商品列表
     */
    @Transactional
    void batchSetUserPrice(Map<Integer, String> levelsToSet, List<Good> goods, int customerId) throws ScriptException;

    @Transactional
    void batchSetUserPriceV2(Map<Integer, String[]> levelsToSet, List<Good> goods, int customerId) throws ScriptException;

    List<Good> findByCatId(int catId);
}
