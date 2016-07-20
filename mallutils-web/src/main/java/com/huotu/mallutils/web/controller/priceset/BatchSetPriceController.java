/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller.priceset;

import com.hot.datacenter.entity.client.UserLevel;
import com.hot.datacenter.entity.config.MallBaseConfig;
import com.hot.datacenter.entity.good.Good;
import com.hot.datacenter.entity.good.GoodBrand;
import com.hot.datacenter.entity.good.GoodCat;
import com.hot.datacenter.entity.good.GoodType;
import com.hot.datacenter.search.GoodSearch;
import com.huotu.mallutils.common.SysConstant;
import com.huotu.mallutils.common.annotation.RequestAttribute;
import com.huotu.mallutils.service.service.config.MallBaseConfigService;
import com.huotu.mallutils.service.service.good.GoodBrandService;
import com.huotu.mallutils.service.service.good.GoodCatService;
import com.huotu.mallutils.service.service.good.GoodService;
import com.huotu.mallutils.service.service.good.GoodTypeService;
import com.huotu.mallutils.service.service.user.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Controller
@RequestMapping("/batchSetPrice")
public class BatchSetPriceController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodCatService goodCatService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private GoodBrandService goodBrandService;
    @Autowired
    private MallBaseConfigService baseConfigService;
    @Autowired
    private GoodTypeService goodTypeService;

    @RequestMapping(value = "/catList", method = RequestMethod.GET)
    public String catList(@RequestAttribute Integer customerId, Model model) {
        List<GoodCat> goodCatList = goodCatService.findByCustomerId(customerId);
        model.addAttribute("goodCatList", goodCatList);
        return "batchSetPrice/good_cat_listV2";
    }

    @RequestMapping(value = "/brandList", method = RequestMethod.GET)
    public String brandList(@RequestAttribute Integer customerId, Model model) {
        List<GoodBrand> goodBrands = goodBrandService.findByCustomerId(customerId);
        model.addAttribute("goodBrands", goodBrands);
        return "batchSetPrice/good_brand_list";
    }

    @RequestMapping(value = "/goodList", method = RequestMethod.GET)
    public String goodList(
            @RequestAttribute Integer customerId,
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            @ModelAttribute(value = "savedGoodInfo") String savedGoodInfo,
            @ModelAttribute(value = "goodSearch") GoodSearch goodSearch,
            Model model
    ) {
        goodSearch.setCustomerId(customerId);
        Page<Good> goods = goodService.findAll(pageIndex, SysConstant.DEFAULT_PAGE_INDEX, goodSearch);
        List<GoodType> rootTypes = goodTypeService.findRootStandardTypes();
        List<GoodType> customTypes = goodTypeService.findByCustomerId(customerId);

        List<GoodCat> goodCatList = goodCatService.findByCustomerId(customerId);
        model.addAttribute("goods", goods.getContent());
        model.addAttribute("pageSize", SysConstant.DEFAULT_PAGE_INDEX);
        model.addAttribute("totalPages", goods.getTotalPages());
        model.addAttribute("totalRecords", goods.getTotalElements());
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("goodCatList", goodCatList);
        model.addAttribute("rootTypes", rootTypes);
        model.addAttribute("customTypes", customTypes);

        return "batchSetPrice/good_listV2";
    }

    @ModelAttribute(value = "levels")
    public List<UserLevel> levels(@RequestAttribute Integer customerId) {
        return levelService.findByCustomerIdWithOrder(customerId);
    }

    @ModelAttribute(value = "baseConfig")
    public MallBaseConfig mallBaseConfig(@RequestAttribute Integer customerId) {
        return baseConfigService.findByCustomerId(customerId);
    }
}
