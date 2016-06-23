/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller.priceset.handler;

import com.huotu.mallutils.common.annotation.RequestAttribute;
import com.huotu.mallutils.common.ienum.ResultCode;
import com.huotu.mallutils.service.entity.good.Good;
import com.huotu.mallutils.service.service.good.GoodService;
import com.huotu.mallutils.web.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allan on 6/21/16.
 */
@Controller
@RequestMapping(value = "/batchSetPrice/api", method = RequestMethod.POST)
public class BatchSetPriceApiController {
    @Autowired
    private GoodService goodService;

    /**
     * 通过分类设置会员价
     *
     * @param evalInfos
     * @param cateIdList
     * @param customerId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batchSetUserPriceByCats")
    @ResponseBody
    public ApiResult batchSetUserPriceByCats(String evalInfos, String cateIdList, @RequestAttribute Integer customerId) throws Exception {
        String[] cateIdArray = cateIdList.split(",");
        String[] evalInfoArray = evalInfos.split(",");
        Map<Integer, String[]> levelsToSet = new HashMap<>(); //设置的等级及公式列表
        for (String evalInfo : evalInfoArray) {
            String[] info = evalInfo.split(":");
            levelsToSet.put(Integer.valueOf(info[0]), new String[]{info[1], info[2]});
        }
        for (String cateIdStr : cateIdArray) {
            List<Good> goodsBeans = goodService.findByCatIdExceptAct("|" + cateIdStr + "|", 0);
            goodService.batchSetUserPriceV2(levelsToSet, goodsBeans, customerId);
        }
        return ApiResult.resultWith(ResultCode.SUCCESS);
    }

    @RequestMapping("/batchSetRebateByCats")
    @ResponseBody
    public ApiResult batchSetRebateByCats(String evalStr, String cateIdList, @RequestAttribute Integer customerId) throws Exception {
        String[] cateIdArray = cateIdList.split(",");
        for (String cateIdStr : cateIdArray) {
            List<Good> goods = goodService.findByCatIdExceptAct("|" + cateIdStr + "|", 0);
            goodService.batchSetRebate(evalStr, goods, customerId);
        }
        return ApiResult.resultWith(ResultCode.SUCCESS);
    }

    /**
     * 按商品品牌设置会员价格
     *
     * @param evalInfos
     * @param brandIdList
     * @param customerId
     * @return
     * @throws Exception
     */
    @RequestMapping("/batchSetUserPriceByBrands")
    @ResponseBody
    public ApiResult batchSetByBrands(String evalInfos, String brandIdList, @RequestAttribute Integer customerId) throws Exception {
        String[] brandIdArray = brandIdList.split(",");
        String[] evalInfoArray = evalInfos.split(",");
        Map<Integer, String[]> levelsToSet = new HashMap<>(); //设置的等级及公式列表
        for (String evalInfo : evalInfoArray) {
            String[] info = evalInfo.split(":");
            levelsToSet.put(Integer.valueOf(info[0]), new String[]{info[1], info[2]});
        }
        for (String brandIdStr : brandIdArray) {
            List<Good> goodsBeans = goodService.findByBrandIdExceptAct(Integer.parseInt(brandIdStr), 0);
            goodService.batchSetUserPriceV2(levelsToSet, goodsBeans, customerId);
        }

        return ApiResult.resultWith(ResultCode.SUCCESS);
    }

    @RequestMapping("/batchSetRebateByBrands")
    @ResponseBody
    public ApiResult batchSetRebateByBrands(String evalStr, String brandIdList, @RequestAttribute Integer customerId) throws Exception {
        String[] brandIdArray = brandIdList.split(",");
        for (String brandIdStr : brandIdArray) {
            List<Good> goods = goodService.findByBrandIdExceptAct(Integer.parseInt(brandIdStr), 0);
            goodService.batchSetRebate(evalStr, goods, customerId);
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
    @RequestMapping(value = "/batchSetUserPriceByGoods")
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

    @RequestMapping("/batchSetRebateByGoods")
    @ResponseBody
    public ApiResult batchSetRebateByGoods(String evalStr, String goodListStr, @RequestAttribute Integer customerId) throws Exception {
        String[] goodIdArray = goodListStr.split(",");
        List<Integer> goodIdList = new ArrayList<>();
        for (String goodIdStr : goodIdArray) {
            goodIdList.add(Integer.valueOf(goodIdStr));
        }
        List<Good> goods = goodService.findByIdIn(goodIdList);
        goodService.batchSetRebate(evalStr, goods, customerId);

        return ApiResult.resultWith(ResultCode.SUCCESS);
    }
}
