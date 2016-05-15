package com.huotu.mallutils.service.service.user;

import com.huotu.mallutils.service.entity.user.Level;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
public interface LevelService {
    List<Level> findByCustomerId(int customerId);

    /**
     * 得到等级列表,先普通会员,在小伙伴的排序
     *
     * @param customerId
     * @return
     */
    List<Level> findByCustomerIdWithOrder(int customerId);
}
