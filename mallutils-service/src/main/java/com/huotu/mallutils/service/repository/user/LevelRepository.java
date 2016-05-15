package com.huotu.mallutils.service.repository.user;

import com.huotu.mallutils.service.entity.user.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    List<Level> findByCustomerId(int customerId);
}
