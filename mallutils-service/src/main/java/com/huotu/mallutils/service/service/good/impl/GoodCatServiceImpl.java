package com.huotu.mallutils.service.service.good.impl;

import com.huotu.mallutils.service.entity.good.GoodCat;
import com.huotu.mallutils.service.repository.good.GoodCatRepository;
import com.huotu.mallutils.service.service.good.GoodCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by allan on 5/16/16.
 */
@Service
public class GoodCatServiceImpl implements GoodCatService {
    @Autowired
    private GoodCatRepository goodCatRepository;

    @Override
    public List<GoodCat> findByCustomerId(int customerId) {
        List<GoodCat> result = new ArrayList<>();
        List<GoodCat> allCate = findByCustomerId(customerId);
        List<GoodCat> roots = allCate.stream().filter(p -> p.getParentId() == 0).collect(Collectors.toList());
        for (GoodCat root : roots) {
            //找孩子
            result.add(root);
            findChild(result, root.getCatId(), allCate);
        }
        return result;
    }

    private void findChild(List<GoodCat> result, int parentId, List<GoodCat> allCate) {
        List<GoodCat> children = allCate.stream().filter(p -> p.getParentId() == parentId).collect(Collectors.toList());
        for (GoodCat child : children) {
            result.add(child);
            findChild(result, child.getCatId(), allCate);
        }
    }
}
