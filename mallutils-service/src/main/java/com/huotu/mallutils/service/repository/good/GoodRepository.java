package com.huotu.mallutils.service.repository.good;

import com.huotu.mallutils.service.entity.good.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Repository
public interface GoodRepository extends JpaRepository<Good, Integer> {
    List<Good> findByGoodCat_CatId(int catId);
}
