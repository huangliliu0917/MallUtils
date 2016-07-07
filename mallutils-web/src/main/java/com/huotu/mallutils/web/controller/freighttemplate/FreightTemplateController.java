/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller.freighttemplate;

import com.huotu.mallutils.common.annotation.RequestAttribute;
import com.huotu.mallutils.service.entity.config.FreightTemplate;
import com.huotu.mallutils.service.service.config.FreightTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String templateList(@RequestAttribute Integer customerId, Model model) {
        List<FreightTemplate> freightTemplates = freightTemplateService.findByCustomerId(customerId);
        model.addAttribute("freightTemplates", freightTemplates);

        return "freight/template_list";
    }

    @RequestMapping(value = "/templateDetail", method = RequestMethod.GET)
    public String templateDetail(long id, Model model) {
        FreightTemplate freightTemplate = freightTemplateService.findById(id);
        model.addAttribute("freightTemplate", freightTemplate);

        return "freight/template_detail";
    }
}
