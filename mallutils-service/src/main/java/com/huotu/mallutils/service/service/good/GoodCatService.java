package com.huotu.mallutils.service.service.good;

import com.huotu.mallutils.service.entity.good.GoodCat;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
public interface GoodCatService {
    List<GoodCat> findByCustomerId(int customerId);
}
