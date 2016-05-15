package com.huotu.mallutils.service.repository.good;

import com.huotu.mallutils.service.entity.good.GoodCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Repository
public interface GoodCatRepository extends JpaRepository<GoodCat, Integer> {
    List<GoodCat> findByCustomerId(int customerId);
}
