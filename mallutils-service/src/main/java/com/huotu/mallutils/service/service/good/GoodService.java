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

    List<Good> findByCatId(int catId);
}
