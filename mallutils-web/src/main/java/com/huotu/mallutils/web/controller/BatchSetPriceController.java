package com.huotu.mallutils.web.controller;

import com.huotu.mallutils.common.annotation.RequestAttribute;
import com.huotu.mallutils.common.ienum.ResultCode;
import com.huotu.mallutils.service.entity.good.Good;
import com.huotu.mallutils.service.entity.good.GoodCat;
import com.huotu.mallutils.service.entity.user.Level;
import com.huotu.mallutils.service.service.good.GoodCatService;
import com.huotu.mallutils.service.service.good.GoodService;
import com.huotu.mallutils.service.service.user.LevelService;
import com.huotu.mallutils.web.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public String catList(@RequestAttribute int customerId, Model model) {
        List<GoodCat> goodCatList = goodCatService.findByCustomerId(customerId);
        List<Level> levels = levelService.findByCustomerIdWithOrder(customerId);
        model.addAttribute("goodCatList", goodCatList);
        model.addAttribute("levels", levels);
        return "good_cat_list";
    }

    @RequestMapping(value = "/batchSetUserPrice", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(value = "transactionManager")
    private ApiResult bachSet(String evalInfos, String cateIdList, @RequestAttribute int customerId) {
        try {
            String[] cateIdArray = cateIdList.split(",");
            String[] evalInfoArray = evalInfos.split(",");
            Map<Integer, String> levelsToSet = new HashMap<>(); //设置的等级及公式列表
            for (String evalInfo : evalInfoArray) {
                String[] info = evalInfo.split(":");
                levelsToSet.put(Integer.valueOf(info[0]), info[1]);
            }
            for (String cateIdStr : cateIdArray) {
                List<Good> goodsBeans = goodService.findByCatId(Integer.parseInt(cateIdStr));
                goodService.batchSetUserPrice(levelsToSet, goodsBeans, customerId);
            }
            return ApiResult.resultWith(ResultCode.SUCCESS);
        } catch (Exception e) {
            return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
        }
    }
}
