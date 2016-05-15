package com.huotu.mallutils.service.service.good.impl;

import com.huotu.mallutils.service.entity.good.Product;
import com.huotu.mallutils.service.repository.good.ProductRepository;
import com.huotu.mallutils.service.service.good.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void batchSave(List<Product> products) {
        productRepository.save(products);
    }
}
