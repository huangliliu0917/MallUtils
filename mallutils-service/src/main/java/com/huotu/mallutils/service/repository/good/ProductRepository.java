package com.huotu.mallutils.service.repository.good;

import com.huotu.mallutils.service.entity.good.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
