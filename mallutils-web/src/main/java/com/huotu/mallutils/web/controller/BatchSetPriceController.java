/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller;

import com.huotu.mallutils.common.SysConstant;
import com.huotu.mallutils.common.annotation.RequestAttribute;
import com.huotu.mallutils.common.ienum.ResultCode;
import com.huotu.mallutils.service.entity.good.Good;
import com.huotu.mallutils.service.entity.good.GoodCat;
import com.huotu.mallutils.service.entity.user.Level;
import com.huotu.mallutils.service.search.GoodSearch;
import com.huotu.mallutils.service.service.good.GoodCatService;
import com.huotu.mallutils.service.service.good.GoodService;
import com.huotu.mallutils.service.service.user.LevelService;
import com.huotu.mallutils.web.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/catList", method = RequestMethod.GET)
    public String catList(@RequestAttribute Integer customerId, Model model) {
        List<GoodCat> goodCatList = goodCatService.findByCustomerId(customerId);
        List<Level> levels = levelService.findByCustomerIdWithOrder(customerId);
        model.addAttribute("goodCatList", goodCatList);
        model.addAttribute("levels", levels);
        return "batchSetPrice/good_cat_list";
    }

    @RequestMapping(value = "/goodList", method = RequestMethod.GET)
    public String goodList(
            @RequestAttribute Integer customerId,
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            String savedGoodInfo,
            GoodSearch goodSearch,
            Model model
    ) {
        Page<Good> goods = goodService.findAll(pageIndex, SysConstant.DEFALUT_PAGE_INDEX, customerId, goodSearch);
        List<Level> levels = levelService.findByCustomerIdWithOrder(customerId);

        model.addAttribute("goods", goods.getContent());
        model.addAttribute("pageSize", SysConstant.DEFALUT_PAGE_INDEX);
        model.addAttribute("totalPages", goods.getTotalPages());
        model.addAttribute("totalRecords", goods.getTotalElements());
        model.addAttribute("goodSearch", goodSearch);
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("savedGoodInfo", savedGoodInfo);
        model.addAttribute("levels", levels);

        return "batchSetPrice/good_list";
    }

    /**
     * 通过分类设置会员价
     *
     * @param evalInfos
     * @param cateIdList
     * @param customerId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batchSetUserPriceByCats", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult bachSetByCats(String evalInfos, String cateIdList, @RequestAttribute Integer customerId) throws Exception {
        String[] cateIdArray = cateIdList.split(",");
        String[] evalInfoArray = evalInfos.split(",");
        Map<Integer, String[]> levelsToSet = new HashMap<>(); //设置的等级及公式列表
        for (String evalInfo : evalInfoArray) {
            String[] info = evalInfo.split(":");
            levelsToSet.put(Integer.valueOf(info[0]), new String[]{info[1], info[2]});
        }
        for (String cateIdStr : cateIdArray) {
            List<Good> goodsBeans = goodService.findByCatId("|" + cateIdStr + "|");
            goodService.batchSetUserPriceV2(levelsToSet, goodsBeans, customerId);
        }
        return ApiResult.resultWith(ResultCode.SUCCESS);
    }

    /**
     * 通过商品设置会员价
     *
     * @param evalInfos
     * @param goodListStr
     * @return
     */
    @RequestMapping(value = "/batchSetUserPriceByGoods", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult bachSetByGoods(String evalInfos, String goodListStr, @RequestAttribute Integer customerId) throws Exception {
        String[] goodIdArray = goodListStr.split(",");
        String[] evalInfoArray = evalInfos.split(",");
        Map<Integer, String[]> levelsToSet = new HashMap<>(); //设置的等级及公式列表
        for (String evalInfo : evalInfoArray) {
            String[] info = evalInfo.split(":");
            levelsToSet.put(Integer.valueOf(info[0]), new String[]{info[1], info[2]});
        }
        List<Integer> goodIdList = new ArrayList<>();
        for (String goodIdStr : goodIdArray) {
            goodIdList.add(Integer.valueOf(goodIdStr));
        }
        List<Good> goods = goodService.findByIdIn(goodIdList);
        goodService.batchSetUserPriceV2(levelsToSet, goods, customerId);
        return ApiResult.resultWith(ResultCode.SUCCESS);
    }
}
