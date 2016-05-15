package com.huotu.mallutils.service.service.user.impl;

import com.huotu.mallutils.service.entity.user.Level;
import com.huotu.mallutils.service.repository.user.LevelRepository;
import com.huotu.mallutils.service.service.user.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by allan on 5/16/16.
 */
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public List<Level> findByCustomerId(int customerId) {
        return levelRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Level> findByCustomerIdWithOrder(int customerId) {
        List<Level> levels = findByCustomerId(customerId);

        List<Level> results = new ArrayList<>();
        List<Level> userLevelList = levels.stream().filter(level -> level.getType() == 0).collect(Collectors.toList());
        List<Level> buddyLevelList = levels.stream().filter(level -> level.getType() == 1).collect(Collectors.toList());
        results.addAll(userLevelList);
        results.addAll(buddyLevelList);

        return results;
    }
}
