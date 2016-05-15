package com.huotu.mallutils.service.service.good;

import com.huotu.mallutils.service.entity.good.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
public interface ProductService {
    /**
     * 保存
     *
     * @param product
     * @return
     */
    @Transactional
    Product save(Product product);

    @Transactional
    void batchSave(List<Product> products);
}
