/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller.dwt;

import com.huotu.mallutils.common.ienum.ResultCode;
import com.huotu.mallutils.web.common.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allan on 5/23/16.
 */
@RequestMapping("/dwt")
public class DWTApiController {
    /**
     * @param tradeType 方法类型
     * @param infoJson  json格式信息
     * @return
     */
    @RequestMapping("/dwtApi")
    public ApiResult dwtApi(String tradeType, String infoJson) {
        // TODO: 5/23/16 会员信息
        return ApiResult.resultWith(ResultCode.SUCCESS);
    }
}
