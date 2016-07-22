/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller.freighttemplate;

import com.alibaba.fastjson.JSON;
import com.hot.datacenter.entity.config.FreightTemplate;
import com.hot.datacenter.entity.config.FreightTemplateDetail;
import com.hot.datacenter.ienum.DeliveryTypeEnum;
import com.huotu.mallutils.common.annotation.RequestAttribute;
import com.huotu.mallutils.common.ienum.ResultCode;
import com.huotu.mallutils.service.service.config.FreightTemplateService;
import com.huotu.mallutils.web.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by allan on 7/7/16.
 */
@Controller
@RequestMapping("/freight")
public class FreightTemplateController {
    @Autowired
    private FreightTemplateService freightTemplateService;

    @RequestMapping(value = "/templateList", method = RequestMethod.GET)
    public String templateList(
            @RequestAttribute Integer customerId,
            @RequestParam(required = false, defaultValue = "0") int proType,
            Model model) {
        List<FreightTemplate> freightTemplates = freightTemplateService.findByCustomerId(customerId, proType);
        List<long[]> freightTemplateUsedInfo = freightTemplateService.freightTemplateUsedInfo(customerId, proType);
        model.addAttribute("freightTemplates", freightTemplates);
        model.addAttribute("proType", proType);
        model.addAttribute("freightTemplateUsedInfo", JSON.toJSON(freightTemplateUsedInfo));

        return "freighttemplate/template_list";
    }

    @RequestMapping(value = "/templateDetail", method = RequestMethod.GET)
    public String templateDetail(
            @RequestParam(required = false, defaultValue = "0") long id,
            @RequestParam(required = false, defaultValue = "0") int proType,
            Model model
    ) {
        FreightTemplate freightTemplate = new FreightTemplate();
        if (id > 0) {
            freightTemplate = freightTemplateService.findOne(id);
        }
        model.addAttribute("freightTemplate", freightTemplate);
        model.addAttribute("templateId", id);
        model.addAttribute("deliveryTypes", DeliveryTypeEnum.values());
        model.addAttribute("proType", proType);
        model.addAttribute("defaultDetailJson", JSON.toJSON(freightTemplate.defaultDetails()));

        return "freighttemplate/template_detail";
    }

    @RequestMapping(value = "/api/setDefault", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult setDefault(
            @RequestAttribute Integer customerId,
            long id
    ) {
        freightTemplateService.setDefault(id, customerId);

        return ApiResult.resultWith(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/api/saveTemplate", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult saveTemplate(
            @RequestAttribute Integer customerId,
            FreightTemplate freightTemplate,
            String detailJson,
            @RequestParam(required = false, defaultValue = "0") int proType
    ) {
        List<FreightTemplateDetail> freightTemplateDetails = JSON.parseArray(detailJson, FreightTemplateDetail.class);

        freightTemplate.setCustomerId(customerId);
        freightTemplate.setFreightTemplateType(proType);
        freightTemplateDetails.forEach(deliveryType -> deliveryType.setFreightTemplate(freightTemplate));
        freightTemplate.setFreightTemplateDetails(freightTemplateDetails);
        freightTemplateService.save(freightTemplate);

        return ApiResult.resultWith(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/api/deleteTemplate", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult deleteTemplate(long id) {
        if (freightTemplateService.isUsed(id)) {
            return ApiResult.resultWith(ResultCode.ERROR, "使用中的运费模板无法删除", null);
        } else {
            freightTemplateService.delete(id);
            return ApiResult.resultWith(ResultCode.SUCCESS);
        }
    }
}
